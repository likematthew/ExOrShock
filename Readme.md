
# ExOrShock
This is a manual on how to create a cup which shocks you if you don´t empty it in a certain amount of time.
### Disclaimer
***This build contains high voltage parts which can hurt you and persons using the cup.***
***We are not responsible for any harms that are made by trying to recreating the cup with this manual or using it.***
## How the cup works
![Cup](https://burle.me/api/images/ex-or-shock-cup-outside-1.jpg =400x)
Before you start, you have to fill up the cup to the top with water. After that, you start the cup with switching on an external battery pack which is located on the bottom. After the cup was switched on, all three LEDs (Blue, Green, Red) are going to light up. Then the calibration mode starts, which calibrates the lowest values of the moisture level sensors that are located directly in the cup (For the calibration the cup needs to be full with water). During the calibration the three LEDs start lighting from top to bottom fifteen times. After the calibration the blue LED is going to blink slowly. This means the cup waits for a value from the Bluetooth module, which you need to connect to and send the seconds how long it should take to empty the cup. Now you can empty the cup again, and fill it with a drink of your choice. After the seconds are received, the blue LED stays lighted. Now the cup is ready for someone to start drinking. If you now tilt the cup to start drinking, the upper moisture level sensor will notice it and the blue LED will start blinking again. The LED will blink faster and faster while the time is running out. If you finished the cup before the time runs out, the green LED will shine. If you don´t finish the cup before the time runs out, the red LED will shine and you will get shocked. Then the circle starts again and the blue LED will start blinking till you send the time via Bluetooth again.
## What you need for the build
### Knowledge
In the best case you have a little bit of programming knowledge and you also know what an Arduino is and how to use it.

### You need these parts for the build
- An [Arduino Uno Microcontroller](https://www.amazon.de/s?k=Arduino+Uno&i=electronics&__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&ref=nb_sb_noss_2) (Or from another manufacturer)
- At least two [Moisture Level Sensors](https://www.amazon.de/Capacitive-Moisture-Corrosion-Resistant-Raspberry/dp/B07FLR13FS/ref=sr_1_2?__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&dchild=1&keywords=Arduino+Moisture+Level+Sensor&qid=1628542140&sr=8-2)
![Cup](https://burle.me/api/images/ex-or-shock-moisture-level-sensor-1.jpg =200x)
- An [DSD TECH HC-06 Bluetooth Module](https://www.amazon.de/s?k=DSD+TECH+HC-06+Bluetooth+Module&__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&ref=nb_sb_noss) (**With a plastic case**)
- An [5 Volt Relay](https://www.amazon.de/s?k=5+Volt+Relay&__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&ref=nb_sb_noss_2) (Or more if you break one)
![Cup](https://burle.me/api/images/ex-or-shock-relay-1.jpg =200x)
- An [High Voltage Transformator](https://www.amazon.de/gp/product/B078ST3844/ref=ppx_yo_dt_b_asin_title_o00_s00?ie=UTF8&psc=1) (From 9 Volt to round about 1000 Kilo Volt)
![Cup](https://burle.me/api/images/ex-or-shock-transformator-1.jpg =200x)
- An [9 Volt Block Battery](https://www.amazon.de/s?k=9+Volt+Block+Battery) (Or more to switch them out if they are empty)
- A [9 Volt Battery Adapter](https://www.amazon.de/s?k=9+Volt+Battery+Adapter&__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&ref=nb_sb_noss_2) for Arduino
![Cup](https://burle.me/api/images/ex-or-shock-9-volt-battery-1.jpg =200x)
- 6 or more [1.5 Volt LR6 Batteries](https://www.amazon.de/s?k=1.5+Volt+LR6+Batteries&__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&ref=nb_sb_noss)
- A 1.5 Volt Battery Holder or a 9 Volt Battery Holder (Together you need at least 7 Volt)
![Cup](https://burle.me/api/images/ex-or-shock-1-5-volt-battery-holder-1.jpg =200x)
- This [Fitness Cup](https://www.amazon.de/gp/product/B01LSM3GAE/ref=ppx_yo_dt_b_asin_title_o01_s00?ie=UTF8&psc=1) (If you use another one, you also need to change the 3D Model)
- Many [Jumper Cables](https://www.amazon.de/s?k=Jumper+Cable&i=electronics&__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&ref=nb_sb_noss_2)
![Cup](https://burle.me/api/images/ex-or-shock-jumper-cable-1.jpg =200x)
- At least one [Red/Blue/Green LED](https://www.amazon.de/s?k=Arduino+LED&__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&ref=nb_sb_noss_2)
- Some [Arduino LEDs](https://www.amazon.de/s?k=Arduino+LED&__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&ref=nb_sb_noss_2) (Blue/Red/Green)
- Some [PCB Boards](https://www.amazon.de/gp/product/B0734XYJPM/ref=ppx_yo_dt_b_asin_title_o01_s01?ie=UTF8&psc=1)
![Cup](https://burle.me/api/images/ex-or-shock-led-1.jpg =200x)
- Aluminium Foil
### At best you have these tools
- A 3D Printer (But its also possible to order it online)
- A Crimping Tool
- Some Screwdrivers
- Some Pliers
- A Hot Glue Gun
- A Soldering Iron
- Sandpaper
- Acrylic Varnish Spray Can (In a color of your choice)
- Arduino Studio Software (Is needed and for free)
- Maybe Fritzing Software (For free)
- Maybe Blender Software (For free)
### Project Files
You need the following files from my [repository](https://github.com/likematthew/ExOrShock):
- 3D Object files Cover.stl, Cup.stl (/3D Object/V2) (For the 3D printed housing)
- ExOrShock.ino (The program that is running on the Arduino)
## How to build it
### The Housing
The housing needs to be 3D printed from the two object files listed above under "Project Files" (Cover.stl, Cup.stl). You can print them with your own 3D Printer or send them to an online printing provider. Which material you use is your choice (Should be some kind of plastic). If the STL files from above don't work for your printer software, you can also open the two Blender files from the repository in Blender and export them in another format. You can also modify the 3D Objects in Blender for your needs. The dimensions are height 13.9 cm, length 11.8 cm, width 10.5 cm.
#### Grinding and painting
After you printed the housing and cover, you may want to grind it with some fine sandpaper so you can paint it in a color of your choice. For the painting i used normal black acrylic varnish and some clear varnish after wards.
### Preparing the parts for the build
#### LED Board
#### 1.5 Volt Battery Pack