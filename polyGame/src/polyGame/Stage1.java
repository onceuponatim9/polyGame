package polyGame;

public class Stage1 extends Stage {

	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		GameManager gm = new GameManager();
		
		System.out.println("=====[Stage1]=====");
		System.out.println("[1.전투] [2.종료]");
		int sel = gm.scan.nextInt();
		
		if(sel == 1) {
			gm.nextStage = "Stage2";
			return true;
			
		} else if(sel == 2) {
			gm.nextStage = "";
			gm.isRun = false;
			return false;
			
		} else {
			gm.nextStage = gm.curStage;
			return true;
		}
	}

}
