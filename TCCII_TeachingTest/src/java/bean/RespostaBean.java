
package bean;

import dao.RespostaDAO;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import model.Aluno;
import model.ComporResposta;
import model.RespostaBanco;


/**
 *
 * @author THAIS
 */
@ManagedBean(name="respostaBean")
@SessionScoped
public class RespostaBean {
    
    ComporResposta resposta = new ComporResposta();
    private List<RespostaBanco> resps;

    public List<RespostaBanco> getResps() {
        return resps;
    }

    public void setResps(List<RespostaBanco> resps) {
        this.resps = resps;
    }
    
    
    
    public List<RespostaBanco> mostrarRespostas() throws SQLException, ClassNotFoundException{
        
        Aluno aluno = (Aluno) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("aluno");
        
        RespostaDAO dao = new RespostaDAO();
        
        List<RespostaBanco> resps = dao.getRepostasAluno2(aluno.getCodAluno());
        
        return resps;
    }
    
    
    public void mostrarRespostasTutor() throws SQLException, ClassNotFoundException{
        
        
         String id_ = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
         Long id = Long.valueOf(id_);
        RespostaDAO dao = new RespostaDAO();
        
        this.resps = dao.getRepostasAluno2(id);
        
        
    }
    
    public void show(AjaxBehaviorEvent event){
        System.out.println("show");
        
    }
}
