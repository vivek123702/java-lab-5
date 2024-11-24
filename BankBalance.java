// Defining the BankInterface
interface BankInterface {
    double getBalance();

    double getInterestRate();
}

// BankA implementation
class BankA implements BankInterface {
    private double balance;

    public BankA(double balance) {
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double getInterestRate() {
        return 7.0; // Interest rate for BankA
    }
}

// BankB implementation
class BankB implements BankInterface {
    private double balance;

    public BankB(double balance) {
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double getInterestRate() {
        return 7.4; // Interest rate for BankB
    }
}

// BankC implementation
class BankC implements BankInterface {
    private double balance;

    public BankC(double balance) {
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double getInterestRate() {
        return 7.9; // Interest rate for BankC
    }
}

// Main class to test the implementation
public class BankBalance {
    public static void main(String[] args) {
        // Creating objects of each bank
        BankA bankA = new BankA(10000);
        BankB bankB = new BankB(150000);
        BankC bankC = new BankC(200000);

        // Displaying the balance and interest rate for each bank
        System.out.println("Bank A:");
        System.out.println("Balance: " + bankA.getBalance());
        System.out.println("Interest Rate: " + bankA.getInterestRate() + "%");

        System.out.println("\nBank B:");
        System.out.println("Balance: " + bankB.getBalance());
        System.out.println("Interest Rate: " + bankB.getInterestRate() + "%");

        System.out.println("\nBank C:");
        System.out.println("Balance: " + bankC.getBalance());
        System.out.println("Interest Rate: " + bankC.getInterestRate() + "%");
    }
}
