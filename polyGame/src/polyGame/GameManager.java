package polyGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GameManager {
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	
	Map<String, Stage> stageList = new HashMap<String, Stage>();
	
	String nextStage = "";
	String curStage = "";
	
	public boolean isRun = true;
	
	public GameManager() {
		stageList.put("Lobby", new Lobby());
		stageList.put("Stage1", new Stage1());
		stageList.put("Stage2", new Stage2());
		nextStage = "Lobby";
	}
	
	public void changeStage() {
		System.out.println("curStage : " + curStage);
		System.out.println("nextStage : " + nextStage);
		
		curStage = nextStage;
		Stage stage = stageList.get(curStage);
		
		while(isRun) {
			Battle battle = new Battle();
			boolean isUpdate = battle.update(); // 여기가 문제
			if (!isUpdate)
				break;
		}
		
		if (nextStage.equals(""))
			isRun = false;
	}
	
	public int inputNumber() {
		int number = -1;
		try {
			String input = scan.next();
			number = Integer.parseInt(input);
		} catch(Exception e) {
			System.out.println("숫자를 입력하세요.");
		}
		return number;
	}

}
