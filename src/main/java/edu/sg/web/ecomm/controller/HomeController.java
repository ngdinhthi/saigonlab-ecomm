package edu.sg.web.ecomm.controller;

import edu.sg.web.ecomm.dto.LoginRequest;
import edu.sg.web.ecomm.dto.UserLoginDto;
import edu.sg.web.ecomm.service.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

  @Autowired
  private UserService userService;

  @RequestMapping({"", "/", "/index"})
  public String index(Model model) {
    if (!userService.checkLogin()) {
      return "redirect:/login";
    }
    userService.getUserLogin()
      .ifPresent(user -> {
        model.addAttribute("title", "Welcome to " + user.getUsername());
      });

    return "index";
  }

  @GetMapping("/login")
  public String loginPage(Model model) {
    model.addAttribute("title", "User Management Application");
    //model.addAttribute("messsage", null);
    model.addAttribute("loginRequest", new LoginRequest());
    return "login";
  }

  @PostMapping("/login")
  public String loginUser(@ModelAttribute LoginRequest loginRequest, Model model) {
    System.out.println(loginRequest.getUsername());
    System.out.println(loginRequest.getPassword());
    Optional<UserLoginDto> user = userService.login(loginRequest.getUsername(), loginRequest.getPassword());
    if (!user.isPresent()) {
      //model.addAttribute("messsage", "Khong dang nhap dc");
      //logMessage(model, "Khong dang nhap dc");
      return "redirect:/login";
    }
    return "redirect:/index";
  }

  private void logMessage(Model model, String message) {
    model.addAttribute("messsage", null);
  }
}
