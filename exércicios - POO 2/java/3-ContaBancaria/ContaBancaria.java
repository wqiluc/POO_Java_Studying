/*
 * Exercício 3 — Encapsulamento: atributo somente leitura
 *
 * Um banco digital precisa de uma classe ContaBancaria.
 * Atributos privados: numero_conta, titular e saldo.
 *
 * - O construtor recebe numero_conta e titular; o saldo começa em 0.✅
 * - numero_conta só tem getter (não muda nunca).✅
 * - titular tem getter e setter.✅
 * - saldo só tem getter: ✅
 *     NÃO pode existir setSaldo(). ✅
 *     O saldo só muda por:
 *      - depositar(double valor): valor deve ser > 0;
 *      - boolean sacar(double valor): valor > 0 e não pode passar do saldo;
 *      - boolean transferir(ContaBancaria destino, double valor): usa sacar e depositar.
 *
 * No main, crie 2 contas, deposite, tente um saque inválido, faça uma
 * transferência e mostre os saldos. Explique em um comentário por que não
 * faz sentido existir setSaldo().
 */


public class ContaBancaria 
{
    private int numero_conta;
    private String titular_conta;
    private double saldo_conta;

    public ContaBancaria(int numero_conta, String titular_conta)
    {
        this.numero_conta = numero_conta;
        this.titular_conta = titular_conta;
        this.saldo_conta = 0;
    }

    public int getNumeroConta()
    {
        return numero_conta;
    }

    public String getTituloConta()
    {
        return titular_conta;
    }

    public void setTituloConta(String titular_conta)
    {
        this.titular_conta = titular_conta;
    }


    public double getSaldoConta()
    {
        return saldo_conta;
    }

    public void depositarSaldo(double valor)
    {
        if(valor <= 0)
        {
            System.err.println("Impossível depositar um valor Nulo ou negativo! ");
            return;
        }

        saldo_conta+=valor;
    }

    public boolean sacarSaldo(double valor)
    {
        if(valor <= 0 || valor > saldo_conta)
        {
            System.err.println("Impossível sacar um valor Inexistente na conta ");
            return false;
        }

        saldo_conta-=valor;
        return true;
    }


    public boolean transferir(ContaBancaria destino, double valor)
    {
        if(sacarSaldo(valor))
        {
            destino.depositarSaldo(valor);
            return true;
        }
        return false;
    }

    @Override
    public String toString()
    {
        return "Conta " + numero_conta + " | Titular: " + titular_conta + " | Saldo: R$ " + saldo_conta;
    }

    public static void main(String[] args) 
    {
        ContaBancaria c1 = new ContaBancaria(1, "Lucas");
        ContaBancaria c2 = new ContaBancaria(2, "Maria");

        c1.depositarSaldo(500);
        c2.depositarSaldo(200);

        c1.sacarSaldo(1000); // saque inválido

        c1.transferir(c2, 150);

        System.out.println(c1);
        System.out.println(c2);
    }
}
