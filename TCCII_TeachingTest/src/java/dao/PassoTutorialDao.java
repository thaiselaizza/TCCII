package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.PassosTutorial;

/**
 *
 * @author THAIS
 */
public class PassoTutorialDao {
    
    private final EntityManager entityManager ;  //Um atributo final de uma classe pode ter seu valor atribuído uma única vez, seja na própria declaração ou no construtor. 
    
    public PassoTutorialDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    public PassosTutorial getPassoUm(long id){
        Query query = entityManager.createNamedQuery("PassosTutorial.findById").setParameter("id", id);
        return (PassosTutorial)query.getSingleResult();
    } 
    
    public PassosTutorial getPassoDois(long id){
        Query query = entityManager.createNamedQuery("PassosTutorial.findById").setParameter("id", id);
        return (PassosTutorial)query.getSingleResult();
    }
    
    public PassosTutorial getPassoTres(long id){
        Query query = entityManager.createNamedQuery("PassosTutorial.findById").setParameter("id", id);
        return (PassosTutorial)query.getSingleResult();
    }
    
    public PassosTutorial getDicaTipoCondicao(long id){
        Query query = entityManager.createNamedQuery("PassosTutorial.findById").setParameter("id", id);
        return (PassosTutorial)query.getSingleResult();
    }
    
}
