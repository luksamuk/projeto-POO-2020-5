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
    
    /**
     * Constrói uma instância de um Cliente.
     * @param nome Nome do cliente.
     * @param endereco Endereço do cliente.
     * @param email E-mail do cliente.
     * @param cpf CPF do cliente.
     * @param telefone Telefone do cliente.
     */
    public Cliente(String nome, String endereco, String email, String cpf,
            String telefone) {
        super(nome, endereco, email, cpf, telefone);
        regCompras = new ArrayList<>();
        setNumInstances(getNumInstances() + 1);
    }
    
    public void adicionaVenda(Venda v) {
        
    }
    
    /**
     * Imprime as informações do cliente na saída padrão do console.
     */
    public void imprimirInfo() {
        System.out.println(this);
    }
    
    /**
     * Retorna o número de instâncias da classe Cliente criadas desde o início
     * da execução da aplicação. Este número pode não condizer com a quantidade
     * de clientes registrada no sistema.
     * @return Um número maior ou igual a zero representando a quantidade de
     * clientes.
     */
    public static int getNumInstances() {
        return num_instances;
    }
    
    /**
     * Redefine o número de instâncias da classe Cliente criadas desde o início
     * da execução da aplicação.
     * @param num Novo número de instâncias a ser utilizado.
     */
    public void setNumInstances(int num) {
        if(num < 0) {
            return;
        }
        num_instances = num;
    }
    
    // Cliente já herda toString de Pessoa.
}
