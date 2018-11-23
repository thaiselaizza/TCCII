package teste;

/**
 *
 * @author THAIS
 */
import dao.QuestaoDao;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.faces.context.FacesContext;
import model.Questao;
import util.ConnectionFactory;

public class Test{   
    
    private QuestaoDao dao =  new QuestaoDao(ConnectionFactory.getEntityManager()); 
    String id = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idQuestao");
    Questao q = dao.getQuestaoPorId(Long.parseLong(id));
    String classeRef = q.getPathClasseReferenciaQuestao();
    String nomeClasseRef = classeRef.substring(classeRef.lastIndexOf("\\")+1,classeRef.lastIndexOf("."));
    String classeTeste = "";
    
    
    
    public void testando()throws IOException, InterruptedException{
        
        String line;         
           
        File dir = new File("D:\\Documentos\\NetBeansProjects\\TCCII_TeachingTest\\test\\classerefteste");
        Process p = Runtime.getRuntime().exec("javac -cp .;junit-4.12.jar *.java", null, dir);
            
            
            
        p.waitFor();
        p = Runtime.getRuntime().exec("java -cp junit-4.12.jar;hamcrest-core-1.3.jar;. org.junit.runner.JUnitCore " + classeTeste, null, dir);
            
        BufferedReader input =new BufferedReader(new InputStreamReader(p.getInputStream()));
        BufferedReader error =new BufferedReader(new InputStreamReader(p.getErrorStream()));

        System.out.println("OUTPUT");
            try
            {
                while ((line = input.readLine()) != null)
                System.out.println(line);
                
            }catch(Exception ex)
            {
                System.out.println("ERROR");
                ex.printStackTrace();
            
            }finally
            {
                input.close();
            }

            
            while ((line = error.readLine()) != null)
            System.out.println(line);
            error.close();
    }
    
   
    
           
        
}