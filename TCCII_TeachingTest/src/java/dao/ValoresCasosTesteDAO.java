
package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.ValoresCasosTeste;
import util.ConnectionFactory;

/**
 *
 * @author THAIS
 */
public class ValoresCasosTesteDAO {
    
    private EntityManager entityManager;
    
    public ValoresCasosTesteDAO(){
    }
    
    public ValoresCasosTesteDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    public ValoresCasosTeste salvarValores(ValoresCasosTeste vct){
        try{
            entityManager.getTransaction().begin();
            System.out.println("Salvando casos de teste.");        
            entityManager.persist(vct);       
            entityManager.getTransaction().commit();   
            return vct;
        }catch(Exception e){
            System.out.println("Erro ValoresCasoTesteDAO: " + e.getMessage());
        }finally{

            
        }
       return null;
    }
    
    public ValoresCasosTeste getIdCasoTeste(long id){
         Query query = entityManager.createNamedQuery("ValoresCasosTeste.findById").setParameter("id", id);
         return (ValoresCasosTeste)query.getSingleResult();
    }
}
