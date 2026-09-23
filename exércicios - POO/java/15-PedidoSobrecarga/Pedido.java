/*
 * Exercício 1 (3ª Lista)
 * Classe Pedido com encapsulamento: codigo (int), nome_cliente (String) e
 * valor (double). Sobrecarga de construtores (um completo, outro sem
 * valor, setando valor = 0). Sobrescreva toString() usando @Override
 * obrigatoriamente.
 */

public class Pedido
{
    private int codigo_pedido;
    private String nome_cliente;
    private double valor_pedido;


    // Construtor completo
    public Pedido(int codigo_pedido, String nome_cliente, double valor_pedido)
    {
        this.codigo_pedido = codigo_pedido;
        this.nome_cliente = nome_cliente;
        this.valor_pedido = valor_pedido;
    }

    public Pedido(int codigo_pedido, String nome_cliente)
    {
        this(codigo_pedido, nome_cliente, 0);
    }


    public int getCodigoPedido()
    {
        return codigo_pedido;
    }

    public void setCodigoPedido(int codigo_pedido)
    {
        this.codigo_pedido = codigo_pedido;
    }

    public String getNomeCliente()
    {
        return nome_cliente;
    }

    public void setNomeCliente(String nome_cliente)
    {
        this.nome_cliente = nome_cliente;
    }

    public double getValorPedido()
    {
        return valor_pedido;
    }

    public void setValorPedido(double valor_pedido)
    {
        this.valor_pedido = valor_pedido;
    }


    @Override
    public String toString()
    {
        return "Pedido #" + codigo_pedido + " | Cliente: " + nome_cliente
            + " | Valor: R$ " + String.format("%.2f", valor_pedido);
    }

    public static void main(String[] args)
    {
        Pedido p1 = new Pedido(1, "Lucas", 150.75);
        Pedido p2 = new Pedido(2, "Maria");

        System.out.println(p1);
        System.out.println(p2);
    }
}