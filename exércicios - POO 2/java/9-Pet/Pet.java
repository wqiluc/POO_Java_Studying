/*
 * Exercício 9 — @Override de toString(), equals() e hashCode()
 *
 * Uma clínica veterinária não quer cadastrar o mesmo pet duas vezes.
 *
 * Crie a classe Pet com nome, especie e cpf_tutor (privados, com getters).
 * Sobrescreva com @Override:
 * - toString(): "Pet{nome='...', especie='...', tutor='...'}"
 * - equals(Object o): dois pets são iguais se tiverem o mesmo nome
 *   (ignorando maiúsculas/minúsculas) E o mesmo cpf_tutor.
 * - hashCode(): coerente com o equals (dica: Objects.hash).
 *
 * No main:
 * - imprima um pet direto com System.out.println(pet);
 * - compare dois pets "iguais" com == e com equals e explique a diferença;
 * - use um ArrayList<Pet> e contains() para impedir cadastro duplicado.
 */

