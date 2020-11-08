package it.unibo.oop.lab.exception1;

/**
 * Models a generic Robot.
 * 
 */
public class Robot {

    private static final int BATTERY_EMPTY = 0;
    private static final int MOVEMENT_DELTA = 1;
    private static final double MOVEMENT_DELTA_CONSUMPTION = 0.1;
    private static final double BATTERY_FULL = 100;

    private double batteryLevel;
    private final RobotEnvironment environment;
    private final String robotName;


    public Robot(final String robotName, final double batteryLevel) {
        this.batteryLevel = batteryLevel;
        this.environment = new RobotEnvironment(new RobotPosition(0, 0));
        this.robotName = robotName;
    }

    public void moveUp() {
        moveToPosition(environment.getCurrPosX(), this.environment.getCurrPosY() + Robot.MOVEMENT_DELTA);
    }

    
    public void moveDown() {
        this.moveToPosition(this.environment.getCurrPosX(), environment.getCurrPosY() - Robot.MOVEMENT_DELTA);
    }

    
    public void moveLeft() {
        this.moveToPosition(this.environment.getCurrPosX() - Robot.MOVEMENT_DELTA,
                this.environment.getCurrPosY());
    }


    public void moveRight() {
        this.moveToPosition(this.environment.getCurrPosX() + Robot.MOVEMENT_DELTA,
                this.environment.getCurrPosY());
    }


    public void recharge() {
        this.batteryLevel = BATTERY_FULL;
    }

    private void moveToPosition(final int newX, final int newY) {
        boolean returnValue = true;
        if (this.isBatteryEnoughToMove()) {
            	environment.move(newX, newY);
                this.consumeBatteryForMovement();
                this.log("Moved to position(" + newX + "," + newY + ").");
        } else {
            throw new NotEnoughBatteryException(batteryLevel,MOVEMENT_DELTA_CONSUMPTION);
        }
    }

    
    protected void consumeBatteryForMovement() {
        this.consumeBattery(Robot.MOVEMENT_DELTA_CONSUMPTION);
    }


    protected void consumeBattery(final double amount) {
        if (batteryLevel >= amount) {
            this.batteryLevel -= amount;
        } else {
            this.batteryLevel = BATTERY_EMPTY;
        }
    }


    protected boolean isBatteryEnoughToMove() {
        return this.getBatteryLevel() >= Robot.MOVEMENT_DELTA_CONSUMPTION;
    }


    
    public double getBatteryLevel() {
        return (double) Math.round(this.batteryLevel * 100) / 100;
    }


    public RobotEnvironment getEnvironment() {
        return this.environment;
    }

 
    protected void log(final String msg) {
        System.out.println("[" + this.robotName + ":]" + msg);
    }
}
