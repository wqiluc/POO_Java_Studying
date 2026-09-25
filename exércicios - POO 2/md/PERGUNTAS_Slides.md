<h1 align="center">Perguntas Teóricas — Slides de POO <br>
<img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" title="Java" alt="Java" width="40" height="40"/>&nbsp; </h1>

> Baseadas nos slides do prof. Maurício Braga (pasta `pdf/`). Tente responder antes de abrir a resposta.

### Introdução ao Java

**1. Por que usar Java? Cite algumas características da linguagem.**
<details><summary>Resposta</summary>

Fortemente tipada, orientada a objetos, alocação dinâmica de memória, desalocação automática (garbage collector), não gera executável nativo e sim bytecode interpretado pela JVM, é multiplataforma ("write once, run anywhere") e tem milhões de recursos de terceiros. Herda o "DNA" do C/C++.
</details>

**2. O que é a JVM e qual a relação dela com o "write once, run anywhere"?**
<details><summary>Resposta</summary>

É a Java Virtual Machine. O compilador gera bytecode (não código nativo), e esse bytecode roda em qualquer sistema que tenha uma JVM. Por isso o mesmo programa roda em Windows, Linux, macOS etc.
</details>

**3. Quais são as convenções de nomes do Java (JCC)?**
<details><summary>Resposta</summary>

- Classes começam com maiúscula e usam camelCase: `PessoaFisica`.
- Variáveis e métodos começam com minúscula e usam camelCase: `anoDePublicacao`.
- Constantes em MAIÚSCULAS separadas por `_`: `SALARIO_MINIMO`.
- Pacotes tudo minúsculo, sem espaço/hífen/underscore: `br.cesarschool.poo`.
- Java é case sensitive (`nome` ≠ `Nome`).
</details>

**4. Quais são os tipos primitivos do Java?**
<details><summary>Resposta</summary>

`byte`, `short`, `int`, `long`, `float`, `double`, `char` e `boolean`. Eles não são classes (`String`, por exemplo, é uma classe, não um primitivo).
</details>

**5. Qual a diferença entre conversão implícita (widening) e explícita (casting / narrowing)?**
<details><summary>Resposta</summary>

- **Implícita (alargamento):** um tipo "mais curto" vai para um "mais largo" (`int` → `long` → `float` → `double`). O Java faz sozinho, sem perda.
- **Explícita (encurtamento / casting):** do "mais largo" para o "mais curto", o programador escreve `(tipo)`. Pode perder informação, e o compilador não avisa.

```java
short s1 = 256;
byte b1 = (byte) s1; // 0  (só sobram os 8 bits de baixo)
int i1 = 255;
byte b2 = (byte) i1; // -1 (11111111 em byte é -1)
int i2 = (int) 255.12; // 255 (perde a parte decimal)
```
</details>

**6. O que é promoção aritmética?**
<details><summary>Resposta</summary>

Numa operação com tipos diferentes, o Java converte o operando "mais curto" para o tipo do "mais largo" antes de calcular. Ex.: `int a = 3; float f = 2.0F; float z = a + f;` → `a` vira `3.0F` e o resultado é `float`.
</details>

**7. O que é escopo de uma variável?**
<details><summary>Resposta</summary>

É a região onde ela existe. Cada bloco `{ }` define um escopo: uma variável declarada dentro de um bloco só pode ser usada nele e nos blocos internos a ele.
</details>

### Classes e Objetos

**8. O que é POO (Programação Orientada a Objetos)?**
<details><summary>Resposta</summary>

É um paradigma que representa o mundo real como um conjunto de **objetos que interagem entre si** para realizar operações. Objetos do mundo real viram objetos no software, e o sistema é montado a partir desses componentes.
</details>

**9. Quais são os 4 pilares da POO?**
<details><summary>Resposta</summary>

Abstração, Encapsulamento, Herança e Polimorfismo.
</details>

**10. Qual a diferença entre Classe e Objeto?**
<details><summary>Resposta</summary>

A **classe** é o molde/"fábrica" que define atributos e métodos. O **objeto** é uma instância concreta criada a partir da classe (com `new`), com seus próprios valores.
Ex.: `Pessoa` é a classe; `João` é um objeto da classe `Pessoa`. "Carro" é a classe; "meu carro" é o objeto.
</details>

