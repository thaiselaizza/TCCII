/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import model.ClasseJUnit;
import model.Questao;

/**
 *
 * @author THAIS
 */
public class CriarArquivo {
    public static void main(String[] args) throws ClassNotFoundException {
        
        
        
                 
        String pathCR = "ClasseReferenciaQuestaoUm";
        ArrayList<String> listaMetodos = new ArrayList();
        
        
            String nomeClasse = pathCR;
            
            Class c = (Class)Class.forName(nomeClasse);
            
            Method[] m = c.getDeclaredMethods();
            
            for (int i = 0; i < m.length; i++){
                String metodoAux = m[i].toString().substring(m[i].toString().lastIndexOf(".")+1, m[i].toString().lastIndexOf(")")+1);
                
                String metodo = metodoAux.replaceAll("\\(.*\\)", "()");
                    listaMetodos.add(metodo);  
                    System.out.println(listaMetodos);
                //}               
            }
        
        }
}
