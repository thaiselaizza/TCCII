package model;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author THAIS
 */


@Entity
@NamedQueries({
    @NamedQuery(name="TipoCondicaoEntrada.findAll", query="SELECT t FROM TipoCondicaoEntrada t")
    
})
public class TipoCondicaoEntrada {
    
    @Id
    @GeneratedValue
    private Long codTipoCondEntrada;
    private String tipoCondicao;
    private String exemploCondicao;
    private String nomeTipoCondEntrada;
    private int qtdClasseInvalida;
    private int qtdClasseValida;
    
    @OneToOne
    @JoinColumn(name = "centradacodtipocondentrada")
    private TipoCondicaoEntrada tipoCondEntrada;

  

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

    public String getNomeTipoCondicaoEntrada() {
        return nomeTipoCondEntrada;
    }

    public void setNomeTipoCondicaoEntrada(String nomeTipoCondEntrada) {
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

    public TipoCondicaoEntrada getTipoCondEntrada() {
        return tipoCondEntrada;
    }

    public void setTipoCondEntrada(TipoCondicaoEntrada tipoCondEntrada) {
        this.tipoCondEntrada = tipoCondEntrada;
    }

    
    
    
}
