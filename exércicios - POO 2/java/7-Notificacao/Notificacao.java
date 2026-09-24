/*
 * Exercício 7 — Classe abstrata + @Override + polimorfismo
 *
 * Um app envia notificações por vários canais.
 *
 * Crie a classe ABSTRATA Notificacao com destinatario, mensagem e o método
 * abstrato enviar().
 *
 * Crie 3 subclasses, cada uma sobrescrevendo enviar() com @Override:
 * - NotificacaoEmail: tem também um assunto; imprime "[E-MAIL] Para: ... | Assunto: ... | msg"
 * - NotificacaoSMS: corta a mensagem em 160 caracteres; imprime "[SMS] Para: ... | msg"
 * - NotificacaoPush: imprime "[PUSH] Dispositivo: ... | msg"
 *
 * No main, crie um array Notificacao[] com uma de cada e percorra com
 * for-each chamando enviar(). Explique em comentário o que é polimorfismo
 * com base no resultado.
 */

