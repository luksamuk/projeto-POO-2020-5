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

/** Representa uma venda realizada no Sistema de Loja de Materiais.
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
    
    /**
     * Constrói uma instância de uma venda na loja.
     */
    public Venda() {
        idVenda = -1;
        data = new Date();
        valorTotal = 0.0f;
        materiais = new HashSet<>();
        quantidades = new HashMap<>();
    }

    /**
     * Recupera o ID da venda no sistema.
     * @return ID atribuído à venda no sistema, ou -1 se a venda ainda não foi
     * cadastrada.
     */
    public int getID() {
        return idVenda;
    }
    
    /**
     * Redefine o ID da venda no sistema. Evite invocar diretamente este método.
     * @param id Novo ID a ser atribuído à venda.
     */
    public void setID(int id) {
        this.idVenda = id;
    }

    /**
     * Recupera a data da venda.
     * @return Data em que a venda foi aberta no sistema.
     */
    public Date getData() {
        return data;
    }

    /**
     * Recupera o valor total da venda.
     * @return Representação do valor total da venda.
     */
    public float getValorTotal() {
        return valorTotal;
    }

    public Set<Material> getMateriais() {
        return materiais;
    }

    public Map<Material, Integer> getQuantidades() {
        return quantidades;
    }
    
    /**
     * Formata as informações da venda para serem impressas como extrato de
     * venda no console.
     * @return String formatada contendo as informações sobre a venda.
     */
    @Override
    public String toString() {
        String buffer = new String();
        buffer += "Venda #" + this.idVenda + "\n";
        buffer += "Data:        " + this.data + "\n";
        buffer += "Valor Total: " + this.valorTotal + "\n";
        buffer += "Materiais adquiridos:";
        for(Material m : materiais) {
            buffer += "\n    Nome: " + m.getNome();
            buffer += "Quantidade: " + quantidades.get(m);
        }
        return buffer;
    }
    
    /**
     * Retorna o extrato da venda atual.
     * @return String formatada contendo as informações sobre a venda.
     */
    public String gerarExtrato() {
        return this.toString();
    }
    
    public void insereMaterial(Material m, int quantidade) {
        
    }
    
    public void removeMaterial(Material m) {
        
    }
}
