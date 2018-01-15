package com.jpenterprise.pgl.models;

public class Player extends Account {


    public Player() {
    }

    public Player(Integer id, String role, String firstName, String lastName, String email, String username, String password, String gender, String telephone) {
        super(id, role, firstName, lastName, email, username, password, gender, telephone);
    }
}
