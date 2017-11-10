package game.gameserver;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AdditionalRewardsTest.class, GameTest.class, GetRRTest.class, Rewards.class, SwapTest.class })
public class AllTests {

}
