package game.gameserver;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class App {
	
	 static void swap(Integer[] array, int index1, int index2){
		int temporary = array[index1];
		array[index1] = array[index2];
		array[index2] = temporary;
	}
	
	static void randomBoxPrize(Integer[] arrayToMix) {
		Random rand = ThreadLocalRandom.current();
		for(int i = arrayToMix.length-1; i>0; i--){
			int index = rand.nextInt(i+1);
			swap(arrayToMix, index, i);
		}
	}
	
	
	static ArrayList<Integer> getUniqueValue(){
		int INDEX_OF_CHEST = 12;
		ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<INDEX_OF_CHEST; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
        
		return list;
	}
	
	static int getUniqueValueForAdditionalRewards(){
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		int number;
		int[] additionalPrize = {2, 5, 10, 20};
        for (int i=0; i<additionalPrize.length; i++) {
            list2.add(additionalPrize[i]);
        }
        Collections.shuffle(list2);
        number = list2.get(0);
		return number;
	}
	
	static int getRoundReward(Integer[] array, int value, boolean type){
		List<Integer> arrayOfIndex = getUniqueValue();
		int additionalReward = getUniqueValueForAdditionalRewards();
		int index;
		boolean extraLife = false;
		for(int i = 0; i<array.length; i++){
			index = arrayOfIndex.get(i);
			if(array[index]!=0 && array[index]!=1){
				value+=array[index];
				
			}
			if(array[index]==1){
				extraLife = true;
			}
			if(array[index]==0){
				if(extraLife==false){
						if(additionalReward==2 && type==false){
							//System.out.println("Druga szansa");
							type = true;
							continue;
						}
						if(additionalReward!=2){
							value+=additionalReward;
							break;
						}
					}else
						extraLife = false;
			}

		}
		return value;
	}

	

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		Integer[] rewards = {100, 20, 20, 5, 5, 5, 5, 5, 1, 0, 0, 0};
		
		boolean type = false;
		int value = 0;
		int prize = 0;
		int rounds = 10000000;
		double avg;
		
		for(int i = 0 ; i<rounds; i++){
			randomBoxPrize(rewards);
			prize += getRoundReward(rewards,value,type);
			type=true;
		}
		avg = (double)prize / (double)rounds;
		System.out.println("Wygrana: "+prize+" EUR");
		System.out.println("AVG: " +avg);
		long endTime = System.nanoTime();
		System.out.println("Took "+((double)endTime - (double)startTime) + " s"); 
	}

}