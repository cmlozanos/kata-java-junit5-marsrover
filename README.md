# kata-java-junit5-marsrover
Repository created for kata mars rover


## Kata problem specification
### Problem Description
You are part of the team that explores Mars by sending remotely controlled vehicles to the surface of
the planet. 

Write an idiomatic <ins>piece of software that translates the commands sent from earth to actions executed by the rover </ins> yielding a final state..

<ins>When the rover touches down on Mars, it is initialized with its current coordinates and the direction
it is facing.</ins>

These could be any coordinates, supplied as arguments (x, y, direction) e.g. (4,2, EAST).

### PartI
The rover is given a command string which contains multiple commands. 

This string must then be broken into each individual command and that command then executed. Implement the following commands:
F -> Move forward on current heading
B -> Move backwards on current heading
L -> Rotate left by 90 degrees
R -> Rotate right by 90 degrees

An example command might be FLFFFRFLB

Once the full command string has been followed, the rover reports it's current coordinates and heading in the format (6, 4) NORTH

### Split the problem by steps
* Step 1 - We need a robot named Rover
* Step 2 - We need that when rover get initialized will have the next arguments (x,y,direction) as example we have 4,2,EAST as parameters
* Step 3 - We need a report from the rover with it's current coordinates and heading, x,y,direction parameters
* Step 3.1 - We need a report formatted as "(6, 4) NORTH"
* Step 4 - Given an individual command F and rover initialized with (4,2, EAST) When rover translate the command Should move one step in Y axis