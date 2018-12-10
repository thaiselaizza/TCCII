/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import dao.RespostaDAO;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import model.RespostaBanco;
import util.ConnectionFactory;

/**
 *
 * @author THAIS
 */
public class TestaRespostaBanco {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        EntityManager em = ConnectionFactory.getEntityManager();
        RespostaDAO dao = new RespostaDAO();
        
        List<RespostaBanco> resps = dao.getRepostasAluno2(1);
        for(RespostaBanco r: resps){
            
            System.out.println(r.getNomeAluno());
            System.out.println(r.getNomeQuestao());
            System.out.println(r.getNomeTipoCondEntrada());
            System.out.println(r.getCondEntrada());
            System.out.println(r.getClasseValida());
            System.out.println(r.getClasseInvalidaUm());
            System.out.println(r.getClasseInvalidaDois());
            System.out.println(r.getEntradaValida());
            System.out.println(r.getSaidaValida());
            System.out.println(r.getEntradaInvalidaUm());
            System.out.println(r.getSaidaInvalidaUm());
            System.out.println(r.getEntradaInvalidaDois());
            System.out.println(r.getSaidaInvalidaDois());
        }
    }
    
}
