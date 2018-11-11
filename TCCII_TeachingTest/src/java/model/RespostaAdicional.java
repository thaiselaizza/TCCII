package model;

import java.util.ArrayList;

/**
 *
 * @author THAIS
 */
public class RespostaAdicional {
    
    private CondicaoEntrada ce;
    private ArrayList<ClasseEquivalencia> equivalencias = new ArrayList();

    public CondicaoEntrada getCe() {
        return ce;
    }

    public void setCe(CondicaoEntrada ce) {
        this.ce = ce;
    }

    public ArrayList<ClasseEquivalencia> getEquivalencias() {
        return equivalencias;
    }

    public void setEquivalencias(ArrayList<ClasseEquivalencia> equivalencias) {
        this.equivalencias = equivalencias;
    }
    
    
}
