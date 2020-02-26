import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SnakeGameTester {

   @Test
   public void testFindTailExhaustive(){
      int x = 1;
      int y = 0;
      boolean[][] game = {{false, true, false},
                          {false, true, false},
                          {false, true, false}
      };

      SnakeGame snake = new SnakeGame(game, x, y);
      int[] test = snake.findTailExhaustive();
      //x
      assertEquals(1, test[0]);
      //y
      assertEquals(2, test[1]);
      //length
      assertEquals(3, test[2]);
   }

   @Test
   public void testFindTailExhaustive1(){
      int x = 0;
      int y = 1;
      boolean[][] game = {{false, false, false},
                          {true, true, true},
                          {false, false, false}
      };

      SnakeGame snake = new SnakeGame(game, x, y);
      int[] test = snake.findTailExhaustive();
      //x
      assertEquals(2, test[0]);
      //y
      assertEquals(2, test[1]);
      //length
      assertEquals(2, test[2]);
   }

   @Test
   public void testFindTailExhaustive2(){
      int x = 2;
      int y = 0;
      boolean[][] game = {{true, true, true},
              {false, false, false},
              {false, false, false}
      };

      SnakeGame snake = new SnakeGame(game, x, y);
      int[] test = snake.findTailExhaustive();
      //x
      assertEquals(1, test[0]);
      //y
      assertEquals(1, test[1]);
      //length
      assertEquals(1, test[2]);
   }

   @Test
   public void testFindTailExhaustive3(){
      int x = 0;
      int y = 0;
      boolean[][] game = {{true, false, false},
                          {true, false, false},
                          {true, false, false}
      };

      SnakeGame snake = new SnakeGame(game, x, y);
      int[] test = snake.findTailExhaustive();
      //x
      assertEquals(1, test[0]);
      //y
      assertEquals(2, test[1]);
      //length
      assertEquals(3, test[2]);
   }

   @Test
   public void testFindTailExhaustive4(){
      int x = 0;
      int y = 2;
      boolean[][] game = {{false, false, false},
                          {false, false, false},
                          {true, true, true}
      };

      SnakeGame snake = new SnakeGame(game, x, y);
      int[] test = snake.findTailExhaustive();
      //x
      assertEquals(3, test[0]);
      //y
      assertEquals(3, test[1]);
      //length
      assertEquals(3, test[2]);
   }

}
