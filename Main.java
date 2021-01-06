import java.util.Scanner;
public class Main {
enum Color {
    RESET("\033[0m"),
    BLACK("\033[0;30m"),   
    RED("\033[0;31m"),      
    GREEN("\033[0;32m"),    
    YELLOW("\033[0;33m"),   
    BLUE("\033[0;34m"),     
    MAGENTA("\033[0;35m"),  
    CYAN("\033[0;36m"),     
    WHITE("\033[0;37m"),    
    // Bold
    BLACK_BOLD("\033[1;30m"),   
    RED_BOLD("\033[1;31m"),     
    GREEN_BOLD("\033[1;32m"),   
    YELLOW_BOLD("\033[1;33m"), 
    BLUE_BOLD("\033[1;34m"),    
    MAGENTA_BOLD("\033[1;35m"), 
    CYAN_BOLD("\033[1;36m"),    
    WHITE_BOLD("\033[1;37m"),  
    // Underline
    BLACK_UNDERLINED("\033[4;30m"),     
    RED_UNDERLINED("\033[4;31m"),       
    GREEN_UNDERLINED("\033[4;32m"),     
    YELLOW_UNDERLINED("\033[4;33m"),    
    BLUE_UNDERLINED("\033[4;34m"),     
    MAGENTA_UNDERLINED("\033[4;35m"),   
    CYAN_UNDERLINED("\033[4;36m"),      
    WHITE_UNDERLINED("\033[4;37m"),     
    // Background
    BLACK_BACKGROUND("\033[40m"),   
    RED_BACKGROUND("\033[41m"),    
    GREEN_BACKGROUND("\033[42m"),   
    YELLOW_BACKGROUND("\033[43m"),  
    BLUE_BACKGROUND("\033[44m"),    
    MAGENTA_BACKGROUND("\033[45m"), 
    CYAN_BACKGROUND("\033[46m"),    
    WHITE_BACKGROUND("\033[47m"),   
    // High Intensity
    BLACK_BRIGHT("\033[0;90m"),     
    RED_BRIGHT("\033[0;91m"),       
    GREEN_BRIGHT("\033[0;92m"),     
    YELLOW_BRIGHT("\033[0;93m"),    
    BLUE_BRIGHT("\033[0;94m"),      
    MAGENTA_BRIGHT("\033[0;95m"),   
    CYAN_BRIGHT("\033[0;96m"),      
    WHITE_BRIGHT("\033[0;97m"),     
    // Bold High Intensity
    BLACK_BOLD_BRIGHT("\033[1;90m"),    
    RED_BOLD_BRIGHT("\033[1;91m"),      
    GREEN_BOLD_BRIGHT("\033[1;92m"),   
    YELLOW_BOLD_BRIGHT("\033[1;93m"),   
    BLUE_BOLD_BRIGHT("\033[1;94m"),     
    MAGENTA_BOLD_BRIGHT("\033[1;95m"),  
    CYAN_BOLD_BRIGHT("\033[1;96m"),     
    WHITE_BOLD_BRIGHT("\033[1;97m"),    
    // High Intensity backgrounds
    BLACK_BACKGROUND_BRIGHT("\033[0;100m"),     
    RED_BACKGROUND_BRIGHT("\033[0;101m"),       
    GREEN_BACKGROUND_BRIGHT("\033[0;102m"),     
    YELLOW_BACKGROUND_BRIGHT("\033[0;103m"),    
    BLUE_BACKGROUND_BRIGHT("\033[0;104m"),      
    MAGENTA_BACKGROUND_BRIGHT("\033[0;105m"),   
    CYAN_BACKGROUND_BRIGHT("\033[0;106m"),      
    WHITE_BACKGROUND_BRIGHT("\033[0;107m");     
    private final String code;
    Color(String code) {
        this.code = code;
    }
    @Override
    public String toString() {
        return code;
    }
} 
static void sleepf() {
  try {
          Thread.sleep(1000);
        }
        catch(InterruptedException ex) {
          Thread.currentThread().interrupt();
      }
}
static void loadf() {
  try {
          Thread.sleep(5000);
        }
        catch(InterruptedException ex) {
          Thread.currentThread().interrupt();
      }
}
    public static void typewriter(String message, long millisPerChar)
    {
        for (int i = 0; i < message.length(); i++)
        {
            System.out.print(message.charAt(i));

            try
            {
                Thread.sleep(millisPerChar);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
    public static void clearf() {
      System.out.print("\033[H\033[2J");
      System.out.flush();
    }
    public static void deathf() {
      System.out.print(Color.RESET);
      System.out.print(Color.RED_BACKGROUND_BRIGHT);
      clearf();
      typewriter("YOU DIED", 50);
      System.out.print(Color.RESET);
      System.exit(0);
    }
    public static void startPoint() {
      System.out.print(Color.WHITE_BOLD);
      typewriter("You wake up in a cold room. You don't remember where you are. As you slowy start seeing in the dark, you see a lamp in your blurry vision. What do you do?\n", 50);
      System.out.print(Color.RESET);
      System.out.print(Color.BLUE_BOLD);
      while (true) {
        Scanner lampOnObj = new Scanner(System.in);  // Create a Scanner object
        String lampOn = lampOnObj.nextLine();
        if (lampOn.equals ("use")) {
          break;

        }
        else if (lampOn.equals ("look")) {
          System.out.print(Color.RESET);
          System.out.print(Color.WHITE_BOLD);
          typewriter("It's to dark to see. You should turn on you lamp by using the 'use' command.\n", 50);
          System.out.print(Color.BLUE_BOLD);
        }
        else if (lampOn.equals ("move")) {
          System.out.print(Color.RESET);
          System.out.print(Color.WHITE_BOLD);
          typewriter("You get up, you walk and bang into a wall, -1 damage. ", 50);
          deathf();
        }
        else if (lampOn.equals ("")) {
          System.out.print(Color.RESET);
          System.out.print(Color.WHITE_BOLD);
          typewriter("INPUT CANNOT BE NULL\n", 50);
        }
        else {
          System.out.print(Color.RESET);
          System.out.print(Color.WHITE_BOLD);
          typewriter("INVALID OPTION\n", 50);
        }
      }
      System.out.print(Color.RESET);
      System.out.print(Color.WHITE_BOLD);
      sleepf();
      clearf();
      typewriter("You turn on the lamp an can somewhat see. You realise that your in your room.", 50);
      sleepf();
      typewriter("\nYou get up and get dressed for the day. When you walk out of the room. It is way different. ", 50);
    }
    public static void main(String[] args) {
      clearf();
      System.out.print(Color.RED_BOLD);
      typewriter("Welcome to this text adventure, what is your name?\n", 50);
      System.out.print(Color.RESET);
      Scanner nameObj = new Scanner(System.in);  // Create a Scanner object
      String name = nameObj.nextLine();  // Read user input
      System.out.print(Color.RED_BOLD);
      typewriter("Your name is now: " + name, 50);
      sleepf();
      clearf();
      System.out.print(Color.RESET);
      System.out.print(Color.GREEN_BOLD);
      typewriter("Compiling game...\n", 50);
      System.out.print(Color.RESET);
      loadf();
      clearf();
      startPoint();
    }
}
/*
public static void {Name}() {
  // Code here
}
*/
