/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.AlunoDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import model.Aluno;
import util.ConnectionFactory;

/**
 *
 * @author THAIS
 */
@ManagedBean
public class ListaAlunoBean {
    
    private AlunoDAO dao =  new AlunoDAO(ConnectionFactory.getEntityManager());
    private List<Aluno> listaAluno = dao.listaAluno();
    private Aluno questao = new Aluno();

    public ListaAlunoBean() {
    }

    public AlunoDAO getDao() {
        return dao;
    }

    public void setDao(AlunoDAO dao) {
        this.dao = dao;
    }

    public List<Aluno> getListaAluno() {
        return listaAluno;
    }

    public void setListaAluuno(List<Aluno> listaAluuno) {
        this.listaAluno = listaAluuno;
    }

    public Aluno getQuestao() {
        return questao;
    }

    public void setQuestao(Aluno questao) {
        this.questao = questao;
    }
    
    
}
