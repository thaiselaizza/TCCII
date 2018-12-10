/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teste;
import java.io.*;
/**
 *
 * @author THAIS
 */
public class LerJUnit {
    

    public static void main(String[] args) {
	
    	
            
            File diretorioDeImagens = new File("D:\\Documentos\\NetBeansProjects\\TCCII_TeachingTest\\test\\classerefteste");
 
            // Listo todos os arquivos do diretório, excluindo os que terminam com txt
            File[] imagensDoDiretorio = diretorioDeImagens.listFiles(
            new FileFilter() {
               public boolean accept(File b){
                  return b.getName().endsWith("Test.java");
               }
            }
         );
        for(File f: imagensDoDiretorio){
            System.out.println(f.getName());
        }
    }

    
    }

        
