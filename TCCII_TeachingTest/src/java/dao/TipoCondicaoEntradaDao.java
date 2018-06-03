package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.TipoCondicaoEntrada;

/**
 *
 * @author THAIS
 */
public class TipoCondicaoEntradaDao {
    
    private final EntityManager entityManager ;  //Um atributo final de uma classe pode ter seu valor atribuído uma única vez, seja na própria declaração ou no construtor. 
    
    public TipoCondicaoEntradaDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    public TipoCondicaoEntrada getDicaTipoCondicao(long id){
        Query query = entityManager.createNamedQuery("TipoCondicaoEntrada.findById").setParameter("id", id);
        return (TipoCondicaoEntrada)query.getSingleResult();
    } 
    
    public List<TipoCondicaoEntrada> listaTipoCondicaoEntrada(){
        
        Query query = entityManager.createNamedQuery("TipoCondicaoEntrada.findAll");
        return query.getResultList();
    } 
}
