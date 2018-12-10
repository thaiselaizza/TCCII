/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Resposta;
import model.RespostaBanco;

/**
 *
 * @author THAIS
 */
public class RespostaDAO {
    
    private EntityManager entityManager;
    
    public RespostaDAO(){
    }
    
    public RespostaDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    public void salvarResposta(Resposta resposta){
        try{
            entityManager.getTransaction().begin();
            System.out.println("Salvando resposta.");        
            entityManager.persist(resposta);       
            entityManager.getTransaction().commit();   
        }catch(Exception e){
            System.out.println("Erro RespostaDAO: "+ e.getMessage());
        }finally{
            
            
        }
        
    }
    
    public Resposta getIdResposta(long id){
         Query query = entityManager.createNamedQuery("Resposta.findById").setParameter("id", id);        
        return (Resposta)query.getSingleResult();
    }
    
    public List<RespostaBanco> getRepostasAluno(long id){
        List<RespostaBanco> respostas = new ArrayList<RespostaBanco>();
        Query query = entityManager.createNamedQuery("Resposta.findQuestoes");//.setParameter("codA", id);
        for(Object resp : query.getResultList()){
            System.out.println(resp);
        }
        return respostas;
    }
    public List<RespostaBanco> getRepostasAluno2(long id) throws SQLException, ClassNotFoundException{
        List<RespostaBanco> respostas = new ArrayList<RespostaBanco>();
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bancoteaching", "root", "root");
        PreparedStatement pStatement = null;
        //Statement stmt = con.createStatement();
        String query = "select  * from resposta as r\n" +
"inner join aluno as a on a.codAluno = r.codaluno\n" +
"inner join questao q on q.codQuestao = r.codquestao\n" +
"inner join condicaoentrada as c on c.codCondicaoEntrada = r.codcondicaoentrada\n" +
"inner join tipocondicaoentrada as t on t.codTipoCondEntrada = c.codtipocondentrada\n" +
"inner join classeequivalencia as eqv on eqv.codClasseEquivalencia = c.codclasseqv\n" +
"inner join valorescasosteste as v on v.codCasoTeste = eqv.codvaloresct\n" +
"where r.codaluno = ?";
        pStatement = con.prepareStatement(query);
        pStatement.setLong(1, id);
        ResultSet rs = pStatement.executeQuery();
        while(rs.next()){
            RespostaBanco resposta = new RespostaBanco();
            resposta.setNomeAluno(rs.getString("loginAluno"));
            resposta.setNomeQuestao(rs.getString("nomeQuestao"));
            resposta.setNomeTipoCondEntrada(rs.getString("nomeTipoCondEntrada"));
            resposta.setCondEntrada(rs.getString("condEntrada"));
            resposta.setClasseValida(rs.getString("classeValida"));
            resposta.setClasseInvalidaUm(rs.getString("classeInvalidaUm"));
            resposta.setClasseInvalidaDois(rs.getString("classeInvalidaDois"));
            resposta.setEntradaValida(rs.getString("entradaValida"));
            resposta.setSaidaValida(rs.getString("saidaValida"));
            resposta.setEntradaInvalidaUm(rs.getString("entradaInvalidaUm"));
            resposta.setSaidaInvalidaUm(rs.getString("saidaInvalidaUm"));
            resposta.setEntradaInvalidaDois(rs.getString("entradaInvalidaDois"));
            resposta.setSaidaInvalidaDois(rs.getString("saidaInvalidaDois"));
            
            respostas.add(resposta);
        }
        System.out.println("fim");
        con.close();
        return respostas;
    }    
    
}
