# ExOrShock
This is a manual on how to create a cup which shocks you if you don´t empty it in a certain amount of time.
### Disclaimer
***This build contains high voltage parts which can hurt you and persons using the cup.***
***I am not responsible for any harms that are made by trying to recreate the cup with this manual or using it.***
## 1. How the finished cup works
![ExOrShock Cup](https://burle.me/api/images/ex-or-shock-cup-outside-1.jpg =450x)
Before you start, you have to fill up the cup to the very top with water. After that, you start the cup with switching on an external battery pack which is located on the bottom. After the cup was switched on, all three LEDs (Blue, Green, Red) are going to light up. Then the calibration mode starts, which calibrates the lowest value of the moisture level sensors that are located directly in the cup.
> For the calibration the cup needs to be full with water as it was mentioned before.

During the calibration the three LEDs start lighting from top to bottom 15 times. After the calibration the blue LED is going to blink slowly. This means the cup waits for a value from the Bluetooth module, which you need to connect to and send the seconds how long it should take to empty the cup. Now you can empty the cup and fill it with a drink of your choice. After the seconds are received, the blue LED stays lighted. The cup is now ready for someone to start drinking. If you tilt the cup to start drinking, the upper moisture level sensor will notice it and the blue LED will start blinking again. The LED will blink faster and faster while the time is running out. If you finished the cup before the time runs out, the green LED will shine. If you don´t finish the cup before the time runs out, the red LED will shine and you will get shocked. Then the circle starts again and the blue LED will start blinking till you send the time via Bluetooth again.
## 2. What you need for the build
### 2.1 Knowledge
In the best case you have a little bit of programming knowledge and you also know what an Arduino is and how to use it. This manual will not teach you any basics of programming or electronics.

### 2.2 You need these parts for the build
- An [Arduino Uno Microcontroller](https://www.amazon.de/s?k=Arduino+Uno&i=electronics&__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&ref=nb_sb_noss_2)
	> Or from another manufacturer.
- At least two [Moisture Level Sensors](https://www.amazon.de/Capacitive-Moisture-Corrosion-Resistant-Raspberry/dp/B07FLR13FS/ref=sr_1_2?__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&dchild=1&keywords=Arduino+Moisture+Level+Sensor&qid=1628542140&sr=8-2)
	> ![Moisture Level Sensor](https://burle.me/api/images/ex-or-shock-moisture-level-sensor-1.jpg =300x)
- A [DSD TECH HC-06 Bluetooth Module](https://www.amazon.de/s?k=DSD+TECH+HC-06+Bluetooth+Module&__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&ref=nb_sb_noss) (**With a plastic case**)
- A [5 Volt Relay](https://www.amazon.de/s?k=5+Volt+Relay&__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&ref=nb_sb_noss_2)
	> ![Relay](https://burle.me/api/images/ex-or-shock-relay-1.jpg =200x)
- A [High Voltage Transformator](https://www.amazon.de/gp/product/B078ST3844/ref=ppx_yo_dt_b_asin_title_o00_s00?ie=UTF8&psc=1)
	> From 9 Volt to round about 1000 Kilo Volt.
	> But you can also use a different one which is not that strong.
![Transformator](https://burle.me/api/images/ex-or-shock-transformator-1.jpg =300x)
- A [9 Volt Block Battery](https://www.amazon.de/s?k=9+Volt+Block+Battery)
	> Or more to switch them out if they are empty.
- A [9 Volt Battery Adapter](https://www.amazon.de/s?k=9+Volt+Battery+Adapter&__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&ref=nb_sb_noss_2)
	> ![9 Volt Battery with Adapter](https://burle.me/api/images/ex-or-shock-9-volt-battery-1.jpg =300x)
- Six or more [1.5 Volt LR6 Batteries](https://www.amazon.de/s?k=1.5+Volt+LR6+Batteries&__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&ref=nb_sb_noss)
- A 1.5 Volt Battery Holder or a 9 Volt Battery Holder
	> Together you need at least 7 volt for powering the Arduino.
	> ![Battery Holder with Batteries](https://burle.me/api/images/ex-or-shock-1-5-volt-battery-holder-1.jpg =300x)
- This [Fitness Cup](https://www.amazon.de/gp/product/B01LSM3GAE/ref=ppx_yo_dt_b_asin_title_o01_s00?ie=UTF8&psc=1)
	> If you use another one, you also need to change the 3D model.
	> Maybe you also want to buy more in case you break one.
- Many [Jumper Cables](https://www.amazon.de/s?k=Jumper+Cable&i=electronics&__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&ref=nb_sb_noss_2)
	> ![Jumper Cables](https://burle.me/api/images/ex-or-shock-jumper-cable-1.jpg =300x)
- At least one [Red/Blue/Green LED](https://www.amazon.de/s?k=Arduino+LED&__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&ref=nb_sb_noss_2)
- Some 220 Ohm Resistors
- Some [PCB Boards](https://www.amazon.de/gp/product/B0734XYJPM/ref=ppx_yo_dt_b_asin_title_o01_s01?ie=UTF8&psc=1)
	> ![LEDs on PCB Board](https://burle.me/api/images/ex-or-shock-led-1.jpg =300x)
- Some [Screws/Nuts and Standoff Spacer](https://www.amazon.de/gp/product/B07RP6CRD5/ref=ppx_yo_dt_b_asin_title_o01_s01?ie=UTF8&psc=1)
- Some [Shrink Tubing](https://www.amazon.de/ChiliTec-12000058-Chilitec-Schrumpfschlauch-Sortiment-100-teilig/dp/B003H9CJ1Y/ref=sr_1_6?__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&dchild=1&keywords=schrumpfschlauch&qid=1629294593&sr=8-6)
- Aluminium Foil
### 2.3 At best you have these tools
- A 3D Printer
	> But it is also possible to order the 3D printed parts online.
- A Crimping Tool
- Some Screwdrivers
- Some Pliers
- A Hot Glue Gun
- A Soldering Iron
- Some Sandpaper
- Acrylic Varnish Spray Can
	> In a color of your choice.
- Arduino Studio Programming Software
	> Is needed for the project and is for free.
- Maybe Fritzing Circuit Diagram Software
	> Is also for free.
- Maybe Blender 3D Software
	> Is also for free.
### 2.4 Project files
You need the following files from the ExOrShock [Repository](https://github.com/likematthew/ExOrShock):
- 3D Objects Cover.stl and Housing.stl 
	> Can be found in /3D Object/V2.
	> For the 3D printed housing.
- ExOrShock.ino
	> The program that is running on the Arduino.

Other interesting files:
- Fritzing.fzz
	> Can be found in /Project.
	> This is the circuit diagram.
## 3. How to build it
### 3.1 Circuit diagram
![Circuit Diagram](https://burle.me/api/images/ex-or-shock-circuit-diagram.png =1000x)
This is an overview on how all the different parts are connected with each other and which pins each part uses.
### 3.2 Components
![Components](https://burle.me/api/images/ex-or-shock-cup-inside-3.png =1000x)
Here you can see how all the components need to be placed inside the housing. In case you are wondering why the bluetooth module isnt marked, this is because it is located directly below the relay. The 9 volt battery adapter with the battery is glued on the cover of the housing and has its place opposite to the transformator. Dont get confused by the look of the transformator, in this image i already covered it with plasticine to isolate it. Below the relay and the bluetooth module ist the USB hub and the power input of the Arduino and on the opposite side are the three LED holes. In front of the LED PCB board is the hole for the moisture level sensor cables that are coming from the cup. The transformator has a hole on the left and right side for it in the housing, these holes are for its two high voltage cables. I also isolated these both cables with plasticine.
### 3.3 Housing preparation
The housing needs to be 3D printed from the two 3D model files listed above under *2.4 Project Files* (Cover.stl, Housing.stl). You can print them with your own 3D printer or send them to an online printing provider. Which material you use is your choice.
> The material should be some kind of plastic.

If the STL files from above don't work for your printer software, you can also open the two Blender files from the repository in Blender and export them in another format. You can also modify the 3D objects in Blender for your needs. The dimensions  for the housing are height 13.9 cm, length 11.8 cm, width 10.5 cm.
#### 3.3.1 Grinding and painting
After you printed the housing and cover, you may want to grind it with some fine sandpaper so you can paint it in a color of your choice.
![Grinded Housing](https://burle.me/api/images/ex-or-shock-housing-1.jpg =300x) 
For the painting i used normal black acrylic varnish and some clear varnish after wards.
![Painted Housing](https://burle.me/api/images/ex-or-shock-housing-2.jpg =300x)
### 3.4 Preparing parts for the build
#### 3.4.1 LED PCB board
![LED PCB Board](https://burle.me/api/images/ex-or-shock-led-1.jpg =500x)
For the LEDs I used the smallest PCB board from the link under *2. What you need for the build*, because it fits perfectly into the housing.
> You can also use any other PCB, but have in mind that the distance between the LEDs must be right to fit into the housing. If this is not the case you may have to change the housing object in Blender. 

Now you have to solder the LEDs (Red, Green, Blue) on the PCB board, at best you do it at the same spots as in the image above. Between the LEDs there need to be three holes so that the distance is right. The red one will be the bottom one in the housing. After you soldert the three LEDs in place, you need three 220 Ohm resistors were you solder one on each minus cable of all three LEDs. After that you can connect all three minus cables together, so that you only have one minus (female) cable for all three LEDs you need to plug in. At the plus end I used three (male) jumper cables in the same color as each LED. At last I put hot glue on all the parts on the bottom of the PCB to insolate and consolidate all components.
![LED PCB Board](https://burle.me/api/images/ex-or-shock-led-2.jpg =800x)
#### 3.4.2 Moisture level sensor
![Moisture Level Sensor](https://burle.me/api/images/ex-or-shock-moisture-level-sensor-1.jpg =500x)
![Moisture Level Sensor](https://burle.me/api/images/ex-or-shock-housing-moisture-level-sensor-1.jpg =200x)
Because we need to glue both moisture level sensor inside the cup and lay the cables trough two holes to get them outside, we need to get rid of the white adapter plastic you can see in the first image. For this I just used a plier to rip it off. The three pins that are left over can be made hot and just pulled out. Now you should have three holes at the end of the moisture level sensor, one for GND, one for Voltage Input (VCC) and one for measuring (AOUT).
![Moisture Level Sensor](https://burle.me/api/images/ex-or-shock-moisture-level-sensor-2.jpg =300x)
Now you can solder your cables into all three holes.
> Leave the cables long enough because they need to get through the housing.

![Moisture Level Sensor](https://burle.me/api/images/ex-or-shock-moisture-level-sensor-3.jpg =500x)
I also hot glued all electric components at the top of the moisture level sensor to make them water proof.
![Moisture Level Sensor](https://burle.me/api/images/ex-or-shock-moisture-level-sensor-4.jpg =500x)
At the end both moisture level sensors should look like this.
### 3.5 Cover
![Housing](https://burle.me/api/images/ex-or-shock-threads-1.jpg =300x)
These are the parts that are used as the threads and screws.
First you want to test every hole of the cover if you can put the screws from the link under *2. What you need for the build* through them. If they dont fit you may want to make them a little bigger. I used the soldering iron for this.
![Battery Holder](https://burle.me/api/images/ex-or-shock-1-5-volt-battery-holder-1.jpg =300x)
Now you can hot glue the 1.5 volt battery holder on the outside of the cover.
![Battery Holder](https://burle.me/api/images/ex-or-shock-1-5-volt-battery-holder-2.jpg =300x)
The power cable should be on the same side as the power input of the Arduino is.
![9 Volt Battery](https://burle.me/api/images/ex-or-shock-cup-inside-1.jpg =500x)
Now you can glue the 9 volt battery adapter on the inner looking side of the cover. Glue it opposite to the transformator so nothing is in the way of the battery.
### 3.6 Cup
![Moisture Level Sensor](https://burle.me/api/images/ex-or-shock-housing-moisture-level-sensor-1.jpg =300x)
After both moisture level sensors are prepared they need to be glued into the cup. For this we use the flat side with the dimensions on it. At first the lower moisture level sensor needs to be glued into the cup. For this i put the sensor on the lowest possible position and then marked the position on the outside where the whole needs to be. I burnt the hole inside with the soldering iron. After that i pulled the cables trough the whole and put glue on the side of the sensor which was going to be glued on the cup.
> Glue the sensor such that it is tilted away from the cup a little bit so that no fluid gets stuck behind.

![Moisture Level Sensor](https://burle.me/api/images/ex-or-shock-housing-moisture-level-sensor-2.jpg =300x)
![Moisture Level Sensor](https://burle.me/api/images/ex-or-shock-housing-moisture-level-sensor-3.jpg =300x)
The other moisture level sensor should be placed on the very top of the cup as you see on the glue in the image above.
![Moisture Level Sensor](https://burle.me/api/images/ex-or-shock-housing-moisture-level-sensor-4.jpg =300x)
At last you need to connect the two plus and minus cables together so you only have one plus and one minus cable for both sensors. Then you can put some shrink tubing around the cables to isolate them. Now you can also put all the cables through the bigger whole in the middle as you see in the image above.
### 3.7 Housing
#### 3.7.1 Installing threads
![Housing](https://burle.me/api/images/ex-or-shock-threads-1.jpg =300x)
These are the parts that are used as the threads and screws.
![Housing](https://burle.me/api/images/ex-or-shock-housing-threads-1.jpg =500x)
At first I installed the threads for the cover, there is already a premade hole for these threads. I made the threads hot with the soldering iron and then pressed them into the hole. Make sure they stay right up. Then maybe fill the wholes around the threads wit the soldering iron and make sure they stay in their places.
![Housing](https://burle.me/api/images/ex-or-shock-housing-threads-2.jpg =500x)
Then I installed the threads for the Arduino. For this I just put the Arduino in the right place, so the hubs are set right into the wholes. Then I marked the four holes with a pen. After that I made each thread hot again with the soldering iron and pressed them in place.
![Housing](https://burle.me/api/images/ex-or-shock-housing-threads-3.jpg =500x)
Next i installed the screws/threads for the LED PCB Board, there i also put it in place and marked the holes with a pen. Then i also made them hot with the soldering iron and pressed them in place.
![Housing](https://burle.me/api/images/ex-or-shock-housing-threads-4.jpg =300x)
![Housing](https://burle.me/api/images/ex-or-shock-housing-threads-5.jpg =300x)
#### 3.7.2 Installing all parts