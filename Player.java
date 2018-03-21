package models;

public abstract class Player {

    protected int[] attempt = new int[2];
    protected int player;

    private static int PORT = 8901;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public TicTacToeClient(String serverAddress) throws Exception {


        socket = new Socket(serverAddress, PORT);
        in = new BufferedReader(new InputStreamReader(
            socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

    public Player(int player){
        this.player = player;
    }

    public abstract void play(Board board);

    public abstract void Try(Board board);

    public boolean checkTry(int[] attempt, Board board){
        if(board.getPosition(attempt) == 0)
            return true;
        else
            return false;

    }

}