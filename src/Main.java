public class Main {
    public static void main(String[] args){
        int numThreadeers= 10;
        int numCalificaciones = 10000;
        int[] calificaciones = new int[100000];
        Contador[] threads = new Contador[numThreadeers];
        int iniIndice = 0;
        int totalSuma = 0;

        for (int i = 0; i < numThreadeers; i++) {
            threads[i] = new Contador(i,iniIndice, numCalificaciones,calificaciones);
            iniIndice += numCalificaciones;
        }
        for (int i = 0; i < numThreadeers; i++) {
            threads[i].start();

        }
        for (int i = 0; i < numThreadeers; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            totalSuma += threads[i].getTotalSum();

        }
        System.out.println("Todos los hilos han acabado su tarea");
        double average = totalSuma/ (double) numCalificaciones;
        System.out.println("la media aritmetica es de : " +average);




    }
}