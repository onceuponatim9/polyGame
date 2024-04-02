package polyGame;

public class Main {
	public static void main(String[] args) {
		GameManager gm = new GameManager();
		Game game = new Game();
		
		while(true) {
			boolean isStart = game.start();
			if(isStart)
				break;
		}
		
		while(true) {
			gm.changeStage();
			if(!gm.isRun)
				break;
		}
		
		System.out.println("game over-");
	}

}
