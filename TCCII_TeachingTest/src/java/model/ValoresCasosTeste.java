package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author THAIS
 */
@Entity
public class ValoresCasosTeste {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codVCT;
    private String valor;
    private String tipo;

    public Long getCodVCT() {
        return codVCT;
    }

    public void setCodVCT(Long codVCT) {
        this.codVCT = codVCT;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
