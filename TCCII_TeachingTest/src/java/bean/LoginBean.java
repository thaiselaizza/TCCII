package bean;

import util.ConnectionFactory;
import dao.AlunoDAO;
import dao.TutorDao;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.Aluno;
import model.Tutor;

/**
 *
 * @author THAIS
 */
@ManagedBean
@SessionScoped
public class LoginBean {
    
    private Aluno aluno = new Aluno();
    private AlunoDAO alunoDao = new AlunoDAO(ConnectionFactory.getEntityManager());
    private String alunoLogado = "";
    private Tutor tutor = new Tutor();
    private TutorDao tutorDao = new TutorDao(ConnectionFactory.getEntityManager());
    private String tutorLogado = "";
    
    
    public String login(){
        
        boolean validou = alunoDao.validaSeha(aluno);
        
        if(validou){
            /*FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("aluno", aluno);
        Aluno aluno = (Aluno) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("aluno");
        System.out.println("Aluno------------------" + aluno.getLoginAluno());*/

            return "/listaQuestoes";
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                            "Aluno não encontrado!", 
                            "Erro no login!"));
            return "/faces/formLogin";
        }
    }
    
    
    public String loginTutor(){
        
        boolean validou = tutorDao.validaSenhaTutor(tutor);
        
        if(validou){
            /*FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("aluno", aluno);
        Aluno aluno = (Aluno) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("aluno");
        System.out.println("Aluno------------------" + aluno.getLoginAluno());*/

            return "/listaAlunos";
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                            "Tutor não encontrado!", 
                            "Erro no login!"));
            return "/faces/formLogin";
        }
    }
    
    public Aluno getAluno(){
        
        return aluno;
    }
    
    public void setAluno(Aluno aluno){
    
        this.aluno = aluno;
    }

    public AlunoDAO getAlunoDao() {
        return alunoDao;
    }

    public void setAlunoDao(AlunoDAO alunoDao) {
        this.alunoDao = alunoDao;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public TutorDao getTutorDao() {
        return tutorDao;
    }

    public void setTutorDao(TutorDao tutorDao) {
        this.tutorDao = tutorDao;
    }

    public String getTutorLogado() {
        return tutorLogado;
    }

    public void setTutorLogado(String tutorLogado) {
        this.tutorLogado = tutorLogado;
    }
    
    
    
    public String efetuarLogout() throws IOException{
        FacesContext fc = FacesContext.getCurrentInstance();  
        HttpSession sessao = (HttpSession) fc.getExternalContext().getSession(false);  
        sessao.invalidate(); 
        return "telaPerfil.xhtml";
    }
    
    public void mostrarAlunoLogado(){
        aluno = alunoDao.buscarPorLogin(aluno.getLoginAluno());
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("aluno", aluno);
        Aluno aluno = (Aluno) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("aluno");
        
        alunoLogado = aluno.getLoginAluno();
        System.out.println("ALUNO: " + aluno.getLoginAluno());
        
    }

    public String getAlunoLogado() {
        return alunoLogado;
    }

    public void setAlunoLogado(String alunoLogado) {
        this.alunoLogado = alunoLogado;
    }
    
    
    public String mostrarTelaLoginTutor(){
        
        return "/formLoginTutor";
    }
    
    public String mostrarTelaLoginAluno(){
        
        return "/formLogin";
    }
}