**11. Do que um objeto é composto?**
<details><summary>Resposta</summary>

De **atributos** (características/propriedades) e **comportamento** (métodos, as ações que ele executa). Também tem uma **identidade** única no sistema.
</details>

**12. Qual a diferença entre uma classe e uma `struct` do C?**
<details><summary>Resposta</summary>

A `struct` só guarda dados. A classe guarda dados **e** os métodos que operam sobre eles (ex.: `rendaAnual()` dentro de `Cliente`).
</details>

**13. O que é um construtor? E o que acontece se eu não criar nenhum?**
<details><summary>Resposta</summary>

É um método especial, com o mesmo nome da classe e sem tipo de retorno, executado no `new` para inicializar o objeto.
Se nenhum construtor for definido, o compilador cria o **construtor padrão** (sem parâmetros), que deixa os atributos com valores padrão (`0`, `false`, `null`). Se você criar **qualquer** construtor, o padrão deixa de existir; se quiser um sem parâmetros, precisa declará-lo.
</details>

**14. O que é o `this` no Java? Quando ele é obrigatório?**
<details><summary>Resposta</summary>

É uma referência ao **objeto atual** (aquele que está executando o método). É necessário quando:
- o parâmetro tem o mesmo nome do atributo (`this.nome = nome;`);
- queremos passar o próprio objeto como parâmetro para outro método.

Também existe o `this(...)`, que chama outro construtor da mesma classe (ver pergunta 33).
</details>

**15. Uma variável de objeto guarda o objeto? O que é `null`?**
<details><summary>Resposta</summary>

Não: ela guarda uma **referência** (endereço de memória) para o objeto. Um mesmo objeto pode ser apontado por várias variáveis. `null` significa que a variável não aponta para objeto nenhum.
</details>

**16. Java passa parâmetros por valor ou por referência?**
<details><summary>Resposta</summary>

**Sempre por valor (cópia).** Em primitivos, copia o valor. Em objetos, copia a *referência* — por isso o método consegue alterar o objeto original, mas não consegue fazer a variável de fora apontar para outro objeto.
</details>

**17. O que são anotações (annotations) no Java e pra que servem?**
<details><summary>Resposta</summary>

São marcações com `@` + nome (e opcionalmente parâmetros) colocadas no código. Servem para o **compilador verificar coisas em tempo de compilação** ou para **ferramentas/frameworks** (ex.: Spring com `@Entity`, `@Id`, `@NotBlank`) usarem essas informações.
</details>

**18. Quais as 3 categorias de anotações? Dê um exemplo de cada.**
<details><summary>Resposta</summary>

- **Marcadoras:** só o nome, sem dados. Ex.: `@Override`, `@Deprecated`.
- **De valor único:** um único membro (`value`). Ex.: `@MinhaAnotacao("valor")`, `@SuppressWarnings("deprecation")`.
- **Completas:** vários pares `nome=valor` separados por vírgula. Ex.: `@Version(major=1, minor=0, micro=0)`.
</details>

**19. O que fazem `@Override` e `@Deprecated`?**
<details><summary>Resposta</summary>

- `@Override`: sinaliza que o método **sobrescreve** um método da superclasse (ou interface). Se a sobrescrita estiver errada (nome ou parâmetros diferentes), dá **erro de compilação**.
- `@Deprecated`: sinaliza que o método/classe está **obsoleto** e não deve mais ser usado. Quem usa recebe um *warning* do compilador.

Ambas são anotações padrão do Java e **não precisam de import**.
</details>

**20. Cite anotações OBRIGATÓRIAS no Java.**
<details><summary>Resposta</summary>

Pegadinha: **nenhuma anotação é obrigatória** para o código compilar. Um método sobrescrito sem `@Override` compila normalmente.
Mas o `@Override` é **fortemente recomendado**: sem ele, se você errar o nome ou os parâmetros, o Java cria um método novo em silêncio e o bug passa despercebido.
</details>

**21. Esse código compila? Por quê?**

