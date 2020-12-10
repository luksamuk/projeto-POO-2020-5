/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojaconstrucao;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

/**
 *
 * @author alchemist
 */
public class Venda {
    private int idVenda;
    private Date data;
    private float valorTotal;
    private Set<Material> materiais;
    private Map<Material, Integer> quantidades;
    
    public Venda(int id) {
        idVenda = id;
        data = new Date();
        valorTotal = 0.0f;
        materiais = new HashSet<Material>();
        quantidades = new HashMap<Material, Integer>();
    }

    public int getIdVenda() {
        return idVenda;
    }

    public Date getData() {
        return data;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public Set<Material> getMateriais() {
        return materiais;
    }

    public Map<Material, Integer> getQuantidades() {
        return quantidades;
    }
    
    public String gerarExtrato() {
        return "";
    }
    
    public void insereMaterial(Material m, int quantidade) {
        
    }
    
    public void removeMaterial(Material m) {
        
    }
}
