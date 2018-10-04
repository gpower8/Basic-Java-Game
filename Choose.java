import java.util.Scanner;

public class Choose {
   public static void main(String [] args) {
       System.out.println("You see a scary house. Do you and your friends investigate?   Y or N?");
       Scanner inputChoice = new Scanner(System.in);
       String choice = inputChoice.nextLine(); 
       String upchoice = choice.toUpperCase(); 
       if (upchoice.equals("Y")) {
          System.out.println("You are very brave, You see that someone left the Tridyminiumobulator on");
        } else {
          System.out.println("Dumb Fizz");

        }

        System.out.println("The Tridyminiumobulator is making weird noises. Do you walk towards it Y or N?");

        choice = inputChoice.nextLine();
        upchoice = choice.toUpperCase();

        if (upchoice.equals("Y")) {
          System.out.println("You turn the tridyminiumobulator off");
        } else {
          System.out.println("Great job Tang, now the whole world blows up");

        }
      }
    }