/* Sistema.java
 * Este arquivo faz parte do projeto "Loja de Construção".
 * Este código é distribuído sob a Licença MIT.
 */
package lojaconstrucao;

import java.util.Map;
import java.util.HashMap;

/** Representa o Sistema de gerenciamento de Loja de Materiais.
 * Este sistema deve ser instanciado uma única vez pela aplicação. Portanto,
 * utiliza-se o padrão de projetos Singleton para garantir que os dados da
 * aplicação existam uma única vez e que a mesma não sofra inconsistências.
 * @author Gabrielly Bailon Soares de Souza
 * @author Lucas Samuel Vieira
 * @author Luísa Vitória Guimarães Silva
 * @version 1.0
 */
public final class Sistema {
    private static Sistema instance;
    
    private Map<String, Colaborador> colaboradores;
    private Map<Integer, Venda>      vendas;
    private Map<String, Cliente>     clientes;
    private Map<Integer, Material>   materiais;
    
    private Sistema() {
        // Polimorfismo: o campo é declarado através da
        // interface Map, mas a instância é de um HashMap.
        
        // Colaboradores são indexados pelo Login, que é String.
        // Clientes são indexados pelo CPF, que é String.
        colaboradores = new HashMap<>();
        vendas        = new HashMap<>();
        clientes      = new HashMap<>();
        materiais     = new HashMap<>();
        
        // Cadastra administrador padrão do sistema
        Administrador adm =
                new Administrador(
                        "Administrador",
                        "",
                        "admin@loja.com",
                        "00000000000",
                        "038000000000",
                        "admin",
                        "admin");
        colaboradores.put(adm.getLogin(), adm);
        
        // Cadastra colaboradores estáticos do sistema
        for(Colaborador c : Colaborador.geraColaboradores()) {
            try {
                this.incluirColaborador(adm, c);
            } catch(InvalidPessoaException e) {
                System.out.println(
                        "No cadastro de colaboradores estáticos: "
                        + e);
            }
        }
    }
    
    public static Sistema getInstance() {
        if(instance == null) {
            instance = new Sistema();
        }
        return instance;
    }
    
    public Colaborador realizaLogin(String login, String senha)
        throws InvalidLoginException {
        Colaborador c = colaboradores.get(login);
        if(c == null) {
            throw new InvalidLoginException(
                    "Login " + login + "não cadastrado");
        }
        if(c.getSenha().equals(senha)) {
            return c;
        }
        throw new InvalidLoginException(login + ": Senha incorreta");
    }
    
    public void incluirColaborador(Administrador adm, Colaborador c)
            throws InvalidPessoaException {
        if(colaboradores.get(c.getLogin()) != null) {
            throw new InvalidPessoaException(c);
        }
        colaboradores.put(c.getLogin(), c);
    }
    
    public void incluirCliente(Administrador adm, Cliente c)
            throws InvalidPessoaException {
        if(clientes.get(c.getCPF()) != null) {
            throw new InvalidPessoaException(c);
        }
        clientes.put(c.getCPF(), c);
    }
    
    public boolean realizarVenda(Venda v) {
        return false;
    }
    
    public boolean cancelarVenda(Venda v) {
        return false;
    }
    
    public boolean incluirMaterial(Material m, int codigo) {
        return false;
    }
    
    public boolean consultarVendas() {
        return false;
    }
    
    public int getInstanciasClientes() {
        return Cliente.getNumInstances();
    }
    
    public int getInstanciasColaboradores() {
        return Colaborador.getNumInstances();
    }
    
    @Override
    public String toString() {
        return "Singleton do Sistema Loja Materiais";
    }
}
