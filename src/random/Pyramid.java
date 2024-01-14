package random;

public class Pyramid {
    
    public static void main(String args[])
    {
        int rows = 5;
        int k = 0;
        
        for(int i = 1; i <= rows; i++)
        {
            for(int space = 1; space <= rows - i; space++)
            {
                System.out.print(" ");
            }
            
            k = 0;
            
            while(k != 2 * i - 1)
            {
                System.out.print("* ");
                ++k;
            }
            
            System.out.println();
        }
    }
}