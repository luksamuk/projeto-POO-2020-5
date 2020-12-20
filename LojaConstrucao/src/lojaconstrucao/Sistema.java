/* Sistema.java
 * Este arquivo faz parte do projeto "Loja de Construção".
 * Este código é distribuído sob a Licença MIT.
 */
package lojaconstrucao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

/** Representa o Sistema de gerenciamento de Loja de Materiais.
 * Este sistema deve ser instanciado uma única vez pela aplicação. Portanto,
 * utiliza-se o padrão de projetos Singleton para garantir que os dados da
 * aplicação existam uma única vez e que a mesma não sofra inconsistências.
 * @author Gabrielly Bailon Soares de Souza
 * @author Lucas Samuel Vieira
 * @author Luísa Vitória Guimarães Silva
 * @version 1.0
 */
public final class Sistema implements Serializable {
    // Atributos "transient" não serão serializados.
    // Todavia, atributos de classe não são serializados por padrão.
    // O uso da palavra-chave é apenas por garantia.
    private static transient Sistema instance;
    private static final transient String DATA_FILENAME = "loja_data.bin";
    
    private int last_id_material = 0;
    private int last_id_venda    = 0;
    
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
    
    /**
     * Retorna a instância do Singleton do Sistema.
     * @return Instância do Singleton do sistema.
     */
    public static Sistema getInstance() {
        if(instance == null) {
            try {
                instance = Sistema.recuperaInformacoes();
            } catch(IOException e) {
                System.err.println(
                        "Dados anteriores não encontrados. Criando novos dados...");
                instance = new Sistema();
            }
        }
        return instance;
    }
    
    /**
     * Realiza o login de um colaborador.
     * @param login String com login do colaborador.
     * @param senha String com senha do colaborador.
     * @return Instância de Colaborador simbolizando o Colaborador cujo login
     * tenha sido feito com sucesso.
     * @throws InvalidLoginException se o login tiver falhado por algum motivo,
     * populado com informação adicional a respeito da falha.
     */
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
    
    /**
     * Adiciona um novo colaborador no sistema.
     * @param adm Referência ao administrador que está realizando a operação.
     * @param c Colaborador aguardando cadastro, populado com suas informações
     * pessoais.
     * @throws InvalidPessoaException se o colaborador possuir um login já
     * existente no sistema.
     */
    public void incluirColaborador(Administrador adm, Colaborador c)
            throws InvalidPessoaException {
        if(colaboradores.get(c.getLogin()) != null) {
            throw new InvalidPessoaException(c);
        }
        colaboradores.put(c.getLogin(), c);
    }
    
    /**
     * Remove um colaborador do sistema.
     * @param adm Referência ao administrador que está realizando a operação.
     * @param login Login do colaborador a ser removido.
     * @return `true` se o colaborador tiver sido removido com sucesso. Caso
     * contrário, retorna `false`.
     */
    public boolean removeColaborador(Administrador adm, String login) {
        Colaborador c = colaboradores.get(login);
        if(c == null) {
            return false;
        }
        colaboradores.remove(login);
        return true;
    }
    
    /**
     * Recupera um colaborador cadastrado no sistema.
     * @param login Login do colaborador procurado.
     * @return Uma referência ao colaborador cujo login seja igual ao informado,
     * ou `null` se não existir colaborador atribuído àquele login.
     */
    public Colaborador getColaborador(String login) {
        return colaboradores.get(login);
    }
    
    /**
     * Imprime a lista completa de colaboradores na saída padrão do console.
     */
    public void mostraColaboradores() {
        for(Colaborador c : colaboradores.values()) {
            System.out.println(c);
            System.out.println();
        }
    }
    
    /**
     * Adiciona um novo cliente no sistema.
     * @param adm Referência ao administrador que está realizando a operação.
     * @param c Cliente aguardando cadastro, populado com suas informações
     * pessoais.
     * @throws InvalidPessoaException se o cliente possuir um CPF que já
     * corresponda a outro cliente.
     */
    public void incluirCliente(Administrador adm, Cliente c)
            throws InvalidPessoaException {
        if(clientes.get(c.getCPF()) != null) {
            throw new InvalidPessoaException(c);
        }
        clientes.put(c.getCPF(), c);
    }
    
    /**
     * Remove um cliente do sistema.
     * @param adm Referência ao administrador que está realizando a operação.
     * @param cpf CPF do cliente a ser removido.
     * @return `true` se o cliente for encontrado no sistema e então removido
     * com sucesso; do contrário, retorna `false`.
     */
    public boolean removeCliente(Administrador adm, String cpf) {
        Cliente c = getCliente(cpf);
        if(c == null) {
            return false;
        }
        clientes.remove(cpf);
        return true;
    }
    
    /**
     * Recupera um cliente cadastrado no sistema.
     * @param cpf CPF do cliente a ser encontrado.
     * @return Uma referência ao cliente cujo CPF corresponda ao informado, ou
     * `null` se o cliente não for encontrado.
     */
    public Cliente getCliente(String cpf) {
        return clientes.get(cpf);
    }
    
