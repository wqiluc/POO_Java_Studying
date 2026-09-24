/*
 * Exercício 4 (3ª Lista)
 * Classe genérica Caixa<T>: atributo privado conteudo (T); métodos
 * guardar(T conteudo), T retirar() e boolean estaVazia().
 */

public class Caixa<T>
{
    private T conteudo;

    public void guardar(T conteudo)
    {
        this.conteudo = conteudo;
    }

    public T retirar()
    {
        // devolve o conteúdo (ou null se estiver vazia) e esvazia a caixa
        T retirado = this.conteudo;
        this.conteudo = null;
        return retirado;
    }

    public boolean estaVazia()
    {
        return this.conteudo == null;
    }
}