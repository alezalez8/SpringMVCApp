package org.example.shunin.config.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class ThirdController {


    @GetMapping("/calculator")
    public String calcul(@RequestParam("a") int a,
                         @RequestParam("b") int b,
                         @RequestParam("action") String action,
                         Model model) {

        String act = "";
        double result;
        switch (action) {
            case "addition":
                result = a + b;
                act = " + ";
                break;

            case "substraction":
                result = a - b;
                act = " - ";
                break;

            case "multiplication":
                result = a * b;
                act = " * ";
                break;

            case "division":
                result = a / (double) b;
                act = " / ";
                break;

            default:
                result = 0;

        }

        model.addAttribute("resultEnd", a + " " + act + " " + b +
                " = " + result);

        return "third/calculator";

    }


}
