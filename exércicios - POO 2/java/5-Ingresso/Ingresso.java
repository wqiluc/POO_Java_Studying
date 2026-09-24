/*
 * Exercício 5 — Sobrecarga de métodos + atributo static
 *
 * Uma bilheteria vende ingressos para eventos.
 * Crie a classe Ingresso com evento e valor_base (privados) e um atributo
 * STATIC total_vendidos, incrementado a cada ingresso criado
 * (crie um getter static para ele).
 *
 * Crie o método calcularPreco com SOBRECARGA (4 versões):
 * - calcularPreco() -> valor base
 * - calcularPreco(boolean meia_entrada) -> metade se for meia
 * - calcularPreco(boolean meia_entrada, String cupom) -> se cupom for "DESC10",
 * aplica 10% em cima do anterior
 * 
 * - calcularPreco(int quantidade) -> valor base * quantidade
 *
 * No main, teste as 4 versões e mostre o total de ingressos vendidos.
 */


public class Ingresso 
{
    private String evento_ingresso;
    private double preco_ingresso;
    private int qtd_ingressos;

    private static int total_ingressos_vendidos = 0;

    public Ingresso(String evento_ingresso, double preco_ingresso, int qtd_ingressos)
    {
        this.evento_ingresso = evento_ingresso;
        this.preco_ingresso = preco_ingresso;
        this.qtd_ingressos = qtd_ingressos;

        total_ingressos_vendidos += qtd_ingressos;
    }

    public static int getTotalIngressosVendidos()
    {
        return total_ingressos_vendidos;
    }

    public String getNomeEvento()
    {
        return evento_ingresso;
    }

    public void setNomeEvento(String evento_ingresso)
    {
        this.evento_ingresso = evento_ingresso;
    }

    public double getPrecoIngresso()
    {
        return preco_ingresso;
    }

    public void setPrecoIngresso(double preco_ingresso)
    {
        this.preco_ingresso = preco_ingresso;
    }


    public int getQTDIngressos()
    {
        return qtd_ingressos;
    }

    public void setQTDIngressos(int qtd_ingressos)
    {
        this.qtd_ingressos = qtd_ingressos;
    }


    public double calcularPreco()
    {
        return preco_ingresso;
    }

    public double calcularPreco(boolean meia_entrada)
    {
        if (meia_entrada == true)
        {
            return calcularPreco() / 2;
        }

        return calcularPreco();
    }

    public double calcularPreco(boolean meia_entrada, String cupom)
    {
        double preco = calcularPreco(meia_entrada);

        if (cupom.equals("DESC10"))
        {
            preco *= 0.9;
        }

        return preco;
    }

    public double calcularPreco(int quantidade)
    {
        return preco_ingresso * quantidade;
    }

    @Override
    public String toString()
    {
        return "Evento: " + getNomeEvento() + " | Preço do Ingresso: " + getPrecoIngresso()
        + " | Quantidade de Ingressos: " + getQTDIngressos();
    }

    public static void main(String[] args) 
    {
        Ingresso i1 = new Ingresso("Show do Coldplay", 400.0, 2);
        Ingresso i2 = new Ingresso("Jogo do Sport", 80.0, 3);

        System.out.println(i1);
        System.out.println(i2);

        System.out.println("\n--- Testando as 4 versões de calcularPreco ---");
        System.out.println("Valor base: " + i1.calcularPreco());
        System.out.println("Meia entrada: " + i1.calcularPreco(true));
        System.out.println("Inteira sem meia: " + i1.calcularPreco(false));
        System.out.println("Meia + cupom DESC10: " + i1.calcularPreco(true, "DESC10"));
        System.out.println("Inteira + cupom inválido: " + i1.calcularPreco(false, "XPTO"));
        System.out.println("Valor para 3 ingressos: " + i2.calcularPreco(i2.getQTDIngressos()));

        System.out.println("\nTotal de ingressos vendidos: " + Ingresso.getTotalIngressosVendidos());
    }
}