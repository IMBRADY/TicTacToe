public class starter{
    public static void main(String args[])
    {
        GameState set = new TTT();
        GameDriver game = new GameDriver(set);
        game.play();
    }
}