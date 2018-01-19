package controller;

import model.SliderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.FileService;
import service.SliderService;

@Controller
public class SliderController {
    @Autowired
    SliderService sliderService;

    @Autowired
    FileService fileService;

    @GetMapping("/getSlider")
    public @ResponseBody Iterable<SliderEntity> getSliderDataById(@RequestParam String id){
        return sliderService.getSliderById(Integer.parseInt(id));
    }

    @RequestMapping("/setSlider")
    public @ResponseBody void addSlider(){
        fileService.addSlider();
    }

}
