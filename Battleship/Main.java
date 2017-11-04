import java.io.*;
import java.util.Scanner;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese tamano del tablero (min 10):");
    int n = sc.nextInt();
    int l;
    Tablero CPU = new Tablero(n);
    int[][] matriz = new int[n][n];
    /*
    for(int i=1;i<=n;i++){
      for(int j=1;j<=n;j++){
        CPU.disparo(i,j);
        if((l=CPU.ganar())>0){
          System.out.println("Lo lograste en: " + l + " intentos");
          System.exit(0);
        } 
      }
    }
    */

    
    int i=0,j=0, largo=0, cont=0;
    while ((l=CPU.ganar())==0)
    {
      i= (int)(Math.random()*n)+1;
      j= (int)(Math.random()*n)+1;

      if (matriz[i-1][j-1] == 0)
      {
        switch (CPU.disparo(i, j))
        {
          case 'A': largo=5; break;
          case 'B': largo=4; break;
          case 'C': largo=3; break;
          case 'S': largo=3; break;
          case 'D': largo=2; break;
          default: largo=-1;
        }
        matriz[i-1][j-1] = largo;
        CPU.Imprimir();
      }
      
      System.out.println(i + ", " + j);
    }
    System.out.println("Lo lograste en: " + l + " intentos");
    System.exit(0);
  }
}