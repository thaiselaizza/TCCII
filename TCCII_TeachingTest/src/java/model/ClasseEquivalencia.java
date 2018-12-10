package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    
    @NamedQuery(name="ClasseEquivalencia.findById", query="SELECT q FROM ClasseEquivalencia q WHERE codClasseEquivalencia =:id")
})
public class ClasseEquivalencia implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codClasseEquivalencia;
    private String classeInvalidaUm;
    private String classeInvalidaDois;
    private String classeValida;

    @OneToMany(mappedBy = "classeEquivalencia")
    private List<CondicaoEntrada> condicaoEntrada;
    
    
    
     
    @OneToOne(optional = false)
    @JoinColumn(name = "codvaloresct")
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

    public List<CondicaoEntrada> getCondicaoEntrada() {
        return condicaoEntrada;
    }

    public void setCondicaoEntrada(List<CondicaoEntrada> condicaoEntrada) {
        this.condicaoEntrada = condicaoEntrada;
    }

    

    public ValoresCasosTeste getValoresCasosTeste() {
        return valoresCasosTeste;
    }

    public void setValoresCasosTeste(ValoresCasosTeste valoresCasosTeste) {
        this.valoresCasosTeste = valoresCasosTeste;
    }

    





}
