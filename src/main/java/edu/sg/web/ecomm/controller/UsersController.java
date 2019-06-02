package edu.sg.web.ecomm.controller;

import edu.sg.web.ecomm.converters.RoleConverters;
import edu.sg.web.ecomm.domain.Role;
import edu.sg.web.ecomm.dto.RoleDto;
import edu.sg.web.ecomm.repository.RoleRepository;
import edu.sg.web.ecomm.request.UserRegistrationForm;
import edu.sg.web.ecomm.service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@Slf4j
public class UsersController {

  @Autowired
  private UserService userService;

  @Autowired
  private RoleRepository roleRepo;

  @GetMapping
  public String userList() {
    return "user/list";
  }

  @GetMapping("/add")
  public String addUserPage(Model model) {
    model.addAttribute("userRegisForm", new UserRegistrationForm());

    final List<RoleDto> roles = roleRepo.findAll().stream()
      .map(RoleConverters.roleConverter())
      .collect(Collectors.toList());

    model.addAttribute("roles", roles);
    return "user/add";
  }

  @PostMapping("/add")
  public String addUser(@ModelAttribute UserRegistrationForm userRegisForm) {
    log.debug("username = {} - email = {} - roleCode = {}",
      userRegisForm.getUsername(), userRegisForm.getEmail(), userRegisForm.getRoleCode());
    return "redirect:/users";
  }

  @PostMapping("/edit")
  public String edit() {
    return "user/edit";
  }
}
