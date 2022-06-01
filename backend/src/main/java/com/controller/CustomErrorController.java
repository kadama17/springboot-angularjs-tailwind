/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Kone Adama
 */
public class CustomErrorController implements ErrorController {


  @RequestMapping("/error")
  @ResponseBody
  String error(HttpServletRequest request) {
    return "<h1>Error occurred</h1>";
  }

  public String getErrorPath() {
    return "/error";
  }
}