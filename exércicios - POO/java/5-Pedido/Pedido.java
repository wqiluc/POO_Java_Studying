/*
 * Exercício 5
 * Classe Pedido com encapsulamento: atributos private + getters/setters.
*/

public class Pedido 
{
    private int numero_pedido;
    private String nome_cliente;
    private Float valor_pedido;

    public Pedido(int numero_pedido, String nome_cliente, Float valor_pedido)
    {
        this.nome_cliente = nome_cliente;
        this.numero_pedido = numero_pedido;
        this.valor_pedido = valor_pedido;
    }

    public int getNumeroPedido()
    {
        return numero_pedido;
    }

    public void setNumeroPedido(int numero_pedido)
    {
        this.numero_pedido = numero_pedido;
    }

    public String getNomeCliente()
    {
        return nome_cliente;
    }

    public void setNomeCliente(String nome_cliente)
    {
        this.nome_cliente = nome_cliente;
    }

    public Float getValorPedido()
    {
        return valor_pedido;
    }

    public void setValorPedido(Float valor_pedido)
    {
        this.valor_pedido = valor_pedido;
    }

    public static void main(String[] args)
    {
        Pedido p = new Pedido(1, "Lucas", 180f);
        System.out.println("\n\t Pedido nº " + p.getNumeroPedido());
        System.out.println("Nome do Cliente " + p.getNomeCliente());
        System.out.println("Valor do Pedido: R$ " + p.getValorPedido());

        p.setValorPedido(180.50f);

        System.out.println("Novo valor: R$ " + p.getValorPedido());

        System.out.println("\nResumo final -> Pedido nº " + p.getNumeroPedido()
                + " | Cliente: " + p.getNomeCliente()
                + " | Valor: R$ " + p.getValorPedido());
    }
}