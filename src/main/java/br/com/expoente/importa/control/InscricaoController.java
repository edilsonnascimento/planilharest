/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.expoente.importa.control;

import br.com.expoente.importa.dao.InscricaoDAO;
import br.com.expoente.importa.entity.Inscricao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ednascimento
 */


@Controller
@RequestMapping("/importar")
public class InscricaoController {
    
    @Autowired 
    private InscricaoDAO inscricaoDao;
    
     @RequestMapping("inscricao")
     public String inscricao(){
         return "/importar/inscricao";
     }
     
     @RequestMapping(method = RequestMethod.POST)
     public String importa(Inscricao inscricao){
                          
         System.out.println("CODIGO: " + inscricao.getCod_cliente_sga());
         inscricaoDao.gravar(inscricao);
         
         return "home";
     }     
     
     
}
