/*
 * Exercício 6 — Herança + @Override + super
 *
 * Uma empresa tem funcionários comuns e gerentes.
 *
 * Crie a classe Funcionario (nome, matricula, salario_base) com getters e o
 * método calcularSalario(), que retorna o salário base.
 *
 * Crie a classe Gerente que HERDA de Funcionario e tem um atributo bonus.
 * - O construtor do Gerente deve chamar super(...).
 * - Sobrescreva calcularSalario() com @Override: salário base + bônus,
 *   reaproveitando super.calcularSalario().
 *
 * Dica: as duas classes podem ficar neste arquivo (só uma pode ser public).
 *
 * No main, crie um Funcionario e um Gerente e imprima o salário de cada um.
 * Pergunta (responda em comentário): o que acontece se você escrever
 * @Override em um método com o nome errado, tipo calcularSalarioo()?
 */

public class Funcionario 
{
    private String nome_funcionario;
    private int matricula_funcionario;
    private double salario_base_funcionario;

    public Funcionario(String nome_funcionario, 
    int matricula_funcionario, double salario_base_funcionario)
    {
        this.nome_funcionario = nome_funcionario;
        this.matricula_funcionario = matricula_funcionario;
        this.salario_base_funcionario = salario_base_funcionario;
    }

    public String getNomeFuncionario()
    {
        return nome_funcionario;
    }

    public void setNomeFuncionario(String nome_funcionario)
    {
        this.nome_funcionario = nome_funcionario;
    }

    public int getMatriculaFuncionario()
    {
        return matricula_funcionario;
    }

    public void setMatriculaFuncionario(int matricula_funcionario)
    {
        this.matricula_funcionario = matricula_funcionario;
    }

    public double getSalarioBaseFuncionario()
    {
        return salario_base_funcionario;
    }

    public void setSalarioBaseFuncionario(double salario_base_funcionario)
    {
        this.salario_base_funcionario = salario_base_funcionario;
    }

    public double calcularSalario()
    {
        return salario_base_funcionario;
    }

    @Override
    public String toString()
    {
        return "( Nome Funcionário: " + nome_funcionario + " | Matrícula Funcionário: " + matricula_funcionario + " | Salário: R$" + calcularSalario() + " )";
    }

    public static void main(String[] args) 
    {
        Funcionario f = new Funcionario("Ana", 101, 3000.0);
        Gerente g = new Gerente("Carlos", 102, 5000.0, 1500.0);

        System.out.println(f);
        System.out.println("Salário de " + f.getNomeFuncionario() + ": R$" + f.calcularSalario());

        System.out.println(g);
        System.out.println("Salário de " + g.getNomeFuncionario() + ": R$" + g.calcularSalario());
    }
}

class Gerente extends Funcionario
{
    private double bonus_gerente;

    public Gerente(String nome_funcionario, 
    int matricula_funcionario,double salario_base_funcionario, 
    double bonus_gerente)
    {
        super(nome_funcionario, matricula_funcionario, salario_base_funcionario);
        this.bonus_gerente = bonus_gerente;
    }

    public double getBonusGerente()
    {
        return bonus_gerente;
    }

    public void setBonusGerente(double bonus_gerente)
    {
        this.bonus_gerente = bonus_gerente;
    }

    @Override
    public double calcularSalario()
    {
        return super.calcularSalario() + bonus_gerente;
    }
}