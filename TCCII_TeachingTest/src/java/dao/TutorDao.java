/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.Tutor;

/**
 *
 * @author THAIS
 */
public class TutorDao {
    
    private EntityManager entityManager;
    
    public TutorDao(){
    }
    public TutorDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    public Tutor buscarPorLogin(String nome){
        Query query = entityManager.createNamedQuery("Tutor.findByName").setParameter("login", nome);
        return (Tutor) query.getSingleResult();
    }


    
    public boolean validaSenhaTutor(Tutor tutor){
        TypedQuery<Long> query = entityManager.createQuery("select count(t) from Tutor as t "
                + " where t.loginTutor = :login "
                + " and t.senhaTutor = :senha ", Long.class);
        
        query.setParameter("login", tutor.getLoginTutor());
        query.setParameter("senha", tutor.getSenhaTutor());
        long qtd = query.getSingleResult();
        
        if(qtd > 0){
            return true;
        }else{
            return false;
        }
    }

    public Tutor buscar(Long idTutor) {
        System.out.println("ID TUTOR: " + idTutor);
        return entityManager.find(Tutor.class, idTutor);
    }
}
