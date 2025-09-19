public  class Main {
    public static int suma(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n + suma(n - 1);
        }
    }
        public static void main (String[]args){
        int num = 8;
        int resultado = suma(num);
        System.out.println("lA SUMA DE LOS NUMEROS ES" +  resultado);
        }
}