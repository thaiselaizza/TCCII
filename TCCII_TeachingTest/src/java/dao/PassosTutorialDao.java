package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.PassosTutorial;

/**
 *
 * @author THAIS
 */
public class PassosTutorialDao {
    
    private final EntityManager entityManager;
    
    public PassosTutorialDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    public List<PassosTutorial> listaPassos(){
        
        Query query = entityManager.createNamedQuery("PassosTutorial.findAll");
        return query.getResultList();
    }

    
}

