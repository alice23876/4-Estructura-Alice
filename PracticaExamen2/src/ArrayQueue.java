public class ArrayQueue <T> implements QueueInterface<Object> {
    private Object[] data;
    private int rear; //indice de insercion
    private int front; //Indica el elemento al frente de la queue
    private int size; //numero de elementos en la queue
    private static final int INITIAL_CAPACITY=10; //Constante para el tamaño incial del arr

    public ArrayQueue(){
        this.data= new Object[INITIAL_CAPACITY];
        this.rear=0;
        this.front=0;
        this.size=0;
    }

    @Override
    public void offer(Object element) {
        //Verificar la capacidad del array ()
        if(size==data.length){
            expandCapacity();
        }
        data[rear]= element; //pone el elemento en el indice asignado (rear)
        rear= (rear+1) % data.length; //recalcula rear, pero evita que se desborde
        size++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object poll() {
        if(isEmpty()){
            System.out.println("La Queue esta vacia");
            return null;
        }
        T result= (T) data[front]; //juanito
        data[front]=null; //lo sacamos
        front=(front+1) % data.length;
        size--;
        return  result;
    }

    @Override
    public Object peek() {
        if(isEmpty()){
            System.out.println("La queue esta vacia");
            return null;
        }
        return data[front];
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    private void expandCapacity (){
        Object[] newArr= new Object[data.length*2]; //Creacion de nuevo arreglo

        for (int i = 0; i < size; i++) {
            newArr[i] = data[ (front+i)%data.length ]; //Vaciado de la info comenzando desde front
        }
        //Rainiamos los valores del arreglo para poderlo seguir usando
        front=0; //Pone el frente en la primera posicion
        data=newArr; //Asiganada el nuevo arreglo al atributo data
        rear=size; // indice de la siguiente insercion
    }

    @Override
    public void print() {
        StringBuilder sb= new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[ (front+i) % data.length ]);
            if(i<size-1) sb.append("->");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
//este ya esta en la interface
    @Override
    public boolean isEmpty() {
        return size==0; //Verifica que size sea 0, en caso caso esta vacia
    }

    @Override
    public int getSize() {
        throw new UnsupportedOperationException("Unimplemented method 'getSize'");
    }
}