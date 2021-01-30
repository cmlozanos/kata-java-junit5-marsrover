package com.kata.marsrover;

import com.kata.marsrover.enumeration.Command;
import com.kata.marsrover.enumeration.Direction;

public class RoverTranslator {
	
	public Rover translate(String command, Rover rover) {

		Point point = rover.getPoint();
		Direction direction = rover.getDirection();
		
		switch (Command.valueOf(command)){
			case B: {
				point = applyCommandBackward(rover);
				break;
			}
			case F: {
				point = applyCommandForward(rover);
				break;
			}
			case R: {
				direction = applyCommandRight(rover.getDirection());
				break;
			}
			case L: {
				direction = applyCommandLeft(rover.getDirection());
				break;
			}
		}

		return new Rover(point, direction);
	}

	private Direction applyCommandLeft(Direction direction) {
		switch (direction){
		case NORTH: {
			return Direction.WEST;
		}
		case EAST: {
			return Direction.NORTH;
		}
		case SOUTH:{
			return Direction.EAST;
		}
		case WEST:{
			return Direction.SOUTH;
		}
		}
		return direction;
	}
	
	private Direction applyCommandRight(Direction direction) {
		switch (direction){
			case NORTH: {
				return Direction.EAST;
			}
			case EAST: {
				return Direction.SOUTH;
			}
			case SOUTH:{
				return Direction.WEST;
			}
			case WEST:{
				return Direction.NORTH;
			}
		}
		return direction;
	}

	private Point applyCommandForward(Rover rover) {
		switch (rover.getDirection()) { 
			case WEST: {
				return new Point(rover.getPoint().getX() - 1, rover.getPoint().getY());
			}
			case NORTH: {
				return new Point(rover.getPoint().getX(), rover.getPoint().getY() + 1 );
			}
			case SOUTH: {
				return new Point(rover.getPoint().getX(), rover.getPoint().getY() - 1 );
			}
			case EAST: {
				return new Point(rover.getPoint().getX() + 1, rover.getPoint().getY());
			}
		}
		return rover.getPoint();
	}

	private Point applyCommandBackward(Rover rover) {
		switch (rover.getDirection()) {
			case WEST: {
				return new Point(rover.getPoint().getX() + 1, rover.getPoint().getY());
			}
			case NORTH: {
				return new Point(rover.getPoint().getX(), rover.getPoint().getY() - 1 );
			}
			case SOUTH: {
				return new Point(rover.getPoint().getX(), rover.getPoint().getY() + 1 );
			}
			case EAST: {
				return new Point(rover.getPoint().getX() - 1, rover.getPoint().getY());
			}
		}
		return rover.getPoint();
	}
}