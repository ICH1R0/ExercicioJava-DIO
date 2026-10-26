# Exercícios Java - DIO

Repositório com os exercícios e laboratórios que fiz nos cursos de Java da **DIO**, organizados em um projeto por pasta. Os temas vão de orientação a objetos (herança e interfaces) até padrões de projeto e uma API com Spring Boot.

## Projetos

| Pasta | Tema | Conceitos praticados |
|---|---|---|
| [`Relogio_Com_Heranca`](./Relogio_Com_Heranca) | Relógio com formatos BRL e US | Herança, classe base e classes derivadas |
| [`CalculoAreas_Com_Interface`](./CalculoAreas_Com_Interface) | Cálculo de áreas de formas geométricas | Interfaces, polimorfismo |
| [`ContasBasica_Com_CollectionsEClassesUteis`](./ContasBasica_Com_CollectionsEClassesUteis) | Contas básicas | Collections e classes úteis do Java |
| [`lab-padroes-projeto-java`](./lab-padroes-projeto-java) | Padrões de projeto em Java puro | Singleton, Strategy, Facade |
| [`lab-padroes-projeto-spring`](./lab-padroes-projeto-spring) | API de clientes com Spring Boot | Spring Data JPA, OpenFeign, integração com ViaCEP, Swagger |

## Detalhes

### Relogio_Com_Heranca
Uma classe base `Clock` e duas classes derivadas, `BRLClock` e `USClock`, que reaproveitam o comportamento da base e especializam o formato de cada região.

### CalculoAreas_Com_Interface
A interface `GeometricForm` define o contrato de cálculo de área, implementado por `Circle`, `Rectangle` e `Square`. O `Main` trata todas as formas pela interface, sem depender da classe concreta.

### ContasBasica_Com_CollectionsEClassesUteis
Exercício de contas básicas usando coleções e classes utilitárias da biblioteca padrão do Java.

### lab-padroes-projeto-java
Três padrões de projeto em Java puro:

- **Singleton**, em três variações: `SingletonEager`, `SingletonLazy` e `SingletonLazyHolder`
- **Strategy**, com um `Robo` que troca de comportamento em tempo de execução (`ComportamentoAgressivo`, `ComportamentoDefensivo` e `ComportamentoNormal`)
- **Facade**, que simplifica o acesso a dois subsistemas (`CrmService` e `CepApi`) por uma única interface

A classe `Test` executa os exemplos de cada padrão.

### lab-padroes-projeto-spring
API REST de clientes e endereços feita com **Spring Boot 4.1.2** e **Java 25**:

- CRUD de clientes em `/clientes`
- Ao cadastrar um cliente, o endereço é buscado pelo CEP na API pública do **ViaCEP** (via OpenFeign) e salvo no banco caso ainda não exista
- Persistência com Spring Data JPA e banco **H2** em memória
- Documentação interativa com **Swagger UI** (springdoc)
- O `ClienteService` funciona como fachada: concentra o acesso aos repositórios e ao ViaCEP, e o controller só conversa com ele

## Como executar

### Projetos em Java puro
1. Abra a pasta do projeto desejado no **IntelliJ IDEA** (`File > Open`)
2. Execute a classe principal (`Main`, ou `Test` no `lab-padroes-projeto-java`)

### lab-padroes-projeto-spring
Pré-requisito: JDK 25.

```bash
cd lab-padroes-projeto-spring

# Linux / macOS
./mvnw spring-boot:run

# Windows (PowerShell)
.\mvnw.cmd spring-boot:run
```

Com a aplicação no ar, a documentação fica em `http://localhost:8080/swagger-ui.html`.

Exemplo de cadastro (o CEP deve ter 8 dígitos, só números):

```bash
curl -X POST http://localhost:8080/clientes \
  -H "Content-Type: application/json" \
  -d '{"nome": "Maria", "endereco": {"cep": "01001000"}}'
```

## Estrutura do repositório

```text
.
├── Relogio_Com_Heranca
├── CalculoAreas_Com_Interface
├── ContasBasica_Com_CollectionsEClassesUteis
├── lab-padroes-projeto-java
├── lab-padroes-projeto-spring
└── .gitignore
```

## Projeto relacionado

- [task-manager-api](https://github.com/ICH1R0/task-manager-api): API de tarefas com Spring Boot, arquitetura em camadas e testes, em repositório próprio.

## Autor

Feito por [ICH1R0](https://github.com/ICH1R0). Os exercícios são adicionados conforme avanço nos cursos.
