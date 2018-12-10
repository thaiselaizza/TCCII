package dao;

import java.util.List;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Aluno;
import model.Questao;
import util.ConnectionFactory;

/**
 *
 * @author THAIS
 */
public class QuestaoDao {
    
    private EntityManager entityManager ;  //Um atributo final de uma classe pode ter seu valor atribuído uma única vez, seja na própria declaração ou no construtor. 
    
    public QuestaoDao(){
    }
    
    public QuestaoDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
   
    
    public List<Questao> listaQuestao(){
        Aluno aluno = (Aluno) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("aluno");
        System.out.println("Aluno------------------" + aluno.getLoginAluno());
        Query query = entityManager.createNamedQuery("Questao.findAll");
        return query.getResultList();
    }
    
    public Questao getQuestaoPorId(long id){     
        Query query = entityManager.createNamedQuery("Questao.findById").setParameter("id", id);
        return (Questao)query.getSingleResult();
    }    
}
