package br.com.cyberfestival.model;

/**
 * Exceção personalizada utilizada quando ocorre uma tentativa
 * de cadastrar um ingresso inválido na bilheteria.
 *
 * Essa exceção herda de RuntimeException, portanto é uma
 * Unchecked Exception. Isso significa que não é obrigatório
 * declarar a exceção com "throws" nos métodos que podem lançá-la.
 */
public class IngressoInvalidoException extends RuntimeException {

    /**
     * Construtor da exceção.
     *
     * O super() envia a mensagem personalizada para o construtor
     * da classe RuntimeException.
     *
     * Essa mensagem poderá ser recuperada através do método
     * getMessage() quando a exceção for capturada.
     */
    public IngressoInvalidoException() {

        // Define a mensagem que será exibida quando a exceção ocorrer.
        super("Erro de Segurança: Ingresso já validado ou código duplicado!");
    }
}
