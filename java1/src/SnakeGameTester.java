import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SnakeGameTester {

   //B O A R D S
   boolean[][] array1 = {{true, false, false},
           {true, false, false},
           {true, false, false}
   };

   boolean[][] array2 = {{false, false, false},
           {true, true, true},
           {false, false, false}
   };

   boolean[][] array3 = {{true, true, false},
           {false, true, false},
           {false, false, false}
   };

   boolean[][] array4 = {{false, false, false},
           {true, false, false},
           {true, true, false}
   };

   boolean[][] array5 = {{false, false, true},
           {false, true, true},
           {false, false, false}};

   //EXHAUSTIVE CHECKS
   @Test
   public void testFindTailExhaustive1(){
      SnakeGame snake = new SnakeGame(array1, 0,0);
      int[] expected = new int[]{0, 1, 2};
      int[] actual = snake.findTailExhaustive();

      assertEquals(7, snake.getExhaustiveChecks());
      assertArrayEquals(expected, actual);
   }

   @Test
   public void testFindTailExhaustive2(){
      SnakeGame snake = new SnakeGame(array2, 0,1);
      int[] expected = new int[]{0, 0, 3};
      int[] actual = snake.findTailExhaustive();

      assertArrayEquals(expected, actual);
   }

   @Test
   public void testFindTailExhaustive3(){
      SnakeGame snake = new SnakeGame(array3, 1,1);
      int[] expected = new int[]{0, 2, 2};
      int[] actual = snake.findTailExhaustive();

      assertArrayEquals(expected, actual);
   }

   @Test
   public void testFindTailExhaustive4(){
      SnakeGame snake = new SnakeGame(array4, 0,1);
      int[] expected = new int[]{0, 3, 1};
      int[] actual = snake.findTailExhaustive();

      assertArrayEquals(expected, actual);
   }

   @Test
   public void testFindTailExhaustive5(){
      SnakeGame snake = new SnakeGame(array5, 2,0);
      int[] expected = new int[]{0, 1, 2};
      int[] actual = snake.findTailExhaustive();

      assertArrayEquals(expected, actual);
   }

   //RECURSIVE CHECKS
   @Test
   public void testFindTailRecursive1(){
      SnakeGame snake = new SnakeGame(array1, 0,0);
      int[] expected = new int[]{2, 1, 2};
      int[] actual = snake.findTailRecursive();

      assertEquals(6, snake.getRecursiveChecks());
      assertArrayEquals(expected, actual);
   }

   @Test
   public void testFindTailRecursive2(){
      SnakeGame snake = new SnakeGame(array2, 0,1);
      int[] expected = new int[]{1, 1, 1};
      int[] actual = snake.findTailRecursive();

      assertEquals(2, snake.getRecursiveChecks());
      assertArrayEquals(expected, actual);
   }

   @Test
   public void testFindTailRecursive3(){
      SnakeGame snake = new SnakeGame(array3, 1,1);
      int[] expected = new int[]{4, 0, 8};
      int[] actual = snake.findTailRecursive();

      assertArrayEquals(expected, actual);
   }

   @Test
   public void testFindTailRecursive4(){
      SnakeGame snake = new SnakeGame(array4, 0,1);
      int[] expected = new int[]{2, 2, 2};
      int[] actual = snake.findTailRecursive();

      assertArrayEquals(expected, actual);
   }

   @Test
   public void testFindTailRecursive5(){
      SnakeGame snake = new SnakeGame(array5, 2,0);
      int[] expected = new int[]{0, 1, 0};
      int[] actual = snake.findTailRecursive();

      assertArrayEquals(expected, actual);
   }



}