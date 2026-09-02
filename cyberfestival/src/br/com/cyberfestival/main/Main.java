package br.com.cyberfestival.main;

import br.com.cyberfestival.model.Bilheteria;
import br.com.cyberfestival.model.Ingresso;
import br.com.cyberfestival.model.IngressoInvalidoException;

/**
 * Classe principal do sistema.
 *
 * É responsável por executar e demonstrar as funcionalidades
 * da classe Bilheteria, como vender ingressos, tratar ingressos
 * com código duplicado e calcular a receita dos ingressos VIP.
 */
public class Main {

    public static void main(String[] args) {

        // Cria um objeto da classe Bilheteria.
        // Esse objeto possui o mapa que armazenará os ingressos vendidos.
        Bilheteria bilheteria = new Bilheteria();

        // Cria o primeiro ingresso.
        // O código é A-01, o tipo é VIP e o valor é R$ 500,00.
        Ingresso ingresso1 = new Ingresso("A-01", "VIP", 500.00);

        // Cria o segundo ingresso.
        // O código é A-02, o tipo é Pista e o valor é R$ 200,00.
        Ingresso ingresso2 = new Ingresso("A-02", "Pista", 200.00);

        // Cria um terceiro ingresso com o mesmo código do ingresso1.
        // Como A-01 já foi vendido, esse ingresso deverá gerar uma exceção.
        Ingresso ingresso3 = new Ingresso("A-01", "PISTA", 200.00);

        // Vende o primeiro ingresso.
        // Como o código A-01 ainda não existe no mapa, a venda é realizada.
        bilheteria.venderIngresso(ingresso1);

        // Vende o segundo ingresso.
        // Como o código A-02 ainda não existe no mapa, a venda é realizada.
        bilheteria.venderIngresso(ingresso2);

        // Exibe uma mensagem informando que os dois ingressos foram vendidos.
        System.out.println("Ingressos A-01 e A-02 vendidos com sucesso.");

        /*
         * O bloco try é utilizado porque a tentativa de vender o ingresso3
         * pode gerar uma IngressoInvalidoException.
         */
        try {

            // Tenta vender o ingresso3.
            // O código A-01 já está cadastrado, então a exceção será lançada.
            bilheteria.venderIngresso(ingresso3);

        } catch (IngressoInvalidoException e) {

            /*
             * Captura a exceção lançada pela Bilheteria e exibe
             * a mensagem definida no construtor da exceção.
             */
            System.out.println("Alerta!!! " + e.getMessage());
        }

        /*
         * Calcula a receita somente dos ingressos cujo tipo é exatamente VIP.
         * Nesse exemplo, apenas o ingresso1 é VIP e custa R$ 500,00.
         */
        double receitaVIP = bilheteria.calcularReceitaVIP();

        // Exibe o valor total da receita dos ingressos VIP.
        System.out.println("Receita VIP: " + receitaVIP);
    }
}