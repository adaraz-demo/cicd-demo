package com.cicd.cicddemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

  @GetMapping("echo")
  public String echo() {
    return "echo message";
  }

}
