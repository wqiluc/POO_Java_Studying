/*
 * Exercício 2 (2ª Lista)
 * Classe Retangulo com encapsulamento: métodos para calcular área e
 * perímetro, e um toString() com todas as informações (lados, área e
 * perímetro). Crie um main que instancie retângulos e imprima suas infos.
 */

public class Retangulo
{
    private static final int LADOS_RETANGULO = 4;

    private int base_retangulo;
    private int altura_retangulo;
    private int area_retangulo;
    private int perimetro_retangulo;

    public Retangulo(int base_retangulo, int altura_retangulo)
    {
        this.base_retangulo = base_retangulo;
        this.altura_retangulo = altura_retangulo;
        this.area_retangulo = this.base_retangulo * this.altura_retangulo;
        this.perimetro_retangulo = (this.base_retangulo + this.altura_retangulo) * 2;
    }

    public int getBaseRetangulo()
    {
        return base_retangulo;
    }

    public void setBaseRetangulo(int base_retangulo)
    {
        this.base_retangulo = base_retangulo;
        calcularArea();
        calcularPerimetro();
    }

    public int getAlturaRetangulo()
    {
        return altura_retangulo;
    }

    public void setAlturaRetangulo(int altura_retangulo)
    {
        this.altura_retangulo = altura_retangulo;
        calcularArea();
        calcularPerimetro();
    }

    public int getAreaRetangulo()
    {
        return area_retangulo;
    }

    public int getPerimetroRetangulo()
    {
        return perimetro_retangulo;
    }

    public void calcularArea()
    {
        this.area_retangulo = this.base_retangulo * this.altura_retangulo;
    }

    public void calcularPerimetro()
    {
        this.perimetro_retangulo = 2 * (this.base_retangulo + this.altura_retangulo);
    }

    @Override // método de sobreescrever
    public String toString()
    {
        return "Retângulo [lados: " + LADOS_RETANGULO
            + ", base: " + base_retangulo
            + ", altura: " + altura_retangulo
            + ", área: " + area_retangulo
            + ", perímetro: " + perimetro_retangulo + "]";
    }

    public static void main(String[] args)
    {
        Retangulo retangulo1 = new Retangulo(5, 3);
        Retangulo retangulo2 = new Retangulo(10, 4);

        System.out.println(retangulo1);
        System.out.println(retangulo2);

        retangulo1.setBaseRetangulo(8);
        System.out.println("Após alterar a base do retângulo 1 para 8:");
        System.out.println(retangulo1);
        System.out.println("Área: " + retangulo1.getAreaRetangulo()
            + " | Perímetro: " + retangulo1.getPerimetroRetangulo());
    }
}