```java
class Funcionario {
    protected double salario;
    public double getSalario(double bonus) { return this.salario + bonus; }
}
class FuncionarioComissionado extends Funcionario {
    protected double extra;
    @Override
    public double getSalario(float bonus) { return this.salario + this.extra + bonus; }
}
```
<details><summary>Resposta</summary>

**Não.** O parâmetro na filha é `float` e na mãe é `double`, então não é uma sobrescrita (seria uma sobrecarga). Como tem `@Override`, o compilador acusa erro: *"method does not override or implement a method from a supertype"*.
</details>

### Abstração e Encapsulamento

**22. O que é Abstração?**
<details><summary>Resposta</summary>

Focar nas **características essenciais** de um objeto, do ponto de vista de quem usa, ignorando os detalhes. Foca no **o que** o objeto faz, não no **como**. Ex.: um player de música só precisa expor `play()`, `stop()`, `pause()`; quem usa não precisa saber como MP3/FLAC são decodificados.
</details>

**23. Quais os benefícios da Abstração?**
<details><summary>Resposta</summary>

Facilita a compreensão do código (vê o problema de forma mais simples), melhora o reaproveitamento (código modular e reutilizável) e reduz o número de erros.
</details>

**24. O que é Encapsulamento?**
<details><summary>Resposta</summary>

Separar a **interface** de um objeto dos **detalhes internos** do funcionamento. Os detalhes ficam escondidos (normalmente `private`) e o acesso é controlado por métodos (getters/setters e outros métodos públicos), garantindo que os dados sejam usados de forma correta.
</details>

**25. Quais as vantagens do Encapsulamento?**
<details><summary>Resposta</summary>

Torna o software mais flexível e fácil de modificar, facilita a organização e o reuso de componentes e **reduz o acoplamento** entre as partes do sistema.
</details>

**26. O que é a "interface" de uma classe (no sentido de encapsulamento)?**
<details><summary>Resposta</summary>

É a lista de serviços que a classe oferece para fora: seus métodos e atributos **públicos**. Funciona como um "contrato" / "painel de controle". Métodos `private` não fazem parte da interface, então podem ser mudados sem quebrar quem usa a classe.
</details>

**27. Quais são os modificadores de acesso e o que cada um permite?**
<details><summary>Resposta</summary>

| Modificador | Quem acessa | Aplica-se a |
|-------------|-------------|-------------|
| `public` | Qualquer classe | classes, métodos, atributos |
| `protected` | Mesmo pacote + subclasses | métodos, atributos |
| *default* (nada) | Só o mesmo pacote | classes, métodos, atributos |
| `private` | Só a própria classe | métodos, atributos |

Acessar algo proibido gera **erro de compilação**. Boa prática: atributos `private`, torne privado tudo o que puder e exponha o mínimo.
</details>

**28. Para que servem getters e setters? E se um atributo só puder ser lido?**
<details><summary>Resposta</summary>

São os métodos "acessores" que dão acesso controlado a atributos `private` (o setter pode validar o valor). Para `boolean`, é comum usar `isAtivo()` em vez de `getAtivo()`. Se o atributo não deve ser alterado de fora, cria-se **só o get** (ex.: `saldo` da `ContaBancaria`).
</details>

**29. O que significa `static`? Como acessar um membro static?**
<details><summary>Resposta</summary>

Significa "**de classe**": o atributo/método pertence à classe, não a cada objeto (todos os objetos compartilham o mesmo valor). Deve ser acessado por `NomeDaClasse.membro` (ex.: `Ingresso.getTotalVendidos()`), e não por uma variável de objeto.
Um método `static` **não** acessa atributos/métodos não-static da mesma classe (não compila). Um método não-static acessa ambos.
</details>

**30. O que `final` faz em um atributo, em um método e em uma classe? Como se declara uma constante?**
<details><summary>Resposta</summary>

- **Atributo/variável:** não pode ser alterado depois de inicializado.
- **Método:** não pode ser sobrescrito.
- **Classe:** não pode ser herdada.

Constantes normalmente são `static final`, com nome em maiúsculas: `public static final double SALARIO_MINIMO = 1518.0;`
</details>

**31. O que são pacotes (packages)? Qual a boa prática de import?**
<details><summary>Resposta</summary>

