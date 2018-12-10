/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


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
        /*
        if(entityManagerFactory == null || !entityManagerFactory.isOpen()){
            System.out.println("Criando entityManager");
            entityManagerFactory = Persistence.createEntityManagerFactory("TestePU");
        }
        */
        if(entityManagerFactory == null){
            System.out.println("Criando entityManager");
            entityManagerFactory = Persistence.createEntityManagerFactory("TestePU");
        }
        
        return entityManagerFactory.createEntityManager();
    }
    public static void closeEntityFactory(){
        entityManagerFactory.close();
    }
    
    public static void main(String[] args) {
        System.out.println("ttttttt");
    }
}
