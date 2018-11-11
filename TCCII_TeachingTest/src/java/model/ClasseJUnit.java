/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author THAIS
 */

public class ClasseJUnit {
       
        
    private String nomeClasse;
    private String atributoCT;
    private String nomeMetodo;
    private String nomeMetodoRef;
    private String parametro;

    public String getNomeClasse() {
        return nomeClasse;
    }

    public void setNomeClasse(String nomeClasse) {
        this.nomeClasse = nomeClasse;
    }

    public String getAtributoCT() {
        return atributoCT;
    }

    public void setAtributoCT(String atributoCT) {
        this.atributoCT = atributoCT;
    }

    public String getNomeMetodo() {
        return nomeMetodo;
    }

    public void setNomeMetodo(String nomeMetodo) {
        this.nomeMetodo = nomeMetodo;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public String getNomeMetodoRef() {
        return nomeMetodoRef;
    }

    public void setNomeMetodoRef(String nomeMetodoRef) {
        this.nomeMetodoRef = nomeMetodoRef;
    }
    
   
    
}
