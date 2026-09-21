<h1 align="center">
  1ª Lista de Exercícios · Exercício 3
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg"
       width="32"
       style="vertical-align: middle;">
</h1>

<h3 align="center">Princípio da Abstração 🎭</h3>

<p align="center">
    <img src="https://img.shields.io/badge/-Java-111827?style=for-the-badge&logo=openjdk&logoColor=E76F00" height="28"/>
    <img src="https://img.shields.io/badge/Lista-1-6f42c1?style=for-the-badge" alt="Lista"/>
    <img src="https://img.shields.io/badge/Tema-Abstra%C3%A7%C3%A3o-blue?style=for-the-badge" alt="Tema"/>
    <img src="https://img.shields.io/badge/N%C3%ADvel-Fundamentos-orange?style=for-the-badge" alt="Nível"/>
    <img src="https://img.shields.io/badge/Status-Conclu%C3%ADdo-brightgreen?style=for-the-badge" alt="Status"/>
</p>

> Resposta teórica da [1ª Lista de Exercícios de POO](../pdf/1ª%20Lista%20de%20Exercícios_POO.pdf): o que é o princípio da abstração e como ele guia a decisão de "o que vira atributo/método numa classe". Fecha o trio conceitual iniciado em [Classes e Objetos](1-DiferencaClassesObjetos.md) e [Construtores](2-Construtores.md).

<h2 align="left">🧭 Sumário: </h2>

1. [O que é abstração](#1-o-que-e)
2. [Como ela guia o design de uma classe](#2-como-guia)
3. [Exemplo: a classe Pedido](#3-exemplo)
4. [Relevante vs. irrelevante — comparação](#4-comparacao)
5. [Relação com os outros exercícios](#5-relacao)

<h2 align="left" id="1-o-que-e">🎭 1. O que é abstração</h2>

Abstração é a capacidade de representar uma entidade do mundo real (ou um
conceito) mantendo apenas as características e comportamentos relevantes
para o problema que está sendo resolvido, e descartando todos os detalhes
irrelevantes para aquele contexto.

<h2 align="left" id="2-como-guia">🧠 2. Como ela guia o design de uma classe</h2>

Ao modelar uma classe, o programador decide *o que importa* representar:
quais atributos (estado) e quais métodos (comportamento) fazem sentido para
o domínio do software, ignorando qualquer informação do mundo real que não
tenha utilidade ali.

<h2 align="left" id="3-exemplo">💻 3. Exemplo: a classe Pedido</h2>

Num sistema de vendas, a classe `Pedido` abstrai apenas o que é relevante
para controlar um pedido:

```java
class Pedido
{
    int numeroPedido;
    String nomeCliente;
    double valorTotal;
}
```

Não importa, por exemplo, a cor da caneta que o cliente usou para assinar o
pedido, ou o humor dele naquele dia — são detalhes reais, mas irrelevantes
para o software.

<h2 align="left" id="4-comparacao">⚖️ 4. Relevante vs. irrelevante — comparação</h2>

| Detalhe do mundo real | Vira atributo da classe? | Por quê |
|---|---|---|
| Número do pedido | ✅ Sim | Identifica o pedido no sistema |
| Nome do cliente | ✅ Sim | Necessário para vincular o pedido a alguém |
| Valor total | ✅ Sim | É a informação que o software precisa controlar |
| Cor da caneta usada na assinatura | ❌ Não | Não tem nenhuma utilidade para o problema |
| Humor do cliente no dia da compra | ❌ Não | Irrelevante para controlar pedidos |

A classe é exatamente essa abstração: um "recorte" simplificado da
realidade, contendo só o que o sistema precisa para funcionar.

<h2 align="left" id="5-relacao">🔗 5. Relação com os outros exercícios</h2>

A abstração é o que permite lidar com sistemas complexos: em vez de pensar
em todos os detalhes possíveis de um "carro", o programador pensa apenas
nos atributos e métodos que o problema exige (placa, modelo, dono, valor de
mercado), tratando o restante como irrelevante para aquele nível de
abstração — como na classe [`Veiculo`](../java/6-Veiculo/Veiculo.java) do
Exercício 6. É a mesma lógica de recorte que define, em cada exercício em
código, quais dados viram atributos `private` inicializados pelo
[construtor](2-Construtores.md) de cada [classe/objeto](1-DiferencaClassesObjetos.md).
