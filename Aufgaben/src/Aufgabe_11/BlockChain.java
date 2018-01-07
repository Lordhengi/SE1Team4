package Aufgabe_11;

import java.util.Arrays;

public class BlockChain {

	public void mining(){};
	
	private int previousHash;
	private String[] transaction;
	private int blockHash;
	
	public BlockChain(int previousHash, String[] transaction){
		this.transaction = transaction;
		this.previousHash = previousHash;
	

		Object[] contens = {Arrays.hashCode(transaction), previousHash};
		this.blockHash = Arrays.hashCode(contens);
	}
	
	
	public int getPreviousHash(){
		return previousHash;
	}
	
	public String[] getTransactions(){
		return transaction;
	}
	
	public int getBlockHash() {
		return blockHash;
	}
}
