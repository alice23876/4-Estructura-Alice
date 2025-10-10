import java.util.*;

public class WarehouseUtils {
    Queue<Package> incoming = new ArrayDeque<>();
    Stack<Package> heavyStack = new Stack<>();
    Stack<Package> lightStack = new Stack<>();
    List<Package> dispatched = new ArrayList<>();

    public void storeRec(Queue<Package> incoming){
        if(incoming == null || incoming.isEmpty()){
            return;
        }
        Package p = incoming.poll();
        if (p.isHeavy()){
            heavyStack.push(p);
        }else {
            lightStack.push(p);
        }
        storeRec(incoming);
    }
    public void dispatchHeavyRec(Stack<Package> heavyStack, List<Package> dispatched){
        if (heavyStack == null || heavyStack.isEmpty()){
            return;
        }
        System.out.println("Despachando pesado");
        Package p = heavyStack.pop();
        dispatched.add(p);
        dispatchHeavyRec(heavyStack, dispatched);
    }
    public void dispatchLightRec(Stack<Package> lightStack, List<Package> dispatched){
        if (lightStack == null || lightStack.isEmpty()){
            return;
        }
        System.out.println("Despachando ligero");
        Package p = lightStack.pop();
        dispatched.add(p);
        dispatchLightRec(lightStack, dispatched);
    }
}
