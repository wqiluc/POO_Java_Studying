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
    private String numero_conta;
    private String titular_conta;
    private double saldo_conta;

    public ContaBancaria(String numero_conta, String titular_conta) 
    {
        this.numero_conta = numero_conta;
        this.titular_conta = titular_conta;
        this.saldo_conta = 0.0;
    }

    public String getNumeroConta() 
    {
        return numero_conta;
    }

    public String getTitularConta() 
    {
        return titular_conta;
    }

    public void setTitularConta(String titular_conta) 
    {
        this.titular_conta = titular_conta;
    }

    public double getSaldoConta() 
    {
        return saldo_conta;
    }

    public void depositarSaldo(double valor) 
    {
        if (valor > 0) 
        {
            saldo_conta += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        } 
        else 
        {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public boolean sacarSaldo(double valor) 
    {
        if (valor > 0 && valor <= saldo_conta) 
        {
            saldo_conta -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
            return true;
        } 
        else 
        {
            System.out.println("Saque inválido. Verifique o valor e o saldo disponível.");
            return false;
        }
    }

    public boolean transferirSaldo(ContaBancaria destino, double valor) 
    {
        if (this.sacarSaldo(valor)) 
        {
            destino.depositarSaldo(valor);
            System.out.println("Transferência de R$" + valor + " para a conta " + destino.getNumeroConta() + " realizada com sucesso.");
            return true;
        } 
        else 
        {
            System.out.println("Transferência inválida. Verifique o valor e o saldo disponível.");
            return false;
        }
    }

    @Override
    public String toString() 
    {
        return "ContaBancaria{" +
                "numero_conta='" + numero_conta + '\'' +
                ", titular_conta='" + titular_conta + '\'' +
                ", saldo_conta=" + saldo_conta +
                '}';
    }


    public static void main(String[] args) 
    {
        ContaBancaria conta1 = new ContaBancaria("12345", "Alice");
        ContaBancaria conta2 = new ContaBancaria("67890", "Bob");

        // Depósito
        conta1.depositarSaldo(1000);
        conta2.depositarSaldo(500);

        // Tentativa de saque inválido
        conta1.sacarSaldo(1500); // Saldo insuficiente

        // Transferência
        conta1.transferirSaldo(conta2, 300);

        // Mostrar saldos
        System.out.println(conta1);
        System.out.println(conta2);   
    }
}