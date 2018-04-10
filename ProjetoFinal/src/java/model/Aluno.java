package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author THAIS
 */
@Entity
public class Aluno {
    
    @Id
    @GeneratedValue
    private Long alunoId;
    private String alunoNome;
    private String alunoLogin;
    private String alunoSenha;

    public Long getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Long alunoId) {
        this.alunoId = alunoId;
    }

    public String getAlunoNome() {
        return alunoNome;
    }

    public void setAlunoNome(String alunoNome) {
        this.alunoNome = alunoNome;
    }

    public String getAlunoLogin() {
        return alunoLogin;
    }

    public void setAlunoLogin(String alunoLogin) {
        this.alunoLogin = alunoLogin;
    }

    public String getAlunoSenha() {
        return alunoSenha;
    }

    public void setAlunoSenha(String alunoSenha) {
        this.alunoSenha = alunoSenha;
    }
    
    
        
}
