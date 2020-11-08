package it.unibo.oop.lab.exception2;

public class TransactionsOverQuotaException extends Exception{
	private static final long serialVersionUID = -5186015990336694793L;

	private final int nTrasnsaction;
	private final int nTrasnsactionRequired;
	
	
	public TransactionsOverQuotaException(int nTrasnsaction, int nTrasnsactionRequired) {
		super();
		this.nTrasnsaction = nTrasnsaction;
		this.nTrasnsactionRequired = nTrasnsactionRequired;
	}
	
	
	public String toString() {
		return "TransactionsOverQuotaException [nTrasnsaction=" + nTrasnsaction + ", nTrasnsactionRequired="
				+ nTrasnsactionRequired + "]";
	}
	
	
	public String getMessage() {
		return this.toString();
	}

}
