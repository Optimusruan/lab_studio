package service;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

@Component
public interface StorageService {

    final int TYPE_IMAGE = 1;//图片类型

    final int TYPE_ARTICLE = 2;//文件类型

    void init();

    void store(MultipartFile file);

    Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename);

    void deleteAll();

    boolean checkFileType(String filename,int fileType);
}