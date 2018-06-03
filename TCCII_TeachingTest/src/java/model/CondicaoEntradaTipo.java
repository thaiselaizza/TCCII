package model;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author THAIS
 */
@Entity
public class CondicaoEntradaTipo {
    
    @Id
    @GeneratedValue
    private Long codCondEntradaTipo;
    private String descricaoCondicao;
    
    @ManyToOne(optional = false)
    @JoinColumn(name="condetcodresposta")
    private Resposta resposta;

    @OneToMany(mappedBy = "condicaoEntradaTipo")
    private Collection<CondicaoEntrada> condicoesEntrada;

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

    public Resposta getResposta() {
        return resposta;
    }

    public void setResposta(Resposta resposta) {
        this.resposta = resposta;
    }

    public Collection<CondicaoEntrada> getCondicoesEntrada() {
        return condicoesEntrada;
    }

    public void setCondicoesEntrada(Collection<CondicaoEntrada> condicoesEntrada) {
        this.condicoesEntrada = condicoesEntrada;
    }

    
    

    
    
}
