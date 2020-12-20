/* Colaborador.java
 * Este arquivo faz parte do projeto "Loja de Construção".
 * Este código é distribuído sob a Licença MIT.
 */
package lojaconstrucao;

import java.util.ArrayList;
import java.util.List;

/** Representa um Colaborador no Sistema de Loja de Materiais, capaz de realizar
 * login e realizar vendas para clientes.
 * @author Gabrielly Bailon Soares de Souza
 * @author Lucas Samuel Vieira
 * @author Luísa Vitória Guimarães Silva
 * @version 1.0
 */
public class Colaborador extends Pessoa {

    /**
     * Número de instâncias de Colaborador criadas desde o início da execução
     * da aplicação. Pode não condizer com o número de colaboradores cadastrados
     * no sistema.
     */
    protected static int num_instances = 0;
    
    /**
     * Login do colaborador.
     */
    protected String login;

    /**
     * Senha do colaborador.
     */
    protected String senha;
    
    /**
     * Constrói uma instância de um objeto representando um Colaborador.
     * @param nome Nome do colaborador.
     * @param endereco Endereço do colaborador.
     * @param email E-mail do colaborador.
     * @param cpf CPF do colaborador.
     * @param telefone Telefone do colaborador.
     * @param login Login do colaborador.
     * @param senha Senha do colaborador.
     */
    public Colaborador(String nome, String endereco, String email, String cpf,
            String telefone, String login, String senha) {
        super(nome, endereco, email, cpf, telefone);
        this.login = login;
        this.senha = senha;
        num_instances++;
    }

    /**
     * Recupera o login do colaborador.
     * @return String representando o login do colaborador.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Redefine o login do colaborador.
     * @param login Novo login a ser atribuído ao colaborador.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Recupera a senha do colaborador.
     * @return String representando a senha do colaborador.
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Redefine a senha do colaborador.
     * @param senha Nova senha a ser atribuída ao colaborador.
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    /**
     * Retorna o número de instâncias de Colaborador criadas desde o início da
     * execução da aplicação. Este número pode não condizer com a quantidade de
     * colaboradores cadastrados. Caso o colaborador seja carregado por um
     * processo de desserialização, este número não será recuperado.
     * @return Número de instâncias de Colaborador criadas.
     */
    public static int getNumInstances() {
        return num_instances;
    }
    
