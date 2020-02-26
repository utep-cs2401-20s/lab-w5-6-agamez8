public class SnakeGame {

    //ELEMENTS
    private boolean[][] game;
    private int[] headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    //DEFAULT CONSTRUCTORS (named after class)
    public SnakeGame(){
        game = new boolean[1][1];
    }

    public SnakeGame(boolean[][] board, int x, int y){
        game = board;
        headPosition[0] = x;
        headPosition[1] = y;
    }

    //METHODS 1
    //modifying exhaustive checks
    public int[] findTailExhaustive(){
        int[] result = new int[3]; //{0, 0, 0};
        for(int i = 0; i < game.length; i++){
            for(int j = 0; i < game.length; j++){
                boolean cell = game[i][j];
                int currentX = i;
                int currentY = j;
                //is it a true cell
                if(cell) {
                    //is it head
                    if (headPosition[0] != currentX && headPosition[1] != currentY) {
                        //mid piece
                        if(neighbors(currentX, currentY) == 1){
                            result[0] = currentX;
                            result[1] = currentY;
                            result[2] = (headPosition[0] - currentX) + (headPosition[1] - currentY);
                            return result;
                        }
                    }
                }
            }
        }
        exhaustiveChecks++;
        return result;
    }

    //cell
    public int neighbors(int x, int y) {
        int neighbors = 0; //no
        for (int i = x-1; i < x+1; i++) {
            for (int j = y-1; i < y+1; j++) {
                //is cell in range
                if (i >= 0 && j >= 0 && i <= game.length && j <= game.length) {
                    //not center
                    if(i != x && j != y){
                        //cell true
                        if(game[i][j]){
                            neighbors++;
                        }
                    }
                }

            }
        }
        return neighbors;
    }

    //METHOD 2
    //reset counters
    //both parameters for head
    public int[] findTailRecursive(){
        resetCounters();
        int[] result = findTailRecursive(headPosition, headPosition);
        return new int[]{result[0], result[1], result[2]};

        //getRecursiveChecks++;
        //find head
    }

    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){
        int[] result = new int[2];
        recursiveChecks++;
        return result;
    }

    private void resetCounters(){
        //called
        recursiveChecks = 0;
        exhaustiveChecks = 0;
    }

    //CURRENT CHECKS
    public static int getRecursiveChecks(){
        return recursiveChecks;
    }

    public static int getExhaustiveChecks(){
        return exhaustiveChecks;
    }

}
