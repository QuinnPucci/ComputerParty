public class Client {

    public static void main(String[] args) {

        // Create processor object
        OrderProcessor op = new OrderProcessor();

        // First order -> ComputerOrder
        ComputerOrder co1 = new ComputerOrder();

        // Computer parts
        co1.addComputerPart(new Motherboard("Asus", 37.5f));
        co1.addComputerPart(new RAM("Kingston", 512, 25.0f));
        co1.addComputerPart(new Drive("SSD", 7200, 89.99f));

        // Peripherals
        co1.addPeripheral(new Printer("HP LaserJet 1010", 129.95f));
        co1.addPeripheral(new Monitor("Dell 24in", 199.99f));

        // Services
        co1.addService(new AssemblyService("GeekSquad", 49.99f));
        co1.addService(new DeliveryService("FedEx", 19.99f));

        // --------------------------
        // Second Order -> ComputerOrder
        ComputerOrder co2 = new ComputerOrder();

        // Computer parts
        co2.addComputerPart(new Motherboard("MSI", 55.0f));
        co2.addComputerPart(new RAM("Corsair", 1024, 44.0f));

        // Peripherals
        co2.addPeripheral(new Monitor("LG Ultrawide", 329.99f));

        // Services
        co2.addService(new DeliveryService("UPS", 24.99f));

        // --------------------------
        // Third order -> PartyOrder
        PartyOrder po1 = new PartyOrder();

        // Cheese
        po1.addCheese(new Cheddar(12.50f));
        po1.addCheese(new Mozzarella(11.25f));

        // Fruit
        po1.addFruit(new Apple(2.25f));
        po1.addFruit(new Orange(2.75f));

        // Services
        po1.addService(new DeliveryService("DoorDash", 9.99f));

        // --------------------------
        // Accept orders into processor
        op.accept(co1);
        op.accept(co2);
        op.accept(po1);
        System.out.println("\n----Orders Accepted----");

        // Confirm order numbers and item counts before processing
        System.out.println("\n----Debug----");
        System.out.println(co1);
        System.out.println(co2);
        System.out.println(po1);

        // Sort into tuple lists using processor
        System.out.println("\n----Processing Orders----");
        op.processor();

        // Dispatch
        System.out.println("\n----Dispatching----");
        System.out.println("\n----Dispatch Computer Parts----");
        op.dispatchComputerParts();

        System.out.println("\n----Dispatch Peripherals----");
        op.dispatchPeripherals();

        System.out.println("\n----Dispatch Cheeses----");
        op.dispatchCheeses();

        System.out.println("\n----Dispatch Fruits----");
        op.dispatchFruits();

        System.out.println("\n----Dispatch Services----");
        op.dispatchServices();
    }
}