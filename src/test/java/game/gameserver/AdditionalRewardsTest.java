package game.gameserver;

import static org.junit.Assert.*;

import org.hamcrest.Matchers;

//import static org.hamcrest.Matchers.*;

import org.junit.Test;
public class AdditionalRewardsTest {

	@Test
	public void test() {
		App game = new App();
		int i = game.getUniqueValueForAdditionalRewards();
		assertThat(i, Matchers.either(Matchers.is(2)).or(Matchers.is(5)).or(Matchers.is(10)).or(Matchers.is(20)));
		assertTrue(i>1&&i<21);
		
	}

}
