package it.unibo.oop.lab.exception2;

public class NotEnoughFoundsException extends Exception{

	private static final long serialVersionUID = -1159808475879283028L;
    private final double balance;
    private final double balanceRequired;
    
	public NotEnoughFoundsException(double balance, double balanceRequired) {
		super();
		this.balance = balance;
		this.balanceRequired = balanceRequired;
	}
	
	
	public String toString() {
		return "NotEnoughFoundsException [balance=" + balance + ", balanceRequired=" + balanceRequired + "]";
	}


	public String getMessage() {
		return this.toString();
	}
}
