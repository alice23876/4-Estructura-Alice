public class InvertirCadena {
    public static void invertir(String cadena) {
        if (!cadena.isEmpty()) {
            invertir(cadena.substring(1));
            System.out.print(cadena.charAt(0));
        }
    }
    public static void main(String[] args) {
        invertir("alice");
    }
}
