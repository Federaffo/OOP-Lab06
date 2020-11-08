package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryException extends IllegalStateException {

    private static final long serialVersionUID = 1L;
    private final double batteryLevel;
    private final double batteyRequired;
    
    public NotEnoughBatteryException(final double batteryLevel, final double required) {
        super();
        this.batteryLevel = batteryLevel;
        this.batteyRequired = required;
    }

    public String toString() {
        return "No enough battery for moving. Battery level is " + batteryLevel
            + " battery required is " + batteyRequired;
    }

    public String getMessage() {
        return this.toString();
    }
}