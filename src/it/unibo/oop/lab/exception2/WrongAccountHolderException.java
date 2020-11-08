package it.unibo.oop.lab.exception2;

public class WrongAccountHolderException extends Exception{
	private static final long serialVersionUID = 7190620326792084901L;
	private final AccountHolder unauthorizedAccountHolder;
	private final AccountHolder expectedAccountHolder;
	
	public WrongAccountHolderException(AccountHolder unauthorizedAccountHolder, AccountHolder exectedAccountHolder) {
		this.unauthorizedAccountHolder = unauthorizedAccountHolder;
		this.expectedAccountHolder = exectedAccountHolder;
	}



	public String toString() {
		return "WrongAccountHolderException [unauthorizedAccountHolder=" + unauthorizedAccountHolder
				+ ", expectedAccountHolder=" + expectedAccountHolder + "]";
	}


	public String getMessage() {
		return this.toString();
	}

}
