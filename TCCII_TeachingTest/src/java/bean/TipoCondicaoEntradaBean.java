/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.PassoTutorialDao;
import dao.TipoCondicaoEntradaDao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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
    
    private TipoCondicaoEntrada tce = new TipoCondicaoEntrada();
    private PassoTutorialDao dao =  new PassoTutorialDao(ConnectionFactory.getEntityManager());
    private TipoCondicaoEntradaDao daoTipoCond = new TipoCondicaoEntradaDao(ConnectionFactory.getEntityManager());
    private List<TipoCondicaoEntrada> listaTipoCondicaoEntrada = daoTipoCond.listaTipoCondicaoEntrada();
   
    private String imagem = null;
    private String nomeImagem = "";
    private String areaDica = "true";
            
    public String textoDica = "Inicial";
    private String enunciado;

    
    public List<String> getClassesValidas(){
        
        TipoCondicaoEntrada entrada = daoTipoCond.getTipoCE(getEntrada());
        
        List<String> validas = new ArrayList<String>();
        for(int i=0; i<entrada.getQtdClasseValida();i++){
            validas.add(String.valueOf(i));
        }
        return validas;     
    }
    
    public List<String> getClassesInValidas(){
        TipoCondicaoEntrada entrada = daoTipoCond.getTipoCE(getEntrada());
        List<String> validas = new ArrayList<String>();
        for(int i=0; i<entrada.getQtdClasseInvalida();i++){
            validas.add(String.valueOf(i));
        }
        return validas;     
    }
    
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

   
    public void tornarInvisivel(){
        areaDica = "false";
    }
    
    
    public void valueChange(ValueChangeEvent e){
        
        
        System.out.println("Valor mudou");
        
        if(e.getNewValue() == null || e == null){
            imagem = null;
        }
        else{
            System.out.println(e.getNewValue().toString()) ;
            String tceSelecionada = e.getNewValue().toString();
            
            if(tceSelecionada.equals("intervalo")){

                imagem = "intervalo.png"; 
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("entrada", "intervalo");
            }
            if(tceSelecionada.equals("valor especifico")){

                imagem = "valor_especifico.png";
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("entrada", "valor especifico");
            }
            if(tceSelecionada.equals("conjunto de valores")){

                imagem = "conjunto_valores.png"; 
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("entrada", "conjunto de valores");
            }
            if(tceSelecionada.equals("condicao logica")){

                imagem = "condicao_logica.png"; 
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("entrada", "condicao logica");
            }
            if(tceSelecionada.equals("Select")){
                imagem = null;
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("entrada", null);
            }
        }
    }
    
    public String getEntrada(){
        String res = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("entrada");
        return res;
    }
    

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    
   

        
}
