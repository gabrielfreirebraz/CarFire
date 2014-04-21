Sistema de locação de automóveis
---

### Leia-me
1. Instale o ambiente local, para saber como configurar [clique aqui](https://github.com/gabrielfreire/java-cookbook-install).
4. Importe o projeto na Eclipse IDE e execute.
5. Cadastre um usuário.
6. Logue com o usuário criado.

### Tecnologias Utilizadas
1. JSF (JavaServer Faces)
2. Hibernate
3. Twitter Bootstrap 
    
### Configuração do Sistema
Ao iniciar o sistema, o atendente de uma Locadora de Veículos seleciona o idioma em que o
sistema será exibido e o código da agência de locação.

### Escolha e Reserva do automóvel
Todo processo de escolha e locação de veículos é descrito nos itens a seguir:

1. O atendente consulta os modelos dos veículos disponíveis e a tarifa do aluguel por km livre
ou km controlado;

2. Após a escolha do modelo do veículo, o atendente informa a data/hora de empréstimo, a
data/hora de devolução, o local do empréstimo, o local que devolução (que poderá ser o
mesmo ou não do empréstimo) e o tipo de tarifa (km livre ou km controlado). Caso o local de
devolução seja diferente do local de retirada o atendente deverá informar ao sistema o país em
que o automóvel será devolvido, a cidade e o estado (vide regra);

3. O atendente cadastra o cliente informando: nome, CPF (para brasileiros), documento de
identificação, passaporte (para estrangeiros), telefone, e-mail, data de nascimento, sexo,
número de habilitação, número de registro, estado emissor e validade;

4. O atendente especifica a forma de pagamento, que poderá ser cartão de crédito ou cheque.
No caso de cartão de crédito, deve ser informado o tipo de cartão (Visa, MasterCARD etc.),
nome do titular do cartão, CPF (para brasileiros), número do cartão, data de validade do cartão
e código de segurança. Esses dados serão validados no sistema externo da operadora de
crédito (simulado através de um arquivo texto). No caso de cheque, deve ser informado o
banco, agência, conta corrente, nome do titular, CPF e telefone. O sistema emite um
comprovante da locação, com um número de locação e todos os dados pertinentes à reserva
do veículo.
Devolução do Automóvel
No momento da devolução do automóvel, o atendente informa ao sistema o número de
locação. O sistema deverá verificar se a entrega está sendo realizada no prazo previsto. Caso
contrário, deverá calcular a multa.

### Regras:

1. Cidade da Devolução ≠ Cidade da Retirada: Acréscimo de R$ 1,00 por km de distância;

2. Agência da Devolução ≠ Agência da Retirada (quando na mesma cidade da retirada): Acréscimo de R$ 10,00;

3. A pessoa que vai alugar o veículo deve ter idade ≥ 21 anos;

4. O valor da multa, por dia, é de 20% do valor da locação do automóvel;

5. Considera-se modelo de veículo: Grupo, Acessório e Veículo. Exemplo:

    __Grupo:__        
    A – Econômico;            
    C – Econômico com Ar;         
    F – Intermediário;         
    G – Intermediário Wagon Especial;       
    H – Executivo;        
    I – Utilitário;       
    K – Executivo Luxo;       
    M – Intermediário Wagon;        
    N – Pick-up;        
    P – 4 x 4 Especial;        
    R – Minivan;       
    U – Furgão;        
    Y – Blindado.      

    __Acessório:__        
    Navegador GPS;      
    Cadeira de Bebê;        
    Motorista.          

    __Veículo:__         
    Chassi;       
    Placa;        
    Cidade;       
    km;        
    Estado;         
    Modelo;       
    Fabricante;         
    etc.       

6. Exemplo de Frotas e Tarifas da Localiza (vide portal da empresa):

7. O cliente deve ter seu crédito aprovado antecipadamente pela locadora. Essa aprovação será realizada através do sistema que consultará o sistema SERASA;

8. A pessoa que vai dirigir o veículo (condutor) deverá ter no mínimo 2 anos de habilitação;

9. A interface com o usuário deverá ter seu idioma alterado, de acordo com o idioma escolhido pelo usuário no próprio programa (Inglês, Espanhol ou Português);

10. A frota de veículos pode ser diferente de uma cidade para a outra e pode ser diferente entre agências de uma mesma cidade;

12. Qualquer agência no país poderá receber a devolução do veículo;

13. Se no momento da locação o cliente já for cadastrado, o sistema recupera os dados do cliente;

14. Se o cliente for pessoa física deve fazer uma locação para cada veículo. Se Pessoa Jurídica poderá ter mais de um automóvel por locação;

15. Todas as ações no sistema são realizadas pelo atendente da locadora;

16. O sistema permitirá que sejam feitas reservas de veículo através de agendamento no momento do procedimento de locação;

17. O pagamento será efetivado no momento da devolução do veículo.
