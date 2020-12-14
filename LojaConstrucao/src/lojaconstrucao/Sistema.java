/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojaconstrucao;

import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author alchemist
 */
public class Sistema {
    
    private static Sistema instance;
    
    private Map<String, Colaborador> colaboradores;
    private Map<Integer, Venda>      vendas;
    private Map<Integer, Cliente>    clientes;
    private Map<Integer, Material>   materiais;
    
    private Sistema() {
        // Polimorfismo: o campo é declarado através da
        // interface Map, mas a instância é de um HashMap.
        
        // Colaboradores são indexados pelo CPF, que é String
        colaboradores = new HashMap<String, Colaborador>();
        vendas        = new HashMap<Integer, Venda>();
        clientes      = new HashMap<Integer, Cliente>();
        materiais     = new HashMap<Integer, Material>();
        
        // TODO: Cadastrar administrador
    }
    
    public static Sistema getInstance() {
        if(instance == null) {
            instance = new Sistema();
        }
        return instance;
    }
    
    public void incluirColaborador(Administrador adm, Colaborador c) throws InvalidPessoaException {
        
    }
    
    public void incluirCliente(Administrador adm, Cliente c) throws InvalidPessoaException {
        
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
