/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.expoente.importa.dao;

import br.com.expoente.importa.entity.Inscricao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ednascimento
 */
@Repository
@Transactional  
public class InscricaoDAO {
    
    @PersistenceContext
    private EntityManager manager;
    
    public void gravar(Inscricao inscricao){
        manager.persist(inscricao);
    }

    public List<Inscricao> listar() {
        return manager.createQuery("SELECT i FROM Inscricao i", Inscricao.class).getResultList();
    }
    
}
