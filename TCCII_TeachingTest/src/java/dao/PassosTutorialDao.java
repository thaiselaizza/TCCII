package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.PassosTutorial;
import util.ConnectionFactory;

/**
 *
 * @author THAIS
 */
public class PassosTutorialDao {
   
    private EntityManager entityManager;
    
    public PassosTutorialDao(){
    }
    
    public PassosTutorialDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    public List<PassosTutorial> listaPassos(){
        Query query = entityManager.createNamedQuery("PassosTutorial.findAll");
        return query.getResultList();
    }

    
}

