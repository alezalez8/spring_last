package ru.alishev.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static java.lang.Integer.valueOf;

/**
 * @author Neil Alishev
 */
@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

        //System.out.println("Hello, " + name + " " + surname);
        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "first/hello";
    }


    @GetMapping("/calculator")
    public String calculate(@RequestParam(value = "a", required = false) String first,
                            @RequestParam(value = "b", required = false) String second,
                            @RequestParam(value = "operand", required = false) String mathOper,
                            Model model) {
        double result = 0;
        int a = valueOf(first);
        int b = valueOf(second);
        String signOfOperation = null;
        switch (mathOper) {
            case "multiplication": {
                result = a * b;
                signOfOperation = "*";
            }
            break;
            case "addition": {
                result = a + b;
                signOfOperation = "+";
            }
            break;
            case "substraction": {
                result = a - b;
                signOfOperation = "-";
            }
            break;
            case "division": {
                if (b != 0) {
                    result = a / (double) b;
                    signOfOperation = "/";
                } else result = 0;
            }
            break;
            default:
                result = 0;
                break;
        }
        System.out.println(a + " " + mathOper + " " + b + " = " + result);
        model.addAttribute("calculator", a + " " + signOfOperation + " " + b + " = " + result);

        return "/first/calculator";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }
}
