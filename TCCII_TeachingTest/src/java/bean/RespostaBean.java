
package bean;

import dao.RespostaDAO;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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
    
    public List<RespostaBanco> mostrarRespostas() throws SQLException, ClassNotFoundException{
        
        Aluno aluno = (Aluno) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("aluno");
        
        RespostaDAO dao = new RespostaDAO();
        
        List<RespostaBanco> resps = dao.getRepostasAluno2(aluno.getCodAluno());
        
        return resps;
    }
}
