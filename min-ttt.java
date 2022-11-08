import pkg.*;
import java.util.ArrayList;

public class starter{
	// public static void main(String args[]) {
	// 	// please leave following line alone, necessary for keyboard/mouse input
	// 	System.out.println("jdjdjd");
	// 	String [][] joe = new String [3][3];
	// 	// joe = {["X",XX],[---],[---]};
	// 	// for (int counter=0; counter<100; counter++){
	// 	joe[0][0]="-"; joe[0][1]="-"; joe[0][2]="-";
	// 	joe[1][0]="-"; joe[1][1]="-"; joe[1][2]="-";
	// 	joe[2][0]="-"; joe[2][1]="-"; joe[2][2]="-";
	// 	// int bob = connect3(joe);
	// 	ArrayList<String> bob = getCurrentMoves(joe);
	// 	System.out.println(bob);
	// }

	public static ArrayList<String> getCurrentMoves(String[][] a){
		ArrayList<String> availablemoves = new ArrayList<String>();
		int count = 1;
		for (int r = 0; r<a.length; r++){
			for (int c=0; c<a.length; c++)
			{
				if (!a[r][c].equals("X")||!a[r][c].equals("O")){

				availablemoves.add(count+"");
				}
				count++;
			}
		}
		return availablemoves;
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
	
	public Player getWinner(){
		if (connect3(a)==1){
			return X;
		}
		else if (connect3(a)=2){
			return O;
		}
		else {
			return null;
		}
	}


	private static int connect3(String[][] a){
		//checking for horizontal
		// boolean currently3=true;
		String checker = "";
		for (int xando=1; xando<3; xando++){
			if (xando==1){
				checker = "X";
				System.out.println("here");
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