import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PrintSourceCode {
    public static void main(String[] args) {
        try {
            printSourceCode(".\\src\\Driver.java");
            printSourceCode(".\\src\\IdleState.java");
            printSourceCode(".\\src\\Snack.java");
            printSourceCode(".\\src\\SnackDispenseHandler.java");
            printSourceCode(".\\src\\StateOfVendingMachine.java");
            printSourceCode(".\\src\\VendingMachine.java");
            printSourceCode(".\\src\\WaitingForMoneyState.java");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printSourceCode(String fileName) throws IOException {
        System.out.println(STR."===== \{fileName} =====");
        String sourceCode = new String(Files.readAllBytes(Paths.get(fileName)));
        System.out.println(sourceCode);
        System.out.println();
    }
}