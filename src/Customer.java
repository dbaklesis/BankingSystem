import java.util.ArrayList;

public class Customer {
    private final String name;
    private double totalMoney = 0;
    private final ArrayList<Double> transactions;

    Customer(String name){
        this.name = name;
        this.transactions = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Double> getTransactions() {
        return this.transactions;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public boolean makeTransaction(double transaction){
        double remainingTotal = this.totalMoney + transaction;
        if (remainingTotal < 0.0) {
            return false;
        }
        this.totalMoney = remainingTotal;
        transactions.add(transaction);

        return true;
    }
}
