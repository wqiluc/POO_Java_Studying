/*
 * Exercício 7 — Generics (classe genérica + tipo limitado + método genérico)
 *
 * Um sistema precisa guardar vários tipos de objetos (produtos, alunos...)
 * e buscar cada um pelo seu id, sem reescrever a mesma lógica para cada tipo.
 *
 * Parte 1 — Interface
 * Crie a interface Identificavel com o método int getId().
 *
 * Parte 2 — Classes do domínio
 * Crie as classes Produto (id, nome, preco) e Aluno (id, nome, nota),
 * ambas implementando Identificavel, com getters e toString().
 *
 * Parte 3 — Classe genérica com tipo LIMITADO
 * Crie a classe Repositorio<T extends Identificavel> com:
 * - atributo privado itens do tipo ArrayList<T>;
 * - void adicionar(T item): NÃO deixe adicionar dois itens com o mesmo id
 *   (imprima uma mensagem de aviso nesse caso);
 * - T buscarPorId(int id): retorna o item ou null se não existir;
 * - boolean remover(int id): retorna true se removeu;
 * - int tamanho();
 * - void listar(): imprime todos os itens.
 *
 * Parte 4 — Método genérico estático
 * No Repositorio (ou em outra classe), crie:
 *     public static <T> void trocar(T[] vetor, int i, int j)
 * que troca de posição dois elementos de QUALQUER vetor.
 *
 * No main:
 * - crie um Repositorio<Produto> e um Repositorio<Aluno>;
 * - adicione alguns itens (inclusive um com id repetido);
 * - busque, remova e liste;
 * - teste o trocar() com um String[] e com um Integer[].
 *
 * Perguntas (responda em comentário):
 * 1) Por que foi preciso escrever "T extends Identificavel"? O que acontece
 *    no buscarPorId() se a classe for só Repositorio<T>?
 * 2) Tente criar um Repositorio<String>. Compila? Por quê?
 * 3) Por que não dá para usar Repositorio<int>, e o que usar no lugar?
 * 4) Qual a vantagem de Repositorio<Produto> em relação a um repositório
 *    que guarda ArrayList<Object>?
 *
 * Dica: tudo pode ficar neste arquivo (só Repositorio é public) e o main
 * pode ficar dentro do Repositorio. Lembre do import java.util.ArrayList.
 */

import java.util.ArrayList;

public class Repositorio<T extends Identificavel>
{
    private ArrayList<T> itens = new ArrayList<>();

    public void adicionar(T item)
    {
        if (buscarPorId(item.getId()) != null)
        {
            System.out.println("Aviso: já existe um item com id " + item.getId());
            return;
        }
        itens.add(item);
    }

    public T buscarPorId(int id)
    {
        for (T item : itens)
        {
            if (item.getId() == id)
            {
                return item;
            }
        }
        return null;
    }

    public boolean remover(int id)
    {
        T item = buscarPorId(id);

        if (item == null)
        {
            return false;
        }

        return itens.remove(item);
    }

    public int tamanho()
    {
        return itens.size();
    }

    public void listar()
    {
        for (T item : itens)
        {
            System.out.println(item);
        }
    }
    public static <T> void trocar(T[] vetor, int i, int j)
    {
        T aux = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = aux;
    }

    public static void main(String[] args)
    {
        Repositorio<Produto> produtos = new Repositorio<>();
        produtos.adicionar(new Produto(1, "Teclado", 150.0));
        produtos.adicionar(new Produto(2, "Mouse", 80.0));
        produtos.adicionar(new Produto(1, "Monitor", 900.0)); // id repetido -> aviso

        Repositorio<Aluno> alunos = new Repositorio<>();
        alunos.adicionar(new Aluno(10, "Ana", 8.5));
        alunos.adicionar(new Aluno(20, "Bruno", 7.0));

        System.out.println("Produtos (" + produtos.tamanho() + "):");
        produtos.listar();

        Produto p = produtos.buscarPorId(2); // sem cast!
        System.out.println("Busca id 2: " + p.getNome());
        System.out.println("Busca id 99: " + produtos.buscarPorId(99)); // null

        System.out.println("Removeu id 10? " + alunos.remover(10)); // true
        System.out.println("Removeu id 99? " + alunos.remover(99)); // false
        System.out.println("Alunos (" + alunos.tamanho() + "):");
        alunos.listar();

        String[] nomes = {"A", "B", "C"};
        Repositorio.trocar(nomes, 0, 2);
        System.out.println(String.join(", ", nomes)); // C, B, A

        Integer[] numeros = {1, 2, 3};
        Repositorio.trocar(numeros, 0, 1);
        System.out.println(numeros[0] + ", " + numeros[1] + ", " + numeros[2]); // 2, 1, 3
    }
}

/*
 * Respostas:
 *
 * 1) O "extends Identificavel" garante ao compilador que todo T tem o método
 *    getId(). Se fosse só Repositorio<T>, o compilador só saberia que T é um
 *    Object, e item.getId() daria erro de compilação ("cannot find symbol").
 *
 * 2) Não compila. String não implementa Identificavel, então não satisfaz o
 *    limite "T extends Identificavel" (erro: "type argument String is not
 *    within bounds of type-variable T").
 *
 * 3) Generics só aceitam tipos de referência (objetos), não tipos primitivos.
 *    No lugar de int usa-se a classe wrapper Integer (double -> Double,
 *    boolean -> Boolean...). O autoboxing converte automaticamente.
 *
 * 4) Segurança de tipo em tempo de compilação: o Repositorio<Produto> só aceita
 *    Produto (erro na hora de compilar se tentar colocar um Aluno) e o
 *    buscarPorId() já devolve Produto, sem precisar de cast. Com Object daria
 *    pra misturar tudo, seria preciso fazer cast em cada busca e um cast
 *    errado só estouraria em tempo de execução (ClassCastException).
 */

interface Identificavel
{
    int getId();
}

class Produto implements Identificavel
{
    private int id;
    private String nome;
    private double preco;

    public Produto(int id, String nome, double preco)
    {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public int getId()
    {
        return id;
    }

    public String getNome()
    {
        return nome;
    }

    public double getPreco()
    {
        return preco;
    }

    @Override
    public String toString()
    {
        return "( Id: " + id + " | Produto: " + nome + " | Preço: R$" + preco + " )";
    }
}

class Aluno implements Identificavel
{
    private int id;
    private String nome;
    private double nota;

    public Aluno(int id, String nome, double nota)
    {
        this.id = id;
        this.nome = nome;
        this.nota = nota;
    }

    @Override
    public int getId()
    {
        return id;
    }

    public String getNome()
    {
        return nome;
    }

    public double getNota()
    {
        return nota;
    }

    @Override
    public String toString()
    {
        return "( Id: " + id + " | Aluno: " + nome + " | Nota: " + nota + " )";
    }
}