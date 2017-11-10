package game.gameserver;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;
public class GetRRTest {

	@Test
	public void test() {
		App game = new App();
		Integer[] rewards = {100, 20, 20, 5, 5, 5, 5, 5, 1, 0, 0, 0};
		int value = 0;
		int prize = 0;
		boolean type = false;
		for(int i = 0 ; i<1; i++){
			//randomBoxPrize(rewards);
			prize +=game.getRoundReward(rewards, value, type);
			type=true;
		}
		System.out.println(prize);
		
		assertTrue(prize>4&&prize<186);
	}

}
