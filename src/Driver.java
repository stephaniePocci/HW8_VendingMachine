public class Driver {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.selectSnack("Snickers");
        vendingMachine.insertMoney(0.75); // Not enough money
        vendingMachine.insertMoney(0.25); // Enough money for Snickers

        vendingMachine.selectSnack("Coke");
        vendingMachine.insertMoney(1.25); // Enough money for Coke

        vendingMachine.selectSnack("Doritos");
        vendingMachine.insertMoney(1.50); // Enough money for Doritos

        vendingMachine.selectSnack("Snickers");
        vendingMachine.insertMoney(1.00); // Enough money for Snickers, but quantity is 0
    }
}