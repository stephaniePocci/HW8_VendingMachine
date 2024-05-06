public class IdleState implements StateOfVendingMachine {
    private final VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectSnack(String snackName) {
        System.out.println(STR."Snack selected: \{snackName}");
        vendingMachine.setState(new WaitingForMoneyState(vendingMachine));
    }

    @Override
    public void insertMoney(double amount) {
        System.out.println("Please select a snack first.");
    }

    @Override
    public void dispenseSnack() {
        System.out.println("Please select a snack and insert money first.");
    }
}