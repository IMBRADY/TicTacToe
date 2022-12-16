import pkg.*;

public class GameDriver implements InputControl, InputKeyControl
{
    private GameState state;
    public GameDriver(GameState initial)
    {
        state = initial;
    }
    public void play()
    {
        //Prints board first with play
        //shows the moves for the player first
        //makes moves until the game is over and prints the name of the winner or says draw if it is a draw
        //I think the scanner that creates the players and gets the names should be in the constructor for ttt though I think I could do that part here as well
        while(state.isGameOver()==false)
        {
            System.out.println("Player "+state.getCurrentPlayer().getName() + ", choose one of the following moves!");
           /* for(int c = 0; c < state.getCurrentMoves().size();c++)
            { 
                System.out.print(state.getCurrentMoves().get(c)+" ");
            }*/
            //System.out.println(state.getCurrentPlayer().getNextMove(state));
            state.makeMove(state.getCurrentPlayer().getNextMove(state));
        }
        if(state.isGameOver()==true)
        {
            state.toString();
            if(state.getWinner()!=null)
            { 
                System.out.println(state.getWinner().getName()+ " is the winner!");
            }
            else
            { 
                System.out.println("ITS A DRAW!");
            }
            System.out.println("Would you like to play again? (Put Yes or No)");
            EasyReader again = new EasyReader();
            String playans = again.readWord();
            if(playans.equals("Yes")||playans.equals("yes")||playans.equals("YES"))
            {
                play();
            }
        }
    }
}
