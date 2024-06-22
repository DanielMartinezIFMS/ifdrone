# Teste de Acionamento de Motores 

## Descrição

O motor foi acoplado ao prototipo, unido por parafusos e fixado por um torno/morsa de bancada.
um arduino foi ligado ao motor , conectado ao computador por usb.

## Tipo de Motor

Motor com escovas, 8v dc (sucata de drone)

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

<!--a href="http://www.youtube.com/watch?feature=player_embedded&v=DHbbZP4LOAc
" target="_blank"><img src="http://img.youtube.com/vi/DHbbZP4LOAc/0.jpg" 
alt="IMAGE ALT TEXT HERE" width="240" height="180" border="10" /-->
Indisponivel
      
  </td>
  <td>
    
- [teste_temperatura_rpm.ino](https://github.com/DanielMartinezIFMS/ifdrone/blob/main/docs/teste_temperara_rpm.ino)

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

Como resultado do experimento, pudemos definir os valores mínimos de início e fim de movimento do motor, evitando seu travamento.

Usando o comando analogWrite:


60 => inicia movimento    110 => velocidade média    255 => máxima velocidade   

50 => velocidade mínima   0 => cessa movimento
