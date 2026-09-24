/*
 * Exercício 8 — @Deprecated (métodos obsoletos)
 *
 * Uma fintech está atualizando a API de pagamentos. Antes existia só o
 * método pagarComBoleto(double valor). Agora o método novo é
 * pagar(double valor, String metodo), que aceita "PIX", "BOLETO" e "CARTAO".
 *
 * Crie a classe ServicoPagamento com total_processado (só getter) e:
 * - pagar(double valor, String metodo): valida valor > 0 e método suportado,
 *   soma ao total e imprime a confirmação; retorna boolean.
 * - pagarComBoleto(double valor): marque como OBSOLETO com
 *   @Deprecated(since = "2.0", forRemoval = true) e com Javadoc @deprecated
 *   indicando o substituto. Ele deve só chamar o método novo.
 *
 * No main, chame os dois métodos e observe o warning do compilador.
 * Pergunta (comentário): por que marcar como deprecated em vez de apagar
 * o método direto?
 */

