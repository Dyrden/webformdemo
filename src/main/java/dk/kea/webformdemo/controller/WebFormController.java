package dk.kea.webformdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WebFormController {

    @GetMapping("/")
    public String showForm() {
        return "webform";
    }

    @PostMapping("/creategreeting")
    public String greetingSite(
        @RequestParam("name") String name,
        @RequestParam("age") int age,
        @RequestParam("volume") int volume,
        RedirectAttributes attributes) {

        System.out.println(name + " " + age + " " + volume); //database create

        attributes.addAttribute("name", name);
        attributes.addAttribute("age", age);
        attributes.addAttribute("volume", volume);



        return "redirect:/creategreeting";

    }

    @GetMapping("/creategreeting")
    public String greetingSiteRedirect(
        @RequestParam("name") String name,
        @RequestParam("age") int age,
        @RequestParam("volume") int volume,
        Model model) {

        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("volume", volume);

        return "greetingside";


    }

}
