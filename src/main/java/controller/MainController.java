package controller;

import dao.MemberRepository;
import model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {

    @Autowired
    private MemberRepository memberRepository;

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);

        return "greeting";
    }

    @GetMapping("/test")
    public @ResponseBody Iterable<MemberEntity> getAllMembers(){
        return memberRepository.findAll();
    }

    @GetMapping("/testid")
    public @ResponseBody Iterable<MemberEntity> getMembersById(@RequestParam String id){
        return memberRepository.findByMemberId(Integer.parseInt(id));
    }
    @GetMapping("/liyuindex")
    public String getIndex()
    {
        return "index";
    }
//    @GetMapping("/rest/sliderData")
    @RequestMapping("/webroot/test")
    public String test1(){
        return "webroot/test1";
    }

    @RequestMapping("/admin2018lab/index")
    public String adminIndex(){
        return "adminback/index";
    }
}
