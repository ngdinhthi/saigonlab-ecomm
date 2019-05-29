package edu.sg.web.ecomm.controller;

import edu.sg.web.ecomm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users/")
public class UsersController {

  @Autowired
  private UserService userService;

  @GetMapping
  public String userList() {
    return "user/list";
  }

  @GetMapping("/add")
  public String addPage() {
    return "user/add";
  }

  @PostMapping("/edit")
  public String edit() {
    return "user/edit";
  }
}
