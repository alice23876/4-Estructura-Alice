import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayQueue<JobCustom> queue = new ArrayQueue<>();
        ArrayStack<JobCustom> stack = new ArrayStack<>();
        SinglyLinkedList list= new SinglyLinkedList();

        while(true) {
            System.out.println("Ingresa el comando >");
            String cmd = sc.nextLine().toUpperCase();//esto vuelve la recoleccion de la consola a mayusculas
            if (cmd.equals("ADD")) {
                System.out.println("Dame el Id: ");
                String idJob = sc.nextLine(); //
                JobCustom job = new JobCustom(idJob);
                // job.setId(idJob);
                queue.offer(job);


            } else if (cmd.equals("PROCESS")) {
                System.out.println("Dame la cantidad a procesar: ");
                String line = sc.nextLine().trim();
                int num;
                try {
                    num = Integer.parseInt(line);
                } catch (NumberFormatException e) {
                    System.out.println("Número inválido. Uso: PROCESS <n>");
                    continue;
                }
                int cont = 0;
                while (!queue.isEmpty() && cont < num) {
                    JobCustom job = (JobCustom) queue.poll();
                    stack.push(job);
                    cont++;
                }
            } else if (cmd.startsWith("ROLLBACK")) {
                System.out.println("Dame la cantidad a revertir: ");
                String line = sc.nextLine().trim();
                int m;
                try {
                    m = Integer.parseInt(line);
                } catch (NumberFormatException e) {
                    System.out.println("Número inválido. Uso: ROLLBACK <m>");
                    continue;
                }

                int count = 0;
                while (!list.isEmpty() && count < m) {
                    JobCustom job = list.removeLast();
                    if (job != null) {
                        queue.offer(job);
                        count++;
                    }
                }
                System.out.println("Rollback completado. Revertidos: " + count);

            } else if (cmd.equals("COMMIT")) {
                while (!stack.isEmpty()) {
                    list.add(stack.pop());
                }

            }else if(cmd.equals("PRINT")){
                printData(queue, stack,list);

            }else if(cmd.equals("END")){
                System.out.println("Estado final:");
                printData(queue, stack, list);
                System.out.println("Ejecución finalizada.");
                break;
            }else{
                System.out.println("Comando no reconocido");
            }
        }

    }
    public static void printData(ArrayQueue queue, ArrayStack stack, SinglyLinkedList list){
        System.out.println("Queue:");
        queue.print();
        System.out.println("Stack: ");
        stack.print();
        System.out.println("List: ");
        list.printList();
    }
}