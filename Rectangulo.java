import java.util.Scanner;
public class Rectangulo 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int m, n, x1, y1, x2, y2;
        System.out.println("Ingrese n");
        n = sc.nextInt();
        System.out.println("Ingrese m");
        m = sc.nextInt();
        System.out.println("Ingrese x1");
        x1 = sc.nextInt();
        System.out.println("Ingrese y1");
        y1 = sc.nextInt();
        System.out.println("Ingrese x2");
        x2 = sc.nextInt();
        System.out.println("Ingrese y2");
        y2 = sc.nextInt();
        sc.close();
        for (int i = 0; i < m ; i++) 
        {
            for (int j = 0; j < n; j++) if (i >= x1 && i <= x2 && j >= y1 && j <= y2) System.out.print('*');
            else System.out.print('.');
            System.out.println();
        }
    }
}
