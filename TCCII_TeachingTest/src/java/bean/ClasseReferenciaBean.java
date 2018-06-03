package bean;

import util.ConnectionFactory;
import dao.QuestaoDao;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import model.Questao;

/**
 *
 * @author THAIS
 */
@ManagedBean(name="cr")
@SessionScoped
public class ClasseReferenciaBean {
    
    private String conteudoClasseRef = "Inicial";
    private QuestaoDao dao =  new QuestaoDao(ConnectionFactory.getEntityManager());

    public String getConteudoClasseRef() {
        return conteudoClasseRef;
    }

    public void setConteudoClasseRef(String conteudoClasseRef) {
        this.conteudoClasseRef = conteudoClasseRef;
    }
    public void teste(){
        System.out.println("Teste");
    }
    
    public void mostrarConteudoClasseRef(){
        System.out.println("inicio");
        this.conteudoClasseRef = "teste";
        String id = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idQuestao");        
        Questao q = dao.getQuestaoPorId(Long.parseLong(id));           
        String nome = q.getPathClasseReferenciaQuestao();       
        String texto = "";
        
               
        try {
            FileReader arq = new FileReader(nome);
            BufferedReader lerArq = new BufferedReader(arq);
 
            String linha = lerArq.readLine(); // lê a primeira linha
            // a variável "linha" recebe o valor "null" quando o processo
            // de repetição atingir o final do arquivo texto
            while (linha != null) {
                //System.out.printf("%s\n", linha);
                texto += linha;
 
            linha = lerArq.readLine(); // lê da segunda até a última linha
      }
 
      arq.close();
      this.conteudoClasseRef = texto;
      System.out.println("Conteudo: " + conteudoClasseRef);
    } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
    }
        
    }
}
