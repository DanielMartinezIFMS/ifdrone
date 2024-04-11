# Teste de Motores

## Descrição

O motor foi acoplado ao prototipo, unido por parafusos e fixado por um torno/morsa de bancada.
Ao eixo do motor foi acoplado um disco, sendo pontuado nesse disco uma pastilha de neodimio.
Ao braço do prototipo foi fixado um sensor de efeito hall (ky003) , capaz de identificar o numero de rotações por minuto do motor.
Ao chassi do motor foi acoplado um sensor de temperatura (dht11).
um arduino foi ligado ao motor e aos sensores, conectado ao computador por usb.

## Recursos

<table>
  <thead>
    <th>Modelo 3d</th>
    <th>Video do Teste</th>
    <th>Arquivos</th>
  </thead>
  <tbody><tr><td>

<image src="https://github.com/DanielMartinezIFMS/ifdrone/assets/80930367/9733e70f-186e-4778-99d7-5438b923400b" width="250"/>
    
[Link de acesso ao modelo 3d](https://a360.co/3vQdebz)
    
  </td>
  <td>

<a href="http://www.youtube.com/watch?feature=player_embedded&v=DHbbZP4LOAc
" target="_blank"><img src="http://img.youtube.com/vi/DHbbZP4LOAc/0.jpg" 
alt="IMAGE ALT TEXT HERE" width="240" height="180" border="10" />
      
  </td>
  <td>
- Scatch Arduino
- 
  </td>
  </tr>
  <tr>
    <td colspan="3">

![esquema_teste_rpm_temperatura](https://github.com/DanielMartinezIFMS/ifdrone/assets/80930367/6c2553ce-7f51-405e-9a7d-9d70ba22ba98)

    </td>
  </tr>
  </tbody>
</table>

## Resultados
### Resumo

Considerando os dados abaixo, pode-se observar uma redução no numero rpm após o motor atindir 35ºC.

### Teste realizado em velocidade mínima (limiar de desligamento)
![teste_baixa_velocidade](https://github.com/DanielMartinezIFMS/ifdrone/assets/80930367/75f947f6-4685-418d-bb18-d50a1e879787)
### Teste realizado em velocidade Média
![teste_media_velocidade](https://github.com/DanielMartinezIFMS/ifdrone/assets/80930367/bfbee050-36e1-418d-92da-5eb5189078ae)

### Teste realizado em velocidade Máxima
> [!WARNING]
> Aparentemente houve uma perda de dados (repetir o teste!)

![teste_alta_velocidade](https://github.com/DanielMartinezIFMS/ifdrone/assets/80930367/6dff29e8-8a41-4c1e-949b-43273f60b1f1)

## Fotos

<table>
  <tbody>
    <tr><td>
      <image src="https://github.com/DanielMartinezIFMS/ifdrone/assets/80930367/36211889-f7f3-4e14-9f65-75b9b39a63e3" width="150" />
    </td><td>
      <image src="https://github.com/DanielMartinezIFMS/ifdrone/assets/80930367/6248167f-5e29-4653-a91d-3b5eccc7d805" width="400" />
    </td><td>
      <image src="https://github.com/DanielMartinezIFMS/ifdrone/assets/80930367/0d6e74f0-2a7c-449a-9b99-bd45fbf6a96f)" width="150" />
    </td></tr>
  </tbody>
</table>

## Memória

- Não houve sucesso utilizando sensor infravermelho em par, nem sensor IR acoplado e nem mesmo com sensor laser, devido a acentuada velocidade do motor que impedia a contagem correta.
- Para uma melhor contagem fez-se uso do comando atachInterrupt para capturar a passagem da pastilha de neodimio em frente ao sensor hall.
