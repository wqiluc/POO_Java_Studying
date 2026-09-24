/*
 * Exercício 5 (3ª Lista)
 * Classe para testar a Caixa<T>: crie uma caixa de String, adicione
 * "usando Generics", chame estaVazia / retirar / estaVazia de novo,
 * imprimindo cada resposta. Crie também uma caixa de Integer.
 */

public class TesteCaixa
{
    public static void main(String[] args)
    {
        Caixa<String> caixaString = new Caixa<>();
        caixaString.guardar("usando Generics");

        System.out.println("Caixa de String vazia? " + caixaString.estaVazia());
        System.out.println("Retirado: " + caixaString.retirar());
        System.out.println("Caixa de String vazia? " + caixaString.estaVazia());

        Caixa<Integer> caixaInteger = new Caixa<>();
        caixaInteger.guardar(42);

        System.out.println("Caixa de Integer vazia? " + caixaInteger.estaVazia());
        System.out.println("Retirado: " + caixaInteger.retirar());
        System.out.println("Caixa de Integer vazia? " + caixaInteger.estaVazia());
    }
}
