/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author THAIS
 */
@ManagedBean
@RequestScoped
public class CondicaoEntradaBean {
    private String condicaoEntrada;

    public String getCondicaoEntrada() {
        return condicaoEntrada;
    }

    public void setCondicaoEntrada(String condicaoEntrada) {
        this.condicaoEntrada = condicaoEntrada;
    }
    
    
}
