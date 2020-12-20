/* Administrador.java
 * Este arquivo faz parte do projeto "Loja de Construção".
 * Este código é distribuído sob a Licença MIT.
 */
package lojaconstrucao;

/** Representa um Colaborador com acesso de Administrador do Sistema, capaz de
 * realizar tarefas de Colaborador e de gerenciar colaboradores e estoque de
 * materiais.
 * @author Gabrielly Bailon Soares de Souza
 * @author Lucas Samuel Vieira
 * @author Luísa Vitória Guimarães Silva
 * @version 1.0
 */
public final class Administrador extends Colaborador {

    /**
     * Constrói uma instância de um objeto representado um administrador.
     * @param nome Nome do administrador.
     * @param endereco Endereço do administrador.
     * @param email E-mail do administrador.
     * @param cpf CPF do administrador.
     * @param telefone Telefone do administrador.
     * @param login Login do administrador.
     * @param senha Senha do administrador.
     */
    public Administrador(String nome, String endereco, String email, String cpf,
            String telefone, String login, String senha) {
        super(nome, endereco, email, cpf, telefone, login, senha);
    }
    
    /**
     * Formata as informações públicas de um Administrador para serem impressas
     * em console.
     * @return String formatada contendo as informações públicas de um
     * Administrador.
     */
    @Override
    public String toString() {
        return super.toString() + "\nEste colaborador é um administrador.";
    }
}