import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name){
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Customer> getCustomers() {
        return this.customers;
    }

    public boolean addCustomer(String name){
        Customer existingCustomer = findCustomer(name);
        if(existingCustomer != null){
            return false;
        }
        this.customers.add(new Customer(name));
        return true;
    }

    public boolean makeTransaction(String name, double transaction){
        Customer existingCustomer = findCustomer(name);
        if(existingCustomer == null){
            return false;
        }
        existingCustomer.makeTransaction(transaction);
        return true;
    }

    private Customer findCustomer(String name){
        for(int i=0; i < customers.size(); ++i){
            boolean isEqual = this.customers.get(i).getName().equals(name);
            if(isEqual){
                return this.customers.get(i);
            }
        }
        return null;
    }
}