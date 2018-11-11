/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.awt.JobAttributes;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author THAIS
 */
public class ListarMetodos {
    
    public static void main(String args[]) {
        try {
            String path = "ClasseReferenciaQuestaoUm.java";
            String nomeClasse = path.substring(path.lastIndexOf("\\")+1,path.lastIndexOf("."));
            
            Class c = (Class)Class.forName(nomeClasse);
            
            Method[] m = c.getDeclaredMethods();
            ArrayList<String> listaMetodos = new ArrayList();
            for (int i = 0; i < m.length; i++){
                String metodo = m[i].toString().substring(m[i].toString().indexOf(".")+1);
                
                if(metodo.contains("set")){
                    listaMetodos.add(metodo);                  
                }               
            }
            
            System.out.println(listaMetodos);          
                                    
        } catch (Throwable e) {
            System.err.println(e);
        }
    }
}
