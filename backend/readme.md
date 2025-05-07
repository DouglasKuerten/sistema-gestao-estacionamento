# 📦 Refatoração do Projeto

## 🛠️ Objetivo

Este documento tem como objetivo apresentar os **principais problemas detectados no código-fonte atual** e definir a **estratégia de refatoração** a ser aplicada. A refatoração visa melhorar a legibilidade, manutenibilidade e qualidade geral do projeto.

---

## 🚨 Principais Problemas Identificados

### Gerais

- Comentários desnecessários no código
- Comprimento de linha excedendo 120 colunas
- Métodos que executam múltiplas responsabilidades
- Métodos com mais de 20 linhas
- Falta de separação de responsabilidades entre controllers e services
- Ausência de métodos Java para encapsular lógica das queries SQL
- Inexistência de testes unitários
- Uso de nomes fora do padrão (abreviações, nomes mistos em português/inglês)
- Estruturas excessivas de `if/else`
- Falta de configuração de linter no projeto
- Ausência de tratamento de erros (exceptions)
- Uso de indentação via tab, em vez da convenção recomendada (espaços)
- Controllers acessam diretamente a lógica de dados, violando o princípio de separação de responsabilidades
- Injeções de dependência diretas de `Jdbc` e `Repository` nos controllers
- Métodos `REST` retornando diretamente o objeto em vez do código `http` e objeto no `body` 
- Ausência de uso de `@ControllerAdvice` para captura e tratamento centralizado de exceções

---

## 🔧 Estratégia de Refatoração
- Criar arquivo de configuração do linter a ser utilizado
- Criar camada de `Service` para retirar lógica dos `Controllers`
- Remover regras de negócio das queries SQL e movê-las para métodos Java
- Reduzir e simplificar métodos longos
- Criar testes unitários com **JUnit**
- Padronizar nomes de variáveis e arquivos
- Substituir estruturas `if/else` por lógica mais limpa
- Adotar um único idioma em todo o código 🇧🇷
- Implementar tratamento global de exceções com `@ControllerAdvice`
- Padronizar a indentação para 2 espaços

---

## 🧪 Ferramentas Utilizadas

| Ferramenta        | Finalidade                                      |
|-------------------|-------------------------------------------------|
| **JUnit**         | Testes unitários                                |
| **JaCoCo**        | Medição de cobertura de testes                  |
| **SonarLint**     | Linter e verificação local de código            |
| **SonarQube**     | Análise estática de código                      |
| **@ControllerAdvice** | Tratamento centralizado de exceções       |

---

## 🪄 Interface Fluente

- Será realizada a implementação de interface fluente em um método

---

## 🧹 Processo

- Criar branches específicas para cada etapa da refatoração
- Registrar todas as mudanças realizadas no `changelog.md`
- Refatorações devem ser feitas de forma incremental e versionada

---

## 📌 Histórico de Mudanças

> Atualize esta seção conforme forem feitas mudanças no projeto.

- [ ] Separação de responsabilidade entre controller e service iniciada
- [ ] Comentários desnecessários removidos
- [ ] Começo da padronização de nomes
- [ ] Configuração do SonarLint aplicada
> Todas as alterações realizadas podem ser consultadas no arquivo `changelog.md`
---
