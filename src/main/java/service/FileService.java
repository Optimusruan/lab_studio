package service;

import dao.FileRepository;
import dao.SliderRepository;
import model.FileEntity;
import model.SliderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Component
public class FileService {
    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private SliderRepository sliderRepository;
    public void addSlider(){
        SliderEntity sliderEntity  = new SliderEntity();
        sliderEntity.setChecked(1);
        sliderEntity.setCheckTime(new Timestamp(new Date().getTime()));
        sliderEntity.setCreateTime(new Timestamp(new Date().getTime()));
        sliderRepository.save(sliderEntity);
        FileEntity fileEntity1 = new FileEntity();
        fileEntity1.setFileUrl("123");
        fileEntity1.getSliderEntities().add(sliderEntity);

        FileEntity fileEntity2 = new FileEntity();
        fileEntity2.setFileUrl("234");
        fileEntity2.getSliderEntities().add(sliderEntity);

       fileRepository.save(fileEntity1);
       fileRepository.save(fileEntity2);

    }
}
