package com.jpenterprise.pgl.repositories;


import com.jpenterprise.pgl.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {
    @Autowired
    private JdbcTemplate template;

    /***
     *
     * @param username
     * @return
     */
    public Customer getCustomerByUserName(String username){

        return template.queryForObject("select c.id, c.first_name,c.last_name, c.email, c.username, c.password, g.gender_type, c.telephone from customer as c JOIN gender as g ON c.gender_id = g.id where username=?",
                new Object[]{username},
                ((rs,i) ->
                    new Customer(
                            rs.getInt("id"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("email"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("gender_type"),
                            rs.getString("telephone")
                    )
                ));
    }

    public void createNewCustomer(Customer customer){
        template.update("insert INTO customer(first_name, last_name, email, username, password, gender_id, telephone)" +
                " VALUES(?,?,?,?,?,(SELECT id FROM gender WHERE gender_type=?),?)",
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getUsername(),
                customer.getPassword(),
                customer.getGender(),
                customer.getTelephone());
    }





}
