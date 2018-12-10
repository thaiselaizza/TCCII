package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author THAIS
 */
public class ComporResposta implements Serializable{
    
    private String respTipoCE;
    private ArrayList<RespostaAdicional> adicionais = new ArrayList();
    private CondicaoEntrada condicaoEntrada;
    private ClasseEquivalencia equivalencia;
    private String entradaValida;
    private String saidaValida;
    private String entradaInvalida1;
    private String saidaInvalida1;
    private String entradaInvalida2;
    private String saidaInvalida2;
    
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
        return this.condicaoEntrada.getCondEntrada();
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

    public String getEntradaValida() {
        return entradaValida;
    }

    public void setEntradaValida(String entradaValida) {
        this.entradaValida = entradaValida;
    }

    public String getSaidaValida() {
        return saidaValida;
    }

    public void setSaidaValida(String saidaValida) {
        this.saidaValida = saidaValida;
    }

    public String getEntradaInvalida1() {
        return entradaInvalida1;
    }

    public void setEntradaInvalida1(String entradaInvalida1) {
        this.entradaInvalida1 = entradaInvalida1;
    }

    public String getSaidaInvalida1() {
        return saidaInvalida1;
    }

    public void setSaidaInvalida1(String saidaInvalida1) {
        this.saidaInvalida1 = saidaInvalida1;
    }

    public String getEntradaInvalida2() {
        return entradaInvalida2;
    }

    public void setEntradaInvalida2(String entradaInvalida2) {
        this.entradaInvalida2 = entradaInvalida2;
    }

    public String getSaidaInvalida2() {
        return saidaInvalida2;
    }

    public void setSaidaInvalida2(String saidaInvalida2) {
        this.saidaInvalida2 = saidaInvalida2;
    }
    
    
    
   
    
    
}
