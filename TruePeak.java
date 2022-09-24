import java.io.*;
import java.util.*;


public class TruePeak
{
    public static void main(String[] args)
    {
        String fileName;
        System.out.println("Enter the name of the data file:");
        Scanner newScanner = new Scanner(System.in);
        fileName = newScanner.nextLine();
        
        String [] dataValues;

        try
        {
            File f = new File(fileName);
            Scanner fileCont = new Scanner(f);
            
            String line = fileCont.nextLine();
            dataValues = line.split(" ");
            
            System.out.print("Data values: ");
            
            int dataVal[] = new int[dataValues.length];
            for (int i = 0; i < dataValues.length; i++)
            {
               dataVal[i] = Integer.parseInt(dataValues[i]);
               System.out.print(dataVal[i]);
               System.out.print(" ");
            }
            System.out.print("\n");
            //dataVal[] array containt the integer values for the input data
            System.out.print("Transition indices: ");
            System.out.print(0);
            int last=0;
            int i = 0;
            for(int j = 1; j < dataVal.length-1; j++)
            {
               int prev = j-1;
               int next = j+1;
               if (dataVal[j] < dataVal[prev] && dataVal[j] < dataVal[next] || dataVal[j] > dataVal[prev] && dataVal[j] > dataVal[next])
               {      
                  
                  System.out.print(j);
                  System.out.print(" ");
               }
               last = j;
            }
            System.out.println(last+1);
            
            int margin;
            System.out.println("Enter the true peak margin:");
            Scanner marginScanner = new Scanner(System.in);
            margin = newScanner.nextInt();

            System.out.print("true Peak: ");
            for(int j = 1; j < dataVal.length-1; j++)
            {
               int prev = j-1;
               int next = j+1;
               if (dataVal[j] < dataVal[prev] && dataVal[j] < dataVal[next] || dataVal[j] > dataVal[prev] && dataVal[j] > dataVal[next])
               {      
                  if (dataVal[j]-dataVal[prev] >= margin)
                  {
                     System.out.print(j);
                     System.out.print(" ");
                  }
               }
            }
        }
        catch(Exception e)
        {
            System.out.println("Error file does not exixts");   //to be removed
            System.exit(0);
        }
    }
}