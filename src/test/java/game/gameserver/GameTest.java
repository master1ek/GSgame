package game.gameserver;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class GameTest {

	@Test
	public void testGetUniqueValue() {
		App game = new App();
		
		assertThat(game.getUniqueValue(), hasSize(12));
		assertThat(game.getUniqueValue(), hasItems(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
		assertThat(game.getUniqueValue(), everyItem(lessThan(12)));
		assertThat(game.getUniqueValue(), everyItem(greaterThan(-1)));
	}
}
