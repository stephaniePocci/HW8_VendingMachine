public class WaitingForMoneyState implements StateOfVendingMachine {
    private final VendingMachine vendingMachine;

    public WaitingForMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectSnack(String snackName) {
        System.out.println(STR."Snack already selected: \{snackName}");
    }

    @Override
    public void insertMoney(double amount) {
        vendingMachine.setCurrentBalance(vendingMachine.getCurrentBalance() + amount);
        System.out.println(STR."Money inserted: $\{amount}");
        System.out.println(STR."Current balance: $\{vendingMachine.getCurrentBalance()}");

        SnackDispenseHandler snackDispenseHandler = vendingMachine.getSnackDispenseHandler();
        boolean snackDispensed = snackDispenseHandler.dispenseSnack(vendingMachine.getCurrentBalance());

        if (snackDispensed) {
            vendingMachine.setState(new IdleState(vendingMachine));
            vendingMachine.setCurrentBalance(0.0);
        } else {
            vendingMachine.setState(new WaitingForMoneyState(vendingMachine));
        }
    }

    @Override
    public void dispenseSnack() {
        System.out.println("Please insert money first.");
    }
}