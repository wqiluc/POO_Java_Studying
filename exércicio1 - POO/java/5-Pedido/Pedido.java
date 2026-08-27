/*
 * Exercício 5
 * Classe Pedido com encapsulamento: atributos private + getters/setters.
 */
public class Pedido 
{

    private int numeroPedido;
    private String nomeCliente;
    private double valorTotal;

    public Pedido(int numeroPedido, String nomeCliente, double valorTotal) 
    {
        this.numeroPedido = numeroPedido;
        this.nomeCliente = nomeCliente;
        this.valorTotal = valorTotal;
    }

    public int getNumeroPedido() 
    {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) 
    {
        this.numeroPedido = numeroPedido;
    }

    public String getNomeCliente() 
    {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) 
    {
        this.nomeCliente = nomeCliente;
    }

    public double getValorTotal() 
    {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) 
    {
        this.valorTotal = valorTotal;
    }

    public static void main(String[] args) 
    {
        Pedido pedido = new Pedido(1, "Lucas", 250.90);
        System.out.println("Pedido #" + pedido.getNumeroPedido()
                + " - Cliente: " + pedido.getNomeCliente()
                + " - Total: " + pedido.getValorTotal());
    }
}