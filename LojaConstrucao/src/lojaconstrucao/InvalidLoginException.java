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
    public InvalidLoginException(String info) {
        super("Impossível realizar login: " + info);
    }
}
