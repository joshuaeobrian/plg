package com.jpenterprise.pgl.apiControllers;

import com.jpenterprise.pgl.models.Account;
import com.jpenterprise.pgl.models.Player;
import com.jpenterprise.pgl.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    AccountRepository repository;

    @PostMapping("/login")
    public ResponseEntity<String> login(HttpSession session, String username, String password){
        Account player = repository.getAccountByUsernameAndPassword(username,password);
        session.setAttribute("userId", player.getId());
        session.setAttribute("account", player);
        return new ResponseEntity<>(player.getUsername(),HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<String> signUpAccount(HttpSession session,String firstName, String lastName, String email,String username,String password,String gender,String phone ){
        Player player = new Player(0,"player",firstName,lastName,email,username,password,gender,phone);
        Integer id = repository.addAccount(player);
        session.setAttribute("userId", id);
        return new ResponseEntity<>(player.getUsername(),HttpStatus.OK);
    }
}
