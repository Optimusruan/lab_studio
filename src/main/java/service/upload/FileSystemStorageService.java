package service.upload;

import dao.FileRepository;
import model.FileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import service.StorageService;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;
import java.util.Date;
import java.util.stream.Stream;

@Service
public class FileSystemStorageService implements StorageService {

    private final Path rootLocation;

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    public FileSystemStorageService(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }

    @Override
    public void store(MultipartFile file) {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + filename);
            }
            if (filename.contains("..")) {
                // This is a security check
                throw new StorageException(
                        "Cannot store file with relative path outside current directory "
                                + filename);
            }
            //修改文件名
            filename = String.valueOf(new Date().getTime()) + String.valueOf(Math.abs(filename.hashCode())) + filename;

            //写数据库
            FileEntity fileEntity = new FileEntity();
            fileEntity.setFileUrl(filename);
            fileEntity.setEnable(1);
            fileEntity.setFileDate(new Timestamp(new Date().getTime()));
            fileRepository.save(fileEntity);

            //上传文件
            Files.copy(file.getInputStream(), this.rootLocation.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new StorageException("Failed to store file " + filename, e);
        }
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(path -> this.rootLocation.relativize(path));
        } catch (IOException e) {
            throw new StorageException("Failed to read stored files", e);
        }

    }

    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new StorageFileNotFoundException(
                        "Could not read file: " + filename);

            }
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    //检查文件类型
    @Override
    public boolean checkFileType(String filename, int fileType) {
        int index = 0;
        for (int i = filename.length() - 1; filename.charAt(i) != '.'; --i) {
            index = i;
        }
        String suffix = filename.substring(index);
        boolean result = false;
        switch (fileType) {
            case TYPE_IMAGE: {
                result = suffix.equals("png") || suffix.equals("jpg") || suffix.equals("gif") || suffix.equals("jpeg");
            }
            ;
            break;
            case TYPE_ARTICLE: {
                result = suffix.equals("ppt") || suffix.equals("pdf") || suffix.equals("pptx");
            }
            break;
        }
        return result;
    }

    @Override
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }
}
