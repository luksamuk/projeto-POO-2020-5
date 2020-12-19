/* LojaConstrucao.java
 * Este arquivo faz parte do projeto "Loja de Construção".
 * Este código é distribuído sob a Licença MIT.
 */
package lojaconstrucao;

/** Ponto de entrada de execução da aplicação.
 *
 * @author Gabrielly Bailon Soares de Souza
 * @author Lucas Samuel Vieira
 * @author Luísa Vitória Guimarães Silva
 * @version 1.0
 */
public final class LojaConstrucao {

    /** Método estático chamado no início da execução do programa.
     * @param args Argumentos fornecidos via linha de comando.
     */
    public static void main(String[] args) {
        Sistema sistema;
        sistema = Sistema.getInstance();
        
        Colaborador usuario;
        
        try {
            usuario = sistema.realizaLogin("admin", "admin");
        } catch (InvalidLoginException e) {
            System.out.println("Erro ao realizar login: " + e);
        }
    }
    
}
