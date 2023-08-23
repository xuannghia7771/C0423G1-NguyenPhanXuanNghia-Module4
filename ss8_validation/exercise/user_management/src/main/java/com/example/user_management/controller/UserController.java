package com.example.user_management.controller;

import com.example.user_management.dto.UserDto;
import com.example.user_management.model.User;
import com.example.user_management.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("")
    public String showList(Model model,
                           @RequestParam(defaultValue = "0", required = false) int page,
                           @RequestParam(defaultValue = "", required = false) String searchLastName) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<User> userPage = userService.searchByLastName(pageable, searchLastName);
        model.addAttribute("userPage", userPage);
        model.addAttribute("searchLastName", searchLastName);
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute UserDto userDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userService.add(user);
        redirectAttributes.addFlashAttribute("message","Creating New User Successfully");
        return "redirect:/user";
    }
}
