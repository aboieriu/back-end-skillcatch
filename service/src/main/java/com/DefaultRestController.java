package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultRestController {

    @RequestMapping("/")
    public String SkillCatch() {
        return "index.jsp";
    }
}
