#include "dht.h" //INCLUSÃO DE BIBLIOTECA

const int pinoDHT11 = A2; //PINO ANALÓGICO UTILIZADO PELO DHT11

dht DHT; //VARIÁVEL DO TIPO DHT

int v = 0;

bool anterior = false;
int qtde = 0;
float leituras[120];
int seq = 0;
unsigned long tempo_zero = millis();
unsigned long tempo_temp = millis();
float media = 0.0;
float manterior = 0.0;
float tanterior = 0.0;
float temperatura = 0.0;

void setup() {
  Serial.begin(9600);
  pinMode(6, OUTPUT);
  pinMode(2,INPUT);
  delay(100);
  digitalWrite(4, HIGH);
  for (int x = 0; x < 120; x++) {
    leituras[x] = float(0);
  }
  attachInterrupt(digitalPinToInterrupt(2), somar, RISING);
  Serial.println("iniciando");

}

void somar() {
  qtde++;
  unsigned long tempo = millis();
  if ((tempo - tempo_zero) > 1000) {
    for (int x = 1; x < 120; x++) {
      leituras[x - 1] = leituras[x];
    }
    leituras[119] = float(qtde);
    qtde = 0;
    tempo_zero = tempo;
   /* Serial.print('[');
    for (int x = 1; x < 120; x++) {
         Serial.print(leituras[x]);
         Serial.print(',');
    }
    Serial.println(']'); */

    
  }
}

void calcMedia() {
  float q = 0.0;
  float total = 120.0;
  for (int x = 0; x < 120; x++) {
    if(leituras[x] == 0){
      total--;
      continue;
    }
    q += leituras[x];
  }
  media = (q / total) * 60 ;

}

void loop() {
  unsigned long tempo = millis();

  if (millis() > (tempo_temp + 2000)) {
    DHT.read11(pinoDHT11); //LÊ AS INFORMAÇÕES DO SENSOR
    //Serial.print("Temperatura: "); //IMPRIME O TEXTO NA SERIAL
    //Serial.print(DHT.temperature, 0); //IMPRIME NA SERIAL O VALOR DE UMIDADE MEDIDO E REMOVE A PARTE DECIMAL
    //Serial.println("*C"); //IMPRIME O TEXTO NA SERIAL
    //Serial.print('[');
    
    
    //Serial.println(']');
    calcMedia();
    
    //Serial.print("rpm:");
    //Serial.println(media);
    temperatura = DHT.temperature;
   
    tempo_temp = millis();

    if(temperatura != tanterior || abs(manterior-media)>10){
      Serial.print(temperatura);
      Serial.print(",");
      Serial.print(media);
      Serial.print(",");
      Serial.println(millis());
    }
    tanterior = float(temperatura);
    manterior= float(media);

  }
  
  if (Serial.available()) {
    char l = Serial.read();
    if (l == 'a') {
      v = 45;
    } else if (l == 's') {
      v = 128;
    } else if (l == 'd') {
      v = 255;
    } else if (l == 'f') {
      v = v - 20;
    } else if (l == 'p') {
      v = 0;
    } else if (l == 'w') {
      v = v+20;
    }
    
    v = (v > 255) ? 255 : v;
    v = (v < 0) ? 0 : v;
    analogWrite(6, v);
  }

}
