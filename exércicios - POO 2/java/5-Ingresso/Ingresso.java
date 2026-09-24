/*
 * Exercício 5 — Sobrecarga de métodos + atributo static
 *
 * Uma bilheteria vende ingressos para eventos.
 * Crie a classe Ingresso com evento e valor_base (privados) e um atributo
 * STATIC total_vendidos, incrementado a cada ingresso criado
 * (crie um getter static para ele).
 *
 * Crie o método calcularPreco com SOBRECARGA (4 versões):
 * - calcularPreco()                                   -> valor base
 * - calcularPreco(boolean meia_entrada)               -> metade se for meia
 * - calcularPreco(boolean meia_entrada, String cupom) -> se cupom for "DESC10",
 *                                                        aplica 10% em cima do anterior
 * - calcularPreco(int quantidade)                     -> valor base * quantidade
 *
 * No main, teste as 4 versões e mostre o total de ingressos vendidos.
 */

