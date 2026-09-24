/*
 * Exercício 5 (2ª Lista)
 * Classe Vetor (vetor tridimensional a1*x + a2*y + a3*z): construtor,
 * Vetor adicionar(Vetor v), void multiplicacaoEscalar(double num) e
 * double produtoEscalar(Vetor v).
 */

public class Vetor
{
    private double a1;
    private double a2;
    private double a3;

    public Vetor(double a1, double a2, double a3)
    {
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
    }

    public double getA1()
    {
        return a1;
    }

    public double getA2()
    {
        return a2;
    }

    public double getA3()
    {
        return a3;
    }
    public Vetor adicionar(Vetor v)
    {
        return new Vetor(this.a1 + v.a1, this.a2 + v.a2, this.a3 + v.a3);
    }

    public void multiplicacaoEscalar(double num)
    {
        this.a1 = this.a1 * num;
        this.a2 = this.a2 * num;
        this.a3 = this.a3 * num;
    }

    public double produtoEscalar(Vetor v)
    {
        return this.a1 * v.a1 + this.a2 * v.a2 + this.a3 * v.a3;
    }

    @Override // método de sobreescrever
    public String toString()
    {
        return a1 + "x + " + a2 + "y + " + a3 + "z";
    }

    public static void main(String[] args)
    {
        Vetor vetorA = new Vetor(1, 2, 3);
        Vetor vetorB = new Vetor(4, 5, 6);

        System.out.println("A = " + vetorA);
        System.out.println("B = " + vetorB);

        System.out.println("A + B = " + vetorA.adicionar(vetorB));
        System.out.println("A . B = " + vetorA.produtoEscalar(vetorB));

        vetorA.multiplicacaoEscalar(2);
        System.out.println("A após multiplicar por 2 = " + vetorA);
    }
}