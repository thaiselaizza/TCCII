
package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.ComporResposta;

/**
 *
 * @author THAIS
 */
@ManagedBean(name="respostaBean ")
@SessionScoped
public class RespostaBean {
    
    ComporResposta resposta = new ComporResposta();
}
