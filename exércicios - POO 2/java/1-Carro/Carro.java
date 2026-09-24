/*
 * Exercício 1 — Classes, atributos e métodos (básico)
 *
 * Uma locadora quer representar seus carros no sistema.
 * Crie a classe Carro com os atributos marca, modelo, ano (int) e
 * velocidade_atual (double, começa em 0).
 *
 * Crie os métodos:
 * - acelerar(double valor): soma à velocidade, com limite máximo de 200 km/h.
 * - frear(double valor): subtrai da velocidade, sem nunca ficar negativa.
 * - exibirStatus(): imprime "Marca Modelo (ano) a X km/h".
 *
 * No main, crie 2 carros, preencha os atributos diretamente, acelere e freie
 * cada um, e teste os limites (acelerar 250 e frear 300).
 */


public class Carro 
{
    private String marca_veiculo;
    private int ano_veiculo;
    private double velocidade_atual_veiculo;


    public Carro(String marca_veiculo, int ano_veiculo, double velocidade_atual_veiculo)
    {
        this.marca_veiculo = marca_veiculo;
        this.ano_veiculo = ano_veiculo;
        this.velocidade_atual_veiculo = 0;
    }

    public String getMarcaVeiculo()
    {
        return marca_veiculo;
    }

    public void setMarcaVeiculo(String marca_veiculo)
    {
        this.marca_veiculo = marca_veiculo;
    }

    public int getAnoVeiculo()
    {
        return ano_veiculo;
    }

    public void setAnoVeiculo(int ano_veiculo)
    {
        this.ano_veiculo = ano_veiculo;
    }


    public double getVelocidadeVeiculo()
    {
        return velocidade_atual_veiculo;
    }

    public void setVelocidadeVeiculo(double velocidade_atual_veiculo)
    {
        this.velocidade_atual_veiculo = 0;
    }

    public void AcelerarVeiculo(double valor)
    {
        velocidade_atual_veiculo+=valor;

        if (velocidade_atual_veiculo>200)
        {
            velocidade_atual_veiculo = 200;
            System.out.println("Você está excedendo o limite de velocidade! Cuidado");
        }
    }

    public void FrearVeiculo(double valor)
    {
        velocidade_atual_veiculo-=valor;

        if (velocidade_atual_veiculo == 0)
        {
            System.out.println("Você parou totalmente o Veículo! ✅");
        }
        else if (velocidade_atual_veiculo < 0)
        {
            velocidade_atual_veiculo = 0;
            System.err.println("Você NÃO PODE ter uma velocidade negativa ❌");
        }
    }

    public void exibirStatus()
    {
        System.out.println(getMarcaVeiculo() + " (" + getAnoVeiculo() + ") a " + getVelocidadeVeiculo() + " km/h");
    }

    public String toString()
    {
        return "Modelo do Veículo: " + getMarcaVeiculo() + 
        " | Ano de lançamento: " + getAnoVeiculo();
    }

    public static void main(String[] args) 
    {
        Carro c = new Carro("Toyota Corolla", 2022, 0);
        Carro c2 = new Carro("Honda Civic", 2020, 0);

        c.setVelocidadeVeiculo(0);
        c2.setVelocidadeVeiculo(0);

        c.AcelerarVeiculo(80);
        c.FrearVeiculo(30);
        c.exibirStatus();

        c2.AcelerarVeiculo(120);
        c2.FrearVeiculo(50);
        c2.exibirStatus();

        c.AcelerarVeiculo(250);
        c.exibirStatus();

        c2.FrearVeiculo(300);
        c2.exibirStatus();
    }
}