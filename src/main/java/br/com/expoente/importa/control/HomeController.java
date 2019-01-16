/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.expoente.importa.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ednascimento
 */
@Controller
public class HomeController {
    
    @RequestMapping("/")
    public ModelAndView index(){
        
        ModelAndView modelAndView = new ModelAndView("home");
        
        return modelAndView;
    }
    
}
