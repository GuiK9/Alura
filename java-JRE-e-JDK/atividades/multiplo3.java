public class multiplo3 {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            if((i * 3) > 100){
                break;
            }
            System.out.println(i * 3);
        }
    }
}
