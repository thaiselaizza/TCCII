package model;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author THAIS
 */
@Entity
public class CondicaoEntrada {
    
    @Id
    @GeneratedValue
    private Long codCondicaoEntrada;
    private String condEntradaResposta;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "condentradacodcondentradatipo")
    private CondicaoEntradaTipo condicaoEntradaTipo;
    
    @OneToMany(mappedBy = "condicaoEntrada")
    private Collection<ClasseEquivalencia> classesEquivalencia;

    public Long getCodCondicaoEntrada() {
        return codCondicaoEntrada;
    }

    public void setCodCondicaoEntrada(Long codCondicaoEntrada) {
        this.codCondicaoEntrada = codCondicaoEntrada;
    }

    public String getCondEntradaResposta() {
        return condEntradaResposta;
    }

    public void setCondEntradaResposta(String condEntradaResposta) {
        this.condEntradaResposta = condEntradaResposta;
    }

    public CondicaoEntradaTipo getCondicaoEntradaTipo() {
        return condicaoEntradaTipo;
    }

    public void setCondicaoEntradaTipo(CondicaoEntradaTipo condicaoEntradaTipo) {
        this.condicaoEntradaTipo = condicaoEntradaTipo;
    }

    public Collection<ClasseEquivalencia> getClassesEquivalencia() {
        return classesEquivalencia;
    }

    public void setClassesEquivalencia(Collection<ClasseEquivalencia> classesEquivalencia) {
        this.classesEquivalencia = classesEquivalencia;
    }



  
    
  
}
