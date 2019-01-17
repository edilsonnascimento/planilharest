/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.expoente.importa.valid;

import br.com.expoente.importa.entity.Inscricao;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


/**
 *
 * @author ednascimento
 */
public class InscricaoValidation implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return Inscricao.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "cod_cliente_sga", "field.required");
        
        
            
    }
    
    
}
