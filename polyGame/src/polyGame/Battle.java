package polyGame;

import java.util.Vector;

public class Battle extends Stage {
	
	UnitManager um = new UnitManager();
	Vector<Player> playerList = null;
	Vector<Unit> monsterList = null;
	
	int playerDead, monsterDead;
	boolean isBattle = false;
	boolean isTurn = true;
	
//	public Battle() {
////		GameManager gm = new GameManager();
////		UserManager um = new UnitManager();
//		um.monsterList.clear();
//		um.makeMonster();
//		playerList = um.getPlayerList();
//		monsterList = um.getMonsterList();
//	}
	
	public void init() {
		um.monsterList.clear();
		um.makeMonster();
		playerList = null;
		monsterList = null;
		playerList = um.playerList;
		monsterList = um.getMonsterList();
	}
	
	public void printAll() {
		System.out.println("======[BATTLE]======");
		System.out.println("[name] [curhp/maxhp] [power]");
		
		System.out.println("======[PLAYER]======");
		for(int i = 0; i < playerList.size(); i++) {
			if(playerList.get(i).curhp > 0)
				playerList.get(i).printData();
		}
		System.out.println("======[MONSTER]======");
		for(int i = 0; i < monsterList.size(); i++) {
			if(monsterList.get(i).curhp > 0)
				monsterList.get(i).printData();
		}
		System.out.println("=====================");
	}
	
	public int attackByPlayer(int index) {
		Player p = playerList.get(index);
		if(p.curhp <= 0)
			return 0;
		
		int sel = 0;
		
		while(true) {
			System.out.println("[" + p.name + "] [1.어택] [2.스킬] [3.도망가기]");
			System.out.print("메뉴 선택 >> ");
			sel = GameManager.inputNumber();
			
			if(sel < 1 || sel > 3)
				continue;
			else
				break;
		}
		
		// player가 moster 공격
		if(sel == 1) {
			int idx = GameManager.ran.nextInt(monsterList.size());
			if(monsterList.get(idx).curhp > 0) {
				p.attack(monsterList.get(idx));
			}
			
		} else if(sel == 2) {
			useSkill(p);
			//p.skill();
			
		} else if(sel == 3) {
			System.out.println("적들로부터 도망쳤습니다.");
			isBattle = false;
		}
		
		return sel;
		
	}
	
	public void attackByMonster(int index) {
		Unit m = monsterList.get(index);
		if(m.curhp <= 0)
			return;
		
		// monster가 player 공격
		int idx = GameManager.ran.nextInt(playerList.size());
		
		if(playerList.get(idx).curhp > 0) {
			m.attack(playerList.get(idx));
		}
	}
	
	public void checkAlive() {
		playerDead = 0;
		monsterDead = 0;
		for(int i = 0; i < playerList.size(); i++) {
			Player p = playerList.get(i);
			if(p.curhp <= 0)
				playerDead++;
		}
		for(int i = 0; i < monsterList.size(); i++) {
			Unit m = monsterList.get(i);
			if(m.curhp <= 0)
				monsterDead++;
		}
	}
	
	public void useSkill(Player player) {
		System.out.println(player.name + "는 방패 스킬을 썼다!!!");
	}

	@Override
	public boolean update() {
		int idx1 = 0;
		int idx2 = 0;
		isBattle = true;
		isTurn = true;
		
		while(isBattle) {
			if(isTurn) {
				printAll();
				if(idx1 < playerList.size()) {
					int n = attackByPlayer(idx1++);
					if(n == 2)
						continue;
					else
						isTurn = false;
					
				} else {
					idx1 = 0;
					isTurn = false;
				}
				
			} else {
				// 한 마리씩 차례대로 공격
				if(idx2 < monsterList.size()) {
					attackByMonster(idx2++);
				} else {
					idx2 = 0;
					
				}
				isTurn = true;
			}
			// player와 monster 생존자 점검
			checkAlive();
			// player와 monster 중에 하나라도 전멸하면
			if(playerDead == playerList.size() || monsterDead == monsterList.size()) {
				printWinner();
				GameManager.isRun = false;
				break;
			}
		}
		GameManager.nextStage = "LOBBY";
		return false;
	}
	
	private void printWinner() {
		if(playerDead == playerList.size())
			System.out.println("monster들에게 졌습니다.");
		else
			System.out.println("monster를 모두 처치했습니다.");
	}

}
