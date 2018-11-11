package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author THAIS
 */
@Entity
public class ClasseEquivalencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codClasseEquivalencia;
    private String classeInvalidaUm;
    private String classeInvalidaDois;
    private String classeValida;
    private String classeValidaTrue;
    private String classeInvalidaFalse;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "classeequivcodcondentrada")
    private CondicaoEntrada condicaoEntrada;
    
    @OneToOne
    @JoinColumn(name = "valorcasosteste")
    private ValoresCasosTeste valoresCasosTeste;

    public Long getCodClasseEquivalencia() {
        return codClasseEquivalencia;
    }

    public void setCodClasseEquivalencia(Long codClasseEquivalencia) {
        this.codClasseEquivalencia = codClasseEquivalencia;
    }

    public String getClasseInvalidaUm() {
        return classeInvalidaUm;
    }

    public void setClasseInvalidaUm(String classeInvalidaUm) {
        this.classeInvalidaUm = classeInvalidaUm;
    }

    public String getClasseInvalidaDois() {
        return classeInvalidaDois;
    }

    public void setClasseInvalidaDois(String classeInvalidaDois) {
        this.classeInvalidaDois = classeInvalidaDois;
    }

    public String getClasseValida() {
        return classeValida;
    }

    public void setClasseValida(String classeValida) {
        this.classeValida = classeValida;
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

    public ValoresCasosTeste getValoresCasosTeste() {
        return valoresCasosTeste;
    }

    public void setValoresCasosTeste(ValoresCasosTeste valoresCasosTeste) {
        this.valoresCasosTeste = valoresCasosTeste;
    }





}
