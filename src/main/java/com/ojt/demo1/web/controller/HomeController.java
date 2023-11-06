package com.ojt.demo1.web.controller;

import com.ojt.demo1.web.form.RegistrationUserForm;
import com.ojt.demo1.web.form.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    public List<RegistrationUserForm> userlists = new ArrayList<>();
    // This list for storing data( Like DB )

//    @RequestMapping("/home")
//    public String home(){
//        System.out.println("home is Running*************");
//        return "home";
//    }
    @RequestMapping("/home")
    public String home(Model model){
        UserForm userForm1 = new UserForm();
        UserForm userForm2 = new UserForm();
        UserForm userForm3 = new UserForm();
        List<UserForm> userFormList = new ArrayList<>();
        userFormList.add(userForm1);
        userFormList.add(userForm2);
        userFormList.add(userForm3);
        model.addAttribute("userlist",userFormList);
        return "home";
    }

//    @RequestMapping("/hello")
//    public String hello(){
//        System.out.println("home is Running*************");
//        return "hello";
//    }
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        System.out.println("home is Running*************");
        return "hello";
    }
    @GetMapping("/profile")
    public String profile(){
        System.out.println("home is Running*************");
        return "user/profile";
    }

    @GetMapping("/user/create")
    public String createUser(Model model){
        var user = new RegistrationUserForm();
//        user.setUserName("Default User");
//        user.setPhoneNumber(123456789);
//        user.setMarried(true);
        List<String> cities = new ArrayList<>();
        cities.add("Yangon");
        cities.add("Mandalay");
        cities.add("Bagan");
        model.addAttribute("user",new RegistrationUserForm());
        model.addAttribute("cities",cities);
        return "user/create";
    }
    @PostMapping("/user/create")
    public String registerUser(@ModelAttribute RegistrationUserForm registerUserForm, Model model){
//        System.out.println("User Name ---->"+registerUserForm.getUserName());
//        System.out.println("User Phone Number ---->"+registerUserForm.getPhoneNumber());
//        System.out.println("Married ---->"+registerUserForm.isMarried());
        userlists.add(registerUserForm);
        for (var user : userlists){
            System.out.println("User Name : "+user.getUserName());
            System.out.println("User Ph no : "+user.getPhoneNumber());
            System.out.println("----------------------------------------");
        }
//        model.addAttribute("user",registerUserForm);
        model.addAttribute("userlists",userlists);
//        System.out.println("User Creation*****");
        return "user/detail";
    }

}
