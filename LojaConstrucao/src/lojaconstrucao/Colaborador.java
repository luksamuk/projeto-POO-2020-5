/* Colaborador.java
 * Este arquivo faz parte do projeto "Loja de Construção".
 * Este código é distribuído sob a Licença MIT.
 */
package lojaconstrucao;

import java.util.ArrayList;
import java.util.List;

/** Representa um Colaborador no Sistema de Loja de Materiais, capaz de realizar
 * login e realizar vendas para clientes.
 * @author Gabrielly Bailon Soares de Souza
 * @author Lucas Samuel Vieira
 * @author Luísa Vitória Guimarães Silva
 * @version 1.0
 */
public class Colaborador extends Pessoa {
    protected static int num_instances = 0;
    
    protected String login;
    protected String senha;
    
    public Colaborador(String nome, String endereco, String email, String cpf,
            String telefone, String login, String senha) {
        super(nome, endereco, email, cpf, telefone);
        this.login = login;
        this.senha = senha;
        num_instances++;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public static int getNumInstances() {
        return num_instances;
    }
    
    /**
     * Gera uma lista de colaboradores estáticos a serem incluídos para testes
     * na aplicação.
     * Os colaboradores gerados não sãpo automaticamente incluídos no sistema.
     * @return Lista de colaboradores distintos que podem ser inseridos.
     */
    public static List<Colaborador> geraColaboradores() {
        List<Colaborador> l = new ArrayList<Colaborador>();
        
        l.add(new Colaborador("Fulano da Silva",    "Rua dos Bobos, 0, Centro",
                              "fulano@exemplo.com", "12345678910",
                              "038999998888", "fulano", "senha"));
        l.add(new Colaborador("Ciclano da Silva",   "Rua dos Bobos, 1, Centro",
                              "ciclano@exemplo.com", "98765432100",
                              "038988889999", "ciclano", "senha123"));
        l.add(new Colaborador("Beltrano da Silva",  "Rua dos Bobos, 2, Centro",
                              "beltrano@exemplo.com", "99911188823",
                              "038977776666", "beltrano", "dolphins"));
        
        // Colaborador que dará erro
        l.add(new Colaborador("Rásquer da Silva", "Rua dos Rásquers, 0, Centro",
                              "rasquer@l33t.com", "12345678910",
                              "038999998888", "fulano", "s0uumr4squerb4c4n4"));
        
        // Adicionar mais 22...
        // TODO
        return l;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nLogin:    " + this.login;
    }
}
