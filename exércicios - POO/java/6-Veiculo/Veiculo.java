/*
 * Exercício 6
 * Classe Veiculo com encapsulamento: atributos private + getters/setters.
 */

public class Veiculo
{
    private String nome_veiculo;
    private String nome_marca;
    private String cor_veiculo;
    private Float preco_veiculo;

    public Veiculo(String nome_veiculo, String nome_marca, String cor_veiculo, Float preco_veiculo)
    {
        this.nome_veiculo = nome_veiculo;
        this.nome_marca = nome_marca;
        this.cor_veiculo = cor_veiculo;
        this.preco_veiculo = preco_veiculo;
    }

    public String getNomeVeiculo()
    {
        return nome_veiculo;
    }

    public void setNomeVeiculo(String nome_veiculo)
    {
        this.nome_veiculo = nome_veiculo;
    }

    public String getNomeMarca()
    {
        return nome_marca;
    }

    public void setNomeMarca(String nome_marca)
    {
        this.nome_marca = nome_marca;
    }

    public String GetCorVeiculo()
    {
        return cor_veiculo;
    }

    public void SetCorVeiculo(String cor_veiculo)
    {
        this.cor_veiculo = cor_veiculo;
    }

    public Float setPrecoVeiculo()
    {
        return preco_veiculo;
    }

    public void getPrecoVeiculo(Float preco_veiculo)
    {
        this.preco_veiculo = preco_veiculo;
    }

    public static void main(String[] args)
    {
        Veiculo veiculo = new Veiculo("Civic", "Honda", 
        "Prata", 120000.00f);

        System.out.println("Veículo: " + veiculo.getNomeVeiculo());
        System.out.println("Marca: " + veiculo.getNomeMarca());
        System.out.println("Cor: " + veiculo.GetCorVeiculo());
        System.out.println("Preço: " + veiculo.setPrecoVeiculo());
    }
}