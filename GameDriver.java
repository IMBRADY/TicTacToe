

public class GameDriver
{
public GameDriver(GameState initial)
{
 state = initial;
}
public void play()
{
//Prints board first with play
for(int i = 0; i < 3; i++)
{
 for int g = 0; g < 3; g++)
{
 System.out.print(“-- ”);
}
 System.out.println();
}
//shows the moves for the player first
//makes moves until the game is over and prints the name of the winner or says draw if it is a draw
//I think the scanner that creates the players and gets the names should be in the constructor for ttt though I think I could do that part here as well
 while(state.isGameOver()==false)
 {
    System.out.println(state.getCurrentPlayer().getName() + “ choose one of the following moves!”);
   for(int c = 0; c < state.getCurrentMoves().size();c++)
  { 
   System.out.print(state.getCurrentMoves().get(c)+” “);
  }
     state.makeMove(state.getCurrentPlayer().getNextMove(state));
      if(state.isGameOver()==true)
     {
      if(state.getWinner()!=null)
     { 
       System.out.println(state.getWinner().getName()+ “ is the winner!”);
      }
     else
    { 
     System.out.println(“draw”):
    }
     }
 }
}
}

          
