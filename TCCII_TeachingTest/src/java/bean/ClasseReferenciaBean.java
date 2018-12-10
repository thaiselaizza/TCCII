package bean;

import util.ConnectionFactory;
import dao.QuestaoDao;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
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
                texto += linha + "\n";
 
            linha = lerArq.readLine(); // lê da segunda até a última linha
                System.out.println(linha);
      }
 
      arq.close();
      this.conteudoClasseRef = texto;
      System.out.println("Conteudo: " + conteudoClasseRef);
    } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
    }        
            
    }
    
    public List<String> listarMetodosClasse(){
        String id = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idQuestao");        
        Questao q = dao.getQuestaoPorId(Long.parseLong(id));           
        String pathCR = q.getPathClasseReferenciaQuestao();
        ArrayList<String> listaMetodos = new ArrayList();
        
        try {
            String nomeClasse = pathCR.substring(pathCR.lastIndexOf("\\")+1,pathCR.lastIndexOf("."));
            System.out.println(nomeClasse);
            
            Class c = (Class)Class.forName(nomeClasse);
            
            Method[] m = c.getDeclaredMethods();
            
            for (int i = 0; i < m.length; i++){
                String metodoAux = m[i].toString().substring(m[i].toString().lastIndexOf(".")+1, m[i].toString().lastIndexOf(")")+1);
                
                String metodo = metodoAux.replaceAll("\\(.*\\)", "()");
                    listaMetodos.add(metodo);  
                    System.out.println(listaMetodos);
                //}               
            }
            
              
            
        } catch (Throwable e) {
            System.err.println(e);
        }
        return listaMetodos;
    }
    
}
