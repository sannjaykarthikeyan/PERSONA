package system; 

import java.io.*;
   import java.util.*;

   public class WriteTextFile
   {
      Scanner sc = new Scanner(System.in);
      
      /**
       * Writes data to text files
       * @param fileName
       * @param text
       * @param overwrite
       */
      public static void write (String fileName, String text, boolean overwrite)
      {
        
         FileWriter file;		
         BufferedWriter buffer;
      
         try 
         {
            file = new FileWriter (fileName, overwrite);  
            buffer = new BufferedWriter (file);
            buffer.write(text);		
            buffer.close ();			
         }
         
            catch (IOException err)
            {
               System.out.println ("error");
            }
      
      }
   }