import java.util.Scanner;
import java.util.Random;
public class ChessColorQuiz {
   public static void main(String[] args) throws Exception {  
      //Creating Chessboard Array
      String[][] chessBoard = new String[64][64];
      int number = 1;
      for(int i = 0; i < 64; i++) {
         if ((i >= 0) && (i < 8)) {
            chessBoard[i][0] = "a" + number;
            if (number % 2 == 0) {
               chessBoard[i][1] = "White";
            } else {
               chessBoard[i][1] = "Black";
            }
         }
         if ((i >= 8) && (i < 16)) {
            if(i == 8) { number = 1; }
            chessBoard[i][0] = "b" + number;
            if (number % 2 == 0) {
               chessBoard[i][1] = "Black";
            } else {
               chessBoard[i][1] = "White";
            }            
         }
         if ((i >= 16) && (i < 24)) {
            if(i == 16) { number = 1; }
            chessBoard[i][0] = "c" + number;
            if (number % 2 == 0) {
               chessBoard[i][1] = "White";
            } else {
               chessBoard[i][1] = "Black";
            }            
         }
         if ((i >= 24) && (i < 32)) {
            if(i == 24) { number = 1; }
            chessBoard[i][0] = "d" + number;
            if (number % 2 == 0) {
               chessBoard[i][1] = "Black";
            } else {
               chessBoard[i][1] = "White";
            }            
         }
         if ((i >= 32) && (i < 40)) {
            if(i == 32) { number = 1; }
            chessBoard[i][0] = "e" + number;
            if (number % 2 == 0) {
               chessBoard[i][1] = "White";
            } else {
               chessBoard[i][1] = "Black";
            }            
         }
         if ((i >= 40) && (i < 48)) {
            if(i == 40) { number = 1; }
            chessBoard[i][0] = "f" + number;
            if (number % 2 == 0) {
               chessBoard[i][1] = "Black";
            } else {
               chessBoard[i][1] = "White";
            }            
         }
         if ((i >= 48) && (i < 56)) {
            if(i == 48) { number = 1; }
            chessBoard[i][0] = "g" + number;
            if (number % 2 == 0) {
               chessBoard[i][1] = "White";
            } else {
               chessBoard[i][1] = "Black";
            }            
         }
         if ((i >= 56) && (i <= 64)) {
            if(i == 56) { number = 1; }
            chessBoard[i][0] = "h" + number;
            if (number % 2 == 0) {
               chessBoard[i][1] = "Black";
            } else {
               chessBoard[i][1] = "White";
            }            
         }
         number++;
      }
      //Display Chessboard Array
      int lineCut = 0;
      int lineCutTwice = 0;
      for(int i = 0; i < 64; i++) {
         System.out.print(chessBoard[i][0] + "-" + chessBoard[i][1] + " | ");
         lineCut++;
         lineCutTwice++;
         if(lineCutTwice == 32) { System.out.println(""); }
         if(lineCut == 8) {
            System.out.println("");
            lineCut = 0;
         }
      }
      System.out.println("");
      //Chessboard Color Quiz
      int option;
      int correct = 0;
      int numberOfQuestions = 0;
      int question;
      Random random = new Random();
      /*
      String correctSoundEffect = "/Correct.mp3";
      String incorrectSoundEffect = "/Incorrect.mp3";
      InputStream correctInput = new FileInputStream(correctSoundEffect);
      InputStream incorrectInput = new FileInputStream(incorrectSoundEffect);
      */
      Scanner keyboard = new Scanner(System.in);
      System.out.println("ALL = 1 | TOP HALF = 2 | BOTTOM HALF = 3\n");
      int questionType = keyboard.nextInt();
      System.out.println("\nQuestion Limit? INFINITY <= 0\n");
      int questionLimit = keyboard.nextInt();
      do {
         if(questionLimit == numberOfQuestions) {
            System.out.println("Keep playing chess! See ya later!");
            System.out.println("\nScore: "+ correct + "/" + numberOfQuestions + "\n");
            break;
         }
         if(questionType == 1) {
             question = random.nextInt(64);
         } else if(questionType == 2) {
            question = random.nextInt(32);
         } else if(questionType == 3) {
            question = random.nextInt(32);
            question = question + 32;
         } else {
            question = random.nextInt(64);
         }
         System.out.println("\nWhat color is " + chessBoard[question][0] + "? | WHITE = 1 | BLACK = 2 | SCORE = 3 | EXIT = 4 |");
         option = keyboard.nextInt();
         if(option == 1) {
            if ("White" == chessBoard[question][1]) {
               System.out.println("\nCorrect!\n" + chessBoard[question][0] + "-" + chessBoard[question][1] + "\n");
               correct++;
               numberOfQuestions++;
            } else {
               System.out.println("\nIncorrect!\n" + chessBoard[question][0] + "-" + chessBoard[question][1] + "\n");
               numberOfQuestions++;
            }
         } else if(option == 2) {
            if ("Black" == chessBoard[question][1]) {
               System.out.println("\nCorrect!\n" + chessBoard[question][0] + "-" + chessBoard[question][1] + "\n");
               correct++;
               numberOfQuestions++;
            } else {
               System.out.println("\nIncorrect!\n" + chessBoard[question][0] + "-" + chessBoard[question][1] + "\n");
               numberOfQuestions++;
            }
         } else if(option == 3) {
            System.out.println("\nScore: "+ correct + "/" + numberOfQuestions + "\n");
         } else if(option == 4) {
            System.out.println("\nKeep playing chess! See ya later!");
            System.out.println("\nScore: "+ correct + "/" + numberOfQuestions + "\n");
         } else {
            System.out.println("\nInvalid option.\n");
         }
         keyboard.nextLine();
      } while(option != 4);
   }
}