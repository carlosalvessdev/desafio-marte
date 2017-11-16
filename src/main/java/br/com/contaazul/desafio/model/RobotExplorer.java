package br.com.contaazul.desafio.model;

import org.springframework.stereotype.Component;

@Component
public class RobotExplorer {
	private int coordX;
    private int coordY;
    private Direction direction;
    
    public RobotExplorer() {
        this.resetRobot();
    }
    
    public void resetRobot() {
        this.coordX = 0;
        this.coordY = 0;
        this.direction = Direction.NORTH;
    }

	public int getCoordX() {
		return coordX;
	}

	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}

	public int getCoordY() {
		return coordY;
	}

	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

    
}
