/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.ClasseEquivalencia;
import util.ConnectionFactory;

/**
 *
 * @author THAIS
 */
public class ClasseEquivalenciaDAO {

    private EntityManager entityManager;
    
    public ClasseEquivalenciaDAO(){
    }
    
    public ClasseEquivalenciaDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    public ClasseEquivalencia salvarClasses(ClasseEquivalencia classes){
        try{
            entityManager.getTransaction().begin();
            System.out.println("Salvando classes de equivalencia.");        
            entityManager.persist(classes);       
            entityManager.getTransaction().commit();  
            return classes;
        }catch(Exception e){
            System.out.println("Erro ClasseEquivalencia: " + e.getMessage());
        }finally{
            
        }
       return null; 
    }
    
    public ClasseEquivalencia getIdCasoTeste(long id){
         Query query = entityManager.createNamedQuery("ClasseEquivalencia.findById").setParameter("id", id);       
        return (ClasseEquivalencia)query.getSingleResult();
    }
}
