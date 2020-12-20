/* InvalidLoginException.java
 * Este arquivo faz parte do projeto "Loja de Construção".
 * Este código é distribuído sob a Licença MIT.
 */
package lojaconstrucao;

/** Representa uma exceção de login inválido para um Colaborador.
 * @author Gabrielly Bailon Soares de Souza
 * @author Lucas Samuel Vieira
 * @author Luísa Vitória Guimarães Silva
 * @version 1.0
 */
public class InvalidLoginException extends Exception {
    
    /**
     * Constrói uma instância de um objeto de exceção de Login.
     * @param info Informação extra sobre o processo falho de Login.
     */
    public InvalidLoginException(String info) {
        super("Impossível realizar login: " + info);
    }
}
