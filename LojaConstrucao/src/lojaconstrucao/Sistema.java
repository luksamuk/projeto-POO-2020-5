/* Sistema.java
 * Este arquivo faz parte do projeto "Loja de Construção".
 * Este código é distribuído sob a Licença MIT.
 */
package lojaconstrucao;

import java.util.Map;
import java.util.HashMap;

/** Representa...
 * @author Gabrielly Bailon Soares de Souza
 * @author Lucas Samuel Vieira
 * @author Luísa Vitória Guimarães Silva
 * @version 1.0
 */
public final class Sistema {
    private static Sistema instance;
    
    private Map<String, Colaborador> colaboradores;
    private Map<Integer, Venda>      vendas;
    private Map<Integer, Cliente>    clientes;
    private Map<Integer, Material>   materiais;
    
    private Sistema() {
        // Polimorfismo: o campo é declarado através da
        // interface Map, mas a instância é de um HashMap.
        
        // Colaboradores são indexados pelo CPF, que é String
        colaboradores = new HashMap<>();
        vendas        = new HashMap<>();
        clientes      = new HashMap<>();
        materiais     = new HashMap<>();
        
        // TODO: Cadastrar administrador
    }
    
    public static Sistema getInstance() {
        if(instance == null) {
            instance = new Sistema();
        }
        return instance;
    }
    
    public void incluirColaborador(Administrador adm, Colaborador c)
            throws InvalidPessoaException {
        
    }
    
    public void incluirCliente(Administrador adm, Cliente c)
            throws InvalidPessoaException {
        
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
}
