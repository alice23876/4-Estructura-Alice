import java.util.ArrayDeque;
import java.util.Deque;


//Fila de clientes
//si quiero encapsular para los metodos usar PRIVATE
public class Cliente {
    int id;
    String name;
    Deque<String> docs;

    //Si no solo en el constructor inicializar
    Cliente(int id, String nome) {
        this.id = id;
        this.name = nome;
        docs = new ArrayDeque<>();
    }
    // Metodo para agregar un documento a la pila del cliente
    public void agregaDoc(String newDoc) {
        docs.push(newDoc);
    }
    
    // Metodo para atender al cliente y retirar todos sus documentos
    public void atender() {
        System.out.println("Cliente en atencion: " + name);
        System.out.print("Documentos retirados: ");
        
        // Aqui sacamos todos los documentos uno por uno
        while (!docs.isEmpty()) {
            String documento = docs.pop();
            System.out.print(documento);
            if (!docs.isEmpty()) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
