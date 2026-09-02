package br.com.cyberfestival.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe responsável pelo controle dos ingressos vendidos.
 *
 * Utiliza um HashMap como banco de dados em memória.
 * A chave do mapa é o codigoId do ingresso e o valor armazenado
 * é o próprio objeto Ingresso.
 */
public class Bilheteria {

    /*
     * Cria o mapa que armazenará os ingressos vendidos.
     *
     * String representa o tipo da chave, que será o codigoId.
     * Ingresso representa o objeto armazenado como valor.
     *
     * O HashMap permite localizar rapidamente um ingresso
     * através do seu código.
     */
    private Map<String, Ingresso> ingressosVendidos = new HashMap<>();

    /**
     * Realiza a venda de um ingresso.
     *
     * Antes de adicionar o ingresso ao mapa, verifica se já existe
     * outro ingresso com o mesmo codigoId.
     *
     * @param ingresso ingresso que será vendido
     */
    public void venderIngresso(Ingresso ingresso) {

        /*
         * Obtém o código do ingresso através do getter.
         * Esse código será utilizado como chave no HashMap.
         */
        String codigo = ingresso.getCodigoId();

        /*
         * Verifica se o mapa já possui uma chave igual ao código
         * do ingresso que está sendo vendido.
         *
         * Se o código já existir, significa que o ingresso já foi
         * vendido ou que existe um código duplicado.
         */
        if (ingressosVendidos.containsKey(codigo)) {

            /*
             * Interrompe a operação lançando a exceção personalizada.
             * Dessa forma, o ingresso duplicado não é adicionado ao mapa.
             */
            throw new IngressoInvalidoException();
        }

        /*
         * Se o código ainda não existir no mapa, adiciona o ingresso.
         *
         * A chave será o codigoId e o valor será o objeto ingresso.
         */
        ingressosVendidos.put(codigo, ingresso);
    }

    /**
     * Calcula a receita total somente dos ingressos VIP.
     *
     * O método utiliza exclusivamente Streams, conforme solicitado.
     * Não são utilizados comandos for ou if neste cálculo.
     *
     * @return soma dos valores de todos os ingressos do tipo VIP
     */
    public double calcularReceitaVIP() {

        /*
         * values() obtém somente os valores armazenados no mapa,
         * ou seja, todos os objetos Ingresso.
         */
        return ingressosVendidos
                .values()

                /*
                 * Converte a coleção de ingressos em um Stream,
                 * permitindo realizar operações funcionais sobre eles.
                 */
                .stream()

                /*
                 * Mantém somente os ingressos cujo tipo seja
                 * exatamente igual à String "VIP".
                 */
                .filter(ingresso -> ingresso.getTipo().equals("VIP"))

                /*
                 * Extrai o valor de cada ingresso VIP.
                 *
                 * O método getValor() retorna um double, por isso
                 * usamos mapToDouble para transformar o Stream em
                 * um fluxo de valores numéricos.
                 */
                .mapToDouble(Ingresso::getValor)

                /*
                 * Soma todos os valores dos ingressos VIP
                 * e retorna o resultado como double.
                 */
                .sum();
    }
}
