/*
 * Exercício 6 (3ª Lista)
 * Classe genérica Par<K, V>: atributos privados chave (K) e valor (V),
 * construtor, getters e @Override public String toString() retornando
 * "(chave, valor)".
 */

public class Par<K, V>
{
    private K chave;
    private V valor;

    public Par(K chave, V valor)
    {
        this.chave = chave;
        this.valor = valor;
    }

    public K getChave()
    {
        return chave;
    }

    public V getValor()
    {
        return valor;
    }

    @Override // método de sobreescrever
    public String toString()
    {
        return "(" + chave + ", " + valor + ")";
    }
}