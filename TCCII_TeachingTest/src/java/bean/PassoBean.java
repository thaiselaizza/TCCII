/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.PassoTutorialDao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import util.ConnectionFactory;

/**
 *
 * @author THAIS
 */
@ManagedBean(name="passo")
@SessionScoped
public class PassoBean {
    
    
    private PassoTutorialDao dao =  new PassoTutorialDao(ConnectionFactory.getEntityManager());
    
    public String textoPasso = "Inicial";
    public String textoDica = "Inicial";

    public String getTextoPasso() {
        return textoPasso;
    }

    public void setTextoPasso(String textoPasso) {
        this.textoPasso = textoPasso;
    }

    public String getTextoDica() {
        return textoDica;
    }

    public void setTextoDica(String textoDica) {
        this.textoDica = textoDica;
    }
    
    
    
    public void mostrarPassoUm(){
        this.textoPasso = dao.getPassoUm(1).getPassoDica();
        System.out.println(textoPasso);
        
    }
    
    public void mostrarDicaTipoCondicao(){
        this.textoDica = dao.getDicaTipoCondicao(2).getPassoDica();
    }
    
    
    public void mostrarPassoDois(){
        this.textoPasso = dao.getPassoDois(3).getPassoDica();
        System.out.println(textoPasso);
        
    }
    
    
    public void mostrarDicaCondicaoEntrada(){
        this.textoDica = dao.getDicaTipoCondicao(4).getPassoDica();
    }
    
    public void mostrarPassoTres(){
        this.textoPasso = dao.getPassoTres(5).getPassoDica();
        System.out.println(textoPasso);
        
    }
       
    public void mostrarDicaClassesEquivalenciaUm(){
        this.textoDica = dao.getDicaTipoCondicao(6).getPassoDica();
    }
    
}
