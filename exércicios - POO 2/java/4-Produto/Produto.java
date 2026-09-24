/*
 * Exercício 4 — Sobrecarga de construtores com this(...)
 *
 * Um e-commerce cadastra produtos em momentos diferentes: às vezes já com
 * preço e estoque, às vezes só com preço, às vezes só com código e nome.
 *
 * Crie a classe Produto (codigo, nome, preco, quantidade_estoque — privados)
 * com TRÊS construtores:
 * 1. Produto(codigo, nome, preco, quantidade_estoque)  -> completo
 * 2. Produto(codigo, nome, preco)                      -> estoque = 0
 * 3. Produto(codigo, nome)                             -> preco = 0.0, estoque = 0
 *
 * Regra: os construtores 2 e 3 devem REAPROVEITAR os outros usando this(...),
 * sem repetir atribuições.
 *
 * Crie getters, setPreco (não aceita negativo), repor(int quantidade) e
 * exibir(). No main, crie um produto com cada construtor.
 */

