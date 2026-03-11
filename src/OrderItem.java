// Modified TwoTuple from textbook as suggested in the instructions
// Later this will be: new OrderItem<Integer, ComputerPart> (orderNumber, part)
public class OrderItem<A, B> {
    public final A first;
    public final B second;
    public OrderItem(A first, B second){
        this.first = first;
        this.second = second;
    }
    @Override
    public String toString() {
        return "(Order Number: " + first + ", Item: " + second + ")";
    }
}
