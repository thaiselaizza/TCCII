package connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author THAIS
 */
public class ConnectionFactory {
    
    private static EntityManagerFactory entityManagerFactory;
        
    public static EntityManager getEntityManager(){
        
        if(entityManagerFactory == null || !entityManagerFactory.isOpen()){
            System.out.println("Criando Entity Manager...");
            entityManagerFactory = 
                    Persistence.createEntityManagerFactory("ProjetoFinalPU");
        
        }
        return entityManagerFactory.createEntityManager();
    }
    
    public static void  closeEntityFactory(){
        
        entityManagerFactory.close();
    }
}
