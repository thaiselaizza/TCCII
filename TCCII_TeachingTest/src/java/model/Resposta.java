package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
    
    @NamedQuery(name="Resposta.findById", query="SELECT q FROM Resposta q WHERE codResposta =:id")/*,
    @NamedQuery(name="Resposta.findByAluno", query="SELECT a.nomeAluno, q.nomeQuestao, t.nomeTipoCondEntrada, c.condEntrada, e.classeValida, e.classeInvalidaUm, \n" +
"e.classeInvalidaDois, v.entradaValida, v.saidaValida, v.entradaInvalidaUm, v.saidaInvalidaUm,\n" +
"v.entradaInvalidaDois, v.saidaInvalidaDois from condicaoentrada c \n" +
"JOIN tipocondicaoentrada AS t ON c.codtipocondentrada = t.codTipoCondEntrada\n" +
"JOIN classeequivalencia AS e ON c.codclasseqv = e.codClasseEquivalencia\n" +
"JOIN valorescasosteste AS v ON e.codvaloresct = v.codCasoTeste\n" +
"JOIN resposta AS r ON c.codCondicaoEntrada = r.codcondicaoentrada\n" +
"JOIN questao AS q ON r.codquestao = q.codQuestao\n" +
"JOIN aluno AS a ON r.codaluno =:codAluno"),
    @NamedQuery(name="Resposta.findQuestoes", query="SELECT r, a FROM Resposta r INNER JOIN r.codaluno a")
  */      
})
public class Resposta implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codResposta;
    
    @ManyToOne
    @JoinColumn(name="codquestao")
    private Questao questao;
    
    @ManyToOne
    @JoinColumn(name="codaluno")
    private Aluno aluno;

    
    @ManyToOne
    @JoinColumn(name = "codcondicaoentrada")
    private CondicaoEntrada condicaoEntrada;
    


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

    public CondicaoEntrada getCondicaoEntrada() {
        return condicaoEntrada;
    }

    public void setCondicaoEntrada(CondicaoEntrada condicaoEntrada) {
        this.condicaoEntrada = condicaoEntrada;
    }
    
    
}


    

    
    
    
    

