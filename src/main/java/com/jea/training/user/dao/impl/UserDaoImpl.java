package com.jea.training.user.dao.impl;

import com.jea.training.user.dao.UserDao;
import com.jea.training.user.model.User;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String signUp(final User u) {

        if(checkNullFields(u)) {

            if(checkIfUsernameExist(u.getUsername())== 0) {

                if(checkPasswordStrength(u.getPasswrd())) {

                    String query="insert into users (username, passwrd, firstName, lastName, ssn, email, address, phone) values(?,?,?,?,?,?,?,?)";

                    jdbcTemplate.update(query, new PreparedStatementSetter() {
                        public void setValues(PreparedStatement user) throws SQLException {
                            user.setString(1, u.getUsername());
                            user.setString(2, hashPassword(u.getPasswrd()));
                            user.setString(3, u.getFirstName());
                            user.setString(4, u.getLastName());
                            user.setInt(5, u.getSsn());
                            user.setString(6, u.getEmail());
                            user.setString(7, u.getAddress());
                            user.setInt(8, u.getPhone());
                        }
                    });

                    return "valid password";
                }
                else
                    return "invalid password";

            }
            else
                return "username exist";

        }
        else
            return "null";

    }

    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    private boolean checkPasswordStrength (String password) {

        int iPasswordScore = 0;

        if( password.length() < 8 )
            return false;

        else
        {
            //check if it contains one digit
            if (password.matches("(?=.*[0-9]).*"))
            {
                //if it contains one lower case letter
                if (password.matches("(?=.*[a-z]).*"))
                {
                    //if it contains one upper case letter
                    if (password.matches("(?=.*[A-Z]).*"))
                    {
                        //if it contains one special character, add 2 to total score
                        if (password.matches("(?=.*[~!@#$%^&*()_-]).*"))
                            return true;
                        else
                            return false;
                    }
                    else
                        return false;
                }
                else
                    return false;
            }
            else
                return false;
        }

    }

    private User getCustomer(String username) {

        String query= "select * from Customer where username = ?  ";
        return jdbcTemplate.queryForObject(query, new Object[] { username }, new RowMapper<User>() {
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setUsername(resultSet.getString("username"));
                user.setPasswrd(resultSet.getString("passwrd"));
                user.setFirstName(resultSet.getString("firstName"));
                user.setLastName(resultSet.getString("lastName"));
                user.setSsn(resultSet.getInt("ssn"));
                user.setEmail(resultSet.getString("email"));
                user.setAddress(resultSet.getString("address"));
                user.setPhone(resultSet.getInt("phone"));
                return user;
            }
        });
    }

    private Integer checkIfUsernameExist(String username)
    {
        String query= "select count(*) from users where username = ?   ";
        return (jdbcTemplate.query(query, new Object[]{username}, new RowMapper<Integer>() {
            public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getInt("count(*)");
            }
        })).get(0);
    }

    private boolean checkNullFields(User user) {

        if((user.getUsername() != null) && (user.getPasswrd()!= null) && (user.getFirstName()!= null) &&
           (user.getLastName() != null)&& (user.getSsn() != 0) && (user.getEmail() != null)&&
           (user.getAddress()!= null) && (user.getPhone()!= 0))
            return true;
        else
            return false;
    }

    @Override
    public User logIn(final String username, String password){

        String query= "select * from users where username = ?  and accountStatus = ?  ";

        List<User> userList=jdbcTemplate.query(query,new Object[] { username,"active" }, new RowMapper<User>() {

            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User u = new User();
                u.setId(resultSet.getString("id"));
                u.setUsername(resultSet.getString("username"));
                u.setPasswrd(resultSet.getString("passwrd"));
                u.setFirstName(resultSet.getString("firstName"));
                u.setLastName(resultSet.getString("lastName"));
                u.setSsn(resultSet.getInt("ssn"));
                u.setEmail(resultSet.getString("email"));
                u.setAddress(resultSet.getString("address"));
                u.setPhone(resultSet.getInt("phone"));
                u.setUserRole(resultSet.getString("userRole"));

                return u;
            }
        });


        if( userList.size() > 0 )
        {
             if (checkPass(password,userList.get(0).getPasswrd()))
                 return userList.get(0);
             else
                 return new User("default","default","default","default","default",0,"default","default",0,"default");
        }
        else
        {
            return new User("default","default","default","default","default",0,"default","default",0,"default");
        }

    }

    private boolean checkPass(String Password, String hashedPassword) {
        if (BCrypt.checkpw(Password, hashedPassword))
            return true;
        else
            return false;
    }

}
