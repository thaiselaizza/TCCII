/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.QuestaoDao;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Questao;
import connection.ConnectionFactory;

/**
 *
 * @author THAIS
 */

@ManagedBean(name="escolhe")
@SessionScoped
public class EscolheQuestaoBean {
   
    
    private QuestaoDao dao =  new QuestaoDao(ConnectionFactory.getEntityManager());

    public String verQuestao(){
        String valor = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        
        Questao q = dao.getQuestaoPorId(Long.parseLong(valor));
        return q.getQuestaoEnunciado();
    }
    
    public String verDetalhes(){
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestParams = context.getExternalContext().getRequestParameterMap();
        String v = (String) requestParams.get("id");
        
        
        return "tipoCondicaoEntrada?faces-redirect=true&amp;id="+v;
    }
    private Questao questao;

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
     
        
    }
    
    
}
