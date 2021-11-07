int  sensorUpper = A0;
int  sensorLower = A1;

void setup() {
  Serial.begin(9600);
  pinMode(sensorUpper,   INPUT);
  pinMode(sensorLower,  INPUT);
}

void loop() {
  delay(1000);
  int valueUpper = analogRead(sensorUpper);
  Serial.println(valueUpper);
  delay(100);
  int valueLower = analogRead(sensorLower);
  Serial.println(valueLower);
  Serial.println();
}
