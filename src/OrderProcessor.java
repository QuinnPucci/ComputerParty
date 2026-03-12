import java.util.*;

public class OrderProcessor {
    public List<GenericOrder<?>> acceptedOrders = new ArrayList<>();
    // declare and initiate an empty internal collection(list) of orders

    public void accept(GenericOrder<?> order){
        acceptedOrders.add(order); // add the order to the the list of orders
    }

    public void processor(List order){

    }


}
