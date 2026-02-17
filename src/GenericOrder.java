public class GenericOrder<T> {
    T item;
    // the below attributes are for supporting the unique ID of each container
    private static int counter = 0; // private and static so it's restricted to this class, and part of the class not the instances
    private final int id; // restricted to this class and cannot be changed

    GenericOrder(T item){
        this.item = item;
        // everytime a container is constructed, up the counter and assign that number to the ID.
        id = ++counter;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    void main() {
    }
}