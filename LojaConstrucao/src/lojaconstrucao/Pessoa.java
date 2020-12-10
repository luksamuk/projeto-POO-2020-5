/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojaconstrucao;

/**
 *
 * @author alchemist
 */
public abstract class Pessoa {
    protected String nome;
    protected String endereco;
    protected String email;
    protected String cpf;
    protected String telefone;

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }
    
}
