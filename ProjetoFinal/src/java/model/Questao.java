package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author THAIS
 */

@Entity
@NamedQueries({
    @NamedQuery(name="Questao.findAll", query="SELECT q FROM Questao q"),
    @NamedQuery(name="Questao.findById", query="SELECT q FROM Questao q WHERE questaoId =:id")
})

public class Questao {
    
    @Id
    @GeneratedValue
    private Long questaoId;
    private String questaoNome;
    private String questaoEnunciado;
    private String questaoCR;

    public Questao() {
    }

    public Questao(String questaoNome, String questaoEnunciado, String questaoCR) {
        this.questaoNome = questaoNome;
        this.questaoEnunciado = questaoEnunciado;
        this.questaoCR = questaoCR;
    }

    public Long getQuestaoId() {
        return questaoId;
    }

    public void setQuestaoId(Long questaoId) {
        this.questaoId = questaoId;
    }

    public String getQuestaoNome() {
        return questaoNome;
    }

    public void setQuestaoNome(String questaoNome) {
        this.questaoNome = questaoNome;
    }

    public String getQuestaoEnunciado() {
        return questaoEnunciado;
    }

    public void setQuestaoEnunciado(String questaoEnunciado) {
        this.questaoEnunciado = questaoEnunciado;
    }

    public String getQuestaoCR() {
        return questaoCR;
    }

    public void setQuestaoCR(String questaoCR) {
        this.questaoCR = questaoCR;
    }
    
    

    
    
    
    
    
}
