import java.util.ArrayList;

public class TTT implements GameState
{
	private Player X;
	private Player O;
	private int connect3res;
	private String[][] board;
	private int moveCount = 0;
	public TTT()
	{
		board = new String[3][3];
		String d = " ";
		for(int c = 0; c<board.length; c++)
			for(int i = 0; i<board[0].length; i++)
				board[c][i] = d;
		X = new Player("X");
		O = new Player("O");
	}
	private void newBoard()
	{
		moveCount = 0;
		for(int c = 0; c < board.length; c++)
            for(int i = 0; i < board[0].length; i++)
				board[c][i]=" ";
	}
	public String convertBoard(int c)
	{
		int r = 1;
		if(c > 9)
		{
			System.out.print("Improper request");
			return " ";
		}
		while(c > 3)
		{
			r++;
			c = c-3;
		}
		return r+","+c;
	}
	public boolean isGameOver()
	{
		//System.out.println(getCurrentMoves().size());
		if (connect3(board) == 1){
			connect3res = 1;
			return true;
		}
		else if (connect3(board) == 2){
			connect3res = 2;
			return true;
		}
		else if(getCurrentMoves().size()==0)
		{
			connect3res = 0;
			//System.out.println("not funny");
			return true;
		}
		else {
			return false;
		}
	}
    public Player getWinner(){
		newBoard();
		if (connect3res == 1){
			return X;
		}
		else if (connect3res == 2){
			return O;
		}
		else {
			return null;
		}
	}
    public Player getCurrentPlayer(){
		// if (isGameOver()==false){
		if(moveCount%2==0){
			return X;
		}
		else{
			return O;
		}
	}
	public ArrayList<String> getCurrentMoves(){
		ArrayList<String> availablemoves = new ArrayList<String>();
		int count = 1;
		for (int r = 0; r<board.length; r++){
			for (int c=0; c<board[0].length; c++)
			{
				if(board[r][c].equals(" "))
					availablemoves.add(count+"");
				count++;
			}
		}
		return availablemoves;
	}
    public void makeMove(String move)
    {
    	//System.out.println(convert(move));
    	if(!(convert(move).equals("no")))
    	{
	    	String use = convert(move);
	    	String pos1 = use.substring(0,1);
	    	String pos2 = use.substring(2,3);
	    	int x = Integer.parseInt(pos1);
	    	int y = Integer.parseInt(pos2);
	    	board[x][y] = getCurrentPlayer().getName();
	    	moveCount++;
    	}
    }
	public String toString()
    {
    	int counter = 1;
    	String Opens = "";
        for(int c = 0; c < board.length; c++)
        {
            for(int i = 0; i < board[0].length; i++)
            {
            	if(i == 2)
            		System.out.print(board[c][i]);
            	else
                	System.out.print(board[c][i]+"|");
                if(board[c][i].equals(" "))
                {
                	Opens += counter+"";
                }
				counter++;
            }
            System.out.println();
        }
        return "board printed, Open Spaces left:"+Opens;
    }
    public String convert(String move)
    {
    	int i = 0;
    	int a = 0;
    	for(int c = 1; c <= 9; c++)
    	{
			//System.out.println("i= "+i);
    		//System.out.println("c = "+c+", move = "+move);
			if(c == Integer.parseInt(move))
				return a+"-"+i;
			i++;
			if(c%3==0)
    		{
    			i = 0;
    			a++;
    		}
    	}
    	return "no";
    }
    private static int connect3(String[][] a){
		//checking for horizontal
		// boolean currently3=true;
		String checker = "";
		for (int xando=1; xando<3; xando++){
			if (xando==1){
				checker = "X";
				//System.out.println("here");
			}
			if (xando==2){
				checker = "O";
			}
			// System.out.println(checker);
			for (int r=0; r<3; r++)
			{
				for (int c=0;c<3;c++){
					if (!a[r][c].equals(checker))
					{
						// currently3=false;
						break;
					}
					if (c==2){
						return xando;
					}
				}
			}
			for (int c=0; c<3; c++)
			{
				for (int r=0;r<3;r++){
					if (!a[r][c].equals(checker))
					{
						// currently3=false;
						break;
					}
					if (r==2){
						return xando;
					}
				}
			}
			for (int rc = 0; rc<3;rc++)
			{
				if (!a[rc][rc].equals(checker)){
					break;
				}
				if (rc==2){
					return xando;
				}
			}
			int counter = a.length-1;
			for (int r = 0; r<3; r++)
			{
				if (!a[r][counter].equals(checker)){
					break;
				}
				if (r==2){
					return xando;
				}
				counter--;
			}	
		}
		return 0;
	}
}