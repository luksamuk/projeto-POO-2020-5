/* Venda.java
 * Este arquivo faz parte do projeto "Loja de Construção".
 * Este código é distribuído sob a Licença MIT.
 */
package lojaconstrucao;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

/** Representa uma venda realizada no Sistema de Loja de Construção.
 * @author Gabrielly Bailon Soares de Souza
 * @author Lucas Samuel Vieira
 * @author Luísa Vitória Guimarães Silva
 * @version 1.0
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
        materiais = new HashSet<>();
        quantidades = new HashMap<>();
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
    
    @Override
    public String toString() {
        String buffer = new String();
        buffer += "Venda #" + this.idVenda + "\n";
        buffer += "Data:        " + this.data + "\n";
        buffer += "Valor Total: " + this.valorTotal + "\n";
        buffer += "Materiais adquiridos:";
        for(Material m : materiais) {
            buffer += "\nNome do material: " + m.getNome();
            buffer += "Quantidade:       " + quantidades.get(m);
        }
        return buffer;
    }
    
    public String gerarExtrato() {
        return this.toString();
    }
    
    public void insereMaterial(Material m, int quantidade) {
        
    }
    
    public void removeMaterial(Material m) {
        
    }
}
