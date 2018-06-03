package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author THAIS
 */
@Entity
public class ClasseEquivalencia {
    
    @Id
    @GeneratedValue
    private Long codClasseEquivalencia;
    private String classeValidaUm;
    private String classeValidaDois;
    private String classeInvalida;
    private String classeValidaTrue;
    private String classeInvalidaFalse;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "classeequivcodcondentrada")
    private CondicaoEntrada condicaoEntrada;

    public Long getCodClasseEquivalencia() {
        return codClasseEquivalencia;
    }

    public void setCodClasseEquivalencia(Long codClasseEquivalencia) {
        this.codClasseEquivalencia = codClasseEquivalencia;
    }

    public String getClasseValidaUm() {
        return classeValidaUm;
    }

    public void setClasseValidaUm(String classeValidaUm) {
        this.classeValidaUm = classeValidaUm;
    }

    public String getClasseValidaDois() {
        return classeValidaDois;
    }

    public void setClasseValidaDois(String classeValidaDois) {
        this.classeValidaDois = classeValidaDois;
    }

    public String getClasseInvalida() {
        return classeInvalida;
    }

    public void setClasseInvalida(String classeInvalida) {
        this.classeInvalida = classeInvalida;
    }

    public String getClasseValidaTrue() {
        return classeValidaTrue;
    }

    public void setClasseValidaTrue(String classeValidaTrue) {
        this.classeValidaTrue = classeValidaTrue;
    }

    public String getClasseInvalidaFalse() {
        return classeInvalidaFalse;
    }

    public void setClasseInvalidaFalse(String classeInvalidaFalse) {
        this.classeInvalidaFalse = classeInvalidaFalse;
    }

    public CondicaoEntrada getCondicaoEntrada() {
        return condicaoEntrada;
    }

    public void setCondicaoEntrada(CondicaoEntrada condicaoEntrada) {
        this.condicaoEntrada = condicaoEntrada;
    }





}
