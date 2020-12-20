/* Material.java
 * Este arquivo faz parte do projeto "Loja de Construção".
 * Este código é distribuído sob a Licença MIT.
 */
package lojaconstrucao;

import java.io.Serializable;
import java.util.Date;

/** Representa um material armazenado no estoque do Sistema de Loja de
 * Construção.
 * @author Gabrielly Bailon Soares de Souza
 * @author Lucas Samuel Vieira
 * @author Luísa Vitória Guimarães Silva
 * @version 1.0
 */
public final class Material implements Serializable {
    private int idMaterial;
    private String nome;
    private int quantidade;
    private float preco;
    private String especificacao;
    private float margemLucro;
    private Date dataFabricacao;
    private String fornecedor;
    
    /**
     * Constrói uma instância de um objeto de Material.
     * @param nome Nome do material.
     * @param quantidade Quantidade de material inicial. Deve ser maior que 0.
     * @param preco Preço unitário do material. Deve ser maior que 0.
     * @param especificacao Texto explicativo sobre o material.
     * @param margemLucro Margem de lucro por unidade do material. Deve ser menor ou igual ao preço.
     * @param dataFabricacao Data de fabricação do material.
     * @param fornecedor Nome do fornecedor do material.
     */
    public Material(String nome, int quantidade, float preco,
            String especificacao, float margemLucro, Date dataFabricacao,
            String fornecedor) {
        idMaterial = -1;
        this.nome = nome;
        setQuantidade(quantidade);
        setPreco(preco);
        this.especificacao = especificacao;
        setMargemLucro(margemLucro);
        this.dataFabricacao = dataFabricacao;
        this.fornecedor = fornecedor;
    }

    /**
     * Recupera o ID do material no sistema.
     * @return ID atribuído ao material no sistema, ou -1 se o material ainda
     * não foi cadastrado.
     */
    public int getID() {
        return this.idMaterial;
    }
    
    /**
     * Redefine o ID do material no sistema. Evite invocar diretamente este
     * método.
     * @param id Novo ID a ser atribuído ao material.
     */
    public void setID(int id) {
        this.idMaterial = id;
    }
    
    /**
     * Recupera o nome do material.
     * @return String contendo o nome do material.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Redefine o nome do material.
     * @param nome Novo nome a ser atribuído ao material.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Recupera a quantidade de material disponível.
     * @return Número inteiro contendo a quantidade de material disponível.
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Redefine a quantidade de material disponível.
     * @param quantidade Nova quantidade de material. Este valor deve ser maior
     * ou igual a zero; caso contrário, seu valor será considerado zero.
     * Adicionalmente, um aviso será impresso na saída padrão de erro em caso de
     * falha.
     */
    public void setQuantidade(int quantidade) {
        if(quantidade < 0) {
            System.err.println(
                    "Atenção: Quantidade de material inválida; corrija a atribuição");
            quantidade = 0;
        }    
        this.quantidade = quantidade;
    }

    /**
     * Recupera o preço unitário do material.
     * @return Preço unitário do material.
     */
    public float getPreco() {
        return preco;
    }

    /**
     * Redefine o preço unitário do material.
     * @param preco Novo preço unitário atribuído ao material. Este valor deve
     * ser maior ou igual a zero; caso contrário, seu valor será considerado
     * zero.
     * Adicionalmente, um aviso será impresso na saída padrão de erro em caso de
     * falha.
     */
    public void setPreco(float preco) {
        if(preco < 0.0f) {
            System.err.println("Atenção: Preço de material inválido; corrija a atribuição");
            preco = 0.0f;
        }
        this.preco = preco;
    }

    /**
     * Recupera a especificação textual do material.
     * @return Texto explicativo sobre o material.
     */
    public String getEspecificacao() {
        return especificacao;
    }

    /**
     * Redefine a especificação do material.
     * @param especificacao Nova descrição textual a ser atribuída ao material.
     */
    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    /**
     * Recupera a margem de lucro unitária do material.
     * @return Margem de lucro por unidade do material.
     */
    public float getMargemLucro() {
        return margemLucro;
    }

    /**
     * Redefine a margem de lucro unitária do material.
     * @param margemLucro Novo valor a ser atribuído à margem de lucro unitária.
     * O valor deve ser maior ou igual a zero, e também menor ou igual ao preço
     * unitário do material; caso contrário, seu valor será considerado zero.
     * Adicionalmente, avisos serão impressos na saída padrão de erros em caso
     * de falhas.
     */
    public void setMargemLucro(float margemLucro) {
        if(margemLucro < 0.0f) {
            System.err.println("Atenção: Margem de lucro de material inválida; corrija a atribuição");
            margemLucro = 0.0f;
        } else if (margemLucro > this.preco) {
            System.err.println("Atenção: Margem de lucro maior que preço; corrija a atribuição");
            margemLucro = 0.0f;
        }
        this.margemLucro = margemLucro;
    }

    /**
     * Recupera a data de fabricação do material.
     * @return Instância representativa de data contendo a data de fabricação.
     */
    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    /**
     * Redefine a data de fabricação do material.
     * @param dataFabricacao Nova data de fabricação a ser atribuída ao material.
     */
    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    /**
     * Recupera o nome do fornecedor do material.
     * @return String contendo o nome do fornecedor do material.
     */
    public String getFornecedor() {
        return fornecedor;
    }

    /**
     * Redefine o nome do fornecedor do material.
     * @param fornecedor Novo nome de fornecedor a ser atribuído.
     */
    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    /**
     * Formata as informações do material para serem impressas no console.
     * @return String formatada contendo as informações sobre o material.
     */
    @Override
    public String toString() {
        return "Material #" + this.idMaterial
             + "\nNome do material:      " + this.nome
             + "\nFornecedor:            " + this.fornecedor
             + "\nQuantidade em estoque: " + this.quantidade
             + "\nPreço unitário:        " + this.preco
             + "\nMargem de Lucro:       " + this.margemLucro
             + "\nData de Fabricação:    " + this.dataFabricacao
             + "\nEspecificação:         " + this.especificacao;
    }
}
