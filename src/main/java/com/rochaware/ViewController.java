package com.rochaware;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.thymeleaf.Thymeleaf;
import org.thymeleaf.spring4.view.ThymeleafView;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import java.util.Locale;

@Controller
public class ViewController {

    @RequestMapping("/jsp")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "var";
    }

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("page","fragments/home");
        return "template";
    }

    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("page","fragments/register");
        return "template";
    }



}