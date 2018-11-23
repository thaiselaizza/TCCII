package model;

import javax.persistence.Column;
import javax.persistence.Entity;
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
    @NamedQuery(name="Questao.findAll", query="SELECT q FROM Questao q"),
    @NamedQuery(name="Questao.findById", query="SELECT q FROM Questao q WHERE codQuestao =:id")
})
public class Questao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codQuestao;
    private String nomeQuestao;
    @Column(length = 500, nullable = false, unique = true)
    private String enunciadoQuestao;
    private String pathClasseReferenciaQuestao;
    private String pathClasseExecutavel;
    
    public Questao() {
    }

    public Questao(String nomeQuestao, String enunciadoQuestao, String pathClasseReferenciaQuestao) {
        this.nomeQuestao = nomeQuestao;
        this.enunciadoQuestao = enunciadoQuestao;
        this.pathClasseReferenciaQuestao = pathClasseReferenciaQuestao;
    }
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "questaocodtutor")
    private Tutor tutor;

    public Long getCodQuestao() {
        return codQuestao;
    }

    public void setCodQuestao(Long codQuestao) {
        this.codQuestao = codQuestao;
    }

    public String getNomeQuestao() {
        return nomeQuestao;
    }

    public void setNomeQuestao(String nomeQuestao) {
        this.nomeQuestao = nomeQuestao;
    }

    public String getEnunciadoQuestao() {
        return enunciadoQuestao;
    }

    public void setEnunciadoQuestao(String enunciadoQuestao) {
        this.enunciadoQuestao = enunciadoQuestao;
    }

    public String getPathClasseReferenciaQuestao() {
        return pathClasseReferenciaQuestao;
    }

    public void setPathClasseReferenciaQuestao(String pathClasseReferenciaQuestao) {
        this.pathClasseReferenciaQuestao = pathClasseReferenciaQuestao;
    }

    public String getPathClasseExecutavel() {
        return pathClasseExecutavel;
    }

    public void setPathClasseExecutavel(String pathClasseExecutavel) {
        this.pathClasseExecutavel = pathClasseExecutavel;
    }
    
    
    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    
    
    
}
