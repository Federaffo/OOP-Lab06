package it.unibo.oop.lab.exception2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * JUnit test to test {@link StrictBankAccount}.
 * 
 */
public class TestStrictBankAccount {

    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
    @Test
    public void testBankOperations() {
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a scelta,
         * con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
         * 
         * 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in presenza
         * di un id utente errato, oppure al superamento del numero di operazioni ATM
         * gratuite.
         */

        AccountHolder mario = new AccountHolder("Mario", "Rossi", 0);
        AccountHolder luigi = new AccountHolder("Luigi", "Bianchi", 1);
        StrictBankAccount bankAcc = new StrictBankAccount(mario.getUserID(), 1000, 10);
        StrictBankAccount bankAcc2 = new StrictBankAccount(luigi.getUserID(), 1000, 10);

        try {
            bankAcc.withdraw(luigi.getUserID(), 100);
            fail();
        } catch (WrongAccountHolderException e) {
            assertEquals("WrongAccountHolderException", e.getMessage());
            System.out.println("WrongAccountHolderException Corretto");
        }
        
        try {
            bankAcc.withdraw(mario.getUserID(), 50000);
            fail();
        }catch(NotEnoughFoundsException e) {
            assertEquals("NotEnoughFoundsException", e.getMessage());
            System.out.println("NotEnoughFoundsException Corretto");
        }

        
        
        for(int i = 0; i < 10; i++) {
            bankAcc.withdrawFromATM(mario.getUserID(), 1);
        }
        
        
        try {
            bankAcc.withdrawFromATM(mario.getUserID(), 1);
            fail();
        }catch(TransactionsOverQuotaException e) {
            assertEquals("TransactionsOverQuotaException", e.getMessage());
            System.out.println("TransactionsOverQuotaException Corretto");
        }
        
    }
}
