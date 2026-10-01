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
        Candidato2026 lula = new Candidato2026();
        lula.setNumeroCandidato(13);
        lula.setNomeCandidato("Lula");
        lula.setTotalVotosCandidatos(0);

        Candidato2026 renan = new Candidato2026();
        renan.setNumeroCandidato(14);
        renan.setNomeCandidato("Renan");
        renan.setTotalVotosCandidatos(0);

        Candidato2026 flavio = new Candidato2026();
        flavio.setNumeroCandidato(22);
        flavio.setNomeCandidato("Flávio");
        flavio.setTotalVotosCandidatos(0);

        Candidato2026 cury = new Candidato2026();
        cury.setNumeroCandidato(70);
        cury.setNomeCandidato("Cury");
        cury.setTotalVotosCandidatos(0);

        System.out.println(lula.getNumeroCandidato() + " - " + lula.getNomeCandidato()
            + ": " + lula.getTotalVotosCandidato() + " votos");
        System.out.println(renan.getNumeroCandidato() + " - " + renan.getNomeCandidato()
            + ": " + renan.getTotalVotosCandidato() + " votos");
        System.out.println(flavio.getNumeroCandidato() + " - " + flavio.getNomeCandidato()
            + ": " + flavio.getTotalVotosCandidato() + " votos");
        System.out.println(cury.getNumeroCandidato() + " - " + cury.getNomeCandidato()
            + ": " + cury.getTotalVotosCandidato() + " votos");
    }
}