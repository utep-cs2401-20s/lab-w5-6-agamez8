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

    public SnakeGame(boolean[][] z, int x, int y){
        game = z;
        headPosition[0] = x;
        headPosition[1] = y;
    }

    //METHODS
    public int[] findTailExhaustive(){
        int[] result = {0, 0, 0};
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

    public int[] findTailRecursive(int x, int y){
        //getRecursiveChecks--;
        //find head

        return new int[0];

    }

    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){
        return new int[0];
    }

    private void resetCounters(){
        //recursiveCheck = 0
        //exhaustiveCheck = 0
    }

    //CURRENT CHECKS
    private static int getRecursiveChecks(){
        //++
        return 0;
    }

    private static int getExhaustiveChecks(){
        //++
        return 0;
    }

}
