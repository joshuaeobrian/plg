package com.jpenterprise.pgl.controllers;

import com.jpenterprise.pgl.models.Customer;
import com.jpenterprise.pgl.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RouteController {
    private String customer;
    @Autowired
    private CustomerRepository customerRepository;
    @GetMapping("/")
    public String getHomePage(Model model){

        return "index";
    }

    @GetMapping("/about")
    public String getAbout(){
        return "about";
    }

    @GetMapping("/signup")
    public String getSignup() {
        return "signup";
    }

    @GetMapping("/timeline")
    public String getTimeLine(){
        return "timeline";
    }

    @GetMapping("/emplogin")
    public String getEmpLogin(){
        return "emplogin";
    }

    @GetMapping("/custlogin")
    public String getCustLogin(){
        return "custlogin";
    }

    @PostMapping("/create")
    public String createCust(Customer customer) {
        this.customer= customer.getUsername();
        customerRepository.createNewCustomer(customer);
        return "redirect:/";
    }
}
