package dao;

import java.util.ArrayList;
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
    public TipoCondicaoEntrada getTipoCondicaoByName(String name){
        Query query = entityManager.createNamedQuery("TipoCondicaoEntrada.findByName").setParameter("name", name);
        return (TipoCondicaoEntrada)query.getSingleResult();
    }
    
    public TipoCondicaoEntrada getTipoCE(String name){
        System.out.println("Entrada para pesquisa: " + name);
        Query query = entityManager.createNamedQuery("TipoCondicaoEntrada.findCE").setParameter("tipoCE", name);
        return (TipoCondicaoEntrada)query.getSingleResult();
    }
    
    public List<TipoCondicaoEntrada> listaTipoCondicaoEntrada(){
        
        Query query = entityManager.createNamedQuery("TipoCondicaoEntrada.findAll");
        /*
        List<TipoCondicaoEntrada> lista = new ArrayList<TipoCondicaoEntrada>();
        TipoCondicaoEntrada newTipo = new TipoCondicaoEntrada();
        newTipo.setNomeTipoCondicaoEntrada("");
        lista.add(newTipo);
        for(Object t: query.getResultList()){
            lista.add((TipoCondicaoEntrada) t);
        }
        return lista;
        
        
        */
        return query.getResultList();
    } 
}
