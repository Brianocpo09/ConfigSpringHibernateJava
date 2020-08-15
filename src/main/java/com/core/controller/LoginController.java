/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.core.service.STipoUsuarioService;
import com.core.service.SUsuarioService;
 
@Controller
public class LoginController
{
    @Autowired
    private SUsuarioService usuarioService;
    @Autowired
    private STipoUsuarioService tipousuarioService;
    
    @RequestMapping("/")
    public String inicio(Model model) {
        return "inicio/index";
    }
    @RequestMapping("/usuarios")
    public ModelAndView usuarios() {
        ModelAndView modelAndView = new ModelAndView("usuario/list-of-users");
        modelAndView.addObject("usuarios",usuarioService.getAllUsuario());
        return modelAndView;
    }
    @RequestMapping("/roles")
    public ModelAndView roles() {
        ModelAndView modelAndView = new ModelAndView("usuario/list-of-tipoUsers");
        modelAndView.addObject("roles",tipousuarioService.getAllTipoUsuario());
        return modelAndView;
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "logout", required = false) String logout,
                            Model model) {
        String errorMessge = null;
        String succesMessge = null;
        if(error != null) {
            errorMessge = "Usuario o Clave incorrecta !!";
        }
        if(logout != null) {
            succesMessge = "Sesion cerrada exitosamente !!";
        }
        model.addAttribute("errorMessge", errorMessge);
        model.addAttribute("succesMessge", succesMessge);
        return "inicio/login";
    }
  
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){   
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout=true";
    }
}