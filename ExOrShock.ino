#include <SoftwareSerial.h>

bool setupStart = false;
bool start = false;
long startTime = 0;

const int tolerance = 3;
const int valueUpperMax = 258; // Needs to be set manually
const int valueLowerMax = 225; // Needs to be set manually
int valueUpperMin = 0; // Will be set automatically

int sensorUpper = A0;
int sensorLower = A1;
int shocker = 2;

int LEDBlue = 5;
int LEDGreen = 6;
int LEDRed = 7;

long LEDBlueTime = 0;
bool LEDBlueBlink = false;

SoftwareSerial bt(10, 11);

void setup()
{
  Serial.begin(9600);
  bt.begin(9600);
  
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
  Serial.println("== Start Calibration ==");
  Serial.println("-- Measurements --");
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
  valueUpperMin = (valueUpperMin / i) + tolerance;
  Serial.println("-- Upper Value Min --");
  Serial.println(valueUpperMin);
  Serial.println("== End Calibration ==");
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
    Serial.println("== Start Loop ==");
    Serial.println("-- Seconds --");
    Serial.println(seconds);
    Serial.println("-- Measurements --");
    
    while(setupStart)
    {
      // Reading values from moisture sensors
      int valueUpper = analogRead(sensorUpper);
      int valueLower = analogRead(sensorLower);
      Serial.println("-- Values -- ");
      Serial.println(valueUpper);
      Serial.println(valueLower);
      
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
  Serial.println("== Stop Loop ==");
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
