<h1 align="center">Resolução — Exercícios de POO (IA) <br>
<img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" title="Java" alt="Java" width="40" height="40"/>&nbsp; </h1>

> Os enunciados completos estão comentados em cada arquivo da pasta `java/`.
> Quando um exercício tem mais de uma classe, elas estão no mesmo arquivo (só a principal é `public`).

| # | Exercício | Tema |
|---|-----------|------|
| 1 | [Carro](../java/1-Carro/Carro.java) | Classes, atributos e métodos (básico) |
| 2 | [Usuario](../java/2-Usuario/Usuario.java) | Encapsulamento com getters e setters (validação) |
| 3 | [ContaBancaria](../java/3-ContaBancaria/ContaBancaria.java) | Encapsulamento: atributo somente leitura |
| 4 | [Produto](../java/4-Produto/Produto.java) | Sobrecarga de construtores com this(...) |
| 5 | [Ingresso](../java/5-Ingresso/Ingresso.java) | Sobrecarga de métodos + atributo static |
| 6 | [Funcionario](../java/6-Funcionario/Funcionario.java) | Herança + @Override + super |

> Perguntas teóricas dos slides: [PERGUNTAS_Slides.md](PERGUNTAS_Slides.md)

---

## 1. Carro — Classes, atributos e métodos (básico)

```java
public class Carro
{
    String marca;
    String modelo;
    int ano;
    double velocidade_atual;

    void acelerar(double valor)
    {
        velocidade_atual += valor;
        if (velocidade_atual > 200)
        {
            velocidade_atual = 200;
        }
    }

    void frear(double valor)
    {
        velocidade_atual -= valor;
        if (velocidade_atual < 0)
        {
            velocidade_atual = 0;
        }
    }

    void exibirStatus()
    {
        System.out.println(marca + " " + modelo + " (" + ano + ") a " + velocidade_atual + " km/h");
    }

    public static void main(String[] args)
    {
        Carro c1 = new Carro();
        c1.marca = "Fiat";
        c1.modelo = "Uno";
        c1.ano = 2012;

        Carro c2 = new Carro();
        c2.marca = "Toyota";
        c2.modelo = "Corolla";
        c2.ano = 2023;

        c1.acelerar(80);
        c1.frear(30);
        c1.exibirStatus(); // 50.0 km/h

        c2.acelerar(250);
        c2.exibirStatus(); // 200.0 km/h (limite)
        c2.frear(300);
        c2.exibirStatus(); // 0.0 km/h (não fica negativo)
    }
}
```

---

## 2. Usuario — Encapsulamento com getters e setters (validação)

```java
public class Usuario
{
    private String nome;
    private String email;
    private String senha;
    private int idade;

    public Usuario(String nome, String email, String senha, int idade)
    {
        setNome(nome);
        setEmail(email);
        setSenha(senha);
        setIdade(idade);
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        if (nome == null || nome.isBlank())
        {
            System.out.println("Nome inválido!");
            return;
        }
        this.nome = nome;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        if (email == null || !email.contains("@"))
        {
            System.out.println("E-mail inválido!");
            return;
        }
        this.email = email;
    }

    // Sem getSenha(): a senha nunca deve sair do objeto
    public void setSenha(String senha)
    {
        if (senha == null || senha.length() < 8)
        {
            System.out.println("Senha deve ter no mínimo 8 caracteres!");
            return;
        }
        this.senha = senha;
    }

    public boolean autenticar(String senha_digitada)
    {
        return this.senha != null && this.senha.equals(senha_digitada);
    }

    public int getIdade()
    {
        return idade;
    }

    public void setIdade(int idade)
    {
        if (idade < 0 || idade > 130)
        {
            System.out.println("Idade inválida!");
            return;
        }
        this.idade = idade;
    }

    public static void main(String[] args)
    {
        Usuario u = new Usuario("Lucas", "lucas@email.com", "senhaForte123", 20);

        u.setEmail("emailsemarroba");   // E-mail inválido!
        u.setSenha("123");              // Senha deve ter no mínimo 8 caracteres!
        u.setIdade(-5);                 // Idade inválida!

        System.out.println(u.getNome() + " - " + u.getEmail() + " - " + u.getIdade());
        System.out.println("Login com senha certa: " + u.autenticar("senhaForte123")); // true
        System.out.println("Login com senha errada: " + u.autenticar("123"));          // false
    }
}
```

---

## 3. ContaBancaria — Encapsulamento: atributo somente leitura

```java
public class ContaBancaria
{
    private String numero_conta;
    private String titular;
    private double saldo;

    public ContaBancaria(String numero_conta, String titular)
    {
        this.numero_conta = numero_conta;
        this.titular = titular;
        this.saldo = 0;
    }

    public String getNumeroConta()
    {
        return numero_conta;
    }

    public String getTitular()
    {
        return titular;
    }

    public void setTitular(String titular)
    {
        this.titular = titular;
    }

    // Só getter: o saldo muda apenas por depositar/sacar/transferir.
    // Um setSaldo() deixaria qualquer parte do código "criar" ou "sumir" com dinheiro
    // sem passar pelas regras (valor positivo, saldo suficiente), quebrando o encapsulamento.
    public double getSaldo()
    {
        return saldo;
    }

    public void depositar(double valor)
    {
        if (valor <= 0)
        {
            System.out.println("Valor de depósito inválido!");
            return;
        }
        saldo += valor;
    }

    public boolean sacar(double valor)
    {
        if (valor <= 0 || valor > saldo)
        {
            System.out.println("Saque não permitido!");
            return false;
        }
        saldo -= valor;
        return true;
    }

    public boolean transferir(ContaBancaria destino, double valor)
    {
        if (sacar(valor))
        {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        ContaBancaria c1 = new ContaBancaria("0001-1", "Ana");
        ContaBancaria c2 = new ContaBancaria("0002-2", "Bruno");

        c1.depositar(500);
        c1.depositar(-50);          // Valor de depósito inválido!
        c1.sacar(1000);             // Saque não permitido!
        c1.transferir(c2, 200);

        System.out.println(c1.getTitular() + ": R$ " + c1.getSaldo()); // 300.0
        System.out.println(c2.getTitular() + ": R$ " + c2.getSaldo()); // 200.0
    }
}
```

