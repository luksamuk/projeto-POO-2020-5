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
    private static Scanner scanner;
    
    /** Método estático chamado no início da execução do programa.
     * @param args Argumentos fornecidos via linha de comando.
     */
    public static void main(String[] args) {
        // Inicialização
        sistema = Sistema.getInstance();
        Colaborador usuario = null;
        executando = true;
        scanner = new Scanner(System.in);
        
        do {
            System.out.println("*** Sistema Loja Construção v1.0.0 ***");
            
            System.out.println("Bem-vindo, "
                    + ((usuario == null)
                            ? "Convidado"
                            : usuario.getNome()));
            
            System.out.println("Escolha uma opção:");
            System.out.println(
                    "1. Realizar " + ((usuario == null)
                                        ? "login"
                                        : "logoff") + "\n"
                  + "2. Realizar venda\n"
                  + "3. Gerenciar materiais\n"
                  + "4. Gerenciar clientes\n"
                  + "5. Gerenciar colaboradores\n"
                  + "6. Exibir número de instâncias de Colaboradores e Clientes\n"

                  + "9. Sair\n");
            
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
    
    /* ===== VENDAS ===== */
    
    private static void realizaVendas(Colaborador c) {
        // TODO: Imprimir extrato logo após realização da venda!
        System.out.println("Realização de vendas não implementada!\n");
    }
    
    
    /* ===== MATERIAIS ===== */
    
    private static void cadastroMaterial(Administrador adm) {
        
    }    
    
    private static void crudMateriais(Colaborador c) {
        // Cadastro, atualização: Administração.
        // Consulta: Colaborador.
        boolean is_admin = c instanceof Administrador;
        String errmsg = "Você não é um administrador. E você sabe disso.";
        
        while(true) {
            System.out.println("*** Gerenciamento de materiais ***");
            System.out.println(
                    "1. Cadastrar material (administrador)\n"
                  + "2. Atualizar dados de material (administrador)\n"
                  + "3. Remover material (administrador)\n"
                  + "4. Imprimir dados de um material\n"
                  + "5. Imprimir estoque\n"
                  + "4. Voltar\n"
                  + "5. Sair\n"
            );
            
            System.out.print("Sua opção: ");
            
            int option = scanner.nextInt();
            scanner.nextLine();
            
            switch(option) {
                case 1:
                    if(!is_admin) {
                        System.out.println(errmsg);
                        break;
                    }
                    System.err.println("Cadastro não implementado");
                    break;
                case 2:
                    if(!is_admin) {
                        System.out.println(errmsg);
                        break;
                    }
                    System.err.println("Atualização de dados não implementada");
                    break;
                case 3:
                    if(!is_admin) {
                        System.out.println(errmsg);
                        break;
                    }
                    System.err.println("Remoção não implementada");
                    break;
                case 4:
                    System.err.println("Mostrar dados não implementada");
                    break;
                case 5:
                    System.err.println("Mostrar estoque não implementada");
                    break;
                case 6: return;
                case 7:
                    executando = false;
                    return;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            System.out.println();
        }
    }
    
    /* ===== CLIENTES ===== */
    
    private static void cadastroCliente(Administrador adm) {
        String nome, endereco, email, cpf, telefone;
        
        System.out.print("Nome:     ");
        nome = scanner.nextLine().trim();
        System.out.print("Endereço: ");
        endereco = scanner.nextLine().trim();
        System.out.print("E-mail:   ");
        email = scanner.nextLine().trim();
        System.out.print("CPF:      ");
        cpf = scanner.nextLine().trim();
        System.out.print("Telefone: ");
        telefone = scanner.nextLine().trim();

        try {
            var cl = new Cliente(nome, endereco, email, cpf,
                    telefone);
            
            sistema.incluirCliente(adm, cl);
            
            System.out.println("\nCadastro realizado com sucesso.");
            System.out.println("Dados cadastrados:\n" + cl);
        } catch(InvalidPessoaException e) {
            System.err.println("Erro ao cadastrar cliente: " + e);
        }
    }
    
    private static void removeCliente(Administrador adm) {
        String cpf;
        System.out.print("CPF:      ");
        cpf = scanner.nextLine().trim();
        
        if(sistema.removeCliente(adm, cpf)) {
            System.out.println("\nCliente removido com sucesso.");
        } else {
            System.err.println("Erro ao remover cliente: CPF não cadastrado.");
        }
    }
    
    private static void alteraCliente(Administrador adm) {
        System.out.println("Insira o CPF para pesquisa.");
        System.out.print("CPF:      ");
        var cpf = scanner.nextLine().trim();
        Cliente c = sistema.getCliente(cpf);
        if(c != null) {
            System.out.println("Insira as novas informações do cliente.");
            System.out.print("Nome:     ");
            c.setNome(scanner.nextLine().trim());
            System.out.print("Endereço: ");
            c.setEndereco(scanner.nextLine().trim());
            System.out.print("E-mail:   ");
            c.setEmail(scanner.nextLine().trim());
            System.out.print("CPF:      ");
            c.setCPF(scanner.nextLine().trim());
            System.out.print("Telefone: ");
            c.setTelefone(scanner.nextLine().trim());
            
            System.out.println("Dados modificados com sucesso.\n");
        } else {
            System.err.println("Erro ao atualizar dados: Cliente não encontrado.");
        }
    }
    
    private static void crudClientes(Colaborador c) {
        // Cadastro, atualização: Administração.
        // Consulta: Colaborador.
        boolean is_admin = c instanceof Administrador;
        String errmsg = "Você não é um administrador. E você sabe disso.";
        
        while(true) {
            System.out.println("*** Gerenciamento de clientes ***");
            System.out.println(
                    "1. Cadastrar clientes (administrador)\n"
                  + "2. Atualizar dados de cliente (administrador)\n"
                  + "3. Remover cliente (administrador)\n"
                  + "4. Imprimir dados de cliente\n"
                  + "5. Mostrar lista de clientes\n"
                  + "6. Voltar\n"
                  + "7. Sair\n"
            );
            
            System.out.print("Sua opção: ");
            
            int option = scanner.nextInt();
            scanner.nextLine();
            
            switch(option) {
                case 1:
                    if(!is_admin) {
                        System.out.println(errmsg);
                        break;
                    }
                    cadastroCliente((Administrador)c);
                    break;
                case 2:
                    if(!is_admin) {
                        System.out.println(errmsg);
                        break;
                    }
                    alteraCliente((Administrador)c);
                    break;
                case 3:
                    if(!is_admin) {
                        System.out.println(errmsg);
                        break;
                    }
                    removeCliente((Administrador)c);
                    break;
                case 4:
                    String cpf;
                    System.out.print("CPF:      ");
                    cpf = scanner.nextLine().trim();
                    Cliente cl = sistema.getCliente(cpf);
                    if(cl != null) {
                        System.out.println(cl);
                    } else {
                        System.err.println("Cliente não encontrado.");
                    }
                    break;
                case 5:
                    sistema.mostraClientes();
                    break;
                case 6: return;
                case 7:
                    executando = false;
                    return;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            System.out.println();
        }
    }
    
    /* ===== COLABORADOR ===== */
    
    private static void cadastroColaborador(Administrador adm) {
        String nome, endereco, email, cpf, telefone, login, senha;
        
        System.out.print("Login:    ");
        login = scanner.nextLine().trim();
        System.out.print("Senha:    ");
        senha = scanner.nextLine().trim();
        System.out.print("Nome:     ");
        nome = scanner.nextLine().trim();
        System.out.print("Endereço: ");
        endereco = scanner.nextLine().trim();
        System.out.print("E-mail:   ");
        email = scanner.nextLine().trim();
        System.out.print("CPF:      ");
        cpf = scanner.nextLine().trim();
        System.out.print("Telefone: ");
        telefone = scanner.nextLine().trim();
        
        try {
            var col = new Colaborador(nome, endereco, email, cpf,
                    telefone, login, senha);
            
            sistema.incluirColaborador(adm, col);
            
            System.out.println("\nCadastro realizado com sucesso.");
            System.out.println("Dados cadastrados:\n" + col);
        } catch(InvalidPessoaException e) {
            System.err.println("Erro ao cadastrar colaborador: " + e);
        }
    }
    
    private static void removeColaborador(Administrador adm) {
        System.out.print("Login:    ");
        var login = scanner.nextLine().trim();
        if(sistema.removeColaborador(adm, login)) {
            System.out.println("\nRemoção realizada com sucesso.");
        } else {
            System.err.println("Erro ao remover colaborador: Login não cadastrado.");
        }
    }
    
    private static void alteraColaborador(Administrador adm) {
        System.out.println("Insira o login para pesquisa.");
        System.out.print("Login:    ");
        var login = scanner.nextLine().trim();
        Colaborador c = sistema.getColaborador(login);
        if(c != null) {
            System.out.println("Insira as novas informações do colaborador.");
            System.out.print("Senha:    ");
            c.setSenha(scanner.nextLine().trim());
            System.out.print("Nome:     ");
            c.setNome(scanner.nextLine().trim());
            System.out.print("Endereço: ");
            c.setEndereco(scanner.nextLine().trim());
            System.out.print("E-mail:   ");
            c.setEmail(scanner.nextLine().trim());
            System.out.print("CPF:      ");
            c.setCPF(scanner.nextLine().trim());
            System.out.print("Telefone: ");
            c.setTelefone(scanner.nextLine().trim());
            
            System.out.println("Dados modificados com sucesso.\n");
        } else {
            System.err.println("Erro ao atualizar dados: Colaborador não encontrado.");
        }
    }
    
    private static void crudColaboradores(Colaborador c) {
        // Cadastro, atualização: Administração.
        // Consulta: Colaborador.
        boolean is_admin = c instanceof Administrador;
        String errmsg = "Você não é um administrador. E você sabe disso.";
        
        while(true) {
            System.out.println("*** Gerenciamento de colaboradores ***");
            System.out.println(
                    "1. Cadastrar colaborador (administrador)\n"
                  + "2. Atualizar dados de colaborador (administrador)\n"
                  + "3. Remover colaborador (administrador)\n"
                  + "4. Voltar\n"
                  + "5. Sair\n"
            );
            
            System.out.print("Sua opção: ");
            
            int option = scanner.nextInt();
            scanner.nextLine();
            
            switch(option) {
                case 1:
                    if(!is_admin) {
                        System.out.println(errmsg);
                        break;
                    }
                    cadastroColaborador((Administrador)c);
                    break;
                case 2:
                    if(!is_admin) {
                        System.out.println(errmsg);
                        break;
                    }
                    alteraColaborador((Administrador)c);
                    break;
                case 3:
                    if(!is_admin) {
                        System.out.println(errmsg);
                        break;
                    }
                    removeColaborador((Administrador)c);
                    break;
                case 4: return;
                case 5:
                    executando = false;
                    return;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            System.out.println();
        }
    }
    
}
