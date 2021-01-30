package com.kata.marsrover;

import com.kata.marsrover.enumeration.Command;
import com.kata.marsrover.enumeration.Direction;

public class RoverTranslator {
	
	public Rover translate(String command, Rover rover) {

		switch (Command.valueOf(command)){
			case B: {
				applyCommandBackward(command, rover);
				break;
			}
			case F: {
				applyCommandForward(command, rover);
				break;
			}
			case R: {
				applyCommandRight(rover);
				break;
			}
			case L: {
				applyCommandLeft(rover);
				break;
			}
		}

		return new Rover(rover.getX(), rover.getY(), rover.getDirection().name());
	}

	private void applyCommandLeft(Rover rover) {
		switch (rover.getDirection()){
		case NORTH: {
			rover.setDirection(Direction.WEST);
			break;
		}
		case EAST: {
			rover.setDirection(Direction.NORTH);
			break;
		}
		case SOUTH:{
			rover.setDirection(Direction.EAST);
			break;
		}
		case WEST:{
			rover.setDirection(Direction.SOUTH);
			break;
		}
		}
	}
	
	private void applyCommandRight(Rover rover) {
		switch (rover.getDirection()){
			case NORTH: {
				rover.setDirection(Direction.EAST);
				break;
			}
			case EAST: {
				rover.setDirection(Direction.SOUTH);
				break;
			}
			case SOUTH:{
				rover.setDirection(Direction.WEST);
				break;
			}
			case WEST:{
				rover.setDirection(Direction.NORTH);
				break;
			}
		}
	}

	private void applyCommandForward(String command, Rover rover) {
		switch (rover.getDirection()) { 
			case WEST: {
				rover.setX(rover.getX() - 1);
				break;
			}
			case NORTH: {
				rover.setY(rover.getY() + 1);
				break;
			}
			case SOUTH: {
				rover.setY(rover.getY() - 1);
				break;
			}
			case EAST: {
				rover.setX(rover.getX() + 1);
				break;
			}
		}
	}

	private void applyCommandBackward(String command, Rover rover) {
		switch (rover.getDirection()) {
			case WEST: {
				rover.setX(rover.getX() + 1);
				break;
			}
			case NORTH: {
				rover.setY(rover.getY() - 1);
				break;
			}
			case SOUTH: {
				rover.setY(rover.getY() + 1);
				break;
			}
			case EAST: {
				rover.setX(rover.getX() - 1);
				break;
			}
		}
	}
}