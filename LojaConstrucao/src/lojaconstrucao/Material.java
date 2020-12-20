/* Material.java
 * Este arquivo faz parte do projeto "Loja de Construção".
 * Este código é distribuído sob a Licença MIT.
 */
package lojaconstrucao;

import java.util.Date;

/** Representa um material armazenado no estoque do Sistema de Loja de
 * Construção.
 * @author Gabrielly Bailon Soares de Souza
 * @author Lucas Samuel Vieira
 * @author Luísa Vitória Guimarães Silva
 * @version 1.0
 */
public final class Material {
    private String nome;
    private int quantidade;
    private float preco;
    private String especificacao;
    private float margemLucro;
    private Date dataFabricacao;
    private String fornecedor;
    
    public Material(String nome, int quantidade, float preco,
            String especificacao, float margemLucro, Date dataFabricacao,
            String fornecedor) {
        this.nome = nome;
        setQuantidade(quantidade);
        setPreco(preco);
        this.especificacao = especificacao;
        setMargemLucro(margemLucro);
        this.dataFabricacao = dataFabricacao;
        this.fornecedor = fornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if(quantidade < 0) {
            System.err.println(
                    "Atenção: Quantidade de material inválida; corrija a atribuição");
            quantidade = 0;
        }    
        this.quantidade = quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        if(preco < 0.0f) {
            System.err.println("Atenção: Preço de material inválido; corrija a atribuição");
            preco = 0.0f;
        }
        this.preco = preco;
    }

    public String getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    public float getMargemLucro() {
        return margemLucro;
    }

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

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    @Override
    public String toString() {
        return   "Nome do material:      " + this.nome
             + "\nFornecedor:            " + this.fornecedor
             + "\nQuantidade em estoque: " + this.quantidade
             + "\nPreço unitário:        " + this.preco
             + "\nMargem de Lucro:       " + this.margemLucro
             + "\nData de Fabricação:    " + this.dataFabricacao
             + "\nEspecificação:         " + this.especificacao;
    }
}
