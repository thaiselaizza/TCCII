package bean;

import dao.PassosTutorialDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import model.PassosTutorial;
import util.ConnectionFactory;

/**
 *
 * @author THAIS
 */
@ManagedBean
public class ListaPassosTutorialBean {
    
    private PassosTutorialDao dao =  new PassosTutorialDao(ConnectionFactory.getEntityManager());
    private List<PassosTutorial> listaPassosTutorial = dao.listaPassos();
    private PassosTutorial passosTutorial = new PassosTutorial();

    public List<PassosTutorial> getListaPassos() {
        return listaPassosTutorial;
    }

    
    

    public PassosTutorial getPassos() {
        return passosTutorial;
    }

    public void setPasso(PassosTutorial passosTutorial) {
        this.passosTutorial = passosTutorial;
        System.out.println(passosTutorial.getPassoDescricao());
    }
}
