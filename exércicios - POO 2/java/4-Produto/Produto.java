

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
 * 3. Produto(codigo, nome)                           -> preco = 0.0, estoque = 0
 *
 * Regra: os construtores 2 e 3 devem REAPROVEITAR os outros usando this(...),
 * sem repetir atribuições.
 *
 * Crie getters, setPreco (não aceita negativo), repor(int quantidade) e
 * exibir(). No main, crie um produto com cada construtor.
 */

public class Produto 
{
    private int codigo_produto;
    private String nome_produto;
    private double preco_produto;
    private int qtd_produto;

    public Produto(int codigo_produto, String nome_produto, double preco_produto, int qtd_produto)
    {
        this.codigo_produto = codigo_produto;
        this.nome_produto = nome_produto;
        this.preco_produto = preco_produto;
        this.qtd_produto = qtd_produto;
    }

    public Produto(int codigo_produto, String nome_produto, double preco_produto)
    {
        this(codigo_produto, nome_produto, preco_produto, 0);
    }

    public Produto(int codigo_produto, String nome_produto)
    {
        this(codigo_produto, nome_produto, 0.0);
    }

    public int getCodigoProduto()
    {
        return codigo_produto;
    }

    public void setCodigoProduto(int codigo_produto)
    {
        this.codigo_produto = codigo_produto;
    }

    public String getNomeProduto()
    {
        return nome_produto;
    }

    public void setNomeProduto(String nome_produto)
    {
        this.nome_produto = nome_produto;
    }

    public double getPrecoProduto()
    {
        return preco_produto;
    }

    public void setPrecoProduto(double preco_produto)
    {
        if (preco_produto <= 0)
        {
            System.err.println("O preço do Produto não pode ser negativo");
            return;
        }

        this.preco_produto = preco_produto;
    }

    public int getQuantidadeProduto()
    {
        return qtd_produto;
    }

    public void setQuantidadeProduto(int qtd_produto)
    {
        this.qtd_produto = qtd_produto;
    }

    public void repor(int quantidade)
    {
        if(quantidade <= 0)
        {
            System.err.println("Não é possivel repor uma qtd nula ou negativa. ");
            return;
        }

        qtd_produto+=quantidade;
    }

    @Override
    public String toString()
    {
        return "Código do Produto: " + getCodigoProduto() +
        " | Nome do Produto: " + getNomeProduto() + " | Preço do Produto: " + getPrecoProduto()
        + " | Quantidade do Produto: " + getQuantidadeProduto();
    }

    public void exibir()
    {
        System.out.println(this);
    }

    public static void main(String[] args) 
    {
        Produto p = new Produto(1, "Notebook", 3500.0, 10);
        Produto p2 = new Produto(2, "Mouse", 80.0);
        Produto p3 = new Produto(3, "Teclado");

        p.exibir();
        p2.exibir();
        p3.exibir();

        System.out.println("\n--- Testando setPreco e repor ---");
        p3.setPrecoProduto(-50);  
        p3.setPrecoProduto(150.0);
        p3.repor(0);       
        p3.repor(5);
        p3.exibir();
    }
}