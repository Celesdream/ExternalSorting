
package externalsorting;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;


public class ExternalSorting
{
    
    static int TAM = 920000; //numero de elementos a ordenar tamaño del archivo en el disco
    static int MAX = TAM/10; // numero de elementos que el buffer de memoria puede contener
    //que es diez veces menos al tamaño del archivo a ordenar
    
    public static void main(String[] args)
    {
     long totalTiempo;
     long tiempoInicio;
     tiempoInicio = System.nanoTime();
     String NombArch = Entrada(TAM);
     externalSort(NombArch);
     totalTiempo = System.nanoTime() - tiempoInicio;
     System.out.println("Tiempo demorado:\t" + totalTiempo + " nanosegundos.");
    }
    static String Entrada(int n) //Aqui generamos el archivo de entrada
    {
     String Nombre = "‪ENTRADA.txt";
     Random Alea = new Random();
     try
     {
         FileWriter FW = new FileWriter(Nombre);
         PrintWriter PRINTWRIT = new PrintWriter(FW);
         for (int i = 0; i < n; i++)
         PRINTWRIT.println(Alea.nextInt(Integer.MAX_VALUE)); //Generamos los numeros de 1 a N
         PRINTWRIT.close();
     }
     catch (IOException EXC){}
     return Nombre;
    }
 
    public static void externalSort(String Archivos)
    {
        String ArchCamin = "CAMINO";
        int[] Buffer = new int[MAX < TAM ? MAX : TAM];
        try
        {
            int i, j;
            i = j = 0;
            FileReader FR = new FileReader(Archivos);
            BufferedReader BR = new BufferedReader(FR);
            int CortesCaminos = 10;
          // iteramos todos los elementos del archivo
            for (i = 0; i < CortesCaminos; i++)
            {
            // Leemos N-elementos a la vez desde el archivo
                for (j = 0; j < (MAX < TAM ? MAX : TAM); j++)
                {
                    String t = BR.readLine();
                    if (t != null)
                        Buffer[j] = Integer.parseInt(t);
                    else
                        break;
                }
            QuickSort a = new QuickSort(); 
            a.QuickRapido(Buffer); //Usamos quicksort para ordenar
            //Escribe los números ordenados en el archivo temporal CAMINOXX
            FileWriter FW = new FileWriter(ArchCamin + Integer.toString(i) + ".txt");
            PrintWriter PW = new PrintWriter(FW);
            for (int k = 0; k < j; k++)
                PW.println(Buffer[k]);
            PW.close();
            FW.close();
            }
   BR.close();
   FR.close();
   // Ahora abrimos cada archivo y los combinamos, despues volvemos a escribir en el disco
   int[] TNum = new int[CortesCaminos];
   BufferedReader[] brs = new BufferedReader[CortesCaminos];
   for (i = 0; i < CortesCaminos; i++)
   {
    brs[i] = new BufferedReader(new FileReader(ArchCamin + Integer.toString(i) + ".txt"));
    String t = brs[i].readLine();
    if (t != null)
     TNum[i] = Integer.parseInt(t);
    else
     TNum[i] = Integer.MAX_VALUE;
   }
   FileWriter FW = new FileWriter("SALIDA.txt");
   PrintWriter PW = new PrintWriter(FW);
   for (i = 0; i < TAM; i++)
   {
    int Min = TNum[0];
    int MinArch = 0;
    for (j = 0; j < CortesCaminos; j++)
    {
     if (Min > TNum[j])
     {
      Min = TNum[j];
      MinArch = j;
     }
    }
    PW.println(Min);
    String S = brs[MinArch].readLine();
    if (S != null)
     TNum[MinArch] = Integer.parseInt(S);
    else
     TNum[MinArch] = Integer.MAX_VALUE;
   }
   
   for (i = 0; i < CortesCaminos; i++)
    brs[i].close();
   PW.close();
   FW.close();
  }
        catch (FileNotFoundException E){System.out.println("ERROR CON EL ARCHIVO  \n");} 
        catch (IOException EX){System.out.println("ERROR\n");} 
 }
    
}
