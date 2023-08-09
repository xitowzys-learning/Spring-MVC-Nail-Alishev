package me.xitowzys.springcourse.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Enumeration;
import java.util.Map;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

        model.addAttribute("message", "Hello, " + name + " " + surname);

//        Map<String, String[]> name = request.getParameterMap();
//        String surname = request.getParameter("surname");
//
//        for (String key : name.keySet()) {
//            String[] strArr = (String[]) name.get(key);
//            for (String val : strArr) {
//                System.out.println("Str Array= " + name.keySet());
//            }
//        }

//        System.out.println(name.toString());

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }
}
