/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojaconstrucao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alchemist
 */
public class Cliente extends Pessoa {
    private List<Venda> regCompras;
    
    public Cliente() {
        regCompras = new ArrayList<Venda>();
    }
    
    public void adicionaVenda(Venda v) {
        
    }
    
    public void imprimirInfo() {
        System.out.println(this);
    }
    
    /*@Override
    public String toString() {
        
    }*/
}
