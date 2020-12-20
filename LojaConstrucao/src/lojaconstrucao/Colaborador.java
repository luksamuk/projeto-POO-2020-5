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

    /**
     * Número de instâncias de Colaborador criadas desde o início da execução
     * da aplicação. Pode não condizer com o número de colaboradores cadastrados
     * no sistema.
     */
    protected static int num_instances = 0;
    
    /**
     * Login do colaborador.
     */
    protected String login;

    /**
     * Senha do colaborador.
     */
    protected String senha;
    
    /**
     * Constrói uma instância de um objeto representando um Colaborador.
     * @param nome Nome do colaborador.
     * @param endereco Endereço do colaborador.
     * @param email E-mail do colaborador.
     * @param cpf CPF do colaborador.
     * @param telefone Telefone do colaborador.
     * @param login Login do colaborador.
     * @param senha Senha do colaborador.
     */
    public Colaborador(String nome, String endereco, String email, String cpf,
            String telefone, String login, String senha) {
        super(nome, endereco, email, cpf, telefone);
        this.login = login;
        this.senha = senha;
        num_instances++;
    }

    /**
     * Recupera o login do colaborador.
     * @return String representando o login do colaborador.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Redefine o login do colaborador.
     * @param login Novo login a ser atribuído ao colaborador.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Recupera a senha do colaborador.
     * @return String representando a senha do colaborador.
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Redefine a senha do colaborador.
     * @param senha Nova senha a ser atribuída ao colaborador.
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    /**
     * Retorna o número de instâncias de Colaborador criadas desde o início da
     * execução da aplicação. Este número pode não condizer com a quantidade de
     * colaboradores cadastrados. Caso o colaborador seja carregado por um
     * processo de desserialização, este número não será recuperado.
     * @return Número de instâncias de Colaborador criadas.
     */
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
        List<Colaborador> l = new ArrayList<>();
        
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
    
    /**
     * Formata as informações públicas de um Colaborador para serem impressas
     * em console.
     * @return String formatada contendo as informações públicas de um
     * Colaborador.
     */
    @Override
    public String toString() {
        return super.toString() + "\nLogin:    " + this.login;
    }
}
