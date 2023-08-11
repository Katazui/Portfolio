import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
public abstract class Generator {
   //Defining File Path
   public File file = new File("");
   public String path = file.getAbsolutePath();
   public Scanner customSpriteInputFile;
   public Scanner customDisplayInputFile;
   
   public File createInputSprite() {
      java.io.File customSpriteInputValues = new java.io.File(path + "/input_sprite.txt");
      try {
         if (customSpriteInputValues.exists()) {
            System.out.println("\nFile \"input_sprite.txt\" already created.");
         } else {
            System.out.println("\nFile \"input_sprite.txt\" created.");
            customSpriteInputValues.createNewFile();
            System.out.println("\nProgram has stopped. Please enter values in input files, then re-run this program again.");
            System.exit(0);                   
         }
      } catch (IOException ex) {
         System.out.println(ex + "Cannot write output file.");
      }
      return customSpriteInputValues;
   }
   
   public File createInputDisplay() {
      java.io.File customDisplayInputValues = new java.io.File(path + "/input_display.txt");
      try {
         if (customDisplayInputValues.exists()) {
            System.out.println("\nFile \"input_display.txt\" already created.");
         } else {
            System.out.println("\nFile \"input_display.txt\" created.");
            customDisplayInputValues.createNewFile();
            System.out.println("\nProgram has stopped. Please enter values in input files, then re-run this program again.");
            System.exit(0);            
         }
      } catch (IOException ex) {
         System.out.println(ex + "Cannot write output file.");
      }
      return customDisplayInputValues;
   }
   
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