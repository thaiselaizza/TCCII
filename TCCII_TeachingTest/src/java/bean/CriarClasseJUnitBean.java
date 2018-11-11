/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.QuestaoDao;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import model.ClasseJUnit;
import model.Questao;
import util.ConnectionFactory;


/**
 *
 * @author THAIS
 */
@ManagedBean(name="classeJU")
public class CriarClasseJUnitBean {   
    
    private String nomeClasse;
    private String nomeMetodo;
    private String parametro;
    private String atributo;
    
    private QuestaoDao dao =  new QuestaoDao(ConnectionFactory.getEntityManager());

    public String getNomeClasse() {
        return nomeClasse;
    }

    public void setNomeClasse(String nomeClasse) {
        this.nomeClasse = nomeClasse;
    }

    public String getNomeMetodo() {
        return nomeMetodo;
    }

    public void setNomeMetodo(String nomeMetodo) {
        this.nomeMetodo = nomeMetodo;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public String getAtributo() {
        return atributo;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }
    
    
    
    
    
    public void criarClasseJUnit() throws IOException{ 
       
       String id = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idQuestao");        
       Questao q = dao.getQuestaoPorId(Long.parseLong(id));           
       String pathCR = q.getPathClasseReferenciaQuestao();
       
       String nomeCR = pathCR.substring(pathCR.lastIndexOf("\\")+1,pathCR.lastIndexOf("."));
        
       PrintWriter pw = null;
       //String nomeCE = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("form:txtCE");
       String nomeClasse = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("form:txtClasse");
       String nomeMetodo = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("form:txtMetodo");
       String nomeParametro = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("form:txtParametro");
       String nomeMR = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("form:comboMR");
       System.out.println("TESTE");
        System.out.println("1. " + nomeClasse);
        String nomeArquivo = nomeClasse;
        System.out.println("Nome arquivo: " + nomeArquivo);
        if(!new File(nomeArquivo).exists()){
            File diretorio = new File("D:\\Documentos\\NetBeansProjects\\TCCII_TeachingTest\\src\\java\\classerefteste");
            File arquivo = new File (diretorio,nomeArquivo + ".java");
            
            try {
                arquivo.createNewFile();
                FileWriter escrever = new FileWriter(arquivo, true);
                pw = new PrintWriter(escrever);
                pw.println("package classerefteste;");
                pw.println("import static org.junit.Assert.*; \r\n");
                pw.println("import org.junit.After;");
                pw.println("import org.junit.Before;");
                pw.println("import org.junit.Test; \r\n");
                pw.println("public class " + nomeClasse + "{ \r\n");
                pw.println("\t" + nomeCR + " " + nomeCR.substring(0,1).toLowerCase().concat(nomeCR.substring(1)) + "; \r\n");
                pw.print("\t@Before \r\n");
                pw.print("\t public void setUp() throws Exception { \r\n");
                pw.print("\t\t" + nomeCR.substring(0,1).toLowerCase().concat(nomeCR.substring(1)) + " = new " + nomeCR + "(); \r\n");
                pw.println("\t} \r\n");
                pw.print("\t@After \r\n");
                pw.print("\t public void tearDown() throws Exception{ \r\n");
                pw.println("\t } \r\n");
                pw.print("\t@Test \r\n");
                pw.print("\t public void " + nomeMetodo + "(" + nomeParametro +")" + "{ \r\n");
                pw.println("\t } \r\n");
                pw.println("}");
                System.out.println(nomeMR);
            } catch (Exception e) {
                 e.printStackTrace();
                 } finally {
                    if (pw != null) {
                    pw.close();
                 }
            }
            
        } else{
            System.out.println("Arquivo não foi criado!");
        }   
    }
}
