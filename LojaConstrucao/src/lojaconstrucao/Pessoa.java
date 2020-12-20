/* Pessoa.java
 * Este arquivo faz parte do projeto "Loja de Construção".
 * Este código é distribuído sob a Licença MIT.
 */
package lojaconstrucao;

/** Provê um guia de implementação de classes que envolvam informações de
 * indivíduos. Esta classe abstrata contém informações que poderiam ser
 * encontradas em clientes e colaboradores.
 * @author Gabrielly Bailon Soares de Souza
 * @author Lucas Samuel Vieira
 * @author Luísa Vitória Guimarães Silva
 * @version 1.0
 */
public abstract class Pessoa implements Comparable<Pessoa> {

    /**
     * Nome da pessoa.
     */
    protected String nome;

    /**
     * Endereço da pessoa.
     */
    protected String endereco;

    /**
     * E-mail da pessoa.
     */
    protected String email;

    /**
     * CPF da pessoa.
     */
    protected String cpf;

    /**
     * Telefone da pessoa.
     */
    protected String telefone;
    
    /**
     * Constrói uma instância de Pessoa. Este construtor não pode ser chamado
     * diretamente, posto ser um construtor de classe abstrata. Em vez disso,
     * classes que extendem esta classe deverão invocar este construtor para
     * finalizar a inicialização das informações de uma Pessoa.
     * @param nome Nome da pessoa.
     * @param endereco Endereço da pessoa.
     * @param email E-mail da pessoa.
     * @param cpf CPF da pessoa.
     * @param telefone Telefone da pessoa.
     */
    public Pessoa(String nome, String endereco, String email, String cpf,
            String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    /**
     * Recupera o nome da pessoa.
     * @return String contendo o nome da pessoa.
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Redefine o nome da pessoa.
     * @param nome Novo nome a ser atribuído à pessoa.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Recupera o endereço da pessoa.
     * @return String contendo o endereço da pessoa.
     */
    public String getEndereco() {
        return endereco;
    }
    
    /**
     * Redefine o endereço a pessoa.
     * @param endereco Novo endereço a ser atribuído à pessoa.
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Recupera o e-mail da pessoa.
     * @return String contendo o e-mail da pessoa.
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Redefine o e-mail da pessoa.
     * @param email Novo e-mail a ser atribuído à pessoa.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Recupera o CPF da pessoa.
     * @return String contendo o CPF da pessoa.
     */
    public String getCPF() {
        return cpf;
    }
    
    /**
     * Redefine o CPF da pessoa.
     * @param cpf Novo CPF a ser atribuído à pessoa.
     */
    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Recupera o telefone da pessoa.
     * @return String contendo o telefone da pessoa.
     */
    public String getTelefone() {
        return telefone;
    }
    
    /**
     * Redefine o telefone da pessoa.
     * @param telefone Novo telefone a ser atribuído à pessoa.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    /**
     * Formata as informações da Pessoa para serem impressas no console.
     * @return String formatada contendo as informações públicas da Pessoa.
     */
    @Override
    public String toString() {
        return "Nome:     " + this.nome
             + "\nEndereço: " + this.endereco
             + "\nE-mail:   " + this.email
             + "\nCPF:      " + this.cpf
             + "\nTelefone: " + this.telefone;
    }
    
    /**
     * Compara duas pessoas através do nome das mesmas, em ordem alfabética.
     * @param p Pessoa ao qual se quer comparar.
     * @return Número inteiro representando a comparação de acordo com ordem
     * alfabética.
     */
    @Override
    public int compareTo(Pessoa p) {
        return p.getNome().compareTo(this.nome);
    }
}
