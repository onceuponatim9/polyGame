package polyGame;

public class Main {
	public static void main(String[] args) {
		GameManager gm = new GameManager();
		Battle battle = new Battle();
		StageStart game = new StageStart();
		
		System.out.println("==== TEXT RPG ====");
		
		// 게임 시작
		while(true) {
			boolean isStart = game.start();
			if(isStart) {
				break;
			}
		}
		
		// 게임 준비
		battle.init();
		
		// 게임 진행
		while(true) {
			boolean isRun = gm.changeStage();
			if(!isRun)
				break;
		}
		
		System.out.println("game over-");
	}

}
