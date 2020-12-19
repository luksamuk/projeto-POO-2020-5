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
    public Administrador(String nome, String endereco, String email, String cpf,
            String telefone, String login, String senha) {
        super(nome, endereco, email, cpf, telefone, login, senha);
    }
}
