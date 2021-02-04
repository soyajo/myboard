package com.soya.myboard.blog.web;

import com.soya.myboard.common.vo.RedirectVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @RequestMapping("/main")
    public String main(){
        System.out.println("@@main@@");
        return "blog/main";
    }
    @GetMapping("insert")
    public String insert(){
        System.out.println("@@insert@@");
        return "blog/insert";
    }
    @PostMapping("insertAction")
    public String insertAction(RedirectAttributes redirectAttributes){
        RedirectVO redirectVO = RedirectVO.builder()
                .url("")
                .message(RedirectVO.MSG_OK)
                .build();

        redirectAttributes.addFlashAttribute("redirectVO",redirectVO);
        return RedirectVO.URL_ALERT_AND_REDIRECT;
    }
}
