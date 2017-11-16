package br.com.contaazul.desafio.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.contaazul.desafio.business.RobotExplorerBO;
import br.com.contaazul.desafio.model.Direction;
import br.com.contaazul.desafio.model.RobotExplorer;
import br.com.contaazul.desafio.model.Rotation;

@Component
public class RobotExplorerBOImpl implements RobotExplorerBO {

	private static final char MOVE_INSTRUCTION = 'M';
	private static final int FIELD_MIN = 0;
	private static final int FIELD_MAX = 4;

	@Autowired
	RobotExplorer robotExplorer;

	@Override
	public RobotExplorer navigation(String instructions) throws Exception {
		robotExplorer.resetRobot();
		if (!isValidCommands(instructions)) {
			throw new Exception();
		}

		for (char instruction : instructions.toCharArray()) {

			if (isMoveCommand(instruction)) {
				operateMove();

			} else if (isRotateCommand(instruction)) {
				Rotation rotationEnum = Rotation.getRotation(instruction);
				operateRotateTo(rotationEnum);
			}
		}

		return robotExplorer;
	}

	@Override
	public boolean isValidCommands(String instructions) {
		boolean isValid = false;

		String moveLimits = new String(new char[FIELD_MAX + 1]).replace("\0", String.valueOf(MOVE_INSTRUCTION));

		if (!instructions.contains(moveLimits) && instructions.matches("^[LRM]*")) {
			isValid = true;
		}

		return isValid;
	}

	@Override
	public boolean isMoveCommand(char instruction) {
		return MOVE_INSTRUCTION == instruction;
	}

	@Override
	public boolean isRotateCommand(char instruction) {
		return Rotation.getRotation(instruction) != null;
	}

	@Override
	public boolean isValidMove(int newCoordX, int newCoordY) {
		return newCoordX <= FIELD_MAX && newCoordX >= FIELD_MIN && newCoordY >= FIELD_MIN && newCoordY <= FIELD_MAX;
	}

	private void operateMove() throws Exception {

		int newCoordX = robotExplorer.getCoordX();
		int newCoordY = robotExplorer.getCoordY();

		Direction direction = robotExplorer.getDirection();
		switch (direction) {
		case NORTH:
			newCoordY++;
			break;
		case SOUTH:
			newCoordY--;
			break;

		case EAST:
			newCoordX++;
			break;
		case WEST:
			newCoordX--;
			break;
		}

		if (isValidMove(newCoordX, newCoordY)) {
			robotExplorer.setCoordX(newCoordX);
			robotExplorer.setCoordY(newCoordY);

			System.out.println("Operate Move: Robot in (" + robotExplorer.getCoordX() + "," + robotExplorer.getCoordY()
					+ "," + robotExplorer.getDirection().getPosition() + ")");
		} else {
			System.out.println("Operate Move: ERROR Robot in (" + newCoordX + "," + newCoordY + ","
					+ robotExplorer.getDirection().getPosition() + ")");
			throw new Exception();
		}
	}

	private void operateRotateTo(Rotation toRotationEnum) {
		Direction orientationEnum = robotExplorer.getDirection();

		Direction newDirection = Direction.getDirectionRotation(orientationEnum, toRotationEnum);
		robotExplorer.setDirection(newDirection);

		System.out.println("Operate Rotate To: Robot in (" + robotExplorer.getCoordX() + "," + robotExplorer.getCoordY()
				+ "," + robotExplorer.getDirection().getPosition() + ")");
	}

}
