/* Pessoa.java
 * Este arquivo faz parte do projeto "Loja de Construção".
 * Este código é distribuído sob a Licença MIT.
 */
package lojaconstrucao;

/** Provê um guia de implementação de classes que envolvam informações de
 * indivíduos.
 * @author Gabrielly Bailon Soares de Souza
 * @author Lucas Samuel Vieira
 * @author Luísa Vitória Guimarães Silva
 * @version 1.0
 */
public abstract class Pessoa {
    protected String nome;
    protected String endereco;
    protected String email;
    protected String cpf;
    protected String telefone;
    
    public Pessoa(String nome, String endereco, String email, String cpf,
            String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getCPF() {
        return cpf;
    }
    
    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    @Override
    public String toString() {
        return "Nome:     " + this.nome
             + "\nEndereço: " + this.endereco
             + "\nE-mail:   " + this.email
             + "\nCPF:      " + this.cpf
             + "\nTelefone: " + this.telefone;
    }
}
