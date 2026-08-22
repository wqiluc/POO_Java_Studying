<h1 align="center">
  1ª Lista de Exercícios · Exercício 1
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg"
       width="32"
       style="vertical-align: middle;">
</h1>

<h3 align="center">Diferença entre Classes e Objetos 🧩</h3>

<p align="center">
    <img src="https://img.shields.io/badge/-Java-111827?style=for-the-badge&logo=openjdk&logoColor=E76F00" height="28"/>
    <img src="https://img.shields.io/badge/Lista-1-6f42c1?style=for-the-badge" alt="Lista"/>
    <img src="https://img.shields.io/badge/Tema-Classes%20%26%20Objetos-blue?style=for-the-badge" alt="Tema"/>
    <img src="https://img.shields.io/badge/N%C3%ADvel-Fundamentos-orange?style=for-the-badge" alt="Nível"/>
    <img src="https://img.shields.io/badge/Status-Conclu%C3%ADdo-brightgreen?style=for-the-badge" alt="Status"/>
</p>

> Resposta teórica da [1ª Lista de Exercícios de POO](../pdf/1ª%20Lista%20de%20Exercícios_POO.pdf): o que diferencia uma **classe** de um **objeto**, com um exemplo em `Cliente`. Base conceitual para todos os exercícios seguintes ([2](2-Construtores.md), [3](3-PrincipioDaAbstracao.md) e os exercícios em código [4 a 7](../java/)).

<h2 align="left">🧭 Sumário: </h2>

1. [O que é uma classe](#1-classe)
2. [O que é um objeto](#2-objeto)
3. [Classe vs. Objeto — comparação direta](#3-comparacao)
4. [Exemplo em Java](#4-exemplo)
5. [Analogia com structs](#5-analogia)

<h2 align="left" id="1-classe">🏗️ 1. O que é uma classe</h2>

Uma **classe** é o molde (ou "fábrica") que define, de forma abstrata, quais
atributos (dados) e métodos (comportamentos) um determinado tipo de entidade
vai ter. Ela não existe fisicamente em memória durante a execução do
programa — é apenas uma definição de tipo, escrita uma única vez no código.

<h2 align="left" id="2-objeto">📦 2. O que é um objeto</h2>

Um **objeto** é uma instância concreta de uma classe, criada em tempo de
execução com o operador `new`. Cada objeto ocupa memória própria e guarda
valores específicos para os atributos definidos pela classe — dois objetos
da mesma classe podem ter estados completamente diferentes entre si.

<h2 align="left" id="3-comparacao">⚖️ 3. Classe vs. Objeto — comparação direta</h2>

| | Classe | Objeto |
|---|---|---|
| **O que é** | Definição/molde do tipo | Instância concreta do tipo |
| **Quando existe** | Em tempo de compilação (código-fonte) | Em tempo de execução, após o `new` |
| **Ocupa memória própria?** | Não | Sim |
| **Quantidade** | Uma só, escrita no código | Quantas forem instanciadas com `new` |
| **Estado (valores dos atributos)** | Não tem — só declara quais existem | Tem valores próprios, independentes de outros objetos |

<h2 align="left" id="4-exemplo">💻 4. Exemplo em Java</h2>

```java
class Cliente
{
    int id;
    String nome;
    double renda;
}
```

`Cliente` é a **classe**. Se eu executar:

```java
Cliente c1 = new Cliente(); // objeto 1: id=1, nome="Marcus", renda=2000.00
Cliente c2 = new Cliente(); // objeto 2: id=2, nome="Carla",  renda=3201.22
```

`c1` e `c2` são dois **objetos** diferentes, ambos criados a partir da mesma
**classe** `Cliente`, mas com valores de atributos independentes um do
outro.

<h2 align="left" id="5-analogia">🔗 5. Analogia com structs</h2>

É a mesma relação que existe entre um tipo estruturado (`struct`) e um
registro (variável daquele tipo) em C — só que em POO a classe também
carrega comportamento (métodos), não apenas dados. Essa distinção entre
"o que o tipo pode ter" (classe) e "quais valores ele tem agora" (objeto) é
a base para entender os próximos temas: como inicializar esse estado de
forma correta ([Exercício 2 — Construtores](2-Construtores.md)) e como
decidir o que faz parte do molde ([Exercício 3 — Princípio da
Abstração](3-PrincipioDaAbstracao.md)).
