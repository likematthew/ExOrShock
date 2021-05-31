#include <SoftwareSerial.h>

bool setupStart = false;
bool start      = false;
long zeit       = 0;

int  sensor     = A0;
int  shocker    = 2;

int  LEDBlue    = 5;
int  LEDGreen   = 6;
int  LEDRed     = 7;

SoftwareSerial bt(11, 10);

void setup() {
  bt.begin(9600);
  Serial.begin(9600);
  
  pinMode(LEDBlue,  OUTPUT);
  pinMode(LEDRed,   OUTPUT);
  pinMode(LEDGreen, OUTPUT);

  pinMode(sensor,   INPUT);
  pinMode(shocker,  OUTPUT);
}

void loop() {
  if (bt.available()) {
    String input = "";
    while(bt.available())
    {
      input += (char)bt.read();
      delay(50);
    }
    int seconds = input.toInt();
    setupStart = true;

    while(setupStart)
    {
      delay(100);
      
      int wert = analogRead(sensor);
      Serial.println(wert);
  
      if(!start)
      {
        if(wert < 220)
        {
          start = true;
          zeit  = millis();
          digitalWrite(LEDBlue, HIGH);
        }
      }
      else
      {
        int sek = (millis() - zeit) / 1000;
        // LOSE
        if(wert < 400 && sek > seconds - 1)
        {
          startShocking();
          delay(200);
          stopShocking();
          endDrinking();
        }
        // WIN
        if(wert > 400 && sek < seconds - 1)
        {
          digitalWrite(LEDGreen, HIGH);
          delay(500);
          digitalWrite(LEDGreen, LOW);
          endDrinking();
        }
      }
    }
    delay(5000);
  }
}

void startShocking()
{
  digitalWrite(LEDRed,  HIGH);
  digitalWrite(shocker, HIGH); 
}

void stopShocking()
{
  digitalWrite(shocker, LOW);
  digitalWrite(LEDRed,  LOW);
}

void endDrinking()
{
  digitalWrite(LEDBlue, LOW);
  setupStart = false;
  start = false;   
}
