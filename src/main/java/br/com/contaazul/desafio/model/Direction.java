package br.com.contaazul.desafio.model;

import java.util.HashMap;
import java.util.Map;



public enum Direction {
	 NORTH("N", 0), SOUTH("S", 180), EAST("E", 90), WEST("W", 270);
	
	private String position;
    private int value;
    private static final Map<Integer, Direction> orientationMap = new HashMap<>();
    
    static {
        for (Direction direction : Direction.values()) {
            orientationMap.put(direction.getValue(), direction);
        }
    }

    Direction(final String position, final int value) {
        this.position = position;
        this.value = value;
    }

    public String getPosition() {
        return this.position;
    }

    public int getValue() {
        return this.value;
    }

    public static Direction getDirectionRotation(Direction direction, Rotation rotation) {
        Direction result;
        final int value = direction.getValue() + rotation.getValue();
        if (value < NORTH.getValue()) {
            result = WEST;
        } else if (value > WEST.getValue()) {
            result = NORTH;
        } else {
            result = orientationMap.get(value);
        }
        return result;
    }

    public static Direction rotate(Direction direction, Rotation rotation) {
        return getDirectionRotation(direction, rotation);
    }

}
