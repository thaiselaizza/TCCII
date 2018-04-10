package model;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

/**
 *
 * @author THAIS
 */
@Entity
public class Tutor {
    
    @Id
    @GeneratedValue    
    private Long idTutor;
    @Column(length = 200,nullable = false,unique = true)
    private String nomeTutor;
    @Column(length = 100,nullable = false,unique = true)
    private String loginTutor;
    @Column(length = 100,nullable = false,unique = true)
    private String senhaTutor;
    
    @OneToMany
    @JoinTable(name = "tutorturma",
            joinColumns = @JoinColumn(name = "idtutor"),
            inverseJoinColumns = @JoinColumn(name = "idturma"))
    private Collection<Turma> turmas;


    public Long getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(Long idTutor) {
        this.idTutor = idTutor;
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
    
    
    
}
