public class Main {
    public static void main(String[] args) {
        ArrayStack2<Character> stack1 = new ArrayStack2<>();
        stack1.print();
        stack1.push('A');
        stack1.push('B');
        stack1.push('C');
        stack1.pop();
        stack1.print();
        stack1.clear();
        stack1.print();
    }
}
