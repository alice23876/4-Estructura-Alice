public class Main {
    public static void main(String[] args) {
        WarehouseUtils utils = new WarehouseUtils();

            Package p1 = new Package(1, 10.0, "Mochila");
            Package p2 = new Package(2, 5.0, "Audifonos");
            Package p3 = new Package(3, 2.0, "Piedra");
            Package p4 = new Package(4, 3.0, "Libros");
            Package p5 = new Package(5, 20.0, "Telefono");

            utils.incoming.offer(p1);
            utils.incoming.offer(p2);
            utils.incoming.offer(p3);
            utils.incoming.offer(p4);
            utils.incoming.offer(p5);

            System.out.println(utils.incoming);
            utils.storeRec(utils.incoming);//este metodo es la separacion de los productos
            // System.out.println(utils.heavyStack);
            utils.dispatchHeavyRec(utils.heavyStack, utils.dispatched);
            utils.dispatchLightRec(utils.lightStack, utils.dispatched);

            System.out.println(utils.dispatched);
        }
}
