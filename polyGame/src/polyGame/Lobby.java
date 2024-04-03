package polyGame;

public class Lobby extends Stage {

	@Override
	public boolean update() {
		System.out.println("=====[Lobby]=====");
		System.out.println("[1.전투] [2.종료]");
		int sel = GameManager.scan.nextInt();
		
		if(sel == 1) {
			GameManager.nextStage = "BATTLE";
			
		} else if(sel == 2) {
			GameManager.nextStage = "";
		}
		
		return false;
	}

}
