
import java.util.Scanner; 
import java.util.ArrayList;
class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
  }
}

class Player {
  private String name; 

  public Player(String aName) {
    name = aName;
  }
  public String getName() {
    return name;
  }
  public String getNextMove(String[][] arrayList) {
    
    ArrayList<String> openSpaces = new ArrayList<String>();
    boolean jeff = false;
    int counter = 0;
    for(int x = 0; x < arrayList.length; x++) {
      for(int y = 0; y < arrayList.length; x++) {
        if(arrayList[x][y] == "--") {
          jeff = true;
          counter++;
          String s = Integer.toString(counter);
          openSpaces.add(s);
        }
      }
    }
    if(jeff == false) {
      return "no moves";
    }
    String chosen;
    while(true) {
      System.out.println("Choose a number 1-9 for your next move");
      System.out.print("your open spaces are:  ");
      for(int b = 0; b < openSpaces.size(); b++) {
        System.out.print(openSpaces.get(b) + ", ");
      }
      System.out.println(" ");
      System.out.print("Your Move: ");
      Scanner sc = new Scanner(System.in);
      chosen = sc.nextLine();
      sc.close();
      boolean jim = false;
      for(int a = 0; a < openSpaces.size(); a++) {
        if(openSpaces.get(a) == chosen) {
          jim = true;
        }
      }
      if(jim == true) {
        return chosen;
      }
      else {
        System.out.println("That is not an open space, please try again");
      }
    }    
  }
}
