public class ComputerOrder extends GenericOrder<Product>{

    // public because im pretty sure the client class will need this later.
    public void addPeripheral(Peripheral item){
        this.addItem(item); // here I simply use this. for the inherited addItem method
    }

    public void addService(Service item){
        this.addItem(item);
    }

    public void addComputerPart(ComputerPart item){
        this.addItem(item);
    }
}
