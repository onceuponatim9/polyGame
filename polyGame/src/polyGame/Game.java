package polyGame;

public class Game {
	public Game() {
		
	}
	
	public boolean start() {
		GameManager gm = new GameManager();
		
		System.out.println("[시작]을 입력하세요");
		String start = gm.scan.next();
		
		if(start.equals("시작")) {
			gm.nextStage = "LOBBY";
			return true;
		}
		
		return false;
	}

}