    /**
     * Imprime a lista completa de clientes na saída padrão do console. A lista
     * de clientes será impressa usando a ordem alfabética.
     */
    public void mostraClientes() {
        List<Cliente> lista = new ArrayList(clientes.values());
        Collections.sort(lista);
        for(Cliente c : lista) {
            System.out.println(c);
            System.out.println();
        }
    }
    
    /**
     * Adiciona um novo material no sistema.
     * @param adm Referência ao administrador que está realizando a operação.
     * @param m Material aguardando cadastro, populado com informações do mesmo.
     * @return ID do material recém-cadastrado.
     */
    public int incluirMaterial(Administrador adm, Material m) {
        int id = last_id_material;
        materiais.put(id, m);
        m.setID(id);
        last_id_material++;
        return id;
    }
    
    /**
     * Remove um material no sistema.
     * @param id ID do material a ser removido.
     * @return `true` se o material for encontrado no sistema e removido com
     * sucesso; do contrário, retorna `false`.
     */
    public boolean removeMaterial(int id) {
        Material m = getMaterial(id);
        if(m == null) {
            return false;
        }
        materiais.remove(id);
        return true;
    }
    
    /**
     * Recupera um material cadastrado no sistema.
     * @param id ID do material a ser recuperado.
     * @return Uma referência ao material cujo ID corresponda ao informado, ou
     * `null` se o material não for encontrado.
     */
    public Material getMaterial(int id) {
        return materiais.get(id);
    }
    
    /**
     * Imprime a lista completa do estoque na saída padrão do console.
     */
    public void mostraEstoque() {
        for(Material m : materiais.values()) {
            System.out.println(m);
            System.out.println();
        }
    }
    
    /**
     * Registra uma venda a um cliente no sistema.
     * @param c Referência ao colaborador realizador da venda.
     * @param cl Referência ao cliente a quem a venda será feita.
     * @param v Referência à venda a ser feita.
     * @return ID da venda recém-cadastrada.
     */
    public int realizaVenda(Colaborador c, Cliente cl, Venda v) {
        int id = last_id_venda;
        vendas.put(id, v);
        v.setID(id);
        cl.adicionaCompra(v);
        v.setCliente(cl);
        last_id_venda++;
        return id;
    }

    /**
     * Recupera uma venda cadastrada no sistema.
     * @param id ID da venda a ser recuperada.
     * @return Uma referência à venda cujo ID seja igual ao informado, ou `null`
     * se a venda não foi encontrada.
     */
    public Venda getVenda(int id) {
        return vendas.get(id);
    }
    
    /**
     * Imprime a lista completa de vendas na saída padrão do console.
     */
    public void mostraVendas() {
        for(Venda v : vendas.values()) {
            System.out.println(v);
            System.out.println();
        }
    }
    
    /**
     * Recupera a quantidade de instâncias de clientes criadas desde o início
     * da aplicação. Pode não condizer com a quantidade de clientes cadastrados.
     * @return Número de instâncias de clientes criados desde o início da
     * execução da aplicação.
     */
    public int getInstanciasClientes() {
        return Cliente.getNumInstances();
    }
    
    /**
     * Recupera a quantidade de instâncias de colaboradores criados desde o
     * início da aplicação. Pode não condizer com a quantidade de colaboradores
     * cadastrados.
     * @return Número de instâncias de colaboradores criados desde o início da
     * execução da aplicação.
     */
    public int getInstanciasColaboradores() {
        return Colaborador.getNumInstances();
    }
    
    /**
     * Formata o Singleton do Sistema para ser impresso no console.
     * @return String indicativa do Singleton do Sistema da Loja de Materiais.
     */
    @Override
    public String toString() {
        return "Singleton do Sistema Loja de Materiais";
    }
    
    /**
     * Salva as informações do sistema em um arquivo binário.
     * @throws IOException se houver algum erro na escrita ou abertura do
     * arquivo.
     */
    public void salvaInformacoes() throws IOException {
        FileOutputStream fstream = new FileOutputStream(DATA_FILENAME);
        ObjectOutputStream ostream = new ObjectOutputStream(fstream);
        ostream.writeObject(this);
        ostream.flush();
        ostream.close();
    }
    
    /**
     * Lê as informações do sistema a partir de um arquivo binário e gera uma
     * instância do sistema a partir disso.
     * @return Uma instância do sistema, caso seja possível criá-la, ou `null`
     * se o objeto lido não for uma instância adequada do sistema.
     * @throws IOException se houver algum erro na leitura ou abertura do
     * arquivo.
     */
    private static Sistema recuperaInformacoes() throws IOException {
        FileInputStream fstream = new FileInputStream(DATA_FILENAME);
        ObjectInputStream ostream = new ObjectInputStream(fstream);
        Sistema sist = null;
        try {
            sist = (Sistema)ostream.readObject();
        } catch(ClassNotFoundException e) {
            throw new IOException("Impossível ler objeto");
        }
        return sist;
    }
}
