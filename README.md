
# PHex
Repositorio de desenvolvimento de drones de pulverização de baixo custo.
Aqui você encontrará a memória de desenvolvimento da tecnologia de construção de drones hexacopteros de pulverização, assim como documentação e demais informações que permitirão a reprodução deste projeto.

O Objetivo geral do projeto é construir um drone de pulverização usando como unidade central de processamento, um celular android Xiaomi Redmi Note 8, 6 motores de drone e como controlador de motores, comunicação e sensoriamento, um arduino nano.

Todas as informações deste repositorio e demais repositorios do projeto são de dominio público, todos os softwares são de codigo livre e aberto sob licença GNU GPLv3.


## Parceiros

<div style="display: flex;">
 
 <image src="https://www.facom.ufms.br/wp-content/uploads/2017/09/grafo_facom.png)" width="100"/>   
 <image src="https://www.gov.br/cnpq/pt-br/canais_atendimento/identidade-visual/CNPq_v2017_rgb.jpg" width="100"/>

</div>

## Fases em andamento:

 0. Voo Inalgural (Set/2025)
<details>
 <summary>
 1. Georreferenciamento e Análise por Visão Computacional
    </summary>
    1.1. Mapeamento de terreno
    
    1.2. Georreferenciamento

    1.3. Análise por Coleta de Dados

    1.4. Análise por visão computacional 
 </details>   
 <details>
  <summary>
 2. Editor de Plano de Voo, telemetria e controle
</summary>
    2.1. Comunicação lora

    2.2. Protocolo de comunicação drone x notebook

    2.3. Georreferenciamento da area alvo

    2.4. Criação do plano de voo

    2.5. Criação do plano de pulverização por cruzamento de dados

    2.6. Telemetria e controle

         2.6.1. Decolar

         2.6.2. Mover ao inicio do plano de voo

         2.6.3. Realizar Plano de Voo

              2.6.3.1. Detectar obstáculo, pairar e informar por telemetria

              2.6.3.2. Ajustar plano de voo por obstáculo (manual)

              2.6.3.3. Ajustar plano de voo por obstáculo (autonomo/ia)

              2.6.3.4. Ajustar trajetoria por deslocamento de ar

              2.6.3.5. Retornar a base (movel ou fixa)

         2.6.4. Retornar a base por starvation
    
         2.6.4. Pousar
    
         2.6.5. Retomar plano de voo incompleto

         2.6.6. Pouso emergencial por falha

         2.6.7. Plano de voo para multiplos drones combinados

         2.6.8. Ajuste de pulverização por visão computacional de tempo real
</details>
  3. Conjunto de Controle (Em andamento)

    3.1. App Android PhexAndroid (em andamento)
  
    3.2. Scatch arduino PhexArduino (em andamento)

    3.3. Cicuito Eletrônico (concluido)
    

 5. Modelagem de estrutuda do drone hexacoptero para voo vertical limitado por cabo guia. (parcialmente completo)

    4.1. Modelagem 3d e impressão (modelo: Phex-v1 Prototipo de Hexacoptero Versão 1) 
  
        4.1.1. Ponta de acoplamento do motor (concluido)
   
        4.1.2. Corpo Central (concluido)
   
        4.1.3. Limitador de curso (concluido)
    
        4.1.4. Acoplador de pouso e decolagem guiado (concluido)
    
        4.1.5. Circuito de controle (em andamento)
    
            4.1.5.1. Integração com barometro (concluido)

            4.1.5.1. Integração com sensor de distancia (proxima fase)

            4.1.5.1. Integração com sensor de proximidade (proxima fase) 

        4.1.6. App Android de Controle (em andamento)

           4.1.6.1. Integração com GPS (proxima fase)

           4.1.6.1. Integração com Câmera Foto (proxima fase)

           4.1.6.1. Integração com Câmera Vídeo (proxima fase)

           4.1.6.1. Integração com Barometro (em andamento)

           4.1.6.1. Integração com Acelerometro e Giroscopio (concluido)
    
           4.1.6.1. Integração com Magnetometro (concluido)

        4.1.6. Integração Android x arduino (em andamento)


        4.1.6. Testes

            4.1.6.1. Voo Vertical (guiado)
    
                4.1.6.1.1. Decolar 
                4.1.6.1.2. Subir 
                4.1.6.1.3. Pairar
                4.1.6.1.4. Descer
                4.1.6.1.5. Pousar
                4.1.6.1.6. girar horario
                4.1.6.1.7. girar antiorario
                4.1.6.1.8. teste sem guia

            4.1.6.2. Voo Horizontal (contido por braço e giroscopio)

                4.1.6.1.1. avançar 
                4.1.6.1.2. mudar direção
                4.1.6.1.3. retroceder

        4.1.7. Resultados
<details>
 <summary>
6. [Teste de velocidade e temperatura de motores](docs/teste_motores.md) (concluido)
 </summary>   
    5.1 Modelagem e impressão de suporte de teste (concluido)
    
    5.2 Criação do Circuito de testes (concluido)
    
    5.3 Testes (corrigir)
    
    5.4 Resultados (parcial)
</details>
<details>
 <summary>
7. [Teste de acionamento de motores](docs/teste_acionamento.md) (concluido)
</summary>
    6.1 Modelagem e impressão de suporte (concluido)

    6.2 Criação do Circuito e Scatch controlador (concluido)

    6.3 Testes (concluido)

    6.4 Resultados (concluido)
</details>
   
## Equipe de desenvolvimento

### Docentes:

  Coordenador Pesquisador: Daniel Cristaldo Martinez
  
  Professor Pesquisador: Carlos Cacho
  
  Professor Pesquisador: Willian
  
  Professor Pesquisador: Lucas
  
### Discentes:

  2023 até a presente data - Giuliano
  
  2023 até a presente data - Arthur

Historico de Participação

  Rafael (2023), Natalia(2022), Matheus (2022)

## Historico de atualização (10 ultimos)

### 2024

07/09 Registro de Voo Vertical

08/16 Registro de Testes com motores.

06/21 Atualização da equipe e registro de acionamento de motores.

06/13 Criação do repositorio e carga de dados iniciais.
