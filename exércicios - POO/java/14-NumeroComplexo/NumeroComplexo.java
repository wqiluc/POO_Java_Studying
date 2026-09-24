/*
 * Exercício 6 (2ª Lista)
 * Classe NumeroComplexo (a + b*i) com encapsulamento, construtor e:
 * NumeroComplexo adicionar(NumeroComplexo c), subtrair(NumeroComplexo c)
 * e multiplicar(NumeroComplexo c).
 */

public class NumeroComplexo
{
    private double parte_real; // a
    private double parte_imaginaria; // b

    public NumeroComplexo(double parte_real, double parte_imaginaria)
    {
        this.parte_real = parte_real;
        this.parte_imaginaria = parte_imaginaria;
    }

    public double getParteReal()
    {
        return parte_real;
    }

    public void setParteReal(double parte_real)
    {
        this.parte_real = parte_real;
    }

    public double getParteImaginaria()
    {
        return parte_imaginaria;
    }

    public void setParteImaginaria(double parte_imaginaria)
    {
        this.parte_imaginaria = parte_imaginaria;
    }

    public NumeroComplexo adicionar(NumeroComplexo c)
    {
        return new NumeroComplexo(this.parte_real + c.parte_real,
            this.parte_imaginaria + c.parte_imaginaria);
    }

    public NumeroComplexo subtrair(NumeroComplexo c)
    {
        return new NumeroComplexo(this.parte_real - c.parte_real,
            this.parte_imaginaria - c.parte_imaginaria);
    }

    public NumeroComplexo multiplicar(NumeroComplexo c)
    {
        double real = this.parte_real * c.parte_real - this.parte_imaginaria * c.parte_imaginaria;
        double imaginaria = this.parte_real * c.parte_imaginaria + this.parte_imaginaria * c.parte_real;
        return new NumeroComplexo(real, imaginaria);
    }

    @Override // método de sobreescrever
    public String toString()
    {
        if (parte_imaginaria < 0)
        {
            return parte_real + " - " + (-parte_imaginaria) + "i";
        }
        return parte_real + " + " + parte_imaginaria + "i";
    }

    public static void main(String[] args)
    {
        NumeroComplexo z = new NumeroComplexo(3, 2);
        NumeroComplexo w = new NumeroComplexo(1, 4);

        System.out.println("z = " + z);
        System.out.println("w = " + w);
        System.out.println("z + w = " + z.adicionar(w));
        System.out.println("z - w = " + z.subtrair(w));
        System.out.println("z . w = " + z.multiplicar(w));
    }
}