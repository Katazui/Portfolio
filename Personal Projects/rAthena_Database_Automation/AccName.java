import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
public class AccName extends Generator {
   public String generateAccName() {
      String message = "";
      try {
         //Writing to File
         FileWriter accNameCustomOutput = new FileWriter(path + "/output_accname.txt");
         while(customSpriteInputFile.hasNextLine()) {
            String s = new String(customSpriteInputFile.nextLine());
            if (s.length() <= 1) {
               accNameCustomOutput.write("\n");
            } else { 
               accNameCustomOutput.write("\t[ACCESSORY_IDs.ACCESSORY_"+ s +"] = \"_"+ s +"\",\n");
            }
         }
         message = "\nFile \"output_accname.txt\" successfully compiled.";
         accNameCustomOutput.close();
      } catch (IOException ex) {
         message = ex + " | Cannot write output file.";
      }  
      return message; 
   }
}