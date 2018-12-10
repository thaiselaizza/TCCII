package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


/**
 *
 * @author THAIS
 */
@Entity
@NamedQueries({
    
    @NamedQuery(name="ValoresCasosTeste.findById", query="SELECT q FROM ValoresCasosTeste q WHERE codCasoTeste =:id")
})
public class ValoresCasosTeste implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codCasoTeste;
    private String entradaValida;
    private String saidaValida;
    private String entradaInvalidaUm;
    private String entradaInvalidaDois;
    private String saidaInvalidaUm;
    private String saidaInvalidaDois;
    
    
    @OneToOne(mappedBy = "valoresCasosTeste")
    private ClasseEquivalencia classeEquivalencia;
    
    
    
    
    public ValoresCasosTeste() {
    }   

    public Long getCodCasoTeste() {
        return codCasoTeste;
    }

    public void setCodCasoTeste(Long codCasoTeste) {
        this.codCasoTeste = codCasoTeste;
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

    public String getEntradaInvalidaUm() {
        return entradaInvalidaUm;
    }

    public void setEntradaInvalidaUm(String entradaInvalidaUm) {
        this.entradaInvalidaUm = entradaInvalidaUm;
    }

    public String getEntradaInvalidaDois() {
        return entradaInvalidaDois;
    }

    public void setEntradaInvalidaDois(String entradaInvalidaDois) {
        this.entradaInvalidaDois = entradaInvalidaDois;
    }

    public String getSaidaInvalidaUm() {
        return saidaInvalidaUm;
    }

    public void setSaidaInvalidaUm(String saidaInvalidaUm) {
        this.saidaInvalidaUm = saidaInvalidaUm;
    }

    public String getSaidaInvalidaDois() {
        return saidaInvalidaDois;
    }

    public void setSaidaInvalidaDois(String saidaInvalidaDois) {
        this.saidaInvalidaDois = saidaInvalidaDois;
    }


    public ClasseEquivalencia getClasseEquivalencia() {
        return classeEquivalencia;
    }

    public void setClasseEquivalencia(ClasseEquivalencia classeEquivalencia) {
        this.classeEquivalencia = classeEquivalencia;
    }

    

    
    
    
}
