import java.util.*;

public class GenericOrder<T> {
    // the below attributes are for supporting the unique ID of each container
    private static int counter = 0; // private and static so it's restricted to this class, and part of the class not the instances
    private final int orderNum; // restricted to this class and cannot be changed

    private List<T> items; // declare a list, init later in the constructor as an empty generic list

    public GenericOrder(){
        this.items = new ArrayList<T>(); // I decided to init as an empty list and use addItem method
        // everytime a container is constructed, up the counter and assign that number to the ID.
        orderNum = ++counter;
    }

    public void addItem(T item) {
        items.add(item);
    }

    // Maybe an addAll at some point

    // getAllItems() as official “iteration access” method later (will just loop that copy in process())
    // could use iterator here
    public List<T> getAllItems() {
        return new ArrayList<>(items); // returns a COPY for safety (calls cannot change the items)
    }

    public int getOrderNum() {
        return orderNum;
    }

    @Override
    public String toString() {
        List<T> view = getAllItems();
        return "GenericOrder{orderNumber=" + orderNum + ", size=" + view.size() + ", items= " + view + "}" ;
    }

}