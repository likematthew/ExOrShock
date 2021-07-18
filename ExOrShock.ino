#include <SoftwareSerial.h>

bool setupStart = false;
bool start = false;
long startTime = 0;

int valueMax = 400;
int valueMin = 220;

int  sensorOben = A0;
int  sensorUnten = A1;
int  shocker = 2;

int  LEDBlue = 5;
int  LEDGreen = 6;
int  LEDRed = 7;

long LEDBlueTime = 0;
bool LEDBlueBlink = false;

SoftwareSerial bt(10, 11);

void setup() 
{
  bt.begin(9600);
  Serial.begin(9600);
  
  pinMode(LEDBlue, OUTPUT);
  pinMode(LEDRed, OUTPUT);
  pinMode(LEDGreen, OUTPUT);

  pinMode(sensorOben, INPUT);
  pinMode(sensorUnten, INPUT);
  pinMode(shocker, OUTPUT);

  systemCheck();
  calibration();
}

void systemCheck()
{
  digitalWrite(LEDBlue, HIGH);
  digitalWrite(LEDGreen, HIGH);
  digitalWrite(LEDRed, HIGH);
  delay(1000);
  digitalWrite(LEDBlue, LOW);
  digitalWrite(LEDGreen, LOW);
  digitalWrite(LEDRed, LOW);
  delay(1000);
  startShocking();
  delay(100);
  stopShocking();
  delay(1000);
}

void calibration()
{
  int i = 0;
  int valueUpper = 0;
  while(i < 15)
  {
    LED(LEDBlue, 200);
    LED(LEDGreen, 200);
    LED(LEDRed, 200);
    delay(200);
    valueUpper += analogRead(sensorOben);
    Serial.println(valueUpper);
    i++;
  }
  valueMin = (valueUpper / i) + 6;
  Serial.println(valueMin);
  Serial.println();
}

void loop() 
{
  // Blue LED blinking while waiting for Bluetooth data
  delay(500);
  LED(LEDBlue, 500);
  
  if (bt.available()) {
    // Getting Bluetooth data
    // Blue LED shines while waiting for start
    digitalWrite(LEDBlue,  HIGH);
    String input = "";
    while(bt.available())
    {
      input += (char)bt.read();
      delay(50);
    }
    int seconds = input.toInt();
    setupStart = true;
    Serial.println(seconds);
    
    while(setupStart)
    {
      // Reading values from moisture sensors
      int valueUpper = analogRead(sensorOben);
      int valueLower = analogRead(sensorUnten);
      Serial.println(valueUpper);
      
      if(!start)
      {
        // Starting when the person starts drinking
        if(valueUpper < valueMin)
        {
          start = true;
          startTime = millis();
          LEDBlueTime = millis();
          LEDBlueBlink = false;
        }
      }
      else
      {
        // Blue LED blinkink faster while drinking
        if((millis() - LEDBlueTime) > 100)
        {
          LEDBlueTime = millis();
          if(LEDBlueBlink) {
            digitalWrite(LEDBlue,  HIGH);
          } else {
            digitalWrite(LEDBlue,  LOW);
          }
          LEDBlueBlink = !LEDBlueBlink;
        }
        
        int sek = (millis() - startTime) / 1000;
        
        // WIN
        if(valueUpper > valueMax && valueLower > valueMax && sek < seconds - 1)
        {
          LED(LEDGreen, 2000);
          endDrinking();
        }
        // LOSE
        if(sek > seconds - 1)
        {
          startShocking();
          delay(100);
          stopShocking();
          endDrinking();
        }
      }
    }
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

void LED(int pLED, int pTime)
{
  digitalWrite(pLED, HIGH);
  delay(pTime);
  digitalWrite(pLED, LOW);
}
