/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.PassoTutorialDao;
import dao.TipoCondicaoEntradaDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import model.TipoCondicaoEntrada;
import util.ConnectionFactory;

/**
 *
 * @author THAIS
 */
@ManagedBean(name="tipoCondicao")
@SessionScoped
public class TipoCondicaoEntradaBean {
    
    private PassoTutorialDao dao =  new PassoTutorialDao(ConnectionFactory.getEntityManager());
    private TipoCondicaoEntradaDao daoTipoCond = new TipoCondicaoEntradaDao(ConnectionFactory.getEntityManager());
    private List<TipoCondicaoEntrada> listaTipoCondicaoEntrada = daoTipoCond.listaTipoCondicaoEntrada();
    
    public String textoDica = "Inicial";

    public String getTextoDica() {
        return textoDica;
    }

    public void setTextoDica(String textoDica) {
        this.textoDica = textoDica;
    }
    
    public void mostrarPassoUm(){
        this.textoDica = dao.getPassoUm(1).getPassoDica();
        System.out.println(textoDica);
        
    }

    public List<TipoCondicaoEntrada> getListaTipoCondicaoEntrada() {
        return listaTipoCondicaoEntrada;
    }

    public void setListaTipoCondicaoEntrada(List<TipoCondicaoEntrada> listaTipoCondicaoEntrada) {
        this.listaTipoCondicaoEntrada = listaTipoCondicaoEntrada;
    }
    
    
}
