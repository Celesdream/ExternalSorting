
package externalsorting;
public class QuickSort 
{
    public static void Muestra(int[] Vect)
{
    for(int i=0;i<Vect.length;i++)
    {
        System.out.print(Vect[i]+" ");
    }
}
    public static void QuickRapido(int vec[])
    {
        final int N=vec.length;
        quickSort(vec, 0, N-1);
    }
    public static void quickSort(int vec[], int Inicio, int Final)
    {
        if(Inicio>=Final) return;
        int pivote=vec[Inicio];
        int ElementoIzquierdo=Inicio+1;
        int ElementoDerecho=Final;
        while(ElementoIzquierdo<=ElementoDerecho)
        {
            while(ElementoIzquierdo<=Final && vec[ElementoIzquierdo]<pivote)
            {
                ElementoIzquierdo++;
            }
            while(ElementoDerecho>Inicio && vec[ElementoDerecho]>=pivote)
            {
                ElementoDerecho--;
            }
        if(ElementoIzquierdo<ElementoDerecho)
        {
            int temp=vec[ElementoIzquierdo];
            vec[ElementoIzquierdo]=vec[ElementoDerecho];
            vec[ElementoDerecho]=temp;
        }
        }
                
        if(ElementoDerecho>Inicio)
        {
            int Temporal=vec[Inicio];
            vec[Inicio]=vec[ElementoDerecho];
            vec[ElementoDerecho]=Temporal;
        }
        quickSort(vec, Inicio, ElementoDerecho-1);
        quickSort(vec, ElementoDerecho+1, Final);
    }

        
}
