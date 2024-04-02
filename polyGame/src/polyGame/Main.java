package polyGame;

public class Main {
	public static void main(String[] args) {
		GameManager gm = new GameManager();
		UnitManager um = new UnitManager();
		Game game = new Game();
		
		System.out.println("==== TEXT RPG ====");
		
		// 게임 시작
		while(true) {
			boolean isStart = game.start();
			if(isStart) {
				break;
			}
		}
		
		// 게임 진행
		while(true) {
			um.makeMonster(3);
			gm.changeStage();
			if(!gm.isRun)
				break;
		}
		
		System.out.println("game over-");
	}

}
