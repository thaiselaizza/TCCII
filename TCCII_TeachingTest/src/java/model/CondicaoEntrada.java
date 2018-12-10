package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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

/**
 *
 * @author THAIS
 */
@Entity
@NamedQueries({
    
    @NamedQuery(name="CondicaoEntrada.findById", query="SELECT q FROM CondicaoEntrada q WHERE codCondicaoEntrada =:id")
})
public class CondicaoEntrada implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codCondicaoEntrada;
    private String condEntrada;
    
    @OneToMany(mappedBy = "condicaoEntrada")
    private List<Resposta> resposta;
    
    @ManyToOne
    @JoinColumn(name = "codclasseqv")
    private ClasseEquivalencia classeEquivalencia;
    
    @ManyToOne
    @JoinColumn(name = "codtipocondentrada")
    private TipoCondicaoEntrada tipoCondicaoEntrada;

    public CondicaoEntrada() {
    }
    
     

    public Long getCodCondicaoEntrada() {
        return codCondicaoEntrada;
    }

    public void setCodCondicaoEntrada(Long codCondicaoEntrada) {
        this.codCondicaoEntrada = codCondicaoEntrada;
    }

    public String getCondEntrada() {
        return condEntrada;
    }

    public void setCondEntrada(String condEntrada) {
        this.condEntrada = condEntrada;
    }    

    public List<Resposta> getResposta() {
        return resposta;
    }

    public void setResposta(List<Resposta> resposta) {
        this.resposta = resposta;
    }

    public ClasseEquivalencia getClasseEquivalencia() {
        return classeEquivalencia;
    }

    public void setClasseEquivalencia(ClasseEquivalencia classeEquivalencia) {
        this.classeEquivalencia = classeEquivalencia;
    }

    public TipoCondicaoEntrada getTipoCondicaoEntrada() {
        return tipoCondicaoEntrada;
    }

    public void setTipoCondicaoEntrada(TipoCondicaoEntrada tipoCondicaoEntrada) {
        this.tipoCondicaoEntrada = tipoCondicaoEntrada;
    }

    
   
    

  
}
