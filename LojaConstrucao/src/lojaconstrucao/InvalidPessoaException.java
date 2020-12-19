/* InvalidPessoaException.java
 * Este arquivo faz parte do projeto "Loja de Construção".
 * Este código é distribuído sob a Licença MIT.
 */
package lojaconstrucao;

/** Representa uma exceção de cadastro inválido para uma Pessoa.
 * @author Gabrielly Bailon Soares de Souza
 * @author Lucas Samuel Vieira
 * @author Luísa Vitória Guimarães Silva
 * @version 1.0
 */
public class InvalidPessoaException extends Exception {
    public InvalidPessoaException(Pessoa p) {
        super("Cadastro inválido para Pessoa " + p.getNome());
    }
    
    // Exceções já herdam toString de Exception.
}
