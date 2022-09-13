public class TestaLacosen {
    public static void main(String[] args) {
        int contador = 1;
        while(contador <= 10){

             for(int i = 1; i <= 10; i++) {

                System.out.print(contador + " * " + i + " = " + (contador * i ) + " // ");
            } 
            System.out.println();
            
            contador++;
        }
    }
}
