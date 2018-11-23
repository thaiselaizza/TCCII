/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.QuestaoDao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import model.ClasseJUnit;
import model.ComporResposta;
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
    
    private String enunciado = "";
    
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
    
    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }
    
    
    
    public String validaEntrada(String entrada){
        
        String listValores[]; 
        List<String> arrayAux = new ArrayList<>();
        String argu = "";
        String valorCampo = "10,20,30".trim();        
               
        listValores = entrada.split(",");      
        
        for(int i=0; i < listValores.length; i++){
            if(i < listValores.length -1){
                argu += "\""+ listValores[i] + "\","; 
            }else{
                argu += "\""+ listValores[i] + "\"";
            }
           
        }
        return argu;
    }
    
    public String criarClasseJUnit() throws IOException{  
       
       String id = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idQuestao");        
       Questao q = dao.getQuestaoPorId(Long.parseLong(id));           
       //String classeExe = q.getPathClasseExecutavel();       
       //String nomeExe = classeExe.substring(classeExe.lastIndexOf("\\")+1,classeExe.lastIndexOf("."));
       String classeRef = q.getPathClasseReferenciaQuestao();
       String nomeClasseRef = classeRef.substring(classeRef.lastIndexOf("\\")+1,classeRef.lastIndexOf("."));
       
       ArrayList<ComporResposta> listaCompor = (ArrayList<ComporResposta>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("listaCompor");
       String tipoEntSelecionada = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("entrada");
       FacesContext context = FacesContext.getCurrentInstance();
       Map<String, String> parameterMap = (Map<String, String>) context.getExternalContext().getRequestParameterMap(); 
       
       String condE = "";
       int tamLista = listaCompor.size();
       int contador = 0;
       String entValida = "";
       String resultadoEspValido = "";
       String entradaInvalida1 = "";
       String entradaInvalida2 = "";
       String resultadoEspInvalido1 = "";
       String resultadoEspInvalido2 = "";
        
       PrintWriter pw = null;  
       int numCT = 1;
       
        if(!new File(nomeClasseRef).exists()){
            File diretorio = new File("D:\\Documentos\\NetBeansProjects\\TCCII_TeachingTest\\test\\classerefteste");
            File arquivo = new File (diretorio,nomeClasseRef + "Test" + ".java");
            
            try {
                arquivo.createNewFile();
                FileWriter escrever = new FileWriter(arquivo, true);
                pw = new PrintWriter(escrever);
                pw.println("import java.io.BufferedReader;");
                pw.println("import java.io.InputStreamReader;");
                pw.println("import java.io.PipedInputStream;");
                pw.println("import java.io.PipedOutputStream;");
                pw.println("import java.io.PrintStream;");
                pw.println("import org.junit.*;");
                pw.println("import static org.junit.Assert.*; \r\n");
                pw.println("public class " + nomeClasseRef + "Test" + " { \r\n"); 
                pw.println("    private PrintStream orig;");
                pw.println("    private PrintStream outStream;");
                pw.println("    private BufferedReader buf;");
                pw.println("    public " + nomeClasseRef + "Test() {");
                pw.println("    } \r\n");
                pw.println("    @BeforeClass");
                pw.println("    public static void setUpClass() {");
                pw.println("    } \r\n");
                pw.println("    @AfterClass");
                pw.println("    public static void tearDownClass() {");
                pw.println("    } \r\n");
                pw.println("    @Before");
                pw.println("    public void setUp() { \r\n");                
                pw.println("        this.orig = System.out;");
                pw.println("        PipedOutputStream pipeOut = new PipedOutputStream();");
                pw.println("        this.outStream = new PrintStream(pipeOut);");
                pw.println("        System.setOut(this.outStream);");
                pw.println("        try {");
                pw.println("            buf = new BufferedReader(new InputStreamReader(new PipedInputStream(pipeOut)));");
                pw.println("        } catch (Exception e) {");
                pw.println("            throw new RuntimeException(\"An error occured while rerouting System.out\");");
                pw.println("        }");
                pw.println("    } \r\n");                             
                pw.println("    @After ");
                pw.println("    public void tearDown() { \r\n");
                pw.println("        this.outStream.flush();");
                pw.println("        this.outStream.close();");
                pw.println("        System.setOut(this.orig);");
                pw.println("    } \r\n");
                
                
                for(int i = 0; i < tamLista; i++){
                    condE = parameterMap.get("formCT:tabelaCasosTeste:"+String.valueOf(contador)+":tipoCondicao");
                    System.out.println(condE);
                    if((condE.equals("intervalo")) || (condE.equals("valor especifico"))){
            
                        entValida = parameterMap.get("formCT:tabelaCasosTeste:"+String.valueOf(contador)+":txtValido");
                        resultadoEspValido = parameterMap.get("formCT:tabelaCasosTeste:"+String.valueOf(contador)+":txtSaidaValida");
                        entradaInvalida1 = parameterMap.get("formCT:tabelaCasosTeste:"+String.valueOf(contador)+":tabelaColuna:0:txtInvalido");  
                        entradaInvalida2 = parameterMap.get("formCT:tabelaCasosTeste:"+String.valueOf(contador)+":tabelaColuna:1:txtInvalido");  
                        resultadoEspInvalido1 = parameterMap.get("formCT:tabelaCasosTeste:"+String.valueOf(contador)+":tabelaColunaSE:0:txtSaidaInvalida");
                        resultadoEspInvalido2 = parameterMap.get("formCT:tabelaCasosTeste:"+String.valueOf(contador)+":tabelaColunaSE:1:txtSaidaInvalida");

                        
                        pw.println("    @Test");
                        pw.println("    public void " + "casoTeste" + String.valueOf(numCT) + "()" + "{ \r\n");
                        pw.println("        try{");
                        pw.println("            String[] args = {"  + validaEntrada(entValida) + "};");
                        pw.println("            " + nomeClasseRef + ".main(args);");
                        pw.println("            String resultadoEsperado = \"" + resultadoEspValido + "\";");                        
                        pw.println("            String resultadoAtual = this.buf.readLine();");
                        pw.println("            assertEquals(resultadoEsperado,resultadoAtual);");
                        pw.println("        } catch (Exception e){");
                        pw.println("            fail(\"Exception occurred: \" + e.getMessage());");
                        pw.println("        }");
                        pw.println("    } \r\n");                        
                        numCT += 1;

                        pw.println("    @Test");
                        pw.println("    public void " + "casoTeste" + String.valueOf(numCT) + "()" + "{ \r\n");
                        pw.println("        try{");
                        pw.println("            String[] args = {"  + validaEntrada(entradaInvalida1) + "};");
                        pw.println("            " + nomeClasseRef + ".main(args);");
                        pw.println("            String resultadoEsperado = \"" + resultadoEspInvalido1 + "\";");
                        pw.println("            String resultadoAtual = this.buf.readLine();");
                        pw.println("            assertEquals(resultadoEsperado,resultadoAtual);");
                        pw.println("        } catch (Exception e){");
                        pw.println("            fail(\"Exception occurred: \" + e.getMessage());");
                        pw.println("        }");                        
                        pw.println("    } \r\n");
                        numCT += 1;

                        pw.println("    @Test");
                        pw.println("    public void " + "casoTeste" + String.valueOf(numCT) + "()" + "{ \r\n");
                        pw.println("        try{");
                        pw.println("            String[] args = {"  + validaEntrada(entradaInvalida2) + "};");
                        pw.println("            " + nomeClasseRef + ".main(args);");
                        pw.println("            String resultadoEsperado = \"" + resultadoEspInvalido2 + "\";");
                        pw.println("            String resultadoAtual = this.buf.readLine();");
                        pw.println("            assertEquals(resultadoEsperado,resultadoAtual);");
                        pw.println("        } catch (Exception e){");
                        pw.println("            fail(\"Exception occurred: \" + e.getMessage());");
                        pw.println("        }"); 
                        pw.println("    } \r\n");
                        numCT += 1;
                        
                        
                        
                        if(i == tamLista - 1){  
                            pw.println("} \r\n");
                            
                            System.out.println(entValida);
                            System.out.println(resultadoEspValido);
                            System.out.println(entradaInvalida1);
                            System.out.println(entradaInvalida2);
                            System.out.println(resultadoEspInvalido1);
                            System.out.println(resultadoEspInvalido2);
                            
                        }
                    }else{                        
                        
                        entValida = parameterMap.get("formCT:tabelaCasosTeste:"+String.valueOf(contador)+":txtValido");
                        resultadoEspValido = parameterMap.get("formCT:tabelaCasosTeste:"+String.valueOf(contador)+":txtSaidaValida");
                        entradaInvalida1 = parameterMap.get("formCT:tabelaCasosTeste:"+String.valueOf(contador)+":tabelaColuna:0:txtInvalido");          
                        resultadoEspInvalido1= parameterMap.get("formCT:tabelaCasosTeste:"+String.valueOf(contador)+":tabelaColunaSE:0:txtSaidaInvalida");
                        
                        
                        pw.println("    @Test");
                        pw.println("    public void " + "casoTeste" + String.valueOf(numCT) + "()" + "{ \r\n");
                        pw.println("        try{");
                        pw.println("            String[] args = {"  + validaEntrada(entValida) + "};");
                        pw.println("            " + nomeClasseRef + ".main(args);");
                        pw.println("            String resultadoEsperado = \"" + resultadoEspValido + "\";");
                        pw.println("            String resultadoAtual = this.buf.readLine();");
                        pw.println("            assertEquals(resultadoEsperado,resultadoAtual);");
                        pw.println("        } catch (Exception e){");
                        pw.println("            fail(\"Exception occurred: \" + e.getMessage());");
                        pw.println("        }");                        
                        pw.println("    } \r\n");
                        numCT += 1;

                        pw.println("    @Test");
                        pw.println("    public void " + "casoTeste" + String.valueOf(numCT) + "()" + "{ \r\n");
                        pw.println("        try{");
                        pw.println("            String[] args = {"  + validaEntrada(entradaInvalida1) + "};");
                        pw.println("            " + nomeClasseRef + ".main(args);");
                        pw.println("            String resultadoEsperado = \"" + resultadoEspInvalido1 + "\";");
                        pw.println("            String resultadoAtual = this.buf.readLine();");
                        pw.println("            assertEquals(resultadoEsperado,resultadoAtual);");
                        pw.println("        } catch (Exception e){");
                        pw.println("            fail(\"Exception occurred: \" + e.getMessage());");
                        pw.println("        }");                                                                
                        pw.println("    } \r\n");  
                        numCT += 1;
                                  
                        
                        if(i == tamLista - 1){  
                            pw.println("} \r\n");
                            
                        }
                    } 
                    
                    contador += 1;
                }                    
                
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
        String sId = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idQuestao");
        //System.out.println("ID RECUPERADO DA SESSAO: " + sId);
        setEnunciado("");
        return "executarClasseJUnit?faces-redirect=true&amp;id="+sId;
}
    
    
    
    
    public void executarJUnit()throws IOException, InterruptedException{
        
         
       String id = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idQuestao");        
       Questao q = dao.getQuestaoPorId(Long.parseLong(id));           
       //String classeExe = q.getPathClasseExecutavel();       
       //String nomeExe = classeExe.substring(classeExe.lastIndexOf("\\")+1,classeExe.lastIndexOf("."));
       String classeRef = q.getPathClasseReferenciaQuestao();
       String nomeClasseRef = classeRef.substring(classeRef.lastIndexOf("\\")+1,classeRef.lastIndexOf("."));
       String classeTeste = nomeClasseRef + "Test";
        
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
