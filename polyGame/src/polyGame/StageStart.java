package polyGame;

public class StageStart extends Stage {
	public StageStart() {
		
	}
	
	public boolean start() {
		System.out.println("[시작]을 입력하세요");
		String start = GameManager.scan.next();
		
		if(start.equals("시작")) {
			GameManager.nextStage = "LOBBY";
			return true;
		}
		
		return false;
	}

	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
