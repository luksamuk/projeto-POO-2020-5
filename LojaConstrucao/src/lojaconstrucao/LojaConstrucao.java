/* LojaConstrucao.java
 * Este arquivo faz parte do projeto "Loja de Construção".
 * Este código é distribuído sob a Licença MIT.
 */
package lojaconstrucao;

import java.util.Scanner;

/** Ponto de entrada de execução da aplicação.
 *
 * @author Gabrielly Bailon Soares de Souza
 * @author Lucas Samuel Vieira
 * @author Luísa Vitória Guimarães Silva
 * @version 1.0
 */
public final class LojaConstrucao {
    private static Sistema sistema;
    private static boolean executando;
    
    /** Método estático chamado no início da execução do programa.
     * @param args Argumentos fornecidos via linha de comando.
     */
    public static void main(String[] args) {
        sistema = Sistema.getInstance();
        
        Colaborador usuario = null;
        executando = true;
        
        Scanner scanner = new Scanner(System.in);
        
        do {
            System.out.println("Sistema Loja Construção v1.0.0");
            
            System.out.println("Bem-vindo, "
                    + ((usuario == null)
                            ? "Convidado"
                            : usuario.getNome()));
            
            System.out.println("Escolha uma opção:");
            System.out.println(
                    "1. Realizar "
                            + ((usuario == null)
                                    ? "login"
                                    : "logoff") + "\n" +
                    "2. Realizar venda\n" +
                    "3. Gerenciar materiais\n" +
                    "4. Gerenciar clientes\n" +
                    "5. Gerenciar colaboradores\n" +
                    "6. Exibir número de instâncias de Colaboradores e Clientes\n" +
                    "9. Sair\n");
            
            System.out.print("Sua opção: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            if((option > 1) && (option < 9) && (usuario == null)) {
                System.out.println("Realize login primeiro.");
            } else {
                switch(option) {
                    case 1:
                        if(usuario == null) {
                            String login, senha;
                            System.out.print("Insira seu login: ");
                            login = scanner.nextLine();
                            System.out.print("Insira sua senha: ");
                            senha = scanner.nextLine();

                            try {
                                usuario = sistema.realizaLogin(login, senha);
                                System.out.println("Login realizado com sucesso.");
                            } catch (InvalidLoginException e) {
                                System.err.println("Erro ao realizar login: " + e);
                            }
                        } else {
                            usuario = null;
                            System.out.println("Logoff realizado com sucesso.");
                        }
                        break;
                    case 2:
                        LojaConstrucao.realizaVendas(usuario);
                        break;
                    case 3:
                        LojaConstrucao.crudMateriais(usuario);
                        break;
                    case 4:
                        LojaConstrucao.crudClientes(usuario);
                        break;
                    case 5:
                        LojaConstrucao.crudColaboradores(usuario);
                        break;
                    case 6:
                        System.out.println("Número de instâncias criadas por classe");
                        System.out.println("Clientes: " + sistema.getInstanciasClientes());
                        System.out.println("Colaboradores: " + sistema.getInstanciasColaboradores());
                        System.out.println("Nota: O número de instâncias pode não corresponder ao número de cadastros no sistema.");
                        break;
                    case 9:
                        executando = false;
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            }
            System.out.println();
        } while(executando);
    }
    
    public static void realizaVendas(Colaborador c) {
        
    }
    
    public static void crudMateriais(Colaborador c) {
        // Cadastro, atualização: Administração.
        // Consulta: Colaborador.
    }
    
    public static void crudClientes(Colaborador c) {
        // Cadastro, atualização: Administração.
        // Consulta: Colaborador.
    }
    
    public static void crudColaboradores(Colaborador c) {
        // Cadastro, atualização: Administração.
        // Consulta: Colaborador.
    }
    
}
