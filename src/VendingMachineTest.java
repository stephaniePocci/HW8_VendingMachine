import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VendingMachineTest {
    private VendingMachine vendingMachine;

    @Before
    public void setUp() {
        vendingMachine = new VendingMachine();
    }


    @Test
    public void testInsertMoney() {
        vendingMachine.selectSnack("Coke");
        vendingMachine.insertMoney(1.25);
        assertEquals(0.0, vendingMachine.getCurrentBalance(), 0.001);
    }

}