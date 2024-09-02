# Egg Basket Java Game
A simple java game made using swing.

## How to run ?
### Installation
<i>Pre-requisite, Java must be installed in the system</i>

<i>Also, edit the path to sprites on the following locations: 
- [Egg.java:42](https://github.com/IshaniSen2612/Egg-Basket-Java-Game/blob/e41022e419ba7559b606d59f048075e989966961/src/Egg.java#L42)
- [Egg.java:70](https://github.com/IshaniSen2612/Egg-Basket-Java-Game/blob/e41022e419ba7559b606d59f048075e989966961/src/Egg.java#L70)
- [Player.java:64](https://github.com/IshaniSen2612/Egg-Basket-Java-Game/blob/e41022e419ba7559b606d59f048075e989966961/src/Player.java#L64)

The images are provide in the following location: [src/Assets/Sprites](https://github.com/IshaniSen2612/Egg-Basket-Java-Game/tree/main/src/Assets/Sprites)
</i>

Clone the repository
```
git clone https://github.com/IshaniSen2612/Egg-Basket-Java-Game.git
```
Change directory to the repo folder
```
cd Egg-Basket-Java-Game
```
Create a `bin` or any output folder
```
mkdir bin
```
Compile all the scripts and direct the output to the bin folder
```
javac -d ./bin/ ./src/*.java
```
Move to the bin folder and run the application
```
cd bin
java App
```
The game should now open in a new window.

### Gameplay instruction
- Press left and right arrow keys to move the player.
- Catch the eggs in the basket.
- Failing to catch eggs for 3 times will result in a game over.

## What have I learned from this ?
- I learned to use swing to create applications with GUI in java.
- I learned to use multithreading to optimize applications and improve performance.
- I learned basic game development skills.

## TODO
- Add a HUD
- Add audio
