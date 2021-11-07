int  shocker = 2;

void setup() {
  pinMode(shocker, OUTPUT);
}

void loop() {
  delay(10000);
  digitalWrite(shocker, HIGH);
  delay(100);
  digitalWrite(shocker, LOW);
  delay(10000);
}
