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

    public List<Inscricao> listar(Integer cod_cliente_sga) {
        return manager.createQuery("SELECT i FROM Inscricao i WHERE i.cod_cliente_sga = :cod_cliente_sga", Inscricao.class)
               .setParameter("cod_cliente_sga", cod_cliente_sga).getResultList();
                
    }
    
    public List<Inscricao> listarTodos() {
        return manager.createQuery("SELECT i FROM Inscricao i").getResultList();
    }
    
}
