public class CustomStack {
    private Node top;

    public void push(char data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }
    public char pop() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        char data = top.data;
        top = top.next;
        return data;
    }

    public boolean isEmpty() {
        return top == null;
    }
    public boolean isPalindrome(String text) {
        text = text.replaceAll("[^a-zA-Z]", "").toLowerCase();
        CustomStack stack = new CustomStack();
        for (int i = 0; i < text.length(); i++) {
            stack.push(text.charAt(i));
        }
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}
