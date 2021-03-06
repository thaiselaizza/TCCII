/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author THAIS
 */
@Entity
@NamedQuery(name="Tutor.findByName", query="SELECT t FROM Tutor t WHERE t.loginTutor = :login")
public class Tutor implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codTutor;
    @Column(length = 200, nullable = false, unique = true)
    private String nomeTutor;
    private String loginTutor;
    private String senhaTutor;
    
    @OneToMany(mappedBy = "tutor")
    private List<Turma> turmas;
    
    @OneToMany(mappedBy = "tutor")
    private List<Questao> questoes;

    public Long getCodTutor() {
        return codTutor;
    }

    public void setCodTutor(Long codTutor) {
        this.codTutor = codTutor;
    }

    public String getNomeTutor() {
        return nomeTutor;
    }

    public void setNomeTutor(String nomeTutor) {
        this.nomeTutor = nomeTutor;
    }

    public String getLoginTutor() {
        return loginTutor;
    }

    public void setLoginTutor(String loginTutor) {
        this.loginTutor = loginTutor;
    }

    public String getSenhaTutor() {
        return senhaTutor;
    }

    public void setSenhaTutor(String senhaTutor) {
        this.senhaTutor = senhaTutor;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

  

    

    
    
}
