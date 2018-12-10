package bean;

import dao.QuestaoDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import model.Questao;
import util.ConnectionFactory;

/**
 *
 * @author THAIS
 */
@ManagedBean
public class ListaQuestaoBean {
    

    
    private QuestaoDao dao =  new QuestaoDao(ConnectionFactory.getEntityManager());
    private List<Questao> listaQuestao = dao.listaQuestao();
    private Questao questao = new Questao();

    public ListaQuestaoBean() {
    }
    
    

    public List<Questao> getListaQuestao() {
        return listaQuestao;
    }

    public void setListaUsuarios(List<Questao> listaQuestao) {
        this.listaQuestao = listaQuestao;
    }
    
    public void getQuestao(long id){
        Questao q = dao.getQuestaoPorId(id);
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
        System.out.println(questao.getNomeQuestao());
    }
    
    
    
   
}


