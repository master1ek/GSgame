package game.gameserver;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;
public class Rewards {

	@Test
	public void testRandomBoxPrize() {
		App game = new App();
		Integer[] testArray = {1,2,3,4,5,6,7,8,9,10};
		game.randomBoxPrize(testArray);
		assertThat(testArray, arrayWithSize(10));
		assertThat(testArray, arrayContainingInAnyOrder(9,5,8,7,4,10,1,3,2,6));

	}

}
