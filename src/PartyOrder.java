public class PartyOrder extends GenericOrder<Product>{

    public void addFruit(Fruit item){
        this.addItem(item);
    }

    public void addCheese(Cheese item){
        this.addItem(item);
    }

    public void addService(Service item){
        this.addItem(item);
    }

}
