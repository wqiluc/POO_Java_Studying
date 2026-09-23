/*
 * Exercício 3 (2ª Lista)
 * Classe Pessoa: nome, idade, altura, peso e sexo (encapsulados). Método
 * para calcular o IMC e um toString() que informa o nome e a categoria do
 * IMC (abaixo do peso, peso normal, acima do peso, obesidade).
 */

public class Pessoa 
{
    private String nome_pessoa;
    private int idade_pessoa;
    private Float altura_pessoa;
    private Float peso_pessoa;
    private String genero_pessoa;

    public Pessoa(String nome_pessoa, int idade_pessoa, 
    Float altura_pessoa, Float peso_pessoa, String genero_pessoa)
    {
        this.nome_pessoa = nome_pessoa;
        this.idade_pessoa = idade_pessoa;
        this.altura_pessoa = altura_pessoa;
        this.peso_pessoa = peso_pessoa;
        this.genero_pessoa = genero_pessoa;   
    }

    public String getNomePessoa()
    {
        return nome_pessoa;
    }

    public void setNomePessoa(String nome_pessoa)
    {
        this.nome_pessoa = nome_pessoa;
    }

    public int getIdadePessoa()
    {
        return idade_pessoa;
    }

    public void setIdadePessoa(int idade_pessoa)
    {
        this.idade_pessoa = idade_pessoa;
    }

    public Float getAlturaPessoa()
    {
        return altura_pessoa;
    }

    public void setAlturaPessoa(Float altura_pessoa)
    {
        this.altura_pessoa = altura_pessoa;
    }

    public Float getPesoPessoa()
    {
        return peso_pessoa;
    }

    public void setPesoPessoa(Float peso_pessoa)
    {
        this.peso_pessoa = peso_pessoa;
    }


    public String getGeneroPessoa()
    {
        return genero_pessoa;
    }

    public void setGeneroPessoa(String genero_pessoa)
    {
        this.genero_pessoa = genero_pessoa;
    }

    public String calcularImcPessoa()
    {
        // IMC = peso / altura²
        Float imc = this.peso_pessoa / (this.altura_pessoa * this.altura_pessoa);
        String categoria;

        if (imc < 18.5f)
        {
            categoria = "abaixo do peso";
        }
        else if (imc < 25f)
        {
            categoria = "peso normal";
        }
        else if (imc < 30f)
        {
            categoria = "acima do peso";
        }
        else
        {
            categoria = "obesidade";
        }

        return "IMC: " + String.format("%.2f", imc) + ", categoria: " + categoria;
    }

    @Override // método de sobreescrever
    public String toString()
    {
        return "Pessoa [nome: " + nome_pessoa + ", " + calcularImcPessoa() + "]";
    }

    public static void main(String[] args)
    {
        Pessoa pessoa1 = new Pessoa("Ana", 20, 1.65f, 50f, "Feminino");
        Pessoa pessoa2 = new Pessoa("Bruno", 25, 1.80f, 75f, "Masculino");
        Pessoa pessoa3 = new Pessoa("Carla", 30, 1.60f, 70f, "Feminino");
        Pessoa pessoa4 = new Pessoa("Diego", 40, 1.75f, 100f, "Masculino");

        System.out.println(pessoa1);
        System.out.println(pessoa2);
        System.out.println(pessoa3);
        System.out.println(pessoa4);

        pessoa4.setPesoPessoa(80f);
        System.out.println("Após alterar o peso de " + pessoa4.getNomePessoa() + " para 80kg:");
        System.out.println(pessoa4);
    }
}