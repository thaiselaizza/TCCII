package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
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
    @NamedQuery(name="TipoCondicaoEntrada.findAll", query="SELECT t FROM TipoCondicaoEntrada t"),
    @NamedQuery(name="TipoCondicaoEntrada.findByName",query="SELECT t FROM TipoCondicaoEntrada t WHERE nomeTipoCondEntrada =:name"),
    @NamedQuery(name="TipoCondicaoEntrada.findCE", query="select t FROM TipoCondicaoEntrada t WHERE nomeTipoCondEntrada =:tipoCE")
   

})
public class TipoCondicaoEntrada implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codTipoCondEntrada;
    private String tipoCondicao;
    private String exemploCondicao;
    private String nomeTipoCondEntrada;
    private int qtdClasseInvalida;
    private int qtdClasseValida;
    
    @OneToMany(mappedBy = "tipoCondicaoEntrada")
    private List<CondicaoEntrada> condicaoEntrada;

    public Long getCodTipoCondEntrada() {
        return codTipoCondEntrada;
    }

    public void setCodTipoCondEntrada(Long codTipoCondEntrada) {
        this.codTipoCondEntrada = codTipoCondEntrada;
    }

    public String getTipoCondicao() {
        return tipoCondicao;
    }

    public void setTipoCondicao(String tipoCondicao) {
        this.tipoCondicao = tipoCondicao;
    }

    public String getExemploCondicao() {
        return exemploCondicao;
    }

    public void setExemploCondicao(String exemploCondicao) {
        this.exemploCondicao = exemploCondicao;
    }

    public String getNomeTipoCondEntrada() {
        return nomeTipoCondEntrada;
    }

    public void setNomeTipoCondEntrada(String nomeTipoCondEntrada) {
        this.nomeTipoCondEntrada = nomeTipoCondEntrada;
    }

    public int getQtdClasseInvalida() {
        return qtdClasseInvalida;
    }

    public void setQtdClasseInvalida(int qtdClasseInvalida) {
        this.qtdClasseInvalida = qtdClasseInvalida;
    }

    public int getQtdClasseValida() {
        return qtdClasseValida;
    }

    public void setQtdClasseValida(int qtdClasseValida) {
        this.qtdClasseValida = qtdClasseValida;
    }

    public List<CondicaoEntrada> getCondicaoEntrada() {
        return condicaoEntrada;
    }

    public void setCondicaoEntrada(List<CondicaoEntrada> condicaoEntrada) {
        this.condicaoEntrada = condicaoEntrada;
    }

  

    
    
  
    
}
