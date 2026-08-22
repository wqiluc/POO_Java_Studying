<h1 align="center">
  1ª Lista de Exercícios · Exercício 2
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg"
       width="32"
       style="vertical-align: middle;">
</h1>

<h3 align="center">Construtores 🏗️</h3>

<p align="center">
    <img src="https://img.shields.io/badge/-Java-111827?style=for-the-badge&logo=openjdk&logoColor=E76F00" height="28"/>
    <img src="https://img.shields.io/badge/Lista-1-6f42c1?style=for-the-badge" alt="Lista"/>
    <img src="https://img.shields.io/badge/Tema-Construtores-blue?style=for-the-badge" alt="Tema"/>
    <img src="https://img.shields.io/badge/N%C3%ADvel-Fundamentos-orange?style=for-the-badge" alt="Nível"/>
    <img src="https://img.shields.io/badge/Status-Conclu%C3%ADdo-brightgreen?style=for-the-badge" alt="Status"/>
</p>

> Resposta teórica da [1ª Lista de Exercícios de POO](../pdf/1ª%20Lista%20de%20Exercícios_POO.pdf): o que é um construtor, por que ele existe e quais regras o Java impõe sobre ele. Continuação direta do [Exercício 1](1-DiferencaClassesObjetos.md) — construtor é o que garante que um **objeto** nasça num estado válido assim que é instanciado a partir de uma **classe**.

<h2 align="left">🧭 Sumário: </h2>

1. [O que são](#1-o-que-sao)
2. [Papel na orientação a objetos](#2-papel)
3. [Regras em Java](#3-regras)
4. [Exemplo](#4-exemplo)
5. [Na prática: os exercícios em código](#5-pratica)

<h2 align="left" id="1-o-que-sao">🔧 1. O que são?</h2>

Um construtor é um método especial de uma classe, executado automaticamente
no momento em que um objeto é criado (com `new`), cuja responsabilidade é
inicializar o estado (os atributos) daquele objeto.

<h2 align="left" id="2-papel">🎯 2. Papel na orientação a objetos</h2>

Garantem que todo objeto nasça em um estado válido e consistente, sem
depender do programador lembrar de chamar métodos de inicialização
separadamente logo após o `new`. É o construtor que recebe os dados
necessários (via parâmetros) e os atribui aos atributos da instância.

<h2 align="left" id="3-regras">📜 3. Regras em Java</h2>

| Regra | Detalhe |
|---|---|
| **Nome** | Idêntico ao nome da classe |
| **Retorno** | Não declara tipo de retorno — nem mesmo `void` |
| **Sobrecarga** | Uma classe pode ter vários construtores, desde que as assinaturas sejam diferentes (número e/ou tipo de parâmetros) |
| **Construtor padrão** | Se nenhum construtor for declarado, o compilador gera um sem parâmetros, com valores padrão (`0`, `false`, `null`) |
| **Perda do padrão** | Se qualquer construtor for declarado explicitamente, o padrão deixa de ser gerado — se ainda for necessário um sem parâmetros, ele precisa ser escrito manualmente |
| **Conflito de nomes** | Quando o parâmetro tem o mesmo nome do atributo, usa-se `this` para diferenciá-los (`this.atributo = atributo`) |

<h2 align="left" id="4-exemplo">💻 4. Exemplo</h2>

```java
public class Produto
{
    private int codigo;
    private String nome;

    public Produto(int codigo, String nome)
    {
        this.codigo = codigo; // this.codigo = atributo da instância
        this.nome = nome;     // nome (sem this) = parâmetro do construtor
    }
}
```

<h2 align="left" id="5-pratica">🚀 5. Na prática: os exercícios em código</h2>

Todos os exercícios de classe da lista aplicam essa regra: recebem os dados
pelo construtor e já entregam o objeto pronto para uso, sem *setters*
soltos logo após o `new`. Vale conferir como isso aparece combinado com
encapsulamento (atributos `private` + *getters*/*setters*) em
[`5-Pedido`](../java/5-Pedido/Pedido.java),
[`6-Veiculo`](../java/6-Veiculo/Veiculo.java) e
[`7-Candidato`](../java/7-Candidato/Candidato.java) — e o caso particular de
um construtor **privado**, usado para impedir instanciação, em
[`4-CalculadoraMatematica`](../java/4-CalculadoraMatematica/CalculadoraMatematica.java).
