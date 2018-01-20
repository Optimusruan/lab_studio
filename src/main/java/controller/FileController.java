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
    public @ResponseBody String saveFile(@RequestParam("files") MultipartFile[] files, RedirectAttributes redirectAttributes){
        StringBuffer stringBuffer = new StringBuffer("");
        for(MultipartFile file:files) {
            String temp = file.getOriginalFilename();
            if(storageService.checkFileType(temp,storageService.TYPE_IMAGE))
            {
                storageService.store(file);
            }
            else {
                stringBuffer.append("failed ").append(temp).append("\n");
            }
//            redirectAttributes.addFlashAttribute("message", "Successfully! " + file.getOriginalFilename());
        }

        return stringBuffer.toString();
    }

    @RequestMapping("/uploadFile")
    public String uploadFile(){
        return "plugin/upload";
    }

}
