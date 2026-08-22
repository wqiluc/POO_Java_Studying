/*
 * Exercício 4
 * Classe "biblioteca de funções" matemáticas: não pode ser instanciada
 * (construtor privado) e só tem métodos estáticos.
 */
public class CalculadoraMatematica 
{
    private CalculadoraMatematica() 
    {
        
    }

    public static double adicionar(double a, double b) 
    {
        return a + b;
    }

    public static double media(double[] valores) 
    {
        double soma = 0;

        for (double valor : valores) 
        {
            soma += valor;
        }

        return soma / valores.length;
    }

    public static boolean ehPrimo(int numero)     
    {
        if (numero < 2) 
        {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(numero); i++) 
        {
            if (numero % i == 0) 
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) 
    {
        System.out.println("adicionar(2.5, 3.7) = " + adicionar(2.5, 3.7));

        double[] valores = {2.0, 4.0, 6.0, 8.0};
        System.out.println("media = " + media(valores));

        System.out.println("ehPrimo(7) = " + ehPrimo(7));
        System.out.println("ehPrimo(10) = " + ehPrimo(10));
    }
}
