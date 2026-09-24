/*
 * Exercício 6 — Herança + @Override + super
 *
 * Uma empresa tem funcionários comuns e gerentes.
 *
 * Crie a classe Funcionario (nome, matricula, salario_base) com getters e o
 * método calcularSalario(), que retorna o salário base.
 *
 * Crie a classe Gerente que HERDA de Funcionario e tem um atributo bonus.
 * - O construtor do Gerente deve chamar super(...).
 * - Sobrescreva calcularSalario() com @Override: salário base + bônus,
 *   reaproveitando super.calcularSalario().
 *
 * Dica: as duas classes podem ficar neste arquivo (só uma pode ser public).
 *
 * No main, crie um Funcionario e um Gerente e imprima o salário de cada um.
 * Pergunta (responda em comentário): o que acontece se você escrever
 * @Override em um método com o nome errado, tipo calcularSalarioo()?
 */

