package model;

import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author THAIS
 */
/*@Entity
public class CondicaoEntradaTipo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codCondEntradaTipo;
    private String descricaoCondicao;
    
    @OneToMany(mappedBy = "condicaoEntradaTipo")
    private List<Resposta> resposta;
    
    @OneToMany(mappedBy = "condicaoEntradaTipo")
    private List<CondicaoEntrada> condicaoEntrada;
    
    @ManyToOne
    @JoinColumn(name = "codcondicaoentradatipo")
    private TipoCondicaoEntrada tipoCondicaoEntrada;
  

    public Long getCodCondEntradaTipo() {
        return codCondEntradaTipo;
    }

    public void setCodCondEntradaTipo(Long codCondEntradaTipo) {
        this.codCondEntradaTipo = codCondEntradaTipo;
    }

    public String getDescricaoCondicao() {
        return descricaoCondicao;
    }

    public void setDescricaoCondicao(String descricaoCondicao) {
        this.descricaoCondicao = descricaoCondicao;
    }

 

 
    
    

    
    
}
*/