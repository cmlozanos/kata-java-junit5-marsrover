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
* Step 4 - Given an individual command F and rover initialized with (4,2, EAST) When rover translate the command Should move one step up in Y axis
* Step 4.1 - Given an individual command B and rover initialized with (1,2, EAST) When rover translate the command Should move one step down in Y axis
* Step 4.2 - Given an individual command F and rover initialized with (4,2, WEST) When rover translate the command Should move one step down in Y axis
* Step 4.3 - Given an individual command B and rover initialized with (1,2, WEST) When rover translate the command Should move one step up in Y axis
* Step 4.4 - Given an individual command F and rover initialized with (4,2, NORTH) When rover translate the command Should move one step up in X axis
* Step 4.5 - Given an individual command B and rover initialized with (1,2, NORTH) When rover translate the command Should move one step down in X axis
* Step 4.6 - Given an individual command F and rover initialized with (4,2, SOUTH) When rover translate the command Should move one step down in X axis
* Step 4.7 - Given an individual command B and rover initialized with (1,2, SOUTH) When rover translate the command Should move one step up in X axis
* Step 5 - When rover its initialized with invalid direction we expect an illegal argument exception
* Step 6 - When rover translator receive an invalid command we expect an illegal argument exception
* Step 7 - Given an individual command R and rover initialized with direction NORTH rover should rotate to EAST
* Step 7.1 - Given an individual command R and rover initialized with direction EAST rover should rotate to SOUTH
* Step 7.2 - Given an individual command R and rover initialized with direction SOUTH rover should rotate to WEST
* Step 7.3 - Given an individual command R and rover initialized with direction WEST rover should rotate to NORTH
* Step 7.4 - Given an individual command L and rover initialized with direction NORTH rover should rotate to WEST
* Step 7.5 - Given an individual command L and rover initialized with direction WEST rover should rotate to SOUTH
* Step 7.6 - Given an individual command L and rover initialized with direction SOUTH rover should rotate to EAST
* Step 7.7 - Given an individual command L and rover initialized with direction EAST rover should rotate to NORTH
* Step 8 - Add X and Y as Point
* Step 9 - Add Multiple commands