package com.MIT.FIS10.controller;

import com.MIT.FIS10.service.UserService;
import com.MIT.FIS10.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/users")
    public String getUsers(
            @RequestParam(defaultValue = "1") int page,
            Model model) {
        int pageSize = 2; // Number of users per page
        Page<User> userPage = userService.getPaginatedUsers(page - 1, pageSize);

        model.addAttribute("users", userPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", userPage.getTotalPages());
        model.addAttribute("pageTitle", "User List");
        return "userdetails";
    }
}