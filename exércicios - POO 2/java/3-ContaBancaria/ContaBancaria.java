/*
 * Exercício 3 — Encapsulamento: atributo somente leitura
 *
 * Um banco digital precisa de uma classe ContaBancaria.
 * Atributos privados: numero_conta, titular e saldo.
 *
 * - O construtor recebe numero_conta e titular; o saldo começa em 0.✅
 * - numero_conta só tem getter (não muda nunca).✅
 * - titular tem getter e setter.✅
 * - saldo só tem getter: ✅
 *     NÃO pode existir setSaldo(). ✅
 *     O saldo só muda por:
 *      - depositar(double valor): valor deve ser > 0;
 *      - boolean sacar(double valor): valor > 0 e não pode passar do saldo;
 *      - boolean transferir(ContaBancaria destino, double valor): usa sacar e depositar.
 *
 * No main, crie 2 contas, deposite, tente um saque inválido, faça uma
 * transferência e mostre os saldos. Explique em um comentário por que não
 * faz sentido existir setSaldo().
 */
