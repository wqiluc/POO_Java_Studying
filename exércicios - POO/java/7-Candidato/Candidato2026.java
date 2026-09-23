/*
 * Exercício 7
 * Classe Candidato com encapsulamento e método para incrementar votos.
 */

public class Candidato2026
{
    private int numero_candidato;
    private String nome_candidato;
    private int total_votos_candidato;


    public int getNumeroCandidato()
    {
        return numero_candidato;
    }

    public void setNumeroCandidato(int numero_candidato)
    {
        this.numero_candidato = numero_candidato;
    }

    public String getNomeCandidato()
    {
        return nome_candidato;
    }

    public void setNomeCandidato(String nome_candidato)
    {
        this.nome_candidato = nome_candidato;
    }

    public int getTotalVotosCandidato()
    {
        return total_votos_candidato;
    }

    public void setTotalVotosCandidatos(int total_votos_candidato)
    {
        this.total_votos_candidato = total_votos_candidato;
    }

    public void incrementarVotos()
    {
        this.total_votos_candidato++;
    }

    public static void main(String[] args)
    {
        String[] nomes = {"Lula", "Renan", "Flávio", "Cury"};
        int[] numeros = {13, 14, 22, 70};

        Candidato2026[] candidatos = new Candidato2026[4];

        for (int indice_candidato = 0; indice_candidato < 4; indice_candidato++)
        {
            candidatos[indice_candidato] = new Candidato2026();
            candidatos[indice_candidato].setNumeroCandidato(numeros[indice_candidato]);
            candidatos[indice_candidato].setNomeCandidato(nomes[indice_candidato]);
            candidatos[indice_candidato].setTotalVotosCandidatos(0);
        }

        for (Candidato2026 c : candidatos)
        {
            System.out.println(c.getNumeroCandidato() + " - " + c.getNomeCandidato()
                + ": " + c.getTotalVotosCandidato() + " votos");
        }
    }
}