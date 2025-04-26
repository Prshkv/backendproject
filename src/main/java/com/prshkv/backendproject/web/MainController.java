package com.prshkv.backendproject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.prshkv.backendproject.domain.Exploit;
import com.prshkv.backendproject.domain.ExploitRepository;






@Controller
public class MainController {

    @Autowired
    private ExploitRepository exploitRepository; 

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("exploits", exploitRepository.findAll());
        return "index";
    }

    @GetMapping("addexploit")
    public String getMethodName(Model model) {
        model.addAttribute("exploit", new Exploit());
        return "addexploit";
    }

    @PostMapping("save-exploit")
    public String saveExploit(@ModelAttribute Exploit exploit) {
        exploitRepository.save(exploit);
        return "redirect:/";
    }

    
    @GetMapping("exploit/{id}")
    public String viewExploit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("exploit" , exploitRepository.findById(id).get());
        return "viewexploit";
    }
    
    @GetMapping("login")
    public String login() {
        return "login";
    }
    
}