    /**
     * Gera uma lista de colaboradores estáticos a serem incluídos para testes
     * na aplicação.
     * Os colaboradores gerados não sãpo automaticamente incluídos no sistema.
     * @return Lista de colaboradores distintos que podem ser inseridos.
     */
    public static List<Colaborador> geraColaboradores() {
        List<Colaborador> l = new ArrayList<>();
        
        l.add(new Colaborador("Fulano da Silva",    "Rua dos Bobos, 0, Centro",
                              "fulano@exemplo.com", "12345678910",
                              "038999998888", "fulano", "senha"));
        l.add(new Colaborador("Ciclano da Silva",   "Rua dos Bobos, 1, Centro",
                              "ciclano@exemplo.com", "98765432100",
                              "038988889999", "ciclano", "senha123"));
        l.add(new Colaborador("Beltrano da Silva",  "Rua dos Bobos, 2, Centro",
                              "beltrano@exemplo.com", "99911188823",
                              "038977776666", "beltrano", "dolphins"));
        
        // Colaborador que dará erro: login repetido.
        l.add(new Colaborador("Rásquer da Silva", "Rua dos Rásquers, 0, Centro",
                              "rasquer@l33t.com", "12345678910",
                              "038999998888", "fulano", "s0uumr4squerb4c4n4"));
        
        l.add(new Colaborador("Maria da Paz",
                "Rua de Mais um Teste, 541, Rio Grande, Diamantina",
                "mariamaria@exemplo.com", "55655655857", "038999995231",
                "maria", "senhadamaria"));
        l.add(new Colaborador("Mari Mar",
                "Rua de testando mais uma vez, 547, Largo, Diamantina",
                "marimar@exemplo.com", "11102325403", "03888887455",
                "marimar", "marimartemumasenha"));
        l.add(new Colaborador("José Wilson",
                "Rua Com Um Nome, 854, Rio Grande, Diamantina",
                "jose@exemplo.com", "22210322230", "038975412589",
                "jose", "jose123"));
        l.add(new Colaborador("José da Silva",
                "Rua das Pedras, 12, Centro, Diamantina",
                "josedasilva1@gmail.com", "12312111122", "03193559352",
                "josedasilva", "senhaa"));
        l.add(new Colaborador("Maria Ana",
                "Rua das Ondas, 22, Centro, Diamantina", "mariaana@gmail.com",
                "12312551122", "03193559352", "mariaana", "senha123"));
        l.add(new Colaborador("Floribela Santos",
                "Rua das Flores, 35, Largo Dom João, Diamantina",
                "floribelasantos35@gmail.com", "12312122122", "03193573852",
                "floribelasantos", "123floribela"));
        l.add(new Colaborador("Cláudio Pereira",
                "Avenida 1, 55, Palha, Diamantina",
                "claudiopereira123@gmail.com", "19873489122", "03192332314",
                "claudiopereira", "senhaclaudio"));
        l.add(new Colaborador("Ana Maria",
                "Rua do cansaço, 123, Rio Grande, Diamantina",
                "anamaria@exemplo.com", "85691458298", "038912345678",
                "anamaria", "senhadaanamaria"));
        l.add(new Colaborador("Lucia Antônia Pinheiro",
                "Avenida 2, 88, Polivalente, Diamantina",
                "luciaantoniap1233@gmail.com", "19873231122", "03192332314",
                "luciaantoniap", "luciasenhaantoniap"));
        l.add(new Colaborador("Josicraudo Fernando",
                "Rua teste, 35, Largo Dom João, Diamantina",
                "josicraud@exemplo.com", "99999999999", "038999854762",
                "josicraudo", "senhajosi"));
        l.add(new Colaborador("Ricardo Gomes",
                "Rua das Flores, 42, Largo Dom João, Diamantina",
                "ricardogomes42@gmail.com", "12318942122", "03193573572",
                "ricardogomes", "senharicardo"));
        l.add(new Colaborador("Josué Fernandes",
                "Rua Qualquer, Largo Dom João, Diamantina",
                "josue@gmail.com", "99899899898", "0319852143256",
                "josue", "123456j"));
        l.add(new Colaborador("Leila Maria",
                "Rua Qualquer, 37 Largo Dom João, Diamantina",
                "leila@exemplo.com", "89889889898", "03195896201",
                "Leila", "12leila56"));
        l.add(new Colaborador("Laura Ramos",
                "Rua da Flores, 55, Largo Dom João, Diamantina",
                "lauraramos55@gmail.com", "12363489122", "031923342244",
                "lauraramos", "laurasenharamos"));
        l.add(new Colaborador("Penha Santos", "Rua do cemitério, 735",
                "penha@teste.com", "58967489532", "03158796321",
                "penha", "penha123"));
        l.add(new Colaborador("Maria da Luz",
                "Rua Testando 123, Largo Dom João, Diamantina",
                "mariinha@gmail.com", "88988988989", "031912548963",
                "mariinha", "senha12"));
        l.add(new Colaborador("Antônio",
                "Rua Sei Lá Qual, 85, Largo Dom João, Diamantina",
                "antonio@gmail.com", "77877877878", "031988885546",
                "antonio", "1ant2"));
        l.add(new Colaborador("Cláudio Pereira",
                "Avenida 1, 55, Palha, Diamantina",
                "claudiopereira123@gmail.com", "19873489122", "03192332314",
                "claudiopereira", "senhaclaudio"));
        l.add(new Colaborador("Luciana",
                "Rua das Flores, 632 Largo Dom João, Diamantina",
                "luciana@gmail.com", "55855855858", "031933334445",
                "luciana", "tialulinda"));
        l.add(new Colaborador("Jorge",
                "Rua dos Vovôs, 145 Largo Dom João, Diamantina",
                "jorge@gmail.com", "55855855695", "031925896320",
                "jorge", "senhaj"));
        l.add(new Colaborador("Emanuel Ventura",
                "Rua do TI, 01, Palha, Diamantina", "emanuel@exemplo.com",
                "66666655569", "038914523698", "manel", "senhadomanek"));
        l.add(new Colaborador("Cristiano Paulo Nunes" ,
                "Rua das Pedras, 34, Largo Dom João, Diamantina",
                "cpnunesdiamantina@gmail.com", "1235724335", "031922334482",
                "cristianopnunes", "csenhapn"));
        
        return l;
    }
    
    /**
     * Formata as informações públicas de um Colaborador para serem impressas
     * em console.
     * @return String formatada contendo as informações públicas de um
     * Colaborador.
     */
    @Override
    public String toString() {
        return super.toString() + "\nLogin:    " + this.login;
    }
}
