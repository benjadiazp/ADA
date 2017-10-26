import java.io.*;
import java.util.Scanner;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese tamano del tablero (min 10):");
    int n = sc.nextInt();
    int l;
    Tablero CPU = new Tablero(n);
    for(int i=1;i<=n;i++){
      for(int j=1;j<=n;j++){
        CPU.disparo(i,j);
        if((l=CPU.ganar())>0){
          System.out.println("Lo lograste en: " + l + " intentos");
          System.exit(0);
        } 
      }
    }
  }
}