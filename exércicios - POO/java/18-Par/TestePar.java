/*
 * Exercício 7 (3ª Lista)
 * Classe para testar o Par<K, V>: crie os pares notaAluno (aluno, nota) e
 * codigoProduto (codigo, descricao), imprima os pares e depois só as
 * chaves de cada um.
 */

public class TestePar
{
    public static void main(String[] args)
    {
        Par<String, Double> notaAluno = new Par<>("Lucas", 9.5);
        Par<Integer, String> codigoProduto = new Par<>(101, "Teclado mecânico");

        System.out.println("Pares:");
        System.out.println(notaAluno);
        System.out.println(codigoProduto);

        System.out.println("Chaves:");
        System.out.println(notaAluno.getChave());
        System.out.println(codigoProduto.getChave());
    }
}
