package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    // Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

//    @GetMapping("goodbye")
//    @ResponseBody
//    public String goodbye() {
//        return "Goodbye, Spring!";
//    }

    // Handles request of the form /hello?name=LaunchCode

    @GetMapping("hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    // Handles request of the from /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name) {
            return "Hello, " + name + "!";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String helloFrom(){
        return "form";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createMessage(@RequestParam String name, @RequestParam String language, Model model) {

        if (name == null) {
            name = "world";
        }

        String greetMe = "";

        if (language.equals("english")){
            greetMe = "Hello, ";
        } else if (language.equals("spanish")) {
            greetMe = "Hola, ";
        } else if (language.equals("french")) {
            greetMe = "Bonjour, ";
        } else if (language.equals("italian")) {
            greetMe = "Buongiorno, ";
        } else if (language.equals("japanese")) {
            greetMe = "Konnichiwa, ";
        }

        String greeting =  greetMe + name ;
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("Javascript");
        names.add("Typescript");
        names.add("Python");
        model.addAttribute("names", names);
        return "hello-list";
    }
}
