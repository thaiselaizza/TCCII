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
import util.ConnectionFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.faces.component.html.HtmlInputText;
import javax.faces.event.AjaxBehaviorEvent;
import javax.persistence.EntityManager;
import model.ClasseEquivalencia;
import model.ComporResposta;
import model.CondicaoEntrada;
import model.RespostaAdicional;

/**
 *
 * @author THAIS
 */

@ManagedBean(name="escolhe")
@SessionScoped
public class EscolheQuestaoBean {
   
    private String enunciado = "";
    
    private QuestaoDao dao =  new QuestaoDao(ConnectionFactory.getEntityManager()); 
    private List<String> validas = new ArrayList<String>();
    private List<String> invalidas =  new ArrayList<String>();

    public List<String> getValidas() {
        return validas;
    }

    public void setValidas(List<String> validas) {
        this.validas = validas;
    }

    public List<String> getInvalidas() {
        return invalidas;
    }

    public void setInvalidas(List<String> invalidas) {
        this.invalidas = invalidas;
    }
    
    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }
    
    public String verQuestao(){
        String id = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idQuestao");
        
        Questao q = dao.getQuestaoPorId(Long.parseLong(id));
        return q.getEnunciadoQuestao();
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
        setEnunciado("");
        ArrayList<ComporResposta> listaCompor = new ArrayList();
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("listaCompor",listaCompor);
        return "tipoCondicaoEntradaTeste?faces-redirect=true&amp;id="+sId;
    }
    
    public String verDetalhes1(){
        String sId = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idQuestao");
        setEnunciado("");
        return "tipoCondicaoEntradaParteUm?faces-redirect=true&amp;id="+sId;
    }
    
    public String verDetalhes2(){
        String sId = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idQuestao");
        //System.out.println("ID RECUPERADO DA SESSAO: " + sId);
        setEnunciado("");
        return "selecionarTipoCondicaoEntrada?faces-redirect=true&amp;id="+sId;
    }
    
    public String verDetalhes3(){
        String sId = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idQuestao");
        String tipoEntSelecionada = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("entrada");
        ComporResposta resposta = new ComporResposta();
        resposta.setRespTipoCE(tipoEntSelecionada);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("resposta",resposta);        
        setEnunciado("");
        System.out.println("Está chamando a tela");
        return "condicaoEntrada?faces-redirect=true&amp;id="+sId;
    }
    
    public String verDetalhes4(){
        String sId = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idQuestao");
        //System.out.println("ID RECUPERADO DA SESSAO: " + sId);
        setEnunciado("");
        return "identificarCondicaoEntrada?faces-redirect=true&amp;id="+sId;
    }
    
    public String verDetalhes5(){
        String sId = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idQuestao");
             
        //String condicaoEntrada = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("textCondicaoEntrada");
        String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("form:textCondicaoEntrada");
        CondicaoEntrada condEntrada = new CondicaoEntrada();
        condEntrada.setCondEntradaResposta(value);
        ComporResposta resposta = (ComporResposta) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("resposta");
        resposta.setCondicaoEntrada(condEntrada);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("resposta",resposta);
        System.out.println("Condição de entrada escolhida: " + value);    
//System.out.println("ID RECUPERADO DA SESSAO: " + sId);
        setEnunciado("");
        return "classesEquivalencia?faces-redirect=true&amp;id="+sId;
    }
    
    public String verDetalhes6(){
        String sId = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idQuestao");
        String entrada = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("entrada");
        setEnunciado("");        
        return "criarClassesEquivalencia?faces-redirect=true&amp;id="+sId;
       
       
    }
    
    public List<ComporResposta> mostraTabela(){
        ArrayList<ComporResposta> listaCompor = (ArrayList<ComporResposta>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("listaCompor");
        System.out.println("TAMANHO LISTA COMPOR: " + listaCompor.size());
        for(ComporResposta compor: listaCompor){
            System.out.println(compor.getRespTipoCE());
            for(RespostaAdicional adicional: compor.getAdicionais()){
                System.out.println(adicional.getCe().getCondEntradaResposta());
                for(ClasseEquivalencia equi: adicional.getEquivalencias()){
                    System.out.println(equi.getClasseValida());
                    System.out.println(equi.getClasseInvalidaUm());
                    System.out.println(equi.getClasseInvalidaDois());
                }
            }
        }
        System.out.println("-------------------------");
        for(ComporResposta compor: listaCompor){
            System.out.println(compor.getRespTipoCE());
            System.out.println(compor.getCondEntrada());
            System.out.println(compor.getValida());
            System.out.println(compor.getInvalidaUm());
            System.out.println(compor.getInvalidaDois());
        }
        return listaCompor;
    }
    
    public String montarLista(){
        String tipoEntSelecionada = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("entrada");
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> parameterMap = (Map<String, String>) context.getExternalContext().getRequestParameterMap();
        System.out.println("Entrada: " + tipoEntSelecionada);
        ComporResposta resposta = (ComporResposta) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("resposta");
        if((tipoEntSelecionada.equals("intervalo")) || (tipoEntSelecionada.equals("valor especifico"))){
            System.out.println("Intervalo ou valor especifico");
            
            String valida1 = parameterMap.get("formTable:tabelaClasseValida:0:valida");
            String invalida1 = parameterMap.get("formTable:tabelaClasseInvalida:0:invalida");
            String invalida2 = parameterMap.get("formTable:tabelaClasseInvalida:1:invalida");
            ClasseEquivalencia equivalencia = new ClasseEquivalencia();
            equivalencia.setClasseValida(valida1);
            equivalencia.setClasseInvalidaUm(invalida1);
            equivalencia.setClasseInvalidaDois(invalida2);
            resposta.setEquivalencia(equivalencia);
                    
            
        }else{
            System.out.println("ELSE");
            
            String valida1 = parameterMap.get("formTable:tabelaClasseValida:0:valida");
            String invalida1 = parameterMap.get("formTable:tabelaClasseInvalida:0:invalida");
            ClasseEquivalencia equivalencia = new ClasseEquivalencia();
            equivalencia.setClasseValida(valida1);
            equivalencia.setClasseInvalidaUm(invalida1);
            resposta.setEquivalencia(equivalencia);
            
        }
        
        ArrayList<ComporResposta> listaCompor = (ArrayList<ComporResposta>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("listaCompor");
        listaCompor.add(resposta);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("listaCompor",listaCompor); 
        System.out.println("TESTE OBJETO COMPOR");
        for(ComporResposta c: listaCompor){
            System.out.println(c.getRespTipoCE());
            System.out.println(c.getCondEntrada());
            System.out.println(c.getValida());
        }
        /*Iterator it = parameterMap.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
        }
        System.out.println("Valida");
        System.out.println(valida1);
        System.out.println("Invalida0");
        System.out.println(invalida1);
        System.out.println("Invalida1");
        System.out.println(invalida2);*/
        String sId = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idQuestao");
        setEnunciado("");        
        return "visualizarTabelaCasosTeste?faces-redirect=true&amp;id="+sId;
    }
    
    public String addTipoCondicaoEntrada(){
        String sId = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idQuestao");
        //System.out.println("ID RECUPERADO DA SESSAO: " + sId);
        setEnunciado("");
        
        return "selecionarTipoCondicaoEntrada?faces-redirect=true&amp;id="+sId;
    }
    
    public String addCondicaoEntrada(){
        String sId = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idQuestao");
        //System.out.println("ID RECUPERADO DA SESSAO: " + sId);
        setEnunciado("");
        return "identificarCondicaoEntrada?faces-redirect=true&amp;id="+sId;   
    }
    
    
    public String especificarCasosTeste(){
        String sId = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idQuestao");
        //System.out.println("ID RECUPERADO DA SESSAO: " + sId);
        setEnunciado("");
        return "especificarCasosTeste?faces-redirect=true&amp;id="+sId;   
    }
    
    public ArrayList<ClasseEquivalencia> obterClassesEquivalencia(){
        ArrayList<ComporResposta> listaCompor = (ArrayList<ComporResposta>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("listaCompor");
        ArrayList<ClasseEquivalencia> listaEquivalencias = new ArrayList<ClasseEquivalencia>();
        System.out.println("TAMANHO LISTA COMPOR: " + listaCompor.size());
        for(ComporResposta compor: listaCompor){
            System.out.println(compor.getEquivalencia().getClasseValida());
            listaEquivalencias.add(compor.getEquivalencia());
        }
        System.out.println(listaEquivalencias.size());
        return listaEquivalencias;
    }
    
    public String mostrarTelaClasseJUnit(){
        String sId = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idQuestao");
        //System.out.println("ID RECUPERADO DA SESSAO: " + sId);
        setEnunciado("");
        return "visualizarClasseJUnitGerada?faces-redirect=true&amp;id="+sId;
    }
    
    
    public void lerClasseReferencia(){
        
        Scanner ler = new Scanner(System.in);
        Questao q = new Questao();
        long idQ = Long.parseLong( (String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idQuestao"));
        Questao questao = dao.getQuestaoPorId(idQ);
        String nome = questao.getPathClasseReferenciaQuestao();
        
        
        
        
        
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
