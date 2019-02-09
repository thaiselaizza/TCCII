package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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
            @NamedQuery(name="Aluno.findByName", query="SELECT a FROM Aluno a WHERE a.loginAluno = :login"),
            @NamedQuery(name="Aluno.findAll", query="SELECT a FROM Aluno a")
})
public class Aluno implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codAluno;
    @Column(length = 200, nullable = false ,unique = true)
    private String nomeAluno;
    private String loginAluno;
    private String senhaAluno;
    
    @OneToMany(mappedBy = "aluno")
    private List<Resposta> respostasAluno;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "codturma")
    private Turma turma;

    public Long getCodAluno() {
        return codAluno;
    }

    public void setCodAluno(Long codAluno) {
        this.codAluno = codAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getLoginAluno() {
        return loginAluno;
    }

    public void setLoginAluno(String loginAluno) {
        this.loginAluno = loginAluno;
    }

    public String getSenhaAluno() {
        return senhaAluno;
    }

    public void setSenhaAluno(String senhaAluno) {
        this.senhaAluno = senhaAluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public List<Resposta> getRespostasAluno() {
        return respostasAluno;
    }

    public void setRespostasAluno(List<Resposta> respostasAluno) {
        this.respostasAluno = respostasAluno;
    }

    
    
    
}
