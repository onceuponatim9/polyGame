package polyGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GameManager {
	static Scanner scan = new Scanner(System.in);
	private Random ran = new Random();
	
	Map<String, Stage> stageList = new HashMap<String, Stage>();
	
	static String nextStage = "";
	private String curStage = "";
	
	public GameManager() {
		
	}

}
