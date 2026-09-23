/*
 *
 * Crie uma classe chamada Livro para representar um livro de uma biblioteca.
 *
 * A classe deve ter os seguintes atributos (todos private):
 *   - titulo (String)
 *   - autor (String)
 *   - numeroPaginas (int)
 *   - paginaAtual (int) -> em qual página o leitor parou
 *
 * A classe deve ter:
 *   - Um construtor que recebe titulo, autor e numeroPaginas, e inicializa
 *     paginaAtual com 0.
 * 
 *   - Getters e setters para todos os atributos.
 * 
 *   - Um método lerPaginas(int quantidade) que soma "quantidade" à
 *     paginaAtual, sem deixar ultrapassar numeroPaginas (se ultrapassar,
 *     paginaAtual deve ficar igual a numeroPaginas).
 * 
 *   - Um método boolean livroTerminado() que retorna true se paginaAtual
 *     for igual a numeroPaginas.
 *
 * No main, crie um Livro, simule a leitura de algumas páginas em partes
 * (chamando lerPaginas mais de uma vez) e imprima o progresso e se o livro
 * já foi terminado.
 */

public class Livro 
{

    private String titulo_livro;
    private String nome_autor;
    private int total_paginas;
    private int pagina_atual;

    public Livro(String titulo_livro, String nome_autor, int total_paginas)
    {
        this.titulo_livro = titulo_livro;
        this.nome_autor = nome_autor;
        this.total_paginas = total_paginas;
        this.pagina_atual = 0;
    }

    public String getTituloLivro()
    {
        return titulo_livro;
    }

    public void setTituloLivro(String titulo_livro)
    {
        this.titulo_livro = titulo_livro;
    }

    public String getNomeAutor()
    {
        return nome_autor;
    }

    public void setNomeAutor(String nome_autor)
    {
        this.nome_autor = nome_autor;
    }

    public int getTotalPaginas()
    {
        return total_paginas;
    }

    public void setTotalPaginas(int total_paginas)
    {
        this.total_paginas = total_paginas;
    }

    public int getPaginaAtual()
    {
        return pagina_atual;
    }

    public void setPaginaAtual(int pagina_atual)
    {
        this.pagina_atual = pagina_atual;
    }

    public void lerPaginas(int quantidade)
    {
        pagina_atual += quantidade;

        if (pagina_atual > total_paginas)
        {
            pagina_atual = total_paginas;
        }
    }

    public boolean livroTerminado()
    {
        return pagina_atual == total_paginas;
    }

    public static void main(String[] args) 
    {
        Livro livro = new Livro("Dom Casmurro", "Machado de Assis", 250);

        int[] leituras = {100, 90, 100};

        for (int quantidade : leituras)
        {
            livro.lerPaginas(quantidade);
            System.out.println("Lendo " + quantidade + " páginas de \"" 
            + livro.getTituloLivro() + "\": "
            + livro.getPaginaAtual() + "/" + livro.getTotalPaginas());
            System.out.println("Livro terminado? " + livro.livroTerminado());
        }
    }
}