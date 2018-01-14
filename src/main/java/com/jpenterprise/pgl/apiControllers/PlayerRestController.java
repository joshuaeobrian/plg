package com.jpenterprise.pgl.apiControllers;


import com.jpenterprise.pgl.models.Player;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/player")
public class PlayerRestController {
    @GetMapping("/")
    public String getListOfPlayers(){
        return "Hello";
    }
    @GetMapping("/{name}")
    public ResponseEntity<Player> getPlayerByName(){
        return new ResponseEntity<Player>(new Player(), HttpStatus.OK);
    }
}
