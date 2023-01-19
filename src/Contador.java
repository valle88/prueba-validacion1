public class Contador extends  Thread{
    private int identificador;
    private int indice;
    private int  nunCalificaciones;
    private int[] calificaciones;
    private int totalSuma;

    public Contador(int identificador, int indice, int nunCalificaciones, int[] calificaciones) {
        this.identificador = identificador;
        this.indice = indice;
        this.nunCalificaciones = nunCalificaciones;
        this.calificaciones = calificaciones;
        this.totalSuma = totalSuma;
    }

    @Override
    public void run() {
        for (int i = indice ; i < indice + nunCalificaciones; i++) {
            totalSuma += calificaciones[i];
        }
        System.out.println("el hilo "+identificador+ "que empezo por: "+ indice + " ha sumado un total de: " +totalSuma);
    }

    public int getTotalSum() {
        return totalSuma;
    }

    public void setTotalSum(int totalSum) {
        this.totalSuma = totalSum;
    }
}
