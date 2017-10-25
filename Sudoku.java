import java.util.Scanner;

public class Sudoku
{
    static int matriz[][];
    public static void main(String[] args)
    {
        System.out.println("Ingrese Sudoku.");
        matriz = leerMatriz();
        System.out.println("Sudoku ingresado.");

        backtracking(matriz, 0);
    }

    public static void backtracking(int [][] m,int l)
    {
        if(Reject(l, 0, 0)) return;
        if(Accept()) output();
        /*
        if(First()) do {
            backtracking(x,l+1);
        } while(Next(m,l+1));
        */
    }

    static boolean Reject(int l, int x, int y) 
    {
        if (x >= 0 && x < 3)
        {
            if (y >= 0 && y < 3)
            {
                for (i=0; i<3; i++)
                for (j=0; j<3; j++)
                if (l == matriz[i][j])
                return true;
            }
            else if (y >= 3 && y < 6)
            {
                for (i=3; i<6; i++)
                for (j=3; j<6; j++)
                if (l == matriz[i][j])
                return true;
            }
            else if (y >= 6 && y < 9)
            {
                for (i=6; i<9; i++)
                for (j=6; j<9; j++)
                if (l == matriz[i][j])
                return true;
            }
        }
        else if (x >= 3 && x < 6)
        {
            if (y >= 0 && y < 3)
            {
                for (i=0; i<3; i++)
                for (j=0; j<3; j++)
                if (l == matriz[i][j])
                return true;
            }
            else if (y >= 3 && y < 6)
            {
                for (i=3; i<6; i++)
                for (j=3; j<6; j++)
                if (l == matriz[i][j])
                return true;
            }
            else if (y >= 6 && y < 9)
            {
                for (i=6; i<9; i++)
                for (j=6; j<9; j++)
                if (l == matriz[i][j])
                return true;
            }
        }
        else if (x >= 6 && x < 9)
        {
            if (y >= 0 && y < 3)
            {
                for (i=0; i<3; i++)
                for (j=0; j<3; j++)
                if (l == matriz[i][j])
                return true;
            }
            else if (y >= 3 && y < 6)
            {
                for (i=3; i<6; i++)
                for (j=3; j<6; j++)
                if (l == matriz[i][j])
                return true;
            }
            else if (y >= 6 && y < 9)
            {
                for (i=6; i<9; i++)
                for (j=6; j<9; j++)
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

    static boolean Accept() 
    {
        return true;
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

}