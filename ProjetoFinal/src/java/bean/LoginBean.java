package bean;

import connection.ConnectionFactory;
import dao.AlunoDAO;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import javax.faces.context.FacesContext;
import model.Aluno;

/**
 *
 * @author THAIS
 */
@ManagedBean
@ViewScoped
public class LoginBean {
    
    private Aluno aluno = new Aluno();
    private AlunoDAO alunoDao = new AlunoDAO(ConnectionFactory.getEntityManager());
    
    public String login(){
        
        boolean validou = alunoDao.validaSeha(aluno);
        
        if(validou){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("aluno", aluno);
        Aluno aluno = (Aluno) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("aluno");
        System.out.println("Aluno------------------" + aluno.getAlunoLogin());

            return "/listaQuestoes";
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                            "Aluno não encontrado!", 
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
    
}
