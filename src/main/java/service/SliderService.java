package service;

import dao.SliderRepository;
import model.FileEntity;
import model.SliderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class SliderService {
    @Autowired
    SliderRepository sliderRepository;

    public Iterable<SliderEntity> getSliderById(int id){
        return sliderRepository.findBySliderId(id);
    }


}