São agrupamentos de classes relacionadas (viram pastas e subpastas). Declara-se com `package br.cesarschool.poo;` no topo do arquivo. Para usar classes de outro pacote, usa-se `import`; as classes do "core" (`java.lang`, ex.: `String`, `Math`) já vêm importadas. Boa prática: importar **classe a classe** (`import java.util.ArrayList;`) em vez de `import java.util.*;`.
</details>

### Herança

**32. O que é Herança? Qual palavra reservada usa?**
<details><summary>Resposta</summary>

Mecanismo para **reutilizar código** de classes existentes: a subclasse (filha) herda tudo que a superclasse (mãe) tem e só define o que é novo. Usa `extends`: `class B extends A`.
A filha herda atributos, métodos e o **tipo** da mãe, mas **não herda os construtores** — e tem a obrigação de chamar o construtor da mãe.
</details>

**33. Para que servem `super(...)` e `this(...)` no construtor?**
<details><summary>Resposta</summary>

- `super(...)`: chama o construtor da **superclasse**. Tem que ser a **primeira linha** do construtor. Se você não escrever, o Java coloca `super()` implícito — e dá erro se a mãe não tiver construtor sem parâmetros.
- `this(...)`: chama **outro construtor da mesma classe** (reuso na sobrecarga de construtores). Quando usado, o construtor não precisa chamar `super`, o outro construtor chamado cuida disso.

Fora do construtor, `super.metodo()` chama a versão da mãe (ex.: `super.calcularSalario() + bonus`).
</details>

**34. Java tem herança múltipla?**
<details><summary>Resposta</summary>

**Não.** Uma classe só pode ter **uma** mãe direta (mas pode ter avós, bisavós...). Por outro lado, uma classe pode **implementar várias interfaces**.
</details>

**35. Como validar se uma herança faz sentido?**
<details><summary>Resposta</summary>

Com a frase **"é um"**: "Todo Médico **é uma** Pessoa" (OK), mas "toda Pessoa é um Médico" não. A filha só pode **adicionar** funcionalidade; se precisar **remover** algo herdado, a hierarquia está errada.
</details>

**36. O que é a classe `Object`?**
<details><summary>Resposta</summary>

É a mãe de **todas** as classes do Java. Se uma classe não declara `extends`, ela estende `Object` automaticamente.
</details>

**37. Uma subclasse acessa os atributos `private` da mãe?**
<details><summary>Resposta</summary>

**Não.** Ela acessa diretamente só o que é `public` ou `protected` (e *default* se estiver no mesmo pacote). Para os `private`, usa os getters/setters da mãe.
</details>

**38. Para que servem `toString()`, `equals()` e `hashCode()`?**
<details><summary>Resposta</summary>

São métodos de `Object` que costumam ser sobrescritos:
- `toString()`: retorna uma String que representa o objeto. O padrão é `NomeDaClasse@hash`.
- `equals(Object o)`: compara se dois objetos são iguais. O padrão compara o **endereço de memória** (igual ao `==`).
- `hashCode()`: retorna um inteiro usado em coleções baseadas em hash (`HashMap`, `HashSet`).

**Regra:** ao sobrescrever `equals()`, sobrescreva também `hashCode()`, para objetos iguais terem o mesmo hash.
</details>

**39. Qual a diferença entre `==` e `equals()` para objetos?**
<details><summary>Resposta</summary>

`==` compara se as duas variáveis apontam para o **mesmo objeto na memória**. `equals()` compara se os objetos são **equivalentes** pela regra que a classe definir (se não for sobrescrito, faz o mesmo que `==`).
</details>

**40. Quais os benefícios da Herança?**
<details><summary>Resposta</summary>

Cria famílias de classes com reuso de código, dá flexibilidade (novos subtipos podem ser usados onde a superclasse é usada) e facilita adicionar funcionalidades sem mexer na classe original.
</details>

### Polimorfismo

**41. O que é Polimorfismo?**
<details><summary>Resposta</summary>

"Muitas formas": permite que um **mesmo nome de método tenha comportamentos diferentes** dependendo do tipo do objeto, e que um objeto seja usado através de variáveis de tipos ancestrais. Assim, um código interage com objetos sem saber a forma específica deles.

