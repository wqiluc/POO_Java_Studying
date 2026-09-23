/*
 * Exercício 1 (2ª Lista)
 * Classe Animal para um Pet Shop: encapsulamento, espécie, idade, se está
 * vacinado, preço e uma descrição. Construtor. Crie também um main que
 * instancie animais e imprima seus atributos.
 */

public class Animal 
{
    private String nome_animal;
    private String especie_animal;
    private int idade_animal;
    private double valor_animal;
    private boolean vacinado_animal;
    private String descricao_animal;

    public Animal(String nome_animal, String especie_animal, int idade_animal,
        double valor_animal, boolean vacinado_animal, String descricao_animal)
        {
            this.nome_animal = nome_animal;
            this.especie_animal = especie_animal;
            this.idade_animal = idade_animal;
            this.valor_animal = valor_animal;
            this.vacinado_animal = vacinado_animal;
            this.descricao_animal = descricao_animal;
        }

    public String getNomeAnimal()
    {
        return nome_animal;
    }

    public void setNomeAnimal(String nome_animal)
    {
        this.nome_animal = nome_animal;
    }

    public String getEspecieAnimal()
    {
        return especie_animal;
    }

    public void setEspecieAnimal(String especie_animal)
    {
        this.especie_animal = especie_animal;
    }

    public int getIdadeAnimal()
    {
        return idade_animal;
    }

    public void setIdadeAnimal(int idade_animal)
    {
        this.idade_animal = idade_animal;
    }

    public double getValorAnimal()
    {
        return valor_animal;
    }

    public void setValorAnimal(double valor_animal)
    {
        this.valor_animal = valor_animal;
    }

    public boolean getVacinadoAnimal()
    {
        return vacinado_animal;
    }

    public void setVacinadoAnimal(boolean vacinado_animal)
    {
        this.vacinado_animal = vacinado_animal;
    }

    public String getDescricaoAnimal()
    {
        return descricao_animal;
    }

    public void setDescricaoAnimal(String descricao_animal)
    {
        this.descricao_animal = descricao_animal;
    }

    public void imprimirAnimal()
    {
        System.out.println("Nome: " + nome_animal);
        System.out.println("Espécie: " + especie_animal);
        System.out.println("Idade: " + idade_animal + " ano(s)");
        System.out.println("Preço: R$ " + valor_animal);
        System.out.println("Vacinado: " + (vacinado_animal ? "Sim" : "Não"));
        System.out.println("Descrição: " + descricao_animal);
        System.out.println("-------------------------");
    }

    public static void main(String[] args) 
    {
        Animal[] animais = new Animal[4];

        animais[0] = new Animal("Rex", "Cachorro", 3, 800, true, "Vira-lata dócil e brincalhão");
        animais[1] = new Animal("Mimi", "Gato", 2, 500, true, "Gata siamesa tranquila");
        animais[2] = new Animal("Kiko", "Calopsita", 1, 250, false, "Assobia o dia inteiro");
        animais[3] = new Animal("Fofa", "Alpaca", 4, 5000, false, "Muito peluda e curiosa");

        for (int i = 0; i < animais.length; i++)
        {
            animais[i].imprimirAnimal();
        }

        animais[2].setVacinadoAnimal(true);
        animais[2].setValorAnimal(300);
        System.out.println("Após vacinar a " + animais[2].getNomeAnimal() + ":");
        animais[2].imprimirAnimal();
    }
}