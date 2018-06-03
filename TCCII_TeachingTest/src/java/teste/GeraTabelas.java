/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import util.ConnectionFactory;

/**
 *
 * @author THAIS
 */
public class GeraTabelas {
    
    public static void main(String args[]){
        
        ConnectionFactory.getEntityManager();
        ConnectionFactory.getEntityManager().close();
        ConnectionFactory.closeEntityFactory();
    }
}
