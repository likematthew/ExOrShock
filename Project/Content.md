# ExOrShock
This is a guide on how to create a cup that will shock you if you don't empty it in a certain amount of time.
## Disclaimer
***This build contains high voltage parts that could injure you and those who use the cup.***
***I am not responsible for any damage caused by attempting to recreate or use the cup with these instructions.***
## 1. How The Cup Works

![ExOrShock](https://burle.me/api/images/ex-or-shock-cup-outside-1.png)

Before you begin, you need to fill up the cup with water to the top. Then start the cup by switching on an external battery pack located on the bottom. After switching on the cup, all three LEDs (Blue, Green, Red) light up. Then the calibration mode starts, which calibrates the lowest value of the upper moisture level sensor, which is located directly in the cup.
> As already mentioned, the cup must be filled with water for calibration.


During the calibration, the three LEDs start to light up 15 times from top to bottom. After the calibration, the blue LED flashes slowly. This means that the cup is waiting for a value from the Bluetooth module, which you have to connect to in order to send the seconds how long it should take to empty the cup. Now you can empty the cup and fill it with a drink of your choice. After the seconds have been received, the blue LED lights up continuously. Now someone can start drinking. When you tilt the cup to start drinking, the top moisture sensor will notice and the blue LED will start flashing again. The LED flashes faster and faster as the time runs out. If you have finished drinking the cup before the time is up, the green LED lights up. If you do not finish the cup before the time is up, the red LED will light up, and you will get shocked. Then the cycle starts again and the blue LED starts flashing until you send the time again via Bluetooth.
## 2. What You Need For The Build
### 2.1 Knowledge
In the best case, you already have programming knowledge and also know what an Arduino is and how to use it. 
> This manual does not teach you the basics of programming or electronics.


### 2.2 Parts
* An [Arduino Uno Microcontroller](https://www.amazon.de/s?k=Arduino+Uno&i=electronics&__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&ref=nb_sb_noss_2)
	> Or from another manufacturer.


* At least two [Moisture Level Sensors](https://www.amazon.de/Capacitive-Moisture-Corrosion-Resistant-Raspberry/dp/B07FLR13FS/ref=sr_1_2?__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&dchild=1&keywords=Arduino+Moisture+Level+Sensor&qid=1628542140&sr=8-2)

	> ![Moisture Level Sensor](https://burle.me/api/images/ex-or-shock-moisture-level-sensor-1.png =300x200)


* A [DSD TECH HC-06 Bluetooth Module](https://www.amazon.de/s?k=DSD+TECH+HC-06+Bluetooth+Module&__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&ref=nb_sb_noss)
	> With a plastic case.


* A [5 Volt Relay](https://www.amazon.de/s?k=5+Volt+Relay&__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&ref=nb_sb_noss_2)

	> ![Relay](https://burle.me/api/images/ex-or-shock-relay-1.png =300x300)


* A [High Voltage Transformer](https://www.amazon.de/gp/product/B078ST3844/ref=ppx_yo_dt_b_asin_title_o00_s00?ie=UTF8&psc=1)
	> Should transform 9 volts to round about 1000 kilo volts.

	> But you can also use a different one that is not that strong.

	> ![Transformer](https://burle.me/api/images/ex-or-shock-transformer-1.png =300x200)


* A [9 Volt Block Battery](https://www.amazon.de/s?k=9+Volt+Block+Battery)
	> Or more to switch them out if they are empty.


* A [9 Volt Battery Adapter](https://www.amazon.de/s?k=9+Volt+Battery+Adapter&__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&ref=nb_sb_noss_2)

	> ![9 Volt Battery with Adapter](https://burle.me/api/images/ex-or-shock-9-volt-battery-1.png =300x300)


* Six or more [1.5 Volt LR6 Batteries](https://www.amazon.de/s?k=1.5+Volt+LR6+Batteries&__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&ref=nb_sb_noss)
* A 1.5 Volt Battery Holder or a 9 Volt Battery Holder
	> Together you need at least 7 volts for powering the Arduino.

	> The battery holder should have a switch if possible.

	> ![Battery Holder with Batteries](https://burle.me/api/images/ex-or-shock-1-5-volt-battery-holder-1.png =300x200)


* This [Fitness Cup](https://www.amazon.de/gp/product/B01LSM3GAE/ref=ppx_yo_dt_b_asin_title_o01_s00?ie=UTF8&psc=1)
	> If you use another one, you also need to change the 3D model.

	> Maybe you also want to get more in case you break one.


* Many [Jumper Cables](https://www.amazon.de/s?k=Jumper+Cable&i=electronics&__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&ref=nb_sb_noss_2)

	> ![Jumper Cables](https://burle.me/api/images/ex-or-shock-jumper-cable-1.png =300x220)


* At least one [Red/Blue/Green LED](https://www.amazon.de/s?k=Arduino+LED&__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&ref=nb_sb_noss_2)
* Some 220 Ohm Resistors
* Some [PCB Boards](https://www.amazon.de/gp/product/B0734XYJPM/ref=ppx_yo_dt_b_asin_title_o01_s01?ie=UTF8&psc=1)

	> ![LED PCB Board](https://burle.me/api/images/ex-or-shock-led-1.png =300x200)


* Some [Screws/Nuts and Standoff Spacer](https://www.amazon.de/gp/product/B07RP6CRD5/ref=ppx_yo_dt_b_asin_title_o01_s01?ie=UTF8&psc=1)
* Some [Shrink Tubing](https://www.amazon.de/ChiliTec-12000058-Chilitec-Schrumpfschlauch-Sortiment-100-teilig/dp/B003H9CJ1Y/ref=sr_1_6?__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&dchild=1&keywords=schrumpfschlauch&qid=1629294593&sr=8-6)
* Aluminium Foil
### 2.3 Tools
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


### 2.4 Project Files
You need the following files from the ExOrShock [repository](https://github.com/likematthew/ExOrShock):
* 3D Objects Cover.stl and Housing.stl 
	> Can be found in /3D Object/V2.

	> For the 3D printed housing.


* ExOrShock.ino
	> The program that is running on the Arduino.


* Fritzing.fzz
	> Can be found in /Project.

	> This is the circuit diagram.


## 3. How To Build It
### 3.1 Circuit Diagram

![Circuit Diagram](https://burle.me/api/images/ex-or-shock-fritzing-1.png)

This is an overview of how all the different parts connect together and what pins each part uses.
### 3.2 Components

![Components](https://burle.me/api/images/ex-or-shock-cup-inside-3.png)

Here you can see how all components have to be placed in the housing. In case you are wondering why the Bluetooth module is not checked, it is because it is right under the relay. The 9 volt battery adapter with the battery is glued to the cover of the housing and has its place opposite the transformer. Don't get confused by the transformer's appearance, in this picture I've already covered it with Plasticine to insulate it. Below the relay and the Bluetooth module are the USB hub and the power input of the Arduino. On the opposite side are the three holes for the LEDs. In front of the LED board is the hole for the moisture sensor cables that come out of the cup. The transformer has a hole in the housing on the left and right for its two high-voltage cables. I also insulated these two cables with Plasticine.
### 3.3 Housing Preparation
The housing must be 3D printed from the two 3D model files listed under '*2.4 Project Files*' (Cover.stl, Housing.stl). You can print these with your own 3D printer or send them to an online print provider. The material you use is your choice.
> The material should be some kind of plastic.


If the STL files from above don't work for your printer software, you can also open the two Blender files from the repository in Blender and export them in a different format. You can also customize the 3D objects in Blender to suit your needs. The dimensions for the case are height 13.9 cm, length 11.8 cm, width 10.5 cm.
#### 3.3.1 Grinding And Painting
After you've printed the case and cover, you can sand it with some fine sandpaper, so you can paint it in a color of your choice.

![Grinded Housing](https://burle.me/api/images/ex-or-shock-housing-1.png =500x380)

For the painting I used normal black acrylic varnish and then some clear varnish.

![Painted Housing](https://burle.me/api/images/ex-or-shock-housing-2.png =500x380)

### 3.4 Parts Preparation
#### 3.4.1 LED PCB Board

![LED PCB Board](https://burle.me/api/images/ex-or-shock-led-1.png =500x350)

For the LEDs I used the smallest circuit board from the link under '*2. What You Need For The Build*', because it fits perfectly into the housing.
> You can also use any other circuit board, but note that the distance between the LEDs must be correct in order to fit into the housing. If they don't, you may need to change the housing object in Blender.


Now you have to solder the LEDs (red, green, blue) onto the board, preferably in the same places as shown in the picture above. There must be three holes between the LEDs so that the distance is correct. The red LED is the lowest in the housing. After you've soldered the three LEDs in place, you will need three 220 ohm resistors, to which you will solder one to each negative lead of all three LEDs. Then you can connect all three negative cables together so that you only have one negative cable (female) for all three LEDs that you can just plug into the Arduino. At the plus end, I used three (male) jumper cables, each in the same color as the respective LED.
> As mentioned earlier, I used jumper cables for all cables in the build, which I only cut in half and soldered to the cables / pins of the components if necessary.

> The female connector for the minus is needed because, as you see in the '*3.1 Circuit Diagram*' topic, the minus cable of the LED PCB board connects to the one from the relay. For this you just have to create another minus cable with one female connector for the relay, one male connector for the LED PCB board and one male for the Arduino pin.


Lastly, I applied hot glue to all the parts on the lower side of the board to isolate and consolidate all components.

![LED PCB Board](https://burle.me/api/images/ex-or-shock-led-2.png =800x400)

#### 3.4.2 Moisture Level Sensor

![Moisture Level Sensor](https://burle.me/api/images/ex-or-shock-moisture-level-sensor-1.png  =500x350)

![Moisture Level Sensor](https://burle.me/api/images/ex-or-shock-housing-moisture-level-sensor-1.png =500x650)

Since we are going to glue both moisture sensors into the cup and route the cables through two holes to bring them outside, we need to remove the white adapter plastic that you can see in the first picture. For this, I just used pliers to tear it off. The three remaining pins can be made hot and simply pulled out. Now you should have three holes at the end of the humidity sensor, one for GND, one for the voltage input (VCC) and one for measuring (AOUT).

![Moisture Level Sensor](https://burle.me/api/images/ex-or-shock-housing-moisture-level-sensor-2.png =500x500)

You can now solder your cables into all three holes, as you can see in the picture above. Solder it so that the wires are on the bottom of the sensor.
> Leave the cables long enough, as you will have to run the cables through the housing after installation.

> Also use cables without a plug at the end or remove them, as the cable may then not fit into the hole in the housing where it has to go through. You can solder the connectors to the cables after:

> * The moisture sensors have been built into the cup

> * The plus and minus cables of both sensors have been connected to one another

> * The cables have been insulated and routed through the hole in the housing

> But this will also be mentioned again later in the manual.


![Moisture Level Sensor](https://burle.me/api/images/ex-or-shock-moisture-level-sensor-3.png =500x275)

I also heat glued all the electrical components to the top of the moisture sensor to make them waterproof.

![Moisture Level Sensor](https://burle.me/api/images/ex-or-shock-moisture-level-sensor-4.png =500x300)

In the end, both moisture sensors should look something like this.
### 3.5 Cover

![Threads and Screws](https://burle.me/api/images/ex-or-shock-threads-1.png =300x150)

These are the threads and bolts that will be used in this build.
First, you may want to test each hole in the cover to see if you can stick the first screw from the picture above through it. If they don't fit, you might want to make them a little bigger. I used the soldering iron for this.

![Battery Holder](https://burle.me/api/images/ex-or-shock-1-5-volt-battery-holder-1.png =500x350)

Now you can glue the 1.5 volt battery holder to the outside of the cover with hot glue.

![Battery Holder](https://burle.me/api/images/ex-or-shock-1-5-volt-battery-holder-2.png =500x500)

> The power wire should be on the same side as the power input holes for the Arduino.


![9 Volt Battery](https://burle.me/api/images/ex-or-shock-cup-inside-1.png =500x350)

Now you can hot glue the 9 volt battery adapter on the inside of the cover. Glue it to the opposite side of the transformer, as also mentioned in '*3.2 Components*', so that nothing gets in the way of the battery.
### 3.6 Cup

![Moisture Level Sensor](https://burle.me/api/images/ex-or-shock-housing-moisture-level-sensor-1.png =500x650)

After both moisture level sensors are prepared, they need to be glued into the cup. For this, we use the flat side with the measurements on it. First, the lower moisture sensor has to be glued into the cup. To do this, I set the sensor to the lowest possible position and then marked the position on the outside where cables need to go through. I burned the hole inside with the soldering iron. After that, I pulled the wires through the hole and put hot glue on the side of the sensor that was going to be glued into the cup. Then I just pressed the sensor against the inside wall of the cup.
> Stick the sensor so that it is tilted a bit away from the cup so that no liquid gets stuck behind it, because this can lead to incorrect measurements.


![Moisture Level Sensor](https://burle.me/api/images/ex-or-shock-housing-moisture-level-sensor-2.png =500x650)

This is how it should look like from the outside.

![Moisture Level Sensor](https://burle.me/api/images/ex-or-shock-housing-moisture-level-sensor-3.png =500x625)

The other moisture sensor should be placed at the very top of the cup as you can see on the hot glue in the picture above.

![Moisture Level Sensor](https://burle.me/api/images/ex-or-shock-housing-moisture-level-sensor-4.png =500x650)

The last thing you have to do is connect the two plus and minus cables together so that you only have one plus and one minus cable for both sensors. Then you can put some shrink tubing around the cables to insulate them. Now you can also run all the cables through the larger hole in the middle, as you can see in the picture above. After the cables have been put through the hole, you can solder the (male) plugs to the two measuring cables and the positive and negative cable.
> Simply cut four male jumper cables in half and solder them to the cables of the sensor.


### 3.7 Housing
#### 3.7.1 Threads And Bluetooth Module

![Threads and Screws](https://burle.me/api/images/ex-or-shock-threads-1.png =300x150)

These are the threads and bolts that will be used in this build.
##### 3.7.1.1 Cover Threads

![Housing](https://burle.me/api/images/ex-or-shock-housing-threads-1.png =500x375)

First I mounted the threads for the cover, a pre-made hole is already available for these threads. I made the threads hot with the soldering iron and then pushed them into the hole. Make sure they stay upright. Then maybe fill the holes around the threads with the soldering iron, making sure they stay in place.

![Housing](https://burle.me/api/images/ex-or-shock-housing-threads-4.png =500x450)

![Housing](https://burle.me/api/images/ex-or-shock-housing-threads-5.png =500x625)

##### 3.7.1.2 Arduino Threads
Then I installed the threads for the Arduino. To do this, I simply put the Arduino in the right place so that the hubs are placed directly in the holes. Then I marked the four screw holes with a pen. Then I heated up each thread again with the soldering iron and pressed it firmly.

![Housing](https://burle.me/api/images/ex-or-shock-housing-threads-2.png =500x375)

##### 3.7.1.3 LED PCB Threads
Next I mounted the screws / threads for the LED board, attached them there and marked the holes with a pen. Then I also made it hot with the soldering iron and pressed it into place.
> Make sure that you do not press the threads too hard into the housing.


![Housing](https://burle.me/api/images/ex-or-shock-housing-threads-3.png =500x500)

##### 3.7.1.4 Bluetooth Module
The Bluetooth module doesn't have any holes for screws, so we don't need to install threads for it. As I said under '*2. What You Need For The Build*', you should get a Bluetooth module with a plastic cover around it. Because now we can simply glue this plastic cover into our housing with hot glue. The position is just above the two holes for the Arduino connectors.
> Leave enough space for the relay that will be installed over the Bluetooth module.


##### 3.7.1.5 Relay Threads
The relay has holes for screws again, so we need to install the threads. To do this, proceed as described above, mark the holes and mount the threads / screws with the soldering iron. I used the same threads / screws as for the LED board.
#### 3.7.2 Parts Installation
Now that all the threads / screws for the parts are in place, we can simply put each part in its place and connect everything.
> You may need to make some connection cables out of the jumper cables in order to be able to connect everything together.


![Components](https://burle.me/api/images/ex-or-shock-cup-inside-3.png =800x550)

##### 3.7.2.1 Transformer Installation
The transformer is not glued into the housing, but just held in place with Plasticine. Just put the transformer's wires through the two holes, one on the left and one on the right, then secure it with Plasticine. I also attached the high voltage cables with Plasticine. Now you can connect the transformer to the relay and the 9 volt battery.
##### 3.7.2.2 Handle Installation

![Handle](https://burle.me/api/images/ex-or-shock-handle-1.png =500x650)

For the handle I just used some aluminum foil and folded it until I got a nice layer. Then I stripped the cables from the transformer at the end so that the aluminum foil could be connected to the wires. Then I just glued the two pieces of aluminum foil in the right places, as you can see in the picture above and below.

![Handle](https://burle.me/api/images/ex-or-shock-handle-2.png =500x600)

You grasp the handle so that the thumb goes to the left piece of aluminum foil and the rest of the hand to the right piece of aluminum foil.
## 3.8 Software
You can find the program for the cup in the ExOrShock repository as it is described in '*2. What You Need For The Build*'.
### 3.8.1 Setting The Moisture Level Sensor Values
As described below '*1. How The Cup Works*' at the beginning, the cup automatically calibrates the lowest value of the upper moisture sensor. This means that we don't have to worry about this value, but we also need the predetermined breaking values ​​of both sensors if we can say with certainty that the cup is empty (more liquid, lower values ​​/ less liquid, higher values).
> You may now be wondering why we don't calibrate these values ​​right at the beginning when the cup is still empty. This is because the higher values ​​always differ between the liquid in the cup (some are stickier, e.g., beer) and the values ​​also vary from time to time due to the sensor itself.


![Program](https://burle.me/api/images/ex-or-shock-program-1.png =500x450)

We have to set a value manually in the program, as described in the comments of the program. To do this, open the ExOrShock program in the Arduino Studio software. Then you might want to use the moisture test program I wrote, which you can find in the ExOrShock repository under '*\Project\Moisture_Level_Test*'. This allows you to evaluate the values ​​yourself. Now just fill the cup with beer and empty it again. While doing this, observe the values ​​of both sensors. Mark the displayed value immediately after emptying the cup. And now set these two values ​​in the ExOrShock program. Then you may have to do a few tries and see if the values ​​are correct for use. After you've done this, you don't have to do it a second time. Your cup is now ready to use.
## 4. Usage

Now that you've finished building the cup, you're finally ready to use it. This is a more accurate explanation than the '*1. How The Cup Works*'. Now is the time to program the Arduino using the ExOrShock program if you haven't already.

Before you begin, you must check that the battery pack on the underside is full of batteries and that the shocker's 9 volt battery is properly inserted. If so, you can fill the whole cup with water to the top.
> At the beginning, the water is required for the calibration mode. The calibration mode measures the lowest value of the upper moisture level sensor (more liquid, lower values ​​/ less liquid, higher values). The program needs this value to recognize when someone starts to drink.


Now you can start the cup by switching on the battery pack on the bottom.
> The battery supplies power to the Arduino, which then starts executing the program.


The cup will now calibrate itself while it is filled with water. During the calibration, the LEDs flash 15 times from top to bottom. After the calibration, the blue LED flashes slowly. Now you need to drain the water and fill it with something that you or the person using the cup will want to drink.

After calibration, you can connect to the Bluetooth module using a Bluetooth serial app. After connecting to the cup, you can send it any number. The number is then interpreted as the seconds the cup waits for the person drinking to empty the cup.

After the seconds have been received, the blue LED remains lit. This means that the cup is now waiting for someone to start drinking.

You grip the handle of the cup as described above below '*3.7.2.2 Handle Installation*'. Then start drinking near the right side of the top moisture level sensor. The sensor detects that someone is starting to drink and starts the countdown. Now the blue LED will flash again and will flash faster and faster as the time runs out.
> If you take a break now, you won't get a shock until the time is up.


If you have finished the cup in time, the green LED lights up. If not, the red LED will light, and you will receive a shock from the transformer.
> The cup evaluates the measured values ​​of both sensors, as soon as the cup has been emptied, the value of both sensors is so high that the Arduino can tell that the cup is empty.

> During the shock, the relay closes, allowing current from the 9 volt battery to flow through the transformer and through the hands of the person who is drinking. 9 volts are not much, but the transformer converts it into many kilo volts. This will feel like a short stab / shock in your hand.


The first lap is now over and the blue LED starts to flash slowly again. Here the cycle starts all over again and the cup waits again for you to send it the seconds via Bluetooth.
## Thanks
Thank you for reading this manual or even building this cup. I hope your final results are as you expected!