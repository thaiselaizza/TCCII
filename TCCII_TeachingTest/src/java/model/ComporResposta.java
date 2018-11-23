package model;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author THAIS
 */
public class ComporResposta {
    
    private String respTipoCE;
    private ArrayList<RespostaAdicional> adicionais = new ArrayList();
    private CondicaoEntrada condicaoEntrada;
    private ClasseEquivalencia equivalencia;
    
    public List<String> getInvalidas(){
        List<String> lista = new ArrayList<String>();
        if(!equivalencia.getClasseInvalidaUm().equals("")){
            lista.add(equivalencia.getClasseInvalidaUm());
        }
        if(equivalencia.getClasseInvalidaDois()!= null){
            lista.add(equivalencia.getClasseInvalidaDois());
        }
        return lista;
    }

    public CondicaoEntrada getCondicaoEntrada() {
        return condicaoEntrada;
    }

    public void setCondicaoEntrada(CondicaoEntrada condicaoEntrada) {
        this.condicaoEntrada = condicaoEntrada;
    }

    public ClasseEquivalencia getEquivalencia() {
        return equivalencia;
    }

    public void setEquivalencia(ClasseEquivalencia equivalencia) {
        this.equivalencia = equivalencia;
    }
    

    public String getRespTipoCE() {
        return respTipoCE;
    }

    public void setRespTipoCE(String respTipoCE) {
        this.respTipoCE = respTipoCE;
    }

    public ArrayList<RespostaAdicional> getAdicionais() {
        return adicionais;
    }

    public void setAdicionais(ArrayList<RespostaAdicional> adicionais) {
        this.adicionais = adicionais;
    }
    
    public String getCondEntrada(){
        return this.condicaoEntrada.getCondEntradaResposta();
    }
    
    
    public String getValida(){
        return this.equivalencia.getClasseValida();
    }
    public String getInvalidaUm(){
        return this.equivalencia.getClasseInvalidaUm();
    }
    public String getInvalidaDois(){
        return this.equivalencia.getClasseInvalidaDois();
    }
    
    

   
    
    
}
