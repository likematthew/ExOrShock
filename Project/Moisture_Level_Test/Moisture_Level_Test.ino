int sensorUpper = A0;
int sensorLower = A1;
const int valueUpperMax = 258;
const int valueLowerMax = 220;

void setup()
{
  Serial.begin(9600);
  pinMode(sensorUpper, INPUT);
  pinMode(sensorLower, INPUT);
}

void loop() 
{
  int a = 0;
  int valueUpper = 0;
  int valueLower = 0;
  do
  {
    delay(25);
    valueUpper += analogRead(sensorUpper);
    delay(25);
    valueLower += analogRead(sensorLower);
    a++;
  }
  while(a < 10);
  valueUpper = valueUpper / 10;
  valueLower = valueLower / 10;
  Serial.println(valueUpper);
  Serial.println(valueLower);
  if(valueUpper > valueUpperMax && valueLower > valueLowerMax)
  {
    Serial.println("FERTIG");
  }
  Serial.println("");
  Serial.println("=====");
  Serial.println("");
}
