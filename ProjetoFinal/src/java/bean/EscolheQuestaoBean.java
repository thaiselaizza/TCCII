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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.faces.event.AjaxBehaviorEvent;
import javax.persistence.EntityManager;

/**
 *
 * @author THAIS
 */

@ManagedBean(name="escolhe")
@SessionScoped
public class EscolheQuestaoBean {
   
    private String enunciado = "";
    
    private QuestaoDao dao =  new QuestaoDao(ConnectionFactory.getEntityManager());
    
    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }
    
    public String verQuestao(){
        String id = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idQuestao");
        
        Questao q = dao.getQuestaoPorId(Long.parseLong(id));
        return q.getQuestaoEnunciado();
    }
    
    

    public void show(AjaxBehaviorEvent event){
        String enun = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("enun");      
        this.enunciado = enun;
        //System.out.println("Enunciado: "+this.enunciado);
    }
    public void mostrarEnunciado(){
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        //System.out.println("id: " + id);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("idQuestao", id);
        
        //return "listaQuestoes?faces-rediret=true";
    }
    
    public String mostrarReferencia(){
        return "classeReferencia?faces-redirect=true";
    }
    
    
    
    public String verDetalhes(){
        String sId = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idQuestao");
        //System.out.println("ID RECUPERADO DA SESSAO: " + sId);
        setEnunciado("");
        return "tipoCondicaoEntrada?faces-redirect=true&amp;id="+sId;
    }
    
    public void lerClasseReferencia(){
        
        Scanner ler = new Scanner(System.in);
        Questao q = new Questao();
        long idQ = Long.parseLong( (String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idQuestao"));
        Questao questao = dao.getQuestaoPorId(idQ);
        String nome = questao.getQuestaoCR();
        
        
        
        
        
        System.out.printf("\nConteúdo do arquivo texto:\n");
        
        try {
            FileReader arq = new FileReader(nome);
            BufferedReader lerArq = new BufferedReader(arq);
 
            String linha = lerArq.readLine(); // lê a primeira linha
            // a variável "linha" recebe o valor "null" quando o processo
            // de repetição atingir o final do arquivo texto
            while (linha != null) {
                System.out.printf("%s\n", linha);
 
            linha = lerArq.readLine(); // lê da segunda até a última linha
      }
 
      arq.close();
    } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
    }
 
    System.out.println();
    }
    
    
    private Questao questao;

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
     
        
    }
    
    
}
