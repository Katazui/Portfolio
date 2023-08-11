
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
public class GeneratorDemo {

   public static void main (String [] args) throws IOException  {
      Scanner keyboard = new Scanner (System.in);
      
      //Defining File Path
      File file = new File("");
      String path = file.getAbsolutePath();
      
      Generator create = new Files();
      //Creating InputSprite.txt file
      Scanner customSpriteInputFile = new Scanner(create.createInputSprite());
      //Creating InputDisplay.txt file
      Scanner customDisplayInputFile = new Scanner(create.createInputDisplay());
      
      //Menu
      System.out.println("\nMade by Katazui.com | Verison 1.0\n\nSelect Generation Option:");
      System.out.println("\t0 - Exit");
      System.out.println("\t1 - accname.lua");
      System.out.println("\t2 - accessoryid.lua");
      System.out.println("\t3 - item_db.txt");
      System.out.println("\t4 - itemInfo.lua");
      int select = keyboard.nextInt();
      //while(select > 0) {
         
         //AccName
         if (select == 1) {
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
               System.out.println("\nFile \"output_accname.txt\" successfully compiled.");
               accNameCustomOutput.close();
            } catch (IOException ex) {
               System.out.println(ex + " | Cannot write output file.");
            }
         }
         
         //AcessoryID
         if (select == 2) {
            System.out.println("Enter View ID starting number.");
            int viewID = keyboard.nextInt();
            viewID--;
            try {
               //Writing to File
               FileWriter accessoryIDCustomOutput = new FileWriter(path + "/output_accessoryid.txt");
               while(customSpriteInputFile.hasNextLine()) {
                  String s = new String(customSpriteInputFile.nextLine());
                  viewID++;
                  if (s.length() <= 1) {
                     accessoryIDCustomOutput.write("\n");
                     viewID--;
                  } else { 
                     accessoryIDCustomOutput.write("\tACCESSORY_"+ s +" = "+ (viewID) +",\n");
                  }
               }
               System.out.println("\nFile \"output_accessoryid.txt\" successfully compiled.");
               accessoryIDCustomOutput.close();
            } catch (IOException ex) {
               System.out.println(ex + " | Cannot write output file.");
            }
         }
         
         
         //ItemID
         if (select == 3) {
            System.out.println("Enter View ID starting number.");
            int viewID = keyboard.nextInt();
            viewID--;
            System.out.println("Enter Item ID starting number.");
            int itemID = keyboard.nextInt();
            itemID--;
            try {
               //Writing to File
               FileWriter itemdbCustomOutput = new FileWriter(path + "/output_itemdb.txt");
               while(customSpriteInputFile.hasNextLine()) {
                  String s = new String(customSpriteInputFile.nextLine());
                  String d = new String(customDisplayInputFile.nextLine());
                  viewID++;
                  itemID++;
                  if (s.length() <= 1) {
                     itemdbCustomOutput.write("\n");
                     viewID--;
                     itemID--;
                  } else {
                     itemdbCustomOutput.write("" + itemID + "," + s + "," + d + ",4,20,,1000,,5,,2,0xFFFFFFFF,63,2,256,,1,0," + (viewID) + ",{},{},{}\n");
                  }
               }
               System.out.println("\nFile \"output_itemdb.txt\" successfully compiled.");
               itemdbCustomOutput.close();
            } catch (IOException ex) {
               System.out.println(ex + " | Cannot write output file.");
            }
         }
         
         
         //ItemInfo
         if (select == 4) {
            System.out.println("Enter View ID starting number.");
            int viewID = keyboard.nextInt();
            viewID--;
            System.out.println("Do you want to print ViewID? [true/false]");
            boolean viewIDCheck = keyboard.nextBoolean();
            System.out.println("Enter Item ID starting number.");
            int itemID = keyboard.nextInt();
            itemID--;
            try {
               //Writing to File
               FileWriter itemInfoCustomOutput = new FileWriter(path + "/output_iteminfo.txt");
               while(customSpriteInputFile.hasNextLine() && customDisplayInputFile.hasNextLine()) {
                  String s = new String(customSpriteInputFile.nextLine());
                  String d = new String(customDisplayInputFile.nextLine());
                  itemID++;
                  viewID++;
                  if (s.length() <= 1) {
                     itemID--;
                     viewID--;
                  } else {                   
                     itemInfoCustomOutput.write("\t["+(itemID)+"] = {\n");
                     itemInfoCustomOutput.write("\t\tunidentifiedDisplayName = \""+d+"\",\n");
                     itemInfoCustomOutput.write("\t\tunidentifiedResourceName = \""+s+"\",\n");
                     itemInfoCustomOutput.write("\t\tunidentifiedDescriptionName = {\n");
                     itemInfoCustomOutput.write("\t\t\t\"Unidentified item, can be identified with [Magnifier].\"\n");
                     itemInfoCustomOutput.write("\t\t},\n");
                     itemInfoCustomOutput.write("\t\tidentifiedDisplayName = \""+d+"\",\n");
                     itemInfoCustomOutput.write("\t\tidentifiedResourceName = \""+s+"\",\n");
                     itemInfoCustomOutput.write("\t\tidentifiedDescriptionName = {\n");
                     itemInfoCustomOutput.write("\t\t\t\"No description yet.\",\n");
                     itemInfoCustomOutput.write("\t\t\t\"-------------------------\",\n");
                     itemInfoCustomOutput.write("\t\t\t\"No effect yet.\",\n");
                     itemInfoCustomOutput.write("\t\t\t\"-------------------------\",\n");
                     itemInfoCustomOutput.write("\t\t\t\"Source:^FF6666 In-Development^000000\",\n");
                     itemInfoCustomOutput.write("\t\t\t\"Class:^6666CC Headgear ^000000\",\n");
                     itemInfoCustomOutput.write("\t\t\t\"Defense:^0000FF 5 ^000000\",\n");
                     itemInfoCustomOutput.write("\t\t\t\"Position:^6666CC Upper ^000000\",\n");
                     itemInfoCustomOutput.write("\t\t\t\"Weight:^009900 100 ^000000\",\n");
                     itemInfoCustomOutput.write("\t\t\t\"Level Requirement:^009900 1 ^000000\",\n");
                     itemInfoCustomOutput.write("\t\t\t\"Jobs:^6666CC All Classes ^000000\"\n");
                     itemInfoCustomOutput.write("\t\t},\n");
                     itemInfoCustomOutput.write("\t\tslotCount = 2,\n");
                     if (viewIDCheck == false) { itemInfoCustomOutput.write("\t\tClassNum = 0\n"); } else { itemInfoCustomOutput.write("\t\tClassNum = " + (viewID) + "\n"); }
                     itemInfoCustomOutput.write("\t},\n");
                  }
               }
               itemInfoCustomOutput.close();
               System.out.println("\nFile \"output_iteminfo.txt\" successfully compiled.");
            } catch (IOException ex) {
               System.out.println(ex + " | Cannot write output file.");
            }
         }
         
         //Item List
         if (select == 5) {
            System.out.println("Enter Item ID starting number.");
            int itemID = keyboard.nextInt();
            System.out.println("Enter Item ID final number.");
            int itemIDFinal = keyboard.nextInt();
            int itemDiff = itemIDFinal - itemID;
            itemID--;
            try {
               //Writing to File
               FileWriter itemListCustomOutput = new FileWriter(path + "/output_itemlist.txt");
               for(int i = 0; i <= itemDiff; i++) {
                  itemID++;
                  itemListCustomOutput.write("\tAdd(4,"+itemID+",1,0,0,33004,1);\n");
               }
               System.out.println("\nFile \"output_itemlist.txt\" successfully compiled.");
               itemListCustomOutput.close();
            } catch (IOException ex) {
               System.out.println(ex + " | Cannot write output file.");
            }
         }         
         
         /*
         System.out.println("");
         System.out.println("Select Generation Option:");
         System.out.println("\t0 - Exit");
         System.out.println("\t1 - itemInfo.lua");
         System.out.println("\t2 - accessoryid.lua");
         System.out.println("\t3 - accname.lua");
         select = keyboard.nextInt();
         */
      //}
      
   }
}