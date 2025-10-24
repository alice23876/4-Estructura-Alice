public interface IStack <T>{
    void push(T data);
    T pop();
    T peek();
    void clear();
    int size();
    boolean isEmpty(); //Todo esto obliga a
    void print();
}