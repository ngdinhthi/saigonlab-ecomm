package edu.sg.web.ecomm.controller;

import edu.sg.web.ecomm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

  @Autowired
  private UserService userService;

  @RequestMapping({"", "/", "/index"})
  public String index() {
    return "index";
  }
}
