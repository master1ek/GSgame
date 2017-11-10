package game.gameserver;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;
public class SwapTest {

	@Test
	public void test() {
		App game = new App();
		Integer[] array = {1,2,3,4,5};
		Integer[] array2 = {1,3,2,4,5};
		game.swap(array, 1, 2);
		for(int x : array)
			System.out.print(x);
		
		System.out.println();
		
		for(int y : array2)
			System.out.print(y);
		assertArrayEquals(array2, array);
	}

}
