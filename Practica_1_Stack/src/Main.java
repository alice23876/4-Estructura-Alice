public class Main {
    public static void main(String[] args) {
        CustomStack stack = new CustomStack();

        String texto1 = "Anita lava la tina";
        String texto2 = "Hola";

        System.out.println(texto1 + " → " + stack.isPalindrome(texto1));
        System.out.println(texto2 + " → " + stack.isPalindrome(texto2));
    }
}