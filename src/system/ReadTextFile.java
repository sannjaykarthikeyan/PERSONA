package system;
   
	// Reading Details of Input File to the eye and Actual input file
   
   import java.io.*;

   
   public class ReadTextFile
   {
	   /*
	    * reads data from text files (i.e. save files)
	    */
      public static String  readTextFile(String fileName)
      {
         FileReader file;
         BufferedReader buffer;
         String input;
      
         try // attempt to read from input stream
         {
            file = new FileReader (fileName);
            buffer = new BufferedReader (file);
            
         
         		
            while ((input = buffer.readLine ()) != null) //while not eof
                return input;
          }
          // catch the error an print an error message
          // catch the error an print an error message
             catch (IOException err)
             {
                System.out.println ("error");
             }
		return null;
      }
   }