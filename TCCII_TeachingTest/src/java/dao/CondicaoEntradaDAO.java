/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.CondicaoEntrada;
import util.ConnectionFactory;

/**
 *
 * @author THAIS
 */
public class CondicaoEntradaDAO {
    
    private EntityManager entityManager;
    
    public CondicaoEntradaDAO(){
    }
    
    public CondicaoEntradaDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    public CondicaoEntrada salvarCondicaoEntrada(CondicaoEntrada ce){  
        try{
            entityManager.getTransaction().begin();
            System.out.println("Salvando ccondição de entrada.");        
            entityManager.persist(ce);       
            entityManager.getTransaction().commit();   
            return ce;
        }catch(Exception e){
            System.out.println("Erro CondicaoEntradaDAO: "+ e.getMessage());
        }finally{
           
            
        }
       return null; 
    }
    
    public CondicaoEntrada getIdCondicaoEntrada(long id){
         Query query = entityManager.createNamedQuery("CondicaoEntrada.findById").setParameter("id", id);
        return (CondicaoEntrada)query.getSingleResult();
    }
}
