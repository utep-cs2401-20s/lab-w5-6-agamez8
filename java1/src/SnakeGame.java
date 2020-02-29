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

        for(int i = 0; i < game.length; i++){
            for(int j = 0; j < game[i].length; j++){
                game[i][j] = board[i][j];
            }
        }
    }

    //METHODS 1
    //modifying exhaustive checks
    public int[] findTailExhaustive(){
        resetCounters();
        int[] result = new int[3];
        for(int i = 0; i < game.length; i++){
            for(int j = 0; i < game.length; j++){
                exhaustiveChecks++;
                boolean cell = game[i][j];
                int currentX = i;
                int currentY = j;
                //is it a true cell
                if(cell) {
                    //is it head
                    if (headPosition[0] != currentX && headPosition[1] != currentY) {
                        //mid piece
                        exhaustiveChecks++;
                        if(neighbors(game) == 1){
                            exhaustiveChecks++;
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

    //cell neighbors
    public int neighbors(boolean[][] array) {
        int sum = 0;
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[0].length; j++){
                if(array[i+1][j] = true){
                    sum++;
                }
                if(array[i+1][j-1] = true){
                    sum++;
                }
                if(array[i-1][j] = true){
                    sum++;
                }
                if(array[i-1][j+1] = true){
                    sum++;
                }
            }
        }
        return sum;
    }

    public int[] neighborRecursive(int x, int y, int[] prev){
        int pos[] = new int[2];
        if((x -1 > -1 && game[x-1][y]) && (prev[0] != x-1)){
            //up
            pos[0] = x-1;
            pos[1] = y;
        }
        else if((x+1 < game.length && game[x+1][y]) && (prev[0] != x+1)){
            //down
            pos[0] = x+1;
            pos[1] = y;
        }
        else if((y-1 > -1 && game[x][y-1]) && (prev[1] != y-1)){
            //left
            pos[0] = x;
            pos[1] = y - 1;
        }
        else if((y+1 < game[x].length && game[x][y+1]) && (prev[1] != y +1)){
            //right
            pos[0] = x;
            pos[1] = y +1;
        }
        return pos;
    }

    //METHOD 2
    //reset counters
    //both parameters for head
    public int[] findTailRecursive(){
        resetCounters();
        int[] result = findTailRecursive(headPosition, headPosition);
        return new int[]{result[0], result[1], result[2]};

        //RecursiveChecks++;
        //find head
    }

    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){
        int[] result = new int[2];
        if(headPosition[1] == currentPosition[1] && headPosition[0] == currentPosition[0]) {
            if (game.length < 2 && game[0].length < 2) {
                recursiveChecks++;
                result[0] = 0;
                result[1] = 0;
                result[2] = 1;
                return result;
            }
            previousPosition[2] = 1;
            recursiveChecks++;
            previousPosition[0] = currentPosition[0];
            previousPosition[1] = currentPosition[1];
            return findTailRecursive(neighborRecursive(currentPosition[0], currentPosition[1], currentPosition), previousPosition);
        }
            else if(neighbors(game) > 1) {

            previousPosition[2]++;
            result[0] = previousPosition[0];
            result[1] = previousPosition[1];
            previousPosition[0] = currentPosition[0];
            previousPosition[1] = currentPosition[1];
            recursiveChecks++;
            return findTailRecursive(neighborRecursive(currentPosition[0], currentPosition[1], result), previousPosition);
            }
            else
            previousPosition[2]++;
            recursiveChecks++;
            result[0] = currentPosition[0];
            result[1] = currentPosition[1];
            result[2] = previousPosition[2];
            return result;
        //return
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
