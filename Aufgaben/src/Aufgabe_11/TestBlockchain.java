package Aufgabe_11;
import static org.junit.Assert.*;

import org.junit.Test;

import Aufgabe_11.BlockChain;

public class TestBlockchain {
	
	
	
	String[] genesisTransactions = {"A send B","B send 191123 C"};
	BlockChain genesisBlock = new BlockChain(0, genesisTransactions);
	
	String[] block2Transactions = {"B send A","C send 10000 A"};
	BlockChain genesisBlock2 = new BlockChain(genesisBlock.getBlockHash(), block2Transactions);
	
	@Test
	public void HashTest() {
		int a = genesisBlock2.getPreviousHash();
		Integer.toString(a);
		assertEquals(genesisBlock.getBlockHash(), a);
	}

}
