
# ExOrShock
This is a manual on how to create a cup which shocks you if you don´t empty it in a certain amount of time.
## Disclaimer
***This build contains high voltage parts which can hurt you and persons using the cup.***
***I am not responsible for any harms that are made by trying to recreate the cup with this manual or using it.***
## 1. How the finished cup works
![ExOrShock Cup](https://burle.me/api/images/ex-or-shock-cup-outside-1.png)
Before you start, you have to fill up the cup to the very top with water. After that, you start the cup with switching on an external battery pack which is located on the bottom. After the cup was switched on, all three LEDs (Blue, Green, Red) are going to light up. Then the calibration mode starts, which calibrates the lowest value of the upper moisture level sensor that is located directly in the cup.
> For the calibration the cup needs to be full with water as it was mentioned before.

During the calibration the three LEDs start lighting from top to bottom 15 times. After the calibration the blue LED is going to blink slowly. This means the cup waits for a value from the Bluetooth module, which you need to connect to and send the seconds how long it should take to empty the cup. Now you can empty the cup and fill it with a drink of your choice. After the seconds are received, the blue LED stays lighted. The cup is now ready for someone to start drinking. If you tilt the cup to start drinking, the upper moisture level sensor will notice it and the blue LED will start blinking again. The LED will blink faster and faster while the time is running out. If you finished the cup before the time runs out, the green LED will shine. If you don´t finish the cup before the time runs out, the red LED will shine and you will get shocked. Then the circle starts again and the blue LED will start blinking till you send the time via Bluetooth again.
## 2. What you need for the build
### 2.1 Knowledge
In the best case you have a little bit of programming knowledge and you also know what an Arduino is and how to use it. This manual will not teach you any basics of programming or electronics.
### 2.2 You need these parts for the build
* An [Arduino Uno Microcontroller](https://www.amazon.de/s?k=Arduino+Uno&i=electronics&__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&ref=nb_sb_noss_2)
	> Or from another manufacturer.

* At least two [Moisture Level Sensors](https://www.amazon.de/Capacitive-Moisture-Corrosion-Resistant-Raspberry/dp/B07FLR13FS/ref=sr_1_2?__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&dchild=1&keywords=Arduino+Moisture+Level+Sensor&qid=1628542140&sr=8-2)
	> ![Moisture Level Sensor](https://burle.me/api/images/ex-or-shock-moisture-level-sensor-1.png)

* A [DSD TECH HC-06 Bluetooth Module](https://www.amazon.de/s?k=DSD+TECH+HC-06+Bluetooth+Module&__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&ref=nb_sb_noss) (**With a plastic case**)
* A [5 Volt Relay](https://www.amazon.de/s?k=5+Volt+Relay&__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&ref=nb_sb_noss_2)
	> ![Relay](https://burle.me/api/images/ex-or-shock-relay-1.png)

* A [High Voltage Transformator](https://www.amazon.de/gp/product/B078ST3844/ref=ppx_yo_dt_b_asin_title_o00_s00?ie=UTF8&psc=1)
	> From 9 Volt to round about 1000 Kilo Volt.
	> But you can also use a different one which is not that strong.
![Transformator](https://burle.me/api/images/ex-or-shock-transformator-1.png)

* A [9 Volt Block Battery](https://www.amazon.de/s?k=9+Volt+Block+Battery)
	> Or more to switch them out if they are empty.

* A [9 Volt Battery Adapter](https://www.amazon.de/s?k=9+Volt+Battery+Adapter&__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&ref=nb_sb_noss_2)
	> ![9 Volt Battery with Adapter](https://burle.me/api/images/ex-or-shock-9-volt-battery-1.png)

* Six or more [1.5 Volt LR6 Batteries](https://www.amazon.de/s?k=1.5+Volt+LR6+Batteries&__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&ref=nb_sb_noss)
* A 1.5 Volt Battery Holder or a 9 Volt Battery Holder
	> Together you need at least 7 volt for powering the Arduino.
	> The Battery Holder should have a switch for powering the Arduino.
	> ![Battery Holder with Batteries](https://burle.me/api/images/ex-or-shock-1-5-volt-battery-holder-1.png)

* This [Fitness Cup](https://www.amazon.de/gp/product/B01LSM3GAE/ref=ppx_yo_dt_b_asin_title_o01_s00?ie=UTF8&psc=1)
	> If you use another one, you also need to change the 3D model.
	> Maybe you also want to buy more in case you break one.

* Many [Jumper Cables](https://www.amazon.de/s?k=Jumper+Cable&i=electronics&__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&ref=nb_sb_noss_2)
	> ![Jumper Cables](https://burle.me/api/images/ex-or-shock-jumper-cable-1.png)

* At least one [Red/Blue/Green LED](https://www.amazon.de/s?k=Arduino+LED&__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&ref=nb_sb_noss_2)
* Some 220 Ohm Resistors
* Some [PCB Boards](https://www.amazon.de/gp/product/B0734XYJPM/ref=ppx_yo_dt_b_asin_title_o01_s01?ie=UTF8&psc=1)
	> ![LEDs on PCB Board](https://burle.me/api/images/ex-or-shock-led-1.png)

* Some [Screws/Nuts and Standoff Spacer](https://www.amazon.de/gp/product/B07RP6CRD5/ref=ppx_yo_dt_b_asin_title_o01_s01?ie=UTF8&psc=1)
* Some [Shrink Tubing](https://www.amazon.de/ChiliTec-12000058-Chilitec-Schrumpfschlauch-Sortiment-100-teilig/dp/B003H9CJ1Y/ref=sr_1_6?__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&dchild=1&keywords=schrumpfschlauch&qid=1629294593&sr=8-6)
* Aluminium Foil
### 2.3 At best you have these tools
* A 3D Printer
	> But it is also possible to order the 3D printed parts online.

* A Crimping Tool
* Some Screwdrivers
* Some Pliers
* A Hot Glue Gun
* A Soldering Iron
* Some Sandpaper
* Acrylic Varnish Spray Can
	> In a color of your choice.

* Arduino Studio Programming Software
	> Is needed for the project and is for free.

* Maybe Fritzing Circuit Diagram Software
	> Is also for free.

* Maybe Blender 3D Software
	> Is also for free.

### 2.4 Project files
You need the following files from the ExOrShock [repository](https://github.com/likematthew/ExOrShock):
* 3D Objects Cover.stl and Housing.stl 
	> Can be found in /3D Object/V2.
	> For the 3D printed housing.

* ExOrShock.ino
	> The program that is running on the Arduino.

Other interesting files:
* Fritzing.fzz
	> Can be found in /Project.
	> This is the circuit diagram.

## 3. How to build it
### 3.1 Circuit diagram
![Circuit Diagram](https://burle.me/api/images/ex-or-shock-circuit-diagram.png)
This is an overview on how all the different parts are connected with each other and which pins each part uses.
### 3.2 Components
![Components](https://burle.me/api/images/ex-or-shock-cup-inside-3.png)
Here you can see how all the components need to be placed inside the housing. In case you are wondering why the bluetooth module isn´t marked, this is because it is located directly below the relay. The 9 volt battery adapter with the battery is glued on the cover of the housing and has it´s place opposite to the transformator. Don’t get confused by the look of the transformator, in this image I already covered it with plasticine to isolate it. Below the relay and the bluetooth module ist the USB hub and the power input of the Arduino and on the opposite side are the three LED holes. In front of the LED PCB board is the hole for the moisture level sensor cables that are coming from the cup. The transformator has a hole on the left and right side for it in the housing, these holes are for it´s two high voltage cables. I also isolated these both cables with plasticine.
### 3.3 Housing preparation
The housing needs to be 3D printed from the two 3D model files listed above under '*2.4 Project Files*' (Cover.stl, Housing.stl). You can print them with your own 3D printer or send them to an online printing provider. Which material you use is your choice.
> The material should be some kind of plastic.

If the STL files from above don’t work for your printer software, you can also open the two Blender files from the repository in Blender and export them in another format. You can also modify the 3D objects in Blender for your needs. The dimensions  for the housing are height 13.9 cm, length 11.8 cm, width 10.5 cm.
#### 3.3.1 Grinding and painting
After you printed the housing and cover, you may want to grind it with some fine sandpaper so you can paint it in a color of your choice.
![Grinded Housing](https://burle.me/api/images/ex-or-shock-housing-1.png) 
For the painting I used normal black acrylic varnish and some clear varnish after wards.
![Painted Housing](https://burle.me/api/images/ex-or-shock-housing-2.png)
### 3.4 Preparing parts for the build
#### 3.4.1 LED PCB board
![LED PCB Board](https://burle.me/api/images/ex-or-shock-led-1.png)
For the LEDs I used the smallest PCB board from the link under '*2. What you need for the build*', because it fits perfectly into the housing.
> You can also use any other PCB, but have in mind that the distance between the LEDs must be right to fit into the housing. If this is not the case you may have to change the housing object in Blender. 

Now you have to solder the LEDs (Red, Green, Blue) on the PCB board, at best you do it at the same spots as in the image above. Between the LEDs there need to be three holes so that the distance is right. The red one will be the bottom one in the housing. After you soldert the three LEDs in place, you need three 220 Ohm resistors were you solder one on each minus cable of all three LEDs. After that you can connect all three minus cables together, so that you only have one minus (female) cable for all three LEDs you need to plug in. At the plus end I used three (male) jumper cables in the same color as each LED. 
> As mentioned for all the cables in the build I used jumper cables that I just cut in half and soldered to the cables/pins of the components if needed. Some jumper cables you can just use as they are for some components.
> The female connector for the minus is needed because as you see in the '*3.1 Circuit diagram*', the minus cable of the LED PCB board connects to the one from the relay. For this you just have to create another minus cable with one female connector for the relay, one male connector for the LED PCB board and one male for the Arduino pin.

At last I put hot glue on all the parts on the bottom of the PCB to insolate and consolidate all components.
![LED PCB Board](https://burle.me/api/images/ex-or-shock-led-2.png)
#### 3.4.2 Moisture level sensor
![Moisture Level Sensor](https://burle.me/api/images/ex-or-shock-moisture-level-sensor-1.png)
![Moisture Level Sensor](https://burle.me/api/images/ex-or-shock-housing-moisture-level-sensor-1.png)
Because we need to glue both moisture level sensor inside the cup and lay the cables trough two holes to get them outside, we need to get rid of the white adapter plastic you can see in the first image. For this I just used a plier to rip it off. The three pins that are left over can be made hot and just pulled out. Now you should have three holes at the end of the moisture level sensor, one for GND, one for Voltage Input (VCC) and one for measuring (AOUT).
![Moisture Level Sensor](https://burle.me/api/images/ex-or-shock-moisture-level-sensor-2.png)
You can now solder your cables into all three holes as you see in the image above. Solder it so that the cables are on the bottom side of the sensor.
> Leave the cables long enough because they need to get through the housing after the installation.
> Also use cables without any connectors at the end or remove them, because then the cable may not fit into the hole of the housing where it needs to get through. You can solder the male connectors to the cables after:
> * The moisture level sensors are installed in the cup
> * The plus and minus cables from both sensors are connected with each other
> * The cables are isolated and layed through the hole in the housing
> 
> But this will also be mentioned later again in the manual.

![Moisture Level Sensor](https://burle.me/api/images/ex-or-shock-moisture-level-sensor-3.png)
I also hot glued all electric components at the top of the moisture level sensor to make them water proof.
![Moisture Level Sensor](https://burle.me/api/images/ex-or-shock-moisture-level-sensor-4.png)
At the end both moisture level sensors should look something like this.
### 3.5 Cover
![Threads and Screws](https://burle.me/api/images/ex-or-shock-threads-1.png)
These are the threads and screws that are used in this build.
First you want to test every hole of the cover to see if you can put the first screw from the image above through them. If they don’t fit you may want to make them a little bigger. I used the soldering iron for this.
![Battery Holder](https://burle.me/api/images/ex-or-shock-1-5-volt-battery-holder-1.png)
Now you can hot glue the 1.5 volt battery holder on the outer side of the cover.
![Battery Holder](https://burle.me/api/images/ex-or-shock-1-5-volt-battery-holder-2.png)
> The power cable should be on the same side as the power input holes for the Arduino.

![9 Volt Battery](https://burle.me/api/images/ex-or-shock-cup-inside-1.png)
Now you can also hot glue the 9 volt battery adapter on the inner side of the cover. Glue it to the opposite side of the transformator, as also mentioned in '*3.2 Components*', so nothing is in the way of the battery.
### 3.6 Cup
![Moisture Level Sensor](https://burle.me/api/images/ex-or-shock-housing-moisture-level-sensor-1.png)
After both moisture level sensors are prepared they need to be glued into the cup. For this we use the flat side with the dimensions on it. At first the lower moisture level sensor needs to be glued into the cup. For this I put the sensor on the lowest possible position and then marked the position on the outside where the whole needs to be. I burnt the hole inside with the soldering iron. After that I pulled the cables trough the hole and put hot glue on the side of the sensor which was going to be glued on the cup. Then I just pressed the sensor against the inner wall of the cup.
> Glue the sensor such that it is tilted away from the cup a little bit so that no fluid gets stuck behind.
> Because this can cause incorrect measurements.

![Moisture Level Sensor](https://burle.me/api/images/ex-or-shock-housing-moisture-level-sensor-2.png)
It should look like this from the outside.
![Moisture Level Sensor](https://burle.me/api/images/ex-or-shock-housing-moisture-level-sensor-3.png)
The other moisture level sensor should be placed on the very top of the cup as you see on the hot glue in the image above.
![Moisture Level Sensor](https://burle.me/api/images/ex-or-shock-housing-moisture-level-sensor-4.png)
At last you need to connect the two plus and minus cables together so you only have one plus and one minus cable for both sensors. Then you can put some shrink tubing around the cables to isolate them. Now you can also put all the cables through the bigger whole in the middle as you see in the image above.
After the cables are layed through the hole you can solder the male connectors to the two measurement, minus and plus cable.
> For this just cut four male jumper cables in half and solder them to the cables of the sensor.
### 3.7 Housing
#### 3.7.1 Installing threads and bluetooth module
![Threads and Screws](https://burle.me/api/images/ex-or-shock-threads-1.png)
These are the threads and screws that are used in this build.
##### 3.7.1.1 Cover threads
![Housing](https://burle.me/api/images/ex-or-shock-housing-threads-1.png)
At first I installed the threads for the cover, there is already a premade hole for these threads. I made the threads hot with the soldering iron and then pressed them into the hole. Make sure they stay right up. Then maybe fill the wholes around the threads with the soldering iron and make sure they stay in their places.
![Housing](https://burle.me/api/images/ex-or-shock-housing-threads-4.png)
![Housing](https://burle.me/api/images/ex-or-shock-housing-threads-5.png)
##### 3.7.1.2 Arduino threads
Then I installed the threads for the Arduino. For this I just put the Arduino in the right place, so the hubs are set right into the holes. Then I marked the four screw holes with a pen. After that I made each thread hot again with the soldering iron and pressed them in place.
![Housing](https://burle.me/api/images/ex-or-shock-housing-threads-2.png)
##### 3.7.1.3 LED PCB threads
Next I installed the screws/threads for the LED PCB board, there I also put it in place and marked the holes with a pen. Then I also made them hot with the soldering iron and pressed them into place.
> Make sure you don´t press the threads too hard into the housing.

![Housing](https://burle.me/api/images/ex-or-shock-housing-threads-3.png)
##### 3.7.1.4 Bluetooth module
The bluetooth module has no holes for screws, so we don´t need to install any threads for it. As I mentioned under '*2. What you need for the build*' you should get a bluetooth module with a plastic cover around it. Because now we can just hot glue that plastic cover inside our housing. The position is right above the two holes for the Arduino plugs.
> Leave enough space for the relay that will be installed above the bluetooth module.

##### 3.7.1.5 Relay threads
The relay has holes for screws again, so we need to install the threads. For this use the same procedure as described before, mark the holes and install the threads/screws with the soldering iron. I used the same threads/screws as for the LED PCB board.
#### 3.7.2 Installing all parts
Now that all the threads/screws for the parts exist, we can just put every part in it´s place and connect everything.
> You may have to create some connection cables out of the jumper cables to be able to connect everything with each other.

![Components](https://burle.me/api/images/ex-or-shock-cup-inside-3.png)
##### 3.7.2.1 Installing the transformator
The transformator is not glued into the housing, it is just held in place with some plasticine. Just put the cables of the transformator through the two holes, one on the left and one on the right, and then put it in place with plasticine. I also put the high voltage cables with plasticine in place. Now you can connect the transformator to the relay and the 9 volt battery.
##### 3.7.2.2 Creating the shock handle
![Handle](https://burle.me/api/images/ex-or-shock-handle-1.png)
For the handle I just used some alu foil and folded it till I got a nice thick layer. Then I unisolated the cables from the transformator at the end so that the alu foil can be connected to the wires. After that I just glued the two alu foil pieces in the right places as you can see in the image above.
![Handle](https://burle.me/api/images/ex-or-shock-handle-2.png)
You grab the handle like this, the thumb goes to the left alu foil and the rest of the hand to the right alu foil piece.
## 3.8 Software
You can find the program for the cup in the ExOrShock repository as mentioned in '*2. What you need for the build*'.
### 3.8.1 Setting the moisture level sensor values
As described below '*1. How the finished cup works*' at the beginning the cup will calibrate automatically the lowest value of the upper moisture level sensor. This means we don´t have to bother about this value, but we also need the breaking point values of both sensors when we surely can say that the cup is empty (More fluid, lower values / Less fluid, higher values). 
> You may ask now why we also just don´t calibrate these values at the beginning when the cup is still empty. This is because the higher values always differ between the fluid thats in the cup (Some is stickier, for example beer) and the values also differ from time to time because of the sensor itself.

We need to set a value manually in the program, as it´s described in the comments of the program. For this open the ExOrShock program in the Arduino Studio software. Then you may want to use the moisture level test program that I have written, you can find it in the ExOrShock repository in \Project\Moisture_Level_Test. With this you can evaluate the values by yourself. Now just fill the cup with beer and empty it again. During this procedur observate the values of both sensors. You mark the value that it shows directly after the cup is emptied. And now you set these both values in the ExOrShock program. Then you may have to do some trial and error and look if the values are correct to use. After you did this you don´t have to do it a second time. Now your cup is ready for use.
## 4. Usage
After you finished building the cup you can finally use it. This is a more accurate explanation then the one below '*1. How the finished cup works*'. Now is the time to program the Arduino with the ExOrShock program if you didn´t already do this.

Before you start you have to look if the battery pack on the bottom is full with batteries and the 9 volt battery, of the shocker, is plugged in correctly. If this is the case then you can fill the whole cup to the top with water.
> The water is needed for the calibration mode at the beginning. The calibration mode measures the lowest value of the upper moisture level sensor (More fluid, lower values / Less fluid, higher values). The program needs this value in order to detect when someone is starting to drink.

Now you can start the cup with switching on the battery pack on the bottom. 
> The battery pack powers the Arduino which is then starting to execute the program.

The cup is now going to calibrate itself while it is full of water. During the calibration the LEDs blink from top to bottom 15 times. After the calibration the blue LED blinks slowly. Now you have to empty the water and fill it with something you or the person using the cup wants to drink.

After the calibration you can connect yourself to the bluetooth module with a serial bluetooth app. After you connected yourself to the cup, you can send any number to it. The number is then interpreted as the seconds that the cup will wait for the person drinking to empty the cup.

After the seconds were received the blue LED stays lighted. This means that the cup is now waiting for someone to start drinking.

You grab the handle of the cup as mentioned above under '*3.7.2.2 Creating the shock handle*'. Then you start drinking near on the right side of the upper moisture level sensor. The moisture level sensor will notice that someone starts drinking and will start the countdown. Now the blue LED is blinking again and will blink faster and faster while the time is running out.
> If you now make a break, you wont get a shock until the time runs out.

If you finish the cup in time the green LED will shine. If not, the red LED will shine and you will get a shock from the transformator.
> The cup is evaluating the measurements on both sensors, once the cup has been emptied, the value of both sensors will be high enough so that the Arduino can say that the cup is empty.
> During the shock the relay closes and lets current run from the 9 volt battery trough the transformator and trough the hands of the person currently drinking. 9 volt are not much, but the transformator transforms them into many kilo volts. This will feel like a short sting/shock in the hand.

Now the first round is finished and the blue LED will start to blink slowly again. Here the cyrcle begins again and the cup is waiting for you again to send them the seconds via bluetooth.