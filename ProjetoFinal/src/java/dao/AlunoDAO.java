package dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import model.Aluno;

/**
 *
 * @author THAIS
 */
public class AlunoDAO {
    
    private final EntityManager entityManager;
    
    public AlunoDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    
    public boolean validaSeha(Aluno aluno){
        
        TypedQuery<Long> query = entityManager.createQuery("select count(a) from Aluno as a "
                + " where a.alunoLogin = :login "
                + " and a.alunoSenha = :senha ", Long.class);
        
        query.setParameter("login", aluno.getAlunoLogin());
        query.setParameter("senha", aluno.getAlunoSenha());
        long qtd = query.getSingleResult();
        
        if(qtd > 0){
            return true;
        }else{
            return false;
        }
    }
}