---

## 4. Produto — Sobrecarga de construtores com this(...)

```java
public class Produto
{
    private String codigo;
    private String nome;
    private double preco;
    private int quantidade_estoque;

    // Construtor completo
    public Produto(String codigo, String nome, double preco, int quantidade_estoque)
    {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade_estoque = quantidade_estoque;
    }

    // Sem estoque: produto recém-cadastrado
    public Produto(String codigo, String nome, double preco)
    {
        this(codigo, nome, preco, 0);
    }

    // Só código e nome: preço ainda não definido
    public Produto(String codigo, String nome)
    {
        this(codigo, nome, 0.0);
    }

    public String getCodigo()
    {
        return codigo;
    }

    public String getNome()
    {
        return nome;
    }

    public double getPreco()
    {
        return preco;
    }

    public void setPreco(double preco)
    {
        if (preco < 0)
        {
            System.out.println("Preço não pode ser negativo!");
            return;
        }
        this.preco = preco;
    }

    public int getQuantidadeEstoque()
    {
        return quantidade_estoque;
    }

    public void repor(int quantidade)
    {
        if (quantidade > 0)
        {
            quantidade_estoque += quantidade;
        }
    }

    public void exibir()
    {
        System.out.println("[" + codigo + "] " + nome + " | R$ " + preco + " | estoque: " + quantidade_estoque);
    }

    public static void main(String[] args)
    {
        Produto p1 = new Produto("A1", "Mouse", 89.90, 15);
        Produto p2 = new Produto("A2", "Teclado", 150.0);
        Produto p3 = new Produto("A3", "Monitor");

        p3.setPreco(999.0);
        p3.repor(5);

        p1.exibir();
        p2.exibir();
        p3.exibir();
    }
}
```

---

## 5. Ingresso — Sobrecarga de métodos + atributo static

```java
public class Ingresso
{
    private static int total_vendidos = 0;

    private String evento;
    private double valor_base;

    public Ingresso(String evento, double valor_base)
    {
        this.evento = evento;
        this.valor_base = valor_base;
        total_vendidos++;
    }

    public String getEvento()
    {
        return evento;
    }

    public double getValorBase()
    {
        return valor_base;
    }

    public static int getTotalVendidos()
    {
        return total_vendidos;
    }

    // Sobrecarga de métodos: mesmo nome, parâmetros diferentes
    public double calcularPreco()
    {
        return valor_base;
    }

    public double calcularPreco(boolean meia_entrada)
    {
        if (meia_entrada)
        {
            return valor_base / 2;
        }
        return valor_base;
    }

    public double calcularPreco(boolean meia_entrada, String cupom)
    {
        double preco = calcularPreco(meia_entrada);
        if ("DESC10".equals(cupom))
        {
            preco *= 0.9;
        }
        return preco;
    }

    public double calcularPreco(int quantidade)
    {
        return valor_base * quantidade;
    }

    public static void main(String[] args)
    {
        Ingresso show = new Ingresso("Show de Rock", 200.0);
        Ingresso cinema = new Ingresso("Cinema", 40.0);

        System.out.println(show.calcularPreco());                 // 200.0
        System.out.println(show.calcularPreco(true));             // 100.0
        System.out.println(show.calcularPreco(true, "DESC10"));   // 90.0
        System.out.println(cinema.calcularPreco(3));              // 120.0

        System.out.println("Ingressos vendidos: " + Ingresso.getTotalVendidos()); // 2
    }
}
```

---

## 6. Funcionario — Herança + @Override + super

```java
public class Funcionario
{
    private String nome;
    private String matricula;
    protected double salario_base;

    public Funcionario(String nome, String matricula, double salario_base)
    {
        this.nome = nome;
        this.matricula = matricula;
        this.salario_base = salario_base;
    }

    public String getNome()
    {
        return nome;
    }

    public String getMatricula()
    {
        return matricula;
    }

    public double getSalarioBase()
    {
        return salario_base;
    }

    public double calcularSalario()
    {
        return salario_base;
    }

    public static void main(String[] args)
    {
        Funcionario f = new Funcionario("Carlos", "F001", 3000);
        Gerente g = new Gerente("Marina", "G001", 3000, 1500);

        System.out.println(f.getNome() + ": R$ " + f.calcularSalario()); // 3000.0
        System.out.println(g.getNome() + ": R$ " + g.calcularSalario()); // 4500.0
    }
}

class Gerente extends Funcionario
{
    private double bonus;

    public Gerente(String nome, String matricula, double salario_base, double bonus)
    {
        super(nome, matricula, salario_base);
        this.bonus = bonus;
    }

    public double getBonus()
    {
        return bonus;
    }

    public void setBonus(double bonus)
    {
        this.bonus = bonus;
    }

    // Se escrevêssemos @Override em calcularSalarioo(), o código NÃO compila:
    // "method does not override or implement a method from a supertype".
    // Sem o @Override, compilaria como um método novo e o bug passaria despercebido.
    @Override
    public double calcularSalario()
    {
        return super.calcularSalario() + bonus;
    }
}
```
