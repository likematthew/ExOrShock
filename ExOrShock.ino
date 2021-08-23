#include <SoftwareSerial.h>

bool setupStart = false;
bool start = false;
long startTime = 0;

int valueUpperMax = 170; // Needs to be set manually
int valueLowerMax = 160; // Needs to be set manually
int valueUpperMin = 0; // Will be set automatically

int  sensorUpper = A0;
int  sensorLower = A1;
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

  pinMode(sensorUpper, INPUT);
  pinMode(sensorLower, INPUT);
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
}

void calibration()
{
  // Calibration of the minimal value
  int i = 0;
  while(i < 15)
  {
    LED(LEDBlue, 200);
    LED(LEDGreen, 200);
    LED(LEDRed, 200);
    delay(200);
    valueUpperMin += analogRead(sensorUpper);
    Serial.println(valueUpperMin);
    i++;
  }
  valueUpperMin = (valueUpperMin / i) + 2; // The 2 is for tolerance
  Serial.println(valueUpperMin);
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
      int valueUpper = analogRead(sensorUpper);
      int valueLower = analogRead(sensorLower);
      Serial.println(valueUpper);
      Serial.println(valueLower);
      Serial.println();
      
      if(!start)
      {
        // Starting when the person starts drinking
        if(valueUpper < valueUpperMin)
        {
          start = true;
          startTime = millis();
          LEDBlueTime = millis();
          LEDBlueBlink = false;
        }
      }
      else
      {
        int sec = (millis() - startTime) / 1000;
        int blinkingTime = 50 + (float)(seconds - sec) / (float)seconds * 250;
        
        // Blue LED blinking faster while drinking
        if((millis() - LEDBlueTime) > blinkingTime)
        {
          LEDBlueTime = millis();
          if(LEDBlueBlink) {
            digitalWrite(LEDBlue,  HIGH);
          } else {
            digitalWrite(LEDBlue,  LOW);
          }
          LEDBlueBlink = !LEDBlueBlink;
        }
        
        // WIN
        if(valueUpper > valueUpperMax && valueLower > valueLowerMax && sec < seconds - 1)
        {
          digitalWrite(LEDBlue,  LOW);
          LED(LEDGreen, 10000);
          endDrinking();
        }
        // LOSE
        if(sec > seconds - 1)
        {
          digitalWrite(LEDBlue,  LOW);
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
