package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author THAIS
 */
@Entity
@NamedQueries({
    
    @NamedQuery(name="PassosTutorial.findById", query="SELECT q FROM PassosTutorial q WHERE codPasso =:id")
})
public class PassosTutorial {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codPasso;
    private String passoDescricao;
    private String passoDica;
    private String passoExemploImagem;

    public PassosTutorial() {
    }

    public PassosTutorial(String passoDescricao, String passoDica, String passoExemploImagem) {
        this.passoDescricao = passoDescricao;
        this.passoDica = passoDica;
        this.passoExemploImagem = passoExemploImagem;
    }
    
    

    public Long getCodPasso() {
        return codPasso;
    }

    public void setCodPasso(Long codPasso) {
        this.codPasso = codPasso;
    }

    public String getPassoDescricao() {
        return passoDescricao;
    }

    public void setPassoDescricao(String passoDescricao) {
        this.passoDescricao = passoDescricao;
    }

    public String getPassoDica() {
        return passoDica;
    }

    public void setPassoDica(String passoDica) {
        this.passoDica = passoDica;
    }

    public String getPassoExemploImagem() {
        return passoExemploImagem;
    }

    public void setPassoExemploImagem(String passoExemploImagem) {
        this.passoExemploImagem = passoExemploImagem;
    }
    
    
}