```java
Animal a1 = new Cachorro();
Animal a2 = new Gato();
a1.interagir(); // "Au au au!"
a2.interagir(); // "Miau...."
```
</details>

**42. Qual a diferença entre Sobrecarga (overload) e Sobrescrita (override)?**
<details><summary>Resposta</summary>

| | Sobrecarga | Sobrescrita |
|---|---|---|
| Onde | Mesma classe | Subclasse redefine método da mãe |
| Assinatura | Mesmo nome, **parâmetros diferentes** | Mesmo nome **e mesmos parâmetros** |
| Resolvida em | Tempo de **compilação** | Tempo de **execução** |
| Anotação | Nenhuma | `@Override` |

Ex. de sobrecarga: `System.out.println(int)`, `println(String)`, `println(boolean)`.
</details>

**43. Posso sobrecarregar um método mudando só o tipo de retorno?**
<details><summary>Resposta</summary>

**Não.** A lista de parâmetros **tem** que ser diferente. O retorno *pode* ser diferente, mas sozinho não basta.
</details>

**44. Quais as vantagens da sobrecarga de construtores?**
<details><summary>Resposta</summary>

Flexibilidade (várias formas de criar o objeto) e reuso (um construtor chama outro com `this(...)`, sem repetir código).
</details>

**45. O que é o Princípio da Substituição?**
<details><summary>Resposta</summary>

É poder usar um objeto de uma **subclasse** numa variável do tipo da **superclasse** (`Animal a = new Cachorro();`), porque a filha "é uma" mãe. O tipo da variável define como o programador **enxerga** o objeto (só vê os métodos de `Animal`), mas o método executado é o do objeto real.
</details>

**46. Qual a diferença entre conversão implícita e explícita de objetos (upcast/downcast)?**
<details><summary>Resposta</summary>

- **Implícita (upcast):** filha → mãe, sem cast. `Animal a = new Cachorro();`
- **Explícita (downcast):** mãe → filha, precisa de cast. `Cachorro c = (Cachorro) a;`
  Se o objeto não for realmente daquele tipo, dá `ClassCastException` **em tempo de execução**.
</details>

**47. Para que serve o `instanceof`?**
<details><summary>Resposta</summary>

Verifica se um objeto é de um tipo (ou subtipo). Usado antes de um downcast para evitar `ClassCastException`:

```java
if (a instanceof Cachorro) {
    Cachorro c = (Cachorro) a;
    c.cocar();
}
```
</details>

**48. O que são Generics e qual problema resolvem?**
<details><summary>Resposta</summary>

Permitem passar **tipos como parâmetro** para classes/interfaces/métodos (`Repositorio<T>`, `List<Cliente>`). Evitam casts e `instanceof` ao tirar objetos de coleções, e o compilador checa os tipos:

```java
List<Cliente> lista = new ArrayList<>();
Cliente c = lista.get(0); // sem cast
```
Só aceitam tipos não primitivos (use `Integer` em vez de `int`).
</details>

**49. O que é uma classe abstrata? E um método abstrato?**
<details><summary>Resposta</summary>

- **Classe abstrata** (`abstract class`): **não pode ser instanciada**, existe para ser estendida. Pode ter métodos abstratos **e** métodos normais.
- **Método abstrato**: só tem a declaração, **sem corpo** (`public abstract void desenhar();`). As subclasses concretas são obrigadas a implementá-lo.

Uma classe **deve** ser abstrata se tem (ou herda sem implementar) algum método abstrato, ou se implementa uma interface sem implementar todos os métodos dela.
</details>

**50. O que é uma Interface? Qual a diferença para uma classe abstrata?**
<details><summary>Resposta</summary>

É um "contrato": só métodos abstratos, e atributos (se houver) são `public static final`. Uma classe usa `implements` e é obrigada a implementar todos os métodos.

| | Classe abstrata | Interface |
|---|---|---|
| Palavra-chave | `extends` | `implements` |
| Métodos | abstratos **e** concretos | só abstratos (no conteúdo dos slides) |
| Atributos | qualquer | só constantes (`public static final`) |
| Quantas por classe | só **uma** | **várias** |

Vantagens das interfaces: aumentam o reuso, reduzem o esforço de evolução e facilitam arquiteturas baseadas em componentes.
</details>
