package com.jpenterprise.pgl.controllers;

import com.jpenterprise.pgl.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class RouteController {
    private String customer;

    @GetMapping("/")
    public String getHomePage(HttpSession session, Model model){
        Integer userId = 0;
        boolean isSession = false;
        if(session.isNew()){
            session.setAttribute("userId",userId);
        }else{
            userId = Integer.parseInt(session.getAttribute("userId").toString());
            if(userId !=0){

                isSession = true;
                model.addAttribute("account",session.getAttribute("account"));
            }
        }
        model.addAttribute("isSession", isSession);
        return "index";
    }
    @GetMapping("/teams")
    public String getTeamPage(HttpSession session, Model model){
        Integer userId = 0;
        boolean isSession = false;
        if(session.isNew()){
            session.setAttribute("userId",userId);
        }else{
            userId = Integer.parseInt(session.getAttribute("userId").toString());
            if(userId !=0){

                isSession = true;
                model.addAttribute("account",session.getAttribute("account"));
            }
        }
        model.addAttribute("isSession", isSession);
        return "views/team";
    }
    @GetMapping("/store")
    public String getStorePage(HttpSession session, Model model){
        Integer userId = 0;
        boolean isSession = false;
        if(session.isNew()){
            session.setAttribute("userId",userId);
        }else{
            userId = Integer.parseInt(session.getAttribute("userId").toString());
            if(userId !=0){

                isSession = true;
                model.addAttribute("account",session.getAttribute("account"));
            }
        }
        model.addAttribute("isSession", isSession);
        return "views/team";
    }

    @GetMapping("/about")
    public String getAbout(){
        return "about";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.setAttribute("userId",0);
        return "redirect:/";
    }

}
