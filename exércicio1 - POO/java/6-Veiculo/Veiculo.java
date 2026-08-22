/*
 * Exercício 6
 * Classe Veiculo com encapsulamento: atributos private + getters/setters.
 */
public class Veiculo 
{
    private String placa;
    private String nomeDono;
    private String modelo;
    private String fabricante;
    private double valorMercado;

    public Veiculo(String placa, String nomeDono, String modelo, String fabricante, double valorMercado) 
    {
        this.placa = placa;
        this.nomeDono = nomeDono;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.valorMercado = valorMercado;
    }

    public String getPlaca() 
    {
        return placa;
    }

    public void setPlaca(String placa) 
    {
        this.placa = placa;
    }

    public String getNomeDono() 
    {
        return nomeDono;
    }

    public void setNomeDono(String nomeDono) 
    {
        this.nomeDono = nomeDono;
    }

    public String getModelo() 
    {
        return modelo;
    }

    public void setModelo(String modelo) 
    {
        this.modelo = modelo;
    }

    public String getFabricante() 
    {
        return fabricante;
    }

    public void setFabricante(String fabricante) 
    {
        this.fabricante = fabricante;
    }

    public double getValorMercado() 
    {
        return valorMercado;
    }

    public void setValorMercado(double valorMercado) 
    {
        this.valorMercado = valorMercado;
    }

    public static void main(String[] args) 
    {
        Veiculo carro = new Veiculo("ABC1D23", "Lucas", "Civic", "Honda", 120000.00);
        System.out.println(carro.getModelo() + " (" + carro.getFabricante() + ") - Placa: "
                + carro.getPlaca() + " - Dono: " + carro.getNomeDono()
                + " - Valor: " + carro.getValorMercado());
    }
}