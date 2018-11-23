/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.awt.AWTEventMulticaster;
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
    public static void main(String[] args){
        
        String listValores[]; 
        List<String> arrayAux = new ArrayList<>();
        String argu = "";
        String valorCampo = "10,20,30".trim();        
               
        listValores = valorCampo.split(",");      
        
        for(int i=0; i < listValores.length; i++){
            if(i < listValores.length -1){
                argu += "\""+ listValores[i] + "\","; 
            }else{
                argu += "\""+ listValores[i] + "\"";
            }
           
        }
        System.out.println("{" + argu+  "}");      
        
    }             
        
}
