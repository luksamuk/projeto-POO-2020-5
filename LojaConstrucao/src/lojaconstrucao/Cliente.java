/* Cliente.java
 * Este arquivo faz parte do projeto "Loja de Construção".
 * Este código é distribuído sob a Licença MIT.
 */
package lojaconstrucao;

import java.util.ArrayList;
import java.util.List;

/** Representa um Cliente no Sistema de Loja de Materiais.
 * @author Gabrielly Bailon Soares de Souza
 * @author Lucas Samuel Vieira
 * @author Luísa Vitória Guimarães Silva
 * @version 1.0
 */
public final class Cliente extends Pessoa {
    private static int num_instances = 0;
    
    private List<Venda> regCompras;
    
    public Cliente(String nome, String endereco, String email, String cpf,
            String telefone) {
        super(nome, endereco, email, cpf, telefone);
        regCompras = new ArrayList<>();
        setNumInstances(getNumInstances() + 1);
    }
    
    public void adicionaVenda(Venda v) {
        
    }
    
    public void imprimirInfo() {
        System.out.println(this);
    }
    
    public static int getNumInstances() {
        return num_instances;
    }
    
    public void setNumInstances(int num) {
        num_instances = num;
    }
    
    /*@Override
    public String toString() {
        
    }*/
}
