package com.kata.marsrover;

import java.util.stream.Stream;

import com.kata.marsrover.enumeration.Command;
import com.kata.marsrover.enumeration.Direction;

public class Application {

	public static void main(String[] args) {
		int x, y;
		Direction direction;
		String commands;
		try {
			x = Integer.parseInt(args[0]);
			y = Integer.parseInt(args[1]);
			direction = Direction.valueOf(args[2]);
			commands = args[3];
			Stream.of(commands).forEach(command -> Command.valueOf(command));
		} catch (ArrayIndexOutOfBoundsException | IllegalArgumentException iae) {
			printHelp();
			return;
		}
		Rover rover = new Rover(x, y, direction.name());
		rover.navigate(commands);
		System.out.println(rover.report());
	}

	private static void printHelp() {
		System.out.println("****************************************");
		System.out.println("There was an error launching the rover application:");
		System.out.println("How to use: x y direction command");
		System.out.println("example: 0 0 NORTH FLFFFLFFRFRBLB");
		System.out.println("Valid directions: NORTH EAST SOUTH WEST");
		System.out.println("Valid commands: F B R L");
		System.out.println(" F - Forward");
		System.out.println(" B - Backward");
		System.out.println(" R - Right");
		System.out.println(" L - Left");
		System.out.println("****************************************");
	}

}
