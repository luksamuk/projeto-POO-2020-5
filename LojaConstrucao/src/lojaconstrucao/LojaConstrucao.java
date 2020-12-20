/* LojaConstrucao.java
 * Este arquivo faz parte do projeto "Loja de Construção".
 * Este código é distribuído sob a Licença MIT.
 */
package lojaconstrucao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
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
    
    /* ===== PONTO DE ENTRADA DA APLICAÇÃO ===== */
    
    /** Método estático chamado no início da execução do programa. Exibe um menu
     * via console que pode ser utilizado para gerenciar o sistema.
     * @param args Argumentos fornecidos via linha de comando, ignorados por
     * padrão.
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
                  + "2. Gerenciar vendas\n"
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
                        LojaConstrucao.crudVendas(usuario);
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
    
    /* ===== SUBMENUS ===== */
    // Os métodos a seguir gerenciam submenus da aplicação.
    
    /* Submenu de vendas */
    private static void crudVendas(Colaborador c) {
        // TODO: Imprimir extrato logo após realização da venda!
        System.out.println("Gerência de vendas não implementada!\n");
    }
    
    /* Submenu de materiais */
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
                  + "6. Voltar\n"
                  + "7. Sair\n"
            );
            
            System.out.print("Sua opção: ");
            
            int option = scanner.nextInt();
            int id;
            scanner.nextLine();
            
            switch(option) {
                case 1:
                    if(!is_admin) {
                        System.out.println(errmsg);
                        break;
                    }
                    cadastroMaterial((Administrador)c);
                    break;
                case 2:
                    if(!is_admin) {
                        System.out.println(errmsg);
                        break;
                    }
                    atualizaMaterial((Administrador)c);
                    break;
                case 3:
                    if(!is_admin) {
                        System.out.println(errmsg);
                        break;
                    }
                    System.out.print("Digite o ID do material: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    if(sistema.removeMaterial(id)) {
                        System.out.println("Material #" + id + " removido com sucesso!\n");
                    } else {
                        System.err.println("Material de ID #" + id + " não encontrado!");
                    }
                    break;
                case 4:
                    System.out.print("Digite o ID do material: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    Material m = sistema.getMaterial(id);
                    if(m != null) {
                        System.out.println("Dados do Material #" + id + ":");
                        System.out.println(m);
                        System.out.println();
                    } else {
                        System.err.println("Material de ID #" + id + " não encontrado!");
                    }
                    break;
                case 5:
                    sistema.mostraEstoque();
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
    
    /* Submenu de clientes */
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
    
    /* Submenu de colaboradores */
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
    
    /* ===== CRUDS DE ENTIDADES DO SISTEMA ===== */
    // As seções a seguir enumeram métodos relacionados à execução de
    // CRUDs com entidades em específico. Os métodos são responsáveis por
    // interagir com o usuário, assim como menus. Portanto, constituem uma
    // certa forma de submenu também, com algumas validações de entradas.
    
    /* ----- VENDAS ----- */
    
    
    /* ----- MATERIAIS ----- */
    
    private static void cadastroMaterial(Administrador adm) {
        String nome, especificacao, fornecedor;
        int quantidade;
        float preco = 0.0f;
        float margemLucro = 0.0f;
        Date dataFabricacao = new Date();
        
        // Formatador de datas a partir de string
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.print("Nome:            ");
        nome = scanner.nextLine().trim();
        do {
            System.out.print("Quantidade:      ");
            quantidade = scanner.nextInt();
            scanner.nextLine();
            if(quantidade <= 0) {
                System.err.println("Quantidade inválida!");
            }
        } while(quantidade <= 0);
        do {
            System.out.print("Preço:           ");
            try {
                preco = scanner.nextFloat();
                if(preco <= 0.0f) {
                    System.err.println("Preço inválido!");
                }
            } catch(InputMismatchException e) {
                System.err.println("Digite novamente. Você esqueceu uma vírgula?");
            } finally {
                scanner.nextLine();
            }
        } while(preco <= 0.0f);
        do {
            System.out.print("Margem de lucro: ");
            try {
                margemLucro = scanner.nextFloat();
                if((margemLucro <= 0.0f) || (margemLucro > preco)) {
                    System.err.println("Margem de lucro inválida!");
                }
            } catch(InputMismatchException e) {
                System.err.println("Digite novamente. Você esqueceu uma vírgula?");
            } finally {
                scanner.nextLine();
            }
        } while((margemLucro <= 0.0f) || (margemLucro > preco));
        System.out.print("Especificação:   ");
        especificacao = scanner.nextLine().trim();
        // Parseando a entrada de data
        boolean dateOk;
        do {
            System.out.print("Data de fabricação (dd/mm/aaaa): ");
            try {
                dataFabricacao = sdf.parse(scanner.nextLine().trim());
                System.out.println("Data informada: " + dataFabricacao);
                System.out.print("Correto? (s/n): ");
                dateOk = scanner.nextLine().trim()
                        .toLowerCase()
                        .startsWith("s");
            } catch(ParseException e) {
                System.err.println("Erro na declaração da data: " + e);
                dateOk = false;
            }
        } while(!dateOk);
        
        System.out.print("Fornecedor:    ");
        fornecedor = scanner.nextLine().trim();
        
        var m = new Material(nome, quantidade, preco, especificacao,
                margemLucro, dataFabricacao, fornecedor);
        sistema.incluirMaterial(adm, m);
        System.out.println("Material cadastrado com sucesso:\n" + m);
    }
    
    private static void atualizaMaterial(Administrador adm) {
        System.out.print("Digite o ID do material: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Material m = sistema.getMaterial(id);
        if(m == null) {
            System.err.println("Material de ID #" + id + " não encontrado.");
            return;
        }
        
        // Formatador de datas a partir de string
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        int quantidade = 0;
        float preco = 0.0f, margemLucro = 0.0f;
        Date dataFabricacao;
        
        System.out.print("Nome:            ");
        m.setNome(scanner.nextLine().trim());
        do {
            System.out.print("Quantidade:      ");
            quantidade = scanner.nextInt();
            scanner.nextLine();
            if(quantidade <= 0) {
                System.err.println("Quantidade inválida!");
            } else {
                m.setQuantidade(quantidade);
            }
        } while(quantidade <= 0);
        do {
            System.out.print("Preço:           ");
            try {
                preco = scanner.nextFloat();
                if(preco <= 0.0f) {
                    System.err.println("Preço inválido!");
                } else {
                    m.setPreco(preco);
                }
            } catch(InputMismatchException e) {
                System.err.println("Digite novamente. Você esqueceu uma vírgula?");
            } finally {
                scanner.nextLine();
            }
        } while(preco <= 0.0f);
        do {
            System.out.print("Margem de lucro: ");
            try {
                margemLucro = scanner.nextFloat();
                if((margemLucro <= 0.0f) || (margemLucro > preco)) {
                    System.err.println("Margem de lucro inválida!");
                } else {
                    m.setMargemLucro(margemLucro);
                }
            } catch(InputMismatchException e) {
                System.err.println("Digite novamente. Você esqueceu uma vírgula?");
            } finally {
                scanner.nextLine();
            }
        } while((margemLucro <= 0.0f) || (margemLucro > preco));
        System.out.print("Especificação:   ");
        m.setEspecificacao(scanner.nextLine().trim());
 
        // Entrada de data
        boolean dateOk;
        do {
            System.out.print("Data de fabricação (dd/mm/aaaa): ");
            try {
                dataFabricacao = sdf.parse(scanner.nextLine().trim());
                System.out.println("Data informada: " + dataFabricacao);
                System.out.print("Correto? (s/n): ");
                dateOk = scanner.nextLine().trim()
                        .toLowerCase()
                        .startsWith("s");
                if(dateOk) {
                    m.setDataFabricacao(dataFabricacao);
                }
            } catch(ParseException e) {
                System.err.println("Erro na declaração da data: " + e);
                dateOk = false;
            }
        } while(!dateOk);
        
        System.out.print("Fornecedor:    ");
        m.setFornecedor(scanner.nextLine().trim());
        
        System.out.println("Dados atualizados com sucesso:");
        System.out.println(m);
        System.out.println();
    }
    
    /* ----- CLIENTES ----- */
    
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
    
    /* ----- COLABORADOR ----- */
    
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
    
}
