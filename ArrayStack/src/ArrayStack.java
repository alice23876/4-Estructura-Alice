public class ArrayStack <T> implements IStack<T>{
    private Object[] data;
    private int top;

    //Constructor 1
    public ArrayStack(){
        this(10); //Invoca al constructor 2
    }

    //Constructor 2
    public ArrayStack(int initialCapacity){
        this.data = new Object[initialCapacity];
        this.top = 0;
    }

    @Override
    public void push(T element) {
        // Asegurar que hay espacio
        if (top == data.length) {
            System.out.println("La pila está llena");
            return;
        }
        data[top++] = element;
    }

    @SuppressWarnings("uncheked")
    @Override
    public T pop() {
        if (isEmpty()) {
            System.out.println("La pila está vacía");
            return null;
        }
        T value = (T) data[--top];
        data[top] = null;
        return value;
    }

    @Override
    public T peek() {
        if (isEmpty()){
            System.out.println("La pila esta vacía");
            return null;
        }
        return (T) data[top - 1];
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }
    @Override
    public void print(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = top-1; i>= 0; i--){
            sb.append(data[i]);
            if (i != 0) sb.append(", ");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
