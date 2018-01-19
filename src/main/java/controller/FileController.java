package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.StorageService;

@Controller
public class FileController {

    private StorageService storageService;

    @Autowired
    public FileController(StorageService storageService) {
        this.storageService = storageService;
    }


    @RequestMapping(value = "/saveFile", method = RequestMethod.POST)
    public @ResponseBody void saveFile(@RequestParam("files") MultipartFile[] files, RedirectAttributes redirectAttributes){
        for(MultipartFile file:files) {
            storageService.store(file);
            redirectAttributes.addFlashAttribute("message", "Successfully! " + file.getOriginalFilename());
        }
    }

    @RequestMapping("/uploadFile")
    public String uploadFile(){
        return "plugin/upload";
    }

}
