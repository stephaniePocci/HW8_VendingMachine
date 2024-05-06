public class SnackDispenseHandler {
    private Snack snack;
    private SnackDispenseHandler nextHandler;

    public SnackDispenseHandler(Snack snack) {
        this.snack = snack;
    }

    public SnackDispenseHandler(Snack snack, SnackDispenseHandler nextHandler) {
        this.snack = snack;
        this.nextHandler = nextHandler;
    }

    public boolean dispenseSnack(double balance) {
        if (snack.getQuantity() == 0) {
            System.out.println("Sorry, there is no " + snack.getName() + " left.");
            if (nextHandler != null) {
                return nextHandler.dispenseSnack(balance);
            } else {
                return false;
            }
        } else if (snack.getPrice() <= balance) {
            System.out.println("Dispensing " + snack.getName());
            snack.setQuantity(snack.getQuantity() - 1);
            return true;
        } else if (nextHandler != null) {
            return nextHandler.dispenseSnack(balance);
        } else {
            System.out.println("Sorry, no snacks available or not enough money.");
            return false;
        }
    }
}