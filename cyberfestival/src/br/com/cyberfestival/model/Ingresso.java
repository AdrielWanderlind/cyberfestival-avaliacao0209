package br.com.cyberfestival.model;

/**
 * Classe que representa um ingresso do festival.
 *
 * Essa classe possui três informações principais:
 * codigoId: identifica o ingresso;
 * tipo: informa se o ingresso é VIP, PISTA etc.;
 * valor: representa o preço do ingresso.
 */
public class Ingresso {

    /*
     * Código identificador do ingresso.
     *
     * É private para garantir o encapsulamento.
     * O acesso ao valor será feito através do getter.
     */
    private String codigoId;

    /*
     * Tipo do ingresso, como "VIP" ou "PISTA".
     *
     * Também é private para manter o atributo encapsulado.
     */
    private String tipo;

    /*
     * Valor monetário do ingresso.
     *
     * O tipo double permite armazenar valores com casas decimais.
     */
    private double valor;

    /**
     * Construtor completo da classe.
     *
     * Recebe todos os atributos necessários para criar um ingresso.
     *
     * @param codigoId código identificador do ingresso
     * @param tipo tipo do ingresso
     * @param valor preço do ingresso
     */
    public Ingresso(String codigoId, String tipo, double valor) {

        /*
         * O "this.codigoId" representa o atributo da classe.
         * O "codigoId" depois do "=" representa o parâmetro recebido.
         */
        this.codigoId = codigoId;

        // Armazena o tipo recebido no atributo tipo.
        this.tipo = tipo;

        // Armazena o valor recebido no atributo valor.
        this.valor = valor;
    }

    /**
     * Getter do codigoId.
     *
     * Permite consultar o código do ingresso sem acessar
     * diretamente o atributo privado.
     *
     * @return código identificador do ingresso
     */
    public String getCodigoId() {
        return codigoId;
    }

    /**
     * Getter do tipo.
     *
     * Permite consultar o tipo do ingresso.
     *
     * @return tipo do ingresso
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Getter do valor.
     *
     * Permite consultar o preço do ingresso.
     *
     * @return valor do ingresso
     */
    public double getValor() {
        return valor;
    }
}
