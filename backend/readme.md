## Manual de Refatoração

### Estrutra do Backend
- Controller > Endpoints em geral
- Service > Lógica de negócio. Obs.: Normalmente o controller chama isso
- Model > Estrutura do banco de dados
- Repository > Onde cria os SQL que for necessário
- Testes Unitários > JUNIT e Mockito