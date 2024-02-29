import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name){
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String name){
        Branch existingBranch = findBranch(name);
        if(existingBranch != null){
            return false;
        }
        this.branches.add(new Branch(name));

        return true;
    }

    public boolean addCustomer(String branchName, String customerName){
        Branch existingBranch = findBranch(branchName);
        if(findBranch(branchName) == null){
            return false;
        }
        return existingBranch.addCustomer(customerName);
    }

    public boolean customerTransaction(String branchName, String customerName, double transaction){
            Branch foundBranch = findBranch(branchName);
            if(foundBranch == null){
                return false;
            }

            return foundBranch.makeTransaction(customerName, transaction);
    }

    public boolean listCustomers(String branchName, boolean printTransctions){
        Branch existingBranch = findBranch(branchName);
        if(existingBranch == null){
            return false;
        }

        Branch branchToPrint = findBranch(branchName);
        if(branchToPrint == null){
            return false;
        }

        System.out.println("\nCustomer details for branch " + branchToPrint.getName());
        ArrayList<Customer> customers = branchToPrint.getCustomers();
        int count = 0;
        for (Customer customer: customers) {   // Customers
            System.out.println("Customer: " + customer.getName());
            if (printTransctions) {
                ArrayList<Double> transactions = customer.getTransactions();
                System.out.println("Transactions");
                for (int k = 0; k < transactions.size(); ++k) {  // Transactions
                    if(count == (customers.size() - 1)){
                        System.out.print("[" + (k+1) + "]" + "  Amount " + transactions.get(k));
                    }else{
                        System.out.println("[" + (k+1) + "]" + "  Amount " + transactions.get(k));
                    }
                }
            }
            count++;
        }

        return true;
    }

    public boolean OLDlistCustomers(String branchName, boolean printTransctions){
        Branch existingBranch = findBranch(branchName);
        if(existingBranch == null){
            return false;
        }

        Branch branchToPrint = findBranch(branchName);
        if(branchToPrint == null){
            return false;
        }

        System.out.println("\nCustomer details for branch " + branchToPrint.getName());
        ArrayList<Customer> customers = branchToPrint.getCustomers();
        for (int j = 0; j < customers.size(); ++j) {   // Customers
            Customer currentCustomer = customers.get(j);
            System.out.println("Customer: " + currentCustomer.getName() + "[" + (j + 1) + "]");
            if (printTransctions) {
                ArrayList<Double> transactions = customers.get(j).getTransactions();
                System.out.println("Transactions");
                for (int k = 0; k < transactions.size(); ++k) {  // Transactions
                    if(j == (customers.size() - 1)){
                        System.out.print("[" + (k+1) + "]" + "  Amount " + transactions.get(k));
                    }else{
                        System.out.println("[" + (k+1) + "]" + "  Amount " + transactions.get(k));
                    }

                }
            }
        }

        return true;
    }

    private Branch findBranch(String name){
        for(int i=0; i < branches.size(); ++i){
            boolean isEqual = this.branches.get(i).getName().equals(name);
            if(isEqual){
                return this.branches.get(i);
            }
        }

        return null;
    }
}
