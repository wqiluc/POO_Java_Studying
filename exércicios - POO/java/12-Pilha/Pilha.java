/*
 * Exercício 4 (2ª Lista)
 * Estrutura de dados Pilha (LIFO): boolean adicionar(Object o), Object
 * retirar() e boolean estaVazia(). Crie um main que adicione e retire
 * objetos, imprimindo o que foi retirado.
 */

public class Pilha
{
    private Object[] elementos_pilha;
    private int topo_pilha; // quantidade de elementos (e próxima posição livre)

    public Pilha(int capacidade_pilha)
    {
        this.elementos_pilha = new Object[capacidade_pilha];
        this.topo_pilha = 0;
    }

    public boolean adicionar(Object o)
    {
        if (topo_pilha == elementos_pilha.length)
        {
            return false; // pilha cheia
        }

        elementos_pilha[topo_pilha] = o;
        topo_pilha++;
        return true;
    }

    public Object retirar()
    {
        if (estaVazia())
        {
            return null;
        }

        topo_pilha--;
        Object retirado = elementos_pilha[topo_pilha];
        elementos_pilha[topo_pilha] = null;
        return retirado;
    }

    public boolean estaVazia()
    {
        return topo_pilha == 0;
    }

    public static void main(String[] args)
    {
        Pilha pilha1 = new Pilha(3);

        System.out.println("Adicionou \"A\"? " + pilha1.adicionar("A"));
        System.out.println("Adicionou 10? " + pilha1.adicionar(10));
        System.out.println("Adicionou 2.5? " + pilha1.adicionar(2.5));
        System.out.println("Adicionou \"B\" (pilha cheia)? " + pilha1.adicionar("B"));

        while (!pilha1.estaVazia())
        {
            System.out.println("Retirado: " + pilha1.retirar());
        }

        System.out.println("Pilha vazia? " + pilha1.estaVazia());
    }
}
