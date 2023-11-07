package com.ojt.demo1.web.controller;

import com.ojt.demo1.persistance.entity.MyUser;
import com.ojt.demo1.bl.service.MyUserRepository;
import com.ojt.demo1.web.form.RegistrationUserForm;
import com.ojt.demo1.web.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    public List<RegistrationUserForm> userlists = new ArrayList<>();
    // This list for storing data( Like DB )
    @Autowired
    MyUserRepository myUserRepository;


//    @RequestMapping("/home")
//    public String home(){
//        System.out.println("home is Running*************");
//        return "home";
//    }
    @RequestMapping("/")
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
        var user = new MyUser();
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
    public String registerUser(@ModelAttribute MyUser user, Model model){

        System.out.println("User Name ---->"+user.getUserName());
        System.out.println("User Phone Number ---->"+user.getPhoneNumber());
        System.out.println("Married ---->"+user.getMarried());

//        userlists.add(registerUserForm);
//        for (var user : userlists){
//            System.out.println("User Name : "+user.getUserName());
//            System.out.println("User Ph no : "+user.getPhoneNumber());
//            System.out.println("----------------------------------------");
//        }
//        System.out.println("User Creation*****");
//        model.addAttribute("user",registerUserForm);


        //  Save in DB
        // query ? session ? sessionFactory

        myUserRepository.save(user);

        return "user/detail";
    }
//    @GetMapping("/user/profile/{userId}")
//    public String getUser(Model model , @PathVariable() Long userId){
//        var myUser = new MyUser();
//        myUser.setUserName("Fake name");
//        myUser.setPhoneNumber(124456);
//        try{
//            var myUser = myUserRepository.findById(userId).get();
//            model.addAttribute("user",myUser);
//        }catch (Exception e){
//            model.addAttribute("error","There is no User.");
//        }
//        return "user/profile";
//    }
    // Select By City
    @GetMapping("/user/profile")
    public String getUser(Model model){
        List<MyUser> userList = myUserRepository.findByCity("Mandalay");
        model.addAttribute("userlists",userList);
        return "user/profile";
    }
    @GetMapping("/user/edit/{userId}")
    public String editUser(Model model , @PathVariable Long userId){
//        var user = new MyUser();
        MyUser user = myUserRepository.findById(userId).get();
        List<String> cities = new ArrayList<>();
        cities.add("Yangon");
        cities.add("Mandalay");
        cities.add("Bagan");
        model.addAttribute("user",user);
        model.addAttribute("cities",cities);
        return "user/edit";
    }
    @PostMapping("/user/edit")
    public String editUser(@ModelAttribute MyUser user, Model model){
        myUserRepository.save(user);
        return "user/profile";

    }
    @GetMapping("/user/delete/{userId}")
    public String deleteUser(@PathVariable Long userId){
//        myUserRepository.deleteById(userId);

        var user = myUserRepository.findById(userId).get();
        myUserRepository.delete(user);

        return "user/profile";
    }
}
