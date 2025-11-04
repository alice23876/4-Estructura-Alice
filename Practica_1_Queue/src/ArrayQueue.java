public class ArrayQueue<T> implements QueueInterface<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    @Override
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía");
        }
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }
    @Override
    public boolean isEmpty() {
        return front == null;
    }
    @Override
    public int getSize() {
        return size;
    }
    public void reverse() {
        if (isEmpty()) return;

        T data = dequeue();
        reverse();
        enqueue(data);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = front;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
