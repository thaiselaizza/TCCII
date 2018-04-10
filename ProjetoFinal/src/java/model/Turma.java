package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author THAIS
 */

@Entity
public class Turma {
    
    @Id
    @GeneratedValue
    private Long idTurma;
    @Column(length = 100,nullable = false,unique = true)
    private String turmaNome;
   
   

}
