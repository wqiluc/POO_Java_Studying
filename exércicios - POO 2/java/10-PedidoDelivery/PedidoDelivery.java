/*
 * Exercício 10 — Desafio final: juntando tudo
 *
 * Um app de delivery precisa montar pedidos.
 *
 * Crie a classe ItemPedido (nome, preco_unitario, quantidade) com getters,
 * getSubtotal() e toString() com @Override: "2x Refrigerante (R$ 24,00)".
 *
 * Crie a classe PedidoDelivery com:
 * - numero gerado automaticamente por um contador static;
 * - cliente, taxa_entrega e um ArrayList<ItemPedido>;
 * - SOBRECARGA de construtores: (cliente, taxa_entrega) e (cliente) para
 *   retirada no balcão (taxa 0), usando this(...);
 * - SOBRECARGA de adicionarItem: (ItemPedido), (nome, preco, quantidade) e
 *   (nome, preco) com quantidade 1;
 * - getters e setTaxaEntrega (não aceita negativo);
 * - calcularSubtotal() e calcularTotal(): frete grátis se subtotal >= R$ 100;
 * - calcularTotalAntigo(): versão velha que sempre soma o frete, marcada
 *   com @Deprecated;
 * - toString() com @Override listando itens e total.
 *
 * No main, monte um pedido com frete grátis e outro de retirada, imprima os
 * dois e compare o total novo com o antigo.
 */

