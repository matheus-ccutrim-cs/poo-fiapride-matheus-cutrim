# Projeto FiapRide - Matheus Costa Cutrim

## Informações do Aluno

* **Nome:** Matheus Costa Cutrim
* **RM:** 568087
* **Turma:** 2CCPR
* **Curso:** Ciência da Computação
* **GitHub:** [@matheus-ccutrim-cs](https://github.com/matheus-ccutrim-cs)

\---

## Descrição do Projeto

Este projeto reúne práticas das aulas 1 a 9 de Programação Orientada a Objetos. O FiapRide representa passageiros, saldo, viagens e diferentes veículos de um sistema de mobilidade. Inclui também um projeto pessoal de biblioteca com empréstimos e devoluções. Os valores de autonomia são exemplos didáticos, não medições reais.

## Como executar

É necessário Java JDK 11 ou superior. No terminal, a partir da raiz, no Windows PowerShell:

```powershell
New-Item -ItemType Directory -Force out
javac -encoding UTF-8 -d out (Get-ChildItem -Recurse src -Filter \*.java | ForEach-Object { $\_.FullName })
java -cp out br.com.fiapride.Main
java -cp out br.com.fiapride.biblioteca.MainBiblioteca
```

Em Linux/macOS:

```bash
mkdir -p out
javac -encoding UTF-8 -d out $(find src -name '\*.java')
java -cp out br.com.fiapride.Main
java -cp out br.com.fiapride.biblioteca.MainBiblioteca
```

## Checklist de Implementação

* \[x] Aula 1 - Classes e Objetos
* \[x] Aula 2 - Métodos
* \[x] Aula 3 - Encapsulamento
* \[x] Aula 4 - Construtores
* \[x] Aula 5 - Associação
* \[x] Aula 6 - Herança
* \[x] Aula 7 - Polimorfismo
* \[x] Aula 8 - Classes Abstratas
* \[x] Aula 9 - Interfaces

## Diagramas

!\[Diagrama de classes do FiapRide](docs/fiapride.png)
!\[Diagrama de classes da biblioteca](docs/biblioteca.png)

## Perguntas de Reflexão

### Aula 1 - Classes e Objetos

**Por que criar uma classe Passageiro em vez de variáveis soltas?**

Uma classe reúne os dados e comportamentos que pertencem a cada passageiro em um modelo. Cada objeto tem seu próprio nome e saldo, mas segue a mesma estrutura. Com variáveis soltas, seria necessário criar e manter nomes diferentes para cada usuário, aumentando o risco de misturar informações. Com a classe, posso criar quantos objetos forem necessários e armazená-los em uma coleção. Para um milhão de usuários, ainda seria preciso usar banco de dados e infraestrutura adequados; a classe organiza a representação, mas não resolve sozinha o armazenamento ou a escala. Ela também facilita aplicar as mesmas regras a todos.

### Aula 2 - Métodos

**Por que criar adicionarSaldo(valor) em vez de alterar o saldo diretamente?**

O método centraliza a regra: o valor deve ser positivo e finito. Se cada parte do programa alterar o saldo por conta própria, uma operação pode aceitar valores negativos, ignorar validações ou aplicar regras diferentes. Isso pode gerar cobranças incorretas e perda de confiança. Ao concentrar a operação em um método, a regra fica mais fácil de testar e modificar. Neste exemplo há também `pagar`, que verifica se o saldo é suficiente. Para dinheiro real, usaria `BigDecimal`, persistência e transações; `double` é uma simplificação didática.

### Aula 3 - Encapsulamento

**Por que um getter público é diferente de um atributo público?**

Com o atributo privado, somente a própria classe controla suas alterações e pode validar os dados. Um getter de `double` entrega o valor, não uma referência que permita alterar o campo original; o nome é uma `String`, que é imutável. Já um atributo público pode ser alterado diretamente, inclusive com um valor inválido. A analogia da cópia ajuda nesses casos, mas nem todo getter retorna uma cópia: se devolver um objeto mutável, quem o recebe pode modificá-lo. Para proteger esse caso seria necessário retornar uma cópia ou visão imutável.

### Aula 4 - Construtores

**Por que não gerar setters para tudo? Como modelo e placa são protegidos?**

Cada atributo tem regras próprias. Um carro não muda de modelo por uma simples atualização cadastral, por isso `modelo` é `final` e não tem setter. A placa pode mudar, mas precisa respeitar um formato; o setter privado mantém essa validação dentro de `Veiculo` e `atualizarPlaca` oferece uma operação pública nomeada. Isso reduz alterações acidentais ou inválidas, mas não comprova uma alteração no Detran nem impede fraude por si só: um sistema real precisaria de autorização, verificação externa e registro de auditoria. Gerar setters automaticamente sem avaliar o significado dos campos pode abrir caminhos que não deveriam existir.

### Aula 5 - Associação

**Por que a viagem recebe o objeto Passageiro em vez de apenas um nome?**

A viagem precisa se relacionar com um passageiro específico, não apenas guardar um texto que pode se repetir. Com a referência ao objeto, ela pode consultar o nome e chamar `pagar` ao ser concluída, mantendo a regra de saldo dentro de `Passageiro`. Uma string isolada não identifica com segurança a conta e não permite aplicar o pagamento diretamente. Na implementação, a viagem só é marcada como concluída depois de um pagamento bem-sucedido e não pode ser concluída duas vezes. Em um sistema persistente, um identificador único também poderia ser usado para recuperar o passageiro no banco.

### Aula 6 - Herança

**Por que a filha não altera diretamente os atributos privados da mãe?**

`private` limita o acesso direto à própria classe que declara o atributo, preservando o encapsulamento mesmo na herança. `Carro` recebe o estado de `Veiculo`, mas inicializa modelo e placa pelo construtor da mãe usando `super(...)`. Assim, a validação da placa fica centralizada e as subclasses não a contornam por acesso direto. Para consultar os dados, elas podem usar getters públicos. No projeto, `setPlaca` é privado e, portanto, também não pode ser chamado diretamente pela filha; a operação pública é `atualizarPlaca`.

### Aula 7 - Polimorfismo

**Por que calcularAutonomia precisa estar na classe base para ser chamado no laço?**

O compilador verifica os métodos disponíveis pelo tipo declarado da referência. No laço, cada variável é declarada como `Veiculo`; se `calcularAutonomia` existisse apenas nas filhas, essa chamada não compilaria. Ao declarar o método na classe base, todos os veículos oferecem esse contrato. Em tempo de execução, o Java escolhe a implementação sobrescrita correspondente ao objeto concreto, como `Carro` ou `Moto`. Isso permite tratar a frota de forma uniforme sem perder o comportamento específico de cada tipo.

### Aula 8 - Classes Abstratas

**Por que declarar Veiculo como abstract?**

O compilador não conhece a intenção de negócio: uma classe comum pode ser instanciada, mesmo que seu nome represente uma ideia genérica. Declarar `Veiculo` como abstrata impede `new Veiculo(...)` e comunica que a classe deve servir de base para tipos concretos. O método abstrato `calcularAutonomia` obriga as subclasses concretas a fornecer uma implementação. Sem essa declaração, alguém poderia criar um veículo genérico com comportamento incompleto e introduzir inconsistências na frota. A restrição é então verificada pelo próprio compilador.

### Aula 9 - Interfaces

**Por que herança simples e múltiplas interfaces?**

Java permite estender uma única classe, evitando a ambiguidade de herdar estado e implementações de duas classes com o mesmo método. Uma classe pode implementar várias interfaces para assumir diferentes contratos. `CarroEletrico`, por exemplo, estende `Veiculo` e implementa `Recarregavel`. Interfaces não eliminam todas as ambiguidades: se duas fornecerem métodos `default` com a mesma assinatura, a classe deverá resolver o conflito sobrescrevendo o método. A constante `CARGA\_MAXIMA` define o limite compartilhado da interface e `recarregar` define uma capacidade que pode ser implementada por tipos diferentes.

## Desafios Técnicos Implementados

### Desafio Pessoal (Seu Projeto)

**Qual foi o domínio escolhido?** Sistema de biblioteca com empréstimo e devolução de livros.

**Quais classes foram criadas?** `Livro`, `Usuario`, `Emprestimo` e `MainBiblioteca`.

**Qual foi o maior desafio técnico?**

Um desafio foi manter o estado do livro consistente com o empréstimo. O livro começa disponível e o construtor de `Emprestimo` verifica se os objetos informados existem antes de registrar o empréstimo. A operação do livro impede que outro empréstimo use o mesmo exemplar enquanto ele estiver indisponível. Na devolução, o livro volta a ficar disponível e o empréstimo é encerrado. Também existe uma verificação para evitar uma segunda devolução. Separei o estado e as operações em classes para não depender apenas de mensagens no `main`. Com isso, foi possível testar a associação entre usuário, livro e empréstimo de forma simples. Esta versão mantém os dados apenas em memória e não trata concorrência; para uso real, eu adicionaria persistência e transações.

## Conclusão

**O que aprendi nestas 9 aulas?**

Aprendi a representar entidades com classes e objetos e a evoluir o código para concentrar regras em métodos e proteger dados. Construtores ajudam a criar objetos consistentes; associações ligam entidades que colaboram; herança, polimorfismo, classes abstratas e interfaces ajudam a organizar comportamentos comuns e específicos. O projeto pessoal ajudou a aplicar essas ideias em outro domínio.

**Qual conceito foi mais difícil de entender?**

Polimorfismo foi um dos conceitos mais desafiadores: a referência pode ser `Veiculo`, mas o comportamento executado depende do objeto concreto. O laço da frota ajudou a visualizar a diferença entre o contrato conhecido pelo compilador e a implementação escolhida em execução.

**O que melhoraria se pudesse refazer?**

Eu adicionaria testes automatizados, identificadores únicos, armazenamento em banco e tratamento de erros mais detalhado. Para valores monetários, substituiria `double` por `BigDecimal`. Também implementaria autenticação e validação real para alterações de placa, além de autonomia baseada em capacidade e consumo. Essas mudanças aproximariam o exercício de um sistema usado fora da sala de aula.

