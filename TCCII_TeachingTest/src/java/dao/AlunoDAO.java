package dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.Aluno;
import util.ConnectionFactory;

/**
 *
 * @author THAIS
 */
public class AlunoDAO {
    
    private EntityManager entityManager;
    
    public AlunoDAO(){
    }
    public AlunoDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    public Aluno buscarPorLogin(String nome){
        Query query = entityManager.createNamedQuery("Aluno.findByName").setParameter("login", nome);
        return (Aluno) query.getSingleResult();
    }


    
    public boolean validaSeha(Aluno aluno){
        TypedQuery<Long> query = entityManager.createQuery("select count(a) from Aluno as a "
                + " where a.loginAluno = :login "
                + " and a.senhaAluno = :senha ", Long.class);
        
        query.setParameter("login", aluno.getLoginAluno());
        query.setParameter("senha", aluno.getSenhaAluno());
        long qtd = query.getSingleResult();
        
        if(qtd > 0){
            return true;
        }else{
            return false;
        }
    }

    public Aluno buscar(Long idAluno) {
        System.out.println("ID ALUNO: " + idAluno);
        return entityManager.find(Aluno.class, idAluno);
    }
}
