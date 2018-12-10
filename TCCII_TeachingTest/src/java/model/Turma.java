/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author THAIS
 */
@Entity
public class Turma implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codTurma;
    @Column(length = 60, nullable = false, unique = true)
    private String nomeTurma;
    
    @ManyToOne(optional = false)
    @JoinColumn(name="codtutor")
    private Tutor tutor;
    
    @OneToMany(mappedBy = "turma")
    private Collection<Aluno> alunos;

    public Long getCodTurma() {
        return codTurma;
    }

    public void setCodTurma(Long codTurma) {
        this.codTurma = codTurma;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Collection<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Collection<Aluno> alunos) {
        this.alunos = alunos;
    }

    
    
    
}
