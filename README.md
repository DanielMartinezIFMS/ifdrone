
# PHex
Repositorio de desenvolvimento de drones de pulverização de baixo custo.
Aqui você encontrará a memória de desenvolvimento da tecnologia de construção de drones hexacopteros de pulverização, assim como documentação e demais informações que permitirão a reprodução deste projeto.

O Objetivo geral do projeto é construir um drone de pulverização usando como unidade central de processamento, um celular android Xiaomi Redmi Note 8, 4 motores de drone e como controlador de motores, comunicação e sensoriamento, um arduino nano.

Todas as informações deste repositorio e demais repositorios do projeto são de dominio público, todos os softwares são de codigo livre e aberto sob licença GNU GPLv3.


## Parceiros

<div style="display: flex;">
 
 <image src="https://www.facom.ufms.br/wp-content/uploads/2017/09/grafo_facom.png)" width="100"/>   
 <image src="https://www.gov.br/cnpq/pt-br/canais_atendimento/identidade-visual/CNPq_v2017_rgb.jpg" width="100"/>

</div>

## Fases em andamento:
 6. Georreferenciamento e Análise por Visão Computacional
    
    6.1. Mapeamento de terreno
    
    6.2. Georreferenciamento

    6.3. Análise por Coleta de Dados

    6.3. Análise por visão computacional 
    
 5. Editor de Plano de Voo, telemetria e controle

    5.1. Comunicação lora

    5.2. Protocolo de comunicação drone x notebook

    5.3. Georreferenciamento da area alvo

    5.4. Criação do plano de voo

    5.5. Criação do plano de pulverização por cruzamento de dados

    5.6. Telemetria e controle

         5.6.1. Decolar

         5.6.2. Mover ao inicio do plano de voo

         5.6.3. Realizar Plano de Voo

              5.6.3.1. Detectar obstáculo, pairar e informar por telemetria

              5.6.3.2. Ajustar plano de voo por obstáculo (manual)

              5.6.3.3. Ajustar plano de voo por obstáculo (autonomo)

              5.6.3.4. Ajustar trajetoria por deslocamento de ar

              5.6.3.5. Retornar a base

         5.6.4. Retornar a base por starvation
    
         5.6.4. Pousar
    
         5.6.5. Retomar plano de voo incompleto

         5.6.6. Pouso emergencial por falha

         5.6.7. Plano de voo para multiplos drones combinados

         5.6.8. Ajuste de pulverização por visão computacional de tempo real
    
    
 4. Conjunto de Controle (Em andamento)

    4.1. App Android PhexAndroid (em andamento)

    4.2. Protocolo de Comunicação Android x arduino (em andamento)
    
    4.2. Scatch arduino PhexArduino 

    4.3. Cicuito Eletrônico (em andamento)
    

 3. Modelagem de estrutuda do drone hexacoptero para voo vertical limitado por cabo guia. (parcialmente completo)

    3.1. Modelagem 3d e impressão (modelo: Phex-v1 Prototipo de Hexacoptero Versão 1)
  
        3.1.1. Ponta de acoplamento do motor (concluido)
   
        3.1.2. Corpo Central (concluido)
   
        3.1.3. Limitador de curso (concluido)
    
        3.1.4. Acoplador de pouso e decolagem guiado (concluido)
    
        3.1.5. Ciscuito de controle (em andamento)
    
        3.1.6. Testes 
   
        3.1.7. Resultados

2. [Teste de velocidade e temperatura de motores](docs/teste_motores.md) (concluido)
    
    2.1 Modelagem e impressão de suporte de teste
    
    2.2 Criação do Circuito de testes
    
    2.3 Testes
    
    2.4 Resultados

1. [Teste de acionamento de motores] (docs/teste_acionamento.md) (concluido)

    2.1 Modelagem e impressão de suporte

    2.2 Criação do Circuito e Scatch controlador

    2.3 Testes

    2.4 Resultados

   
Equipe de desenvolvimento
Ativos
  Coordenador Pesquisador: Daniel Cristaldo Martinez
  Professor Pesquisador: Carlos Cacho
  Professor Pesquisador: Willian
  Professor Pesquisador: Lucas
  
Alunos:
  2023 até a presente data - Giuliano
  2023 até a presente data - Arthur

Historico de Participação
  Rafael (2023), Natalia(2022), Matheus (2022)

Historico de atualização (10 ultimos)
06/13 Criação do repositorio e carga de dados iniciais.
