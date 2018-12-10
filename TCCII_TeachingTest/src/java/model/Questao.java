package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
public class Questao implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codQuestao;
    private String nomeQuestao;
    @Column(length = 500, nullable = false, unique = true)
    private String enunciadoQuestao;
    private String pathClasseReferenciaQuestao;   
    
    @OneToMany(mappedBy = "questao")
    private List<Resposta> respostas;
    
    
    @ManyToOne
    @JoinColumn(name = "codtutor")
    private Tutor tutor;
    
    public Questao() {
    }

    public Questao(String nomeQuestao, String enunciadoQuestao, String pathClasseReferenciaQuestao) {
        this.nomeQuestao = nomeQuestao;
        this.enunciadoQuestao = enunciadoQuestao;
        this.pathClasseReferenciaQuestao = pathClasseReferenciaQuestao;
    }
    
    

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

  /*  public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }*/

    
    
    
}
