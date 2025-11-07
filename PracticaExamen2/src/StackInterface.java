public interface StackInterface <T>{
    void push(T data);
    T pop();
    T peek();
    void clear();
    int size();
    boolean isEmpty();
    void print();
}
