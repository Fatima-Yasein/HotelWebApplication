package com.jea.training.user.controller;

import com.jea.training.user.dao.UserDao;
import com.jea.training.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
//@SessionAttributes ("username")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/home")
    public String handleHome() {
        return "home";
    }

    @RequestMapping(value="/userCreationView")
    public String create() {
        return "signUp";
    }

    @RequestMapping(value="/addUser", method = RequestMethod.POST)
    public String create(@ModelAttribute User user, ModelMap model) {

        String registrationResult = (userDao.signUp(user));

        if(registrationResult.equals("null"))
        {
            model.addAttribute("message", "Please check the entered values again.\nAll fields must be filled with proper values");
            return "signUpFailed";

        }

        else if(registrationResult.equals("invalid password"))
        {
            model.addAttribute("message", "Password's length should be at least 8 characters.\nPassword should contain at least one uppercase, one lowercase, one digit and one special character");
            return "signUpFailed";

        }

        else if(registrationResult.equals("username exist"))
        {
            model.addAttribute("message", "Please choose another username.");
            return "signUpFailed";

        }

        else
        {
            model.addAttribute("message", "A customer with the following information was added successfully:");
            model.addAttribute("username", user.getUsername());
            model.addAttribute("passwrd", user.getPasswrd());
            model.addAttribute("firstName", user.getFirstName());
            model.addAttribute("lastName", user.getLastName());
            model.addAttribute("ssn", user.getSsn());
            model.addAttribute("email", user.getEmail());
            model.addAttribute("address", user.getAddress());
            model.addAttribute("phone", user.getPhone());

            return "user";
        }

    }

    @RequestMapping(value="/userLogInView")
    public String getUser()
    {
        return "login";
    }

    @RequestMapping(value="/selectUser", method = RequestMethod.POST)
    public String selectUser(@RequestParam String username, @RequestParam String passwrd, ModelMap model, HttpSession session, HttpServletRequest request)
    {
        User user = checkCookies(request);

        if ( user == null)
        {
            user = userDao.logIn(username,passwrd);

            session.setAttribute("id",user.getId());
            session.setAttribute("username",user.getUsername());
            session.setAttribute("passwrd",user.getPasswrd());
            session.setAttribute("firstName",user.getFirstName());
            session.setAttribute("lastName",user.getLastName());
            session.setAttribute("ssn",user.getSsn());
            session.setAttribute("email",user.getEmail());
            session.setAttribute("address",user.getAddress());
            session.setAttribute("phone",user.getPhone());
            session.setAttribute("userRole",user.getUserRole());
        }

        if(user.getUserRole().equals("default"))
        {
            model.addAttribute("message", "Incorrect username or password. Please try again ");
            return "logInFailed";
        }

        else if(user.getUserRole().equals("customer"))
        {
//            model.addAttribute("message", "Customer information:");
            model.addAttribute("username", username);
//            model.addAttribute("passwrd", user.getPasswrd());
//            model.addAttribute("firstName", user.getFirstName());
//            model.addAttribute("lastName", user.getLastName());
//            model.addAttribute("ssn", user.getSsn());
//            model.addAttribute("email", user.getEmail());
//            model.addAttribute("address", user.getAddress());
//            model.addAttribute("phone", user.getPhone());
//            model.addAttribute("userRole", user.getUserRole());

            return "customer";
        }

        else if(user.getUserRole().equals("admin"))
        {
            model.addAttribute("message", "Incorrect username or password.");
            return "admin";
        }

        else if(user.getUserRole().equals("employee"))
        {
            model.addAttribute("message", "Incorrect username or password.");
            return "employee";
        }

        else
            return "manager";


    }

    private User checkCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        User user = null;
        String id = "", username = "", password = "", fname = "", lname = "", ssn = "", email = "", address = "", phone = "", userRole = "";

        for( Cookie cookie : cookies)
        {
            if(cookie.getName().equalsIgnoreCase("username"))
                //user.setUsername(cookie.getValue());
                username = cookie.getValue();
            if(cookie.getName().equalsIgnoreCase("passwrd"))
                //user.setPasswrd(cookie.getValue());
                password = cookie.getValue();
            if(cookie.getName().equalsIgnoreCase("firstName"))
                //user.setFirstName(cookie.getValue());
                fname = cookie.getValue();
            if(cookie.getName().equalsIgnoreCase("lastName"))
                //user.setLastName(cookie.getValue());
                lname = cookie.getValue();
            if(cookie.getName().equalsIgnoreCase("ssn"))
                //user.setSsn(Integer.parseInt(cookie.getValue()));
                ssn = cookie.getValue();
            if(cookie.getName().equalsIgnoreCase("email"))
                //user.setEmail(cookie.getValue());
                email = cookie.getValue();
            if(cookie.getName().equalsIgnoreCase("address"))
                //user.setAddress(cookie.getValue());
                address = cookie.getValue();
            if(cookie.getName().equalsIgnoreCase("phone"))
                //user.setPhone(Integer.parseInt(cookie.getValue()));
                phone = cookie.getValue();
            if(cookie.getName().equalsIgnoreCase("userRole"))
                //user.setUserRole(cookie.getValue());
                userRole = cookie.getValue();
        }

        if (!id.isEmpty() && !username.isEmpty() && !password.isEmpty() && !fname.isEmpty() && !lname.isEmpty() &&
            !ssn.isEmpty() && !email.isEmpty() && !address.isEmpty() && !phone.isEmpty() && !userRole.isEmpty() )

            user = new  User( id,  username,  password,  fname,  lname, Integer.parseInt( ssn),  email,  address, Integer.parseInt( phone),  userRole);


        return user;
    }

    @RequestMapping(value="/logout")
    public String signOut(HttpSession session)
    {
        session.removeAttribute("id");
        session.removeAttribute("username");
        session.removeAttribute("passwrd");
        session.removeAttribute("firstName");
        session.removeAttribute("lastName");
        session.removeAttribute("ssn");
        session.removeAttribute("email");
        session.removeAttribute("address");
        session.removeAttribute("phone");
        session.removeAttribute("userRole");

        return "home";
    }


}
