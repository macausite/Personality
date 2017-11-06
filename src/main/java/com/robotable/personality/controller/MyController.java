package com.robotable.personality.controller;

import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MyController {
  
  @RequestMapping
  public String handleRequest (Model model) {
      model.addAttribute("msg", "A message from the controller");
      model.addAttribute("time", LocalTime.now());
      return "index";
  }
}