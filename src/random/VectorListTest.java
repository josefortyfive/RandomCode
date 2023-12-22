package random;

import java.util.*;


public class VectorListTest {
    
    public static void main(String args[])
    {
        int size = 1_000_000;
        
        ArrayList<Integer> arrayList = new ArrayList<>();
        long start = System.currentTimeMillis();
        
        
        for(int i = 0; i < size; i++)
        {
            arrayList.add(i);
        }
        
        long end = System.currentTimeMillis();
        
        System.out.println("Added " +size+ " elements of ArrayList: "+(end - start)+"ms");
        
        
        Vector<Integer> vectorList = new Vector<>();
        start = System.currentTimeMillis();
        
        
        for(int i = 0; i < size; i++)
        {
            vectorList.add(i);
        }
        
        end = System.currentTimeMillis();
        
        System.out.println("Added " +size+ " elements of VectorList: "+(end - start)+"ms");
        
    }
}