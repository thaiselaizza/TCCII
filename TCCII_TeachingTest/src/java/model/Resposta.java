package model;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author THAIS
 */
@Entity
public class Resposta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codResposta;
    
    @OneToOne
    @JoinColumn(name = "respostacodquestao")
    private Questao questao;
    
    @OneToOne
    @JoinColumn(name = "respostacodaluno")
    private Aluno aluno;
    
    @OneToMany(mappedBy = "resposta")
    private Collection<CondicaoEntradaTipo> condicoesET;

    public Long getCodResposta() {
        return codResposta;
    }

    public void setCodResposta(Long codResposta) {
        this.codResposta = codResposta;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Collection<CondicaoEntradaTipo> getCondicoesET() {
        return condicoesET;
    }

    public void setCondicoesET(Collection<CondicaoEntradaTipo> condicoesET) {
        this.condicoesET = condicoesET;
    }

    
    
    
    
}
