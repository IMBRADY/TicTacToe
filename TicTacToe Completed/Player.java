import java.util.ArrayList;

public class Player {
    private String name;
    public Player(String aName)
    {
        name = aName;
    }
    public String getName()
    {
        return name;
    }
    public String getNextMove(GameState state)
    {
        ArrayList<String> openSpaces = new ArrayList<String>();
        String[] Spaces = state.toString().split(":");
        for(int c = 0; c<Spaces[1].length(); c++)
        {
            openSpaces.add(Spaces[1].substring(c,c+1));
        }
        if(openSpaces.size()==0)
            return "no moves";
        String chosen = "";
        System.out.println("Choose a number 1-9 for your next move");
        System.out.print("your open spaces are:  ");
        for(int b = 0; b < openSpaces.size(); b++)
        {
            System.out.print(openSpaces.get(b) + ", ");
        }
        System.out.println("");
        System.out.print("Your Move: ");
        
        EasyReader in = new EasyReader();
        chosen = in.readWord();
        
        boolean jim = false;
        //System.out.println("size = "+openSpaces.size());
        
        for(int a = 0; a < openSpaces.size(); a++)
        {
            //System.out.println("openSpaces = "+openSpaces.get(a)+", chosen = "+chosen);
            boolean burger = openSpaces.get(a).equals(chosen);
            if(burger)
            {
                //System.out.println("god free me");
                jim = true;
                break;
            }
        } 
        if(jim)
        {
            //System.out.println("I am here");
            return chosen;
        }
        else
        {
            System.out.println("NOT A MOVE, GO AGAIN");
            return getNextMove(state);
        }
    }
}