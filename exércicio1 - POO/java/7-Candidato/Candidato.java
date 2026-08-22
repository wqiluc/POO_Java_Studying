/*
 * Exercício 7
 * Classe Candidato com encapsulamento e método para incrementar votos.
 */
public class Candidato 
{

    private int numero;
    private String nome;
    private int votos;

    public Candidato(int numero, String nome) 
    {
        this.nome = nome;
        this.numero = numero;
        this.votos = 0;
    }

    public int getNumero() 
    {
        return numero;
    }

    public void setNumero(int numero) 
    {
        this.numero = numero;
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public int getVotos() 
    {
        return votos;
    }

    public void incrementarVotos() 
    {
        votos++;
    }

    public static void main(String[] args) 
    {
        Candidato candidato = new Candidato(13, "Maria");
        candidato.incrementarVotos();
        candidato.incrementarVotos();
        candidato.incrementarVotos();

        System.out.println(candidato.getNome() + " (" + candidato.getNumero()
                + ") tem " + candidato.getVotos() + " votos");
    }
}