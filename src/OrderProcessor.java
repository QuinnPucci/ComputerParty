import java.util.*;

public class OrderProcessor {
    // Declare and initialize an empty internal collection(list) of orders(which are also lists) -> A list or lists.
    public List<GenericOrder<?>> acceptedOrders = new ArrayList<>();
    // Declare and initialize a list for each sorted Product category that stores tuples
    List<OrderItem> computerPartTuple = new ArrayList<>();
    List<OrderItem> peripheralTuple = new ArrayList<>();
    List<OrderItem> cheeseTuple = new ArrayList<>();
    List<OrderItem> fruitTuple = new ArrayList<>();
    List<OrderItem> serviceTuple = new ArrayList<>();

    public void accept(GenericOrder<?> order){
        acceptedOrders.add(order); // add the order to the the list of orders
    }

    public void processor(){
        // iterate the list of orders
        for (GenericOrder order : acceptedOrders){
            int curOrderNum = order.getOrderNum();
            List<Product> curOrder = order.getAllItems();
            // nested for-each loops to iterate the orders
            for (Product curProduct : curOrder){
                // Conditional + instanceof to match product type
                if (curProduct instanceof ComputerPart){
                    // Create Two Tuple
                    OrderItem cpOrderItem = new OrderItem<>(curOrderNum, curProduct);
                    // Add to appropriate list
                    computerPartTuple.add(cpOrderItem);
                } else if (curProduct instanceof Peripheral) {
                    OrderItem perOrderItem = new OrderItem(curOrderNum, curProduct);
                    peripheralTuple.add(perOrderItem);
                } else if (curProduct instanceof Cheese) {
                    OrderItem cheOrderItem = new OrderItem(curOrderNum, curProduct);
                    cheeseTuple.add(cheOrderItem);
                } else if (curProduct instanceof Fruit) {
                    OrderItem frOrderItem = new OrderItem<>(curOrderNum, curProduct);
                    fruitTuple.add(frOrderItem);
                } else if (curProduct instanceof Service) {
                    OrderItem seOrderItem = new OrderItem(curOrderNum, curProduct);
                    serviceTuple.add(seOrderItem);
                }

            }

        }

    }

    public void dispatchComputerParts() {
        // Now that the products are separated by processor, dispatch methods use a similar pattern to further separate by subproduct
        for (OrderItem t : computerPartTuple) {
            int orderNum = (int) t.first; // casting the variables in the Tuple
            Product p = (Product) t.second;
            // use isntanceof just like processor
            if (p instanceof Motherboard) {
                Motherboard mb = (Motherboard) p;
                // Match output & use provided methods from Product class
                System.out.println("Motherboard - name=" + mb.getManufacturer()
                        + ", price=$" + mb.price()
                        + ", order number=" + orderNum);
            } else if (p instanceof RAM) {
                RAM ram = (RAM) p;
                System.out.println("RAM - name=" + ram.getManufacturer()
                        + ", size=" + ram.size
                        + ", price=$" + ram.price()
                        + ", order number=" + orderNum);
            } else if (p instanceof Drive) {
                Drive d = (Drive) p;
                System.out.println("Drive - type=" + d.getType()
                        + ", speed=" + d.getSpeed()
                        + ", price=$" + d.price()
                        + ", order number=" + orderNum);
            } else {
                // if for some reason it is none of those
                System.out.println(p.getClass().getSimpleName()
                        + " - price=$" + p.price()
                        + ", order number=" + orderNum);
            }
        }
    }

    public void dispatchPeripherals() {
        for (OrderItem t : peripheralTuple) {
            int orderNum = (int) t.first;
            Product p = (Product) t.second;

            if (p instanceof Printer) {
                Printer pr = (Printer) p;
                System.out.println("Printer - model=" + pr.getModel()
                        + ", price=$" + pr.price()
                        + ", order number=" + orderNum);
            } else if (p instanceof Monitor) {
                Monitor m = (Monitor) p;
                System.out.println("Monitor - model=" + m.getModel()
                        + ", price=$" + m.price()
                        + ", order number=" + orderNum);
            } else {
                System.out.println(p.getClass().getSimpleName()
                        + " - price=$" + p.price()
                        + ", order number=" + orderNum);
            }
        }
    }

    public void dispatchCheeses() {
        for (OrderItem t : cheeseTuple) {
            int orderNum = (int) t.first;
            Product p = (Product) t.second;

            System.out.println(p.getClass().getSimpleName()
                    + " - price=$" + p.price()
                    + ", order number=" + orderNum);
        }
    }

    public void dispatchFruits() {
        for (OrderItem t : fruitTuple) {
            int orderNum = (int) t.first;
            Product p = (Product) t.second;

            System.out.println(p.getClass().getSimpleName()
                    + " - price=$" + p.price()
                    + ", order number=" + orderNum);
        }
    }

    public void dispatchServices() {
        for (OrderItem t : serviceTuple) {
            int orderNum = (int) t.first;
            Product p = (Product) t.second;

            if (p instanceof AssemblyService) {
                AssemblyService as = (AssemblyService) p;
                System.out.println("AssemblyService - provider=" + as.getProvider()
                        + ", price=$" + as.price()
                        + ", order number=" + orderNum);
            } else if (p instanceof DeliveryService) {
                DeliveryService ds = (DeliveryService) p;
                System.out.println("DeliveryService - courier=" + ds.getCourier()
                        + ", price=$" + ds.price()
                        + ", order number=" + orderNum);
            } else {
                System.out.println(p.getClass().getSimpleName()
                        + " - price=$" + p.price()
                        + ", order number=" + orderNum);
            }
        }
    }

}
