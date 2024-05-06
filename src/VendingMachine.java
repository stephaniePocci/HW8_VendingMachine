import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private StateOfVendingMachine state;
    private final SnackDispenseHandler snackDispenseHandler;
    private final List<Snack> snacks;
    private double currentBalance;

    public VendingMachine() {
        this.state = new IdleState(this);
        this.snackDispenseHandler = setupSnackDispenseHandler();
        this.snacks = new ArrayList<>();
        this.currentBalance = 0.0;
    }

    private SnackDispenseHandler setupSnackDispenseHandler() {
        SnackDispenseHandler cokeHandler = new SnackDispenseHandler(new Snack("Coke", 1.25, 10));
        SnackDispenseHandler pepsiHandler = new SnackDispenseHandler(new Snack("Pepsi", 1.25, 10), cokeHandler);
        SnackDispenseHandler cheetosHandler = new SnackDispenseHandler(new Snack("Cheetos", 1.50, 10), pepsiHandler);
        SnackDispenseHandler doritosHandler = new SnackDispenseHandler(new Snack("Doritos", 1.50, 10), cheetosHandler);
        SnackDispenseHandler kitKatHandler = new SnackDispenseHandler(new Snack("KitKat", 1.00, 10), doritosHandler);

        return new SnackDispenseHandler(new Snack("Snickers", 1.00, 1), kitKatHandler);
    }

    public void selectSnack(String snackName) {
        state.selectSnack(snackName);
    }

    public void insertMoney(double amount) {
        state.insertMoney(amount);
    }

    public void setState(StateOfVendingMachine state) {
        this.state = state;
    }

    public SnackDispenseHandler getSnackDispenseHandler() {
        return snackDispenseHandler;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public List<Snack> getSnacks() {
        return snacks;
    }
}