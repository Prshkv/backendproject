package com.prshkv.backendproject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.prshkv.backendproject.domain.AppUser;
import com.prshkv.backendproject.domain.AppUserRepository;



@Controller
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AppUserRepository appUserRepository;

    //Login page
    @GetMapping("login")
    public String login() {
        return "login";
    }

    //Signup page
    @GetMapping("signup")
    public String signup(Model model) {
        model.addAttribute("user", new AppUser());
        return "signup";
    }

    //Save user
    @PostMapping("saveuser")
    public String saveUser(@ModelAttribute AppUser user) {

        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        user.setRole("ROLE_USER");
    
        appUserRepository.save(user);
 
        return "redirect:/login";
    }

}
