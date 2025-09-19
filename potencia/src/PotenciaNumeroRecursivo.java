import java.util.Scanner;

public class PotenciaNumeroRecursivo {

    public static void main(String[] args) {
        Scanner pot = new Scanner(System.in);
        System.out.print("coloca un numero de base: ");
        int base = pot.nextInt();
        System.out.print("coloca un numero para el exponente: ");
        int exponente = pot.nextInt();
        pot.close();
        System.out.printf("el numero %d elevado a %d es igual a %.3f", base, exponente, potencia(base, exponente));
    }

    private static double potencia(int base, int exponente){
        if(exponente==0){
            return 1;
        } else if (exponente<0) {
            return potencia(base, exponente+1) / base;
        } else {
            return base * potencia(base, exponente-1);
        }
    }
}