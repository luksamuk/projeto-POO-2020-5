/* Colaborador.java
 * Este arquivo faz parte do projeto "Loja de Construção".
 * Este código é distribuído sob a Licença MIT.
 */
package lojaconstrucao;

/** Representa um Colaborador no Sistema de Loja de Materiais, capaz de realizar
 * login e realizar vendas para clientes.
 * @author Gabrielly Bailon Soares de Souza
 * @author Lucas Samuel Vieira
 * @author Luísa Vitória Guimarães Silva
 * @version 1.0
 */
public class Colaborador extends Pessoa {
    protected String login;
    protected String senha;
    
    public Colaborador(String nome, String endereco, String email, String cpf,
            String telefone, String login, String senha) {
        super(nome, endereco, email, cpf, telefone);
        this.login = login;
        this.senha = senha;
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
    
    
}
