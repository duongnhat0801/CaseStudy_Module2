import java.util.Scanner;

public class Input {
 private static Scanner sc = new Scanner(System.in);
 public static int getInt(){
     try{
         return Integer.parseInt(sc.nextLine());
     }catch (Exception e) {
         System.out.println("Vui lòng nhập số: ");
         return getInt();
     }
 }
    public static String getString() {
        return sc.nextLine();
    }
    public static double getDouble(){
        try{
            return Double.parseDouble(sc.nextLine());
        }catch (Exception e) {
            System.out.println("Vui lòng nhập số: ");
            return getDouble();
        }
    }
}

