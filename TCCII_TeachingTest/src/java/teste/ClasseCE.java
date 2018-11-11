/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import dao.TipoCondicaoEntradaDao;
import model.TipoCondicaoEntrada;
import util.ConnectionFactory;


/**
 *
 * @author THAIS
 */
public class ClasseCE {
    public static void main(String[] args) {
        TipoCondicaoEntradaDao daoTipoCond = new TipoCondicaoEntradaDao(ConnectionFactory.getEntityManager());
       TipoCondicaoEntrada entrada = daoTipoCond.getTipoCE("Intervalo");

        
        
    }
}
