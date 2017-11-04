import java.util.Scanner;

import javax.net.ssl.ExtendedSSLSession;

public class Sudoku
{
    static int matriz[][];
    public static void main(String[] args)
    {
        System.out.println("Ingrese Sudoku.");
        matriz = leerMatriz();
        System.out.println("Sudoku ingresado.");

        backtracking(matriz, 0, 0, -1);
    }

    public static void backtracking(int [][] m,int fila, int columna, int l)
    {
        if(Reject(l, 0, 0)) return;
        if(Accept(m, fila, columna)) output();
        
        if(First()) do {
            backtracking(x,l+1);
        } while(Next(m,l+1));
        
    }

    static boolean Reject(int l, int x, int y) 
    {
        if (x >= 0 && x < 3)
        {
            if (y >= 0 && y < 3)
            {
                for (int i=0; i<3; i++)
                for (int j=0; j<3; j++)
                if (l == matriz[i][j])
                return true;
            }
            else if (y >= 3 && y < 6)
            {
                for (int i=0; i<3; i++)
                for (int j=0; j<3; j++)
                if (l == matriz[i][j])
                return true;
            }
            else if (y >= 6 && y < 9)
            {
                for (int i=0; i<3; i++)
                for (int j=0; j<3; j++)
                if (l == matriz[i][j])
                return true;
            }
        }
        else if (x >= 3 && x < 6)
        {
            if (y >= 0 && y < 3)
            {
                for (int i=0; i<3; i++)
                for (int j=0; j<3; j++)
                if (l == matriz[i][j])
                return true;
            }
            else if (y >= 3 && y < 6)
            {
                for (int i=0; i<3; i++)
                for (int j=0; j<3; j++)
                if (l == matriz[i][j])
                return true;
            }
            else if (y >= 6 && y < 9)
            {
                for (int i=0; i<3; i++)
                for (int j=0; j<3; j++)
                if (l == matriz[i][j])
                return true;
            }
        }
        else if (x >= 6 && x < 9)
        {
            if (y >= 0 && y < 3)
            {
                for (int i=0; i<3; i++)
                for (int j=0; j<3; j++)
                if (l == matriz[i][j])
                return true;
            }
            else if (y >= 3 && y < 6)
            {
                for (int i=0; i<3; i++)
                for (int j=0; j<3; j++)
                if (l == matriz[i][j])
                return true;
            }
            else if (y >= 6 && y < 9)
            {
                for (int i=0; i<3; i++)
                for (int j=0; j<3; j++)
                if (l == matriz[i][j])
                return true;
            }
        }
        for (int i=0; i<9; i++)
        {
            if(l==matriz[x][i] || l==matriz[i][y])
                return true;
            
        }
        return false;
    }

    static boolean Accept(int[][] m, int x, int y) 
    {
        if (siguienteCelda(m, x, y)==null)
        return true;
        return false;

    }

    static void output() 
    {
        System.out.println("\n\nSudoku terminado:\n");
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            System.out.print(matriz[i][j] + " ");
            System.out.println();
        }
        System.exit(0);
        
    }

    static boolean First() 
    {
        return true;
    }

    static boolean Next() 
    {

        return true;
    }

    static int[][] leerMatriz() 
    {
        Scanner sc = new Scanner(System.in);
        int[][] matriz = new int[9][9];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                matriz[i][j] = sc.nextInt();
        sc.close();
        return matriz;
    }

    static int[] siguienteCelda(int[][] matriz, int x, int y)
    {
        int[] pos = new int[] {x, y};
        while (x<8)
        {
            pos[0]++;
            if (matriz[pos[0]][pos[1]]==0)
            return pos;
        }
        if (y<8)
        {
            pos[0]=0;
            pos[1]++;
            
        }
        else
        {
            return null;
        }
        return pos;
    }

}