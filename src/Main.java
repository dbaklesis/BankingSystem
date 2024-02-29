public class Main {
    public static void main(String[] args) {
        
        Bank bank = new Bank("National Bank");
        bank.addBranch("Athens");
        // Testing branch already  exists
        if(!bank.addBranch("Athens")){
            System.out.println("Branch Athens already exists");
        }

        bank.addCustomer("Athens", "John");
        bank.addCustomer("Athens", "Kostas");
        bank.addCustomer("Athens", "Vasiliki");
        
        // Testing customer already exists
        if(!bank.addCustomer("Athens", "Maria")){
            System.out.println("Customer Maria already exists.");
        }
        
        // Testing bank does not exist
        if(!bank.addCustomer("Alpha Bank", "Voula")) {
            System.out.println("failed to add customer Voula. No bank Alpha Bank");
        }

        bank.customerTransaction("Athens", "John", 14.14);
        bank.customerTransaction("Athens", "Maria", 3191.00);
        bank.customerTransaction("Athens", "Maria", 3.95);
        
        // Testing no such customer in this branch
        if(!bank.customerTransaction("Athens", "Kiriakos", 2.99)){
            System.out.println("Customer Kiriakos does not exist");
        }
        
        if(!bank.customerTransaction("Tripoli", "Pavlos", 22.98)){
            System.out.println("Transaction failed. Either branch Tripoli doesn't exist or customer Steve not found");
        }

        bank.listCustomers("Athens", true);
        
        bank.addBranch("Eurobank");
        bank.addCustomer("Eurobank", "Dimitris");
        bank.addCustomer("Eurobank", "Niki");
        bank.addCustomer("Eurobank", "Giorgos");

        bank.customerTransaction("Eurobank", "Dimitris", 25.00);
        bank.customerTransaction("Eurobank", "Dimitris", 30.50);
        bank.customerTransaction("Eurobank", "Dimitris", 110.87);
        bank.customerTransaction("Eurobank", "Dimitris", 110.87);

        bank.listCustomers("Eurobank", true);

        Customer customer = new Customer("Giannis");
        customer.makeTransaction(65.83);
    }
}
