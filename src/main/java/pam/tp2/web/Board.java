package pam.tp2.web;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.authentication.LdapAuthenticationProvider;
import org.springframework.security.ldap.userdetails.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import pam.tp1.alert.AlertMail;

import java.security.Principal;

import static org.springframework.ldap.query.LdapQueryBuilder.query;


@Controller
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class Board {

    private static Logger logger = Logger.getLogger(Board.class);

    @Autowired
    AlertMail mailSender;

    @RequestMapping("/board")
    public String greeting( Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        model.addAttribute("name",authentication.getName());
        return "board";
    }

    @RequestMapping("/board/sendMail")
    public String sendMail(@RequestBody String response){
        mailSender.sendMessage(response);
        return "d";
    }


}
