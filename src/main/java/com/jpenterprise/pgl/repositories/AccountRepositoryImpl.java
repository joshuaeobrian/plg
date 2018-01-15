package com.jpenterprise.pgl.repositories;

import com.jpenterprise.pgl.models.Account;
import com.jpenterprise.pgl.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepositoryImpl implements AccountRepository{
    @Autowired
    JdbcTemplate template;
    @Override
    public Integer addAccount(Account account) {
        return template.queryForObject(
                        "INSERT INTO person(first_name, last_name, email, username, password, gender_id, telephone, role_id) " +
                        "VALUES (?,?,?,?,?,(SELECT id FROM gender WHERE gender_type=?),?, (SELECT id FROM role WHERE role_type=?)) RETURNING id",
                new Object[]{
                        account.getFirstName(),
                        account.getLastName(),
                        account.getEmail(),
                        account.getUsername(),
                        account.getPassword(),
                        account.getGender(),
                        account.getTelephone(),
                        account.getRole()
                },
                (rs, i) -> rs.getInt("id"));
    }

    @Override
    public Account getAccountByUsernameAndPassword(String username, String password) {
        return template.queryForObject("SELECT p.id, p.first_name, p.last_name, p.email, p.username, p.password, p.telephone, g.gender_type, r.role_type  " +
                "FROM person AS p" +
                "  JOIN gender AS g ON p.gender_id = g.id" +
                "  JOIN role AS r ON p.role_id = r.id" +
                "  WHERE p.password=? AND p.username=? OR p.email=?;", new Object[] {password,username, username}, (rs,i)->
             new Player(
                     rs.getInt("id"),
                     rs.getString("role_type"),
                     rs.getString("first_name"),
                     rs.getString("last_name"),
                     rs.getString("email"),
                     rs.getString("username"),
                     rs.getString("password"),
                     rs.getString("gender_type"),
                     rs.getString("telephone")
             )
        );
    }
}
