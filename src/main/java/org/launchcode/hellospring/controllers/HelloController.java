package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @ResponseBody
    public String helloFrom(){
        return  "<form method='post'>" +
                "<input type='text' name='name'>" +
                "<select name = 'language'>" +
                "<option value = 'english'>English</option>"+
                "<option value = 'spanish'>Spanish</option>"+
                "<option value = 'french'>French</option>"+
                "<option value = 'italian'>Italian</option>"+
                "<option value = 'japanese'>Japanese</option>"+
                "</select>"+
                "<input type='submit' value='Greet me!'>" +
                "</form>";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String createMessage(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "world";
        }

        String greeting = "";

        if (language.equals("english")){
            greeting = "Hello, ";
        } else if (language.equals("spanish")) {
            greeting = "Hola, ";
        } else if (language.equals("french")) {
            greeting = "Bonjour, ";
        } else if (language.equals("italian")) {
            greeting = "Buongiorno, ";
        } else if (language.equals("japanese")) {
            greeting = "Konnichiwa, ";
        }

        return greeting + name ;
    }
}
