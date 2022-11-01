class psvm {
        public static String[][] createBoard()
        {
			String d = "-- ";
			String[][] strboard = new String[3][3];
			for(int c = 0; c<strboard.length; c++)
				for(int i = 0; i<strboard[0].length; i++)
					strboard[c][i] = d;
			return strboard;
		}
		public static void main(String args[])
		{
			TTT.fullplay();
		}
		public static void fullplay()
		{
			GameDriver g = new GameDriver(createBoard());
			toString();
			while(!isGameOver())
			{
				System.out.println(getCurrentPlayer().getName() + "choose one of the following moves.");
				for(int c = 0; c<getCurrentMoves().size(); c++)
				{
					System.out.println(getCurrentMoves.get(0));
				}
				g.play();
			}


		}

}