package polyGame;

import java.util.Vector;

public class Battle extends Stage {
	GameManager gm;
	UnitManager um;
	Vector<Player> playerList = null;
	Vector<Unit> monsterList = null;
	
	int playerDead, monsterDead;
	
	public Battle() {
		gm = new GameManager();
		um = new UnitManager();
		playerList = um.getPlayerList();
		monsterList = um.getMonsterList();
	}
	
	public void printAll() {
		System.out.println("======[BATTLE]======");
		System.out.println("[name] [curhp/maxhp] [power]");
		
		System.out.println("======[PLAYER]======");
		for(int i = 0; i < playerList.size(); i++) {
			playerList.get(i).printData();
		}
		System.out.println("======[MONSTER]======");
		for(int i = 0; i < monsterList.size(); i++) {
			monsterList.get(i).printData();
		}
	}
	
	public void attackByPlayer(int index) {
		Player p = playerList.get(index);
		if(p.curhp <= 0)
			return;
		
		int sel = 0;
		
		while(true) {
			System.out.println("[" + p.name + "] [1.어택] [2.스킬]");
			System.out.print("메뉴 선택 >> ");
			sel = gm.inputNumber();
			
			if(sel < 1 || sel > 2)
				continue;
			else
				break;
		}
		
		// player가 moster 공격
		if(sel == 1) {
			while(true) {
				int idx = gm.ran.nextInt(monsterList.size());
				if(monsterList.get(idx).curhp > 0) {
					p.attack(monsterList.get(idx));
					break;
				}
			}
			
			
		} else if(sel == 2) {
			p.skill();
		}
		
	}
	
	public void attackByMonster(int index) {
		Unit m = monsterList.get(index);
		if(m.curhp <= 0)
			return;
		
		while(true) {
			int idx = gm.ran.nextInt(playerList.size());
			
			// monster가 player 공격
			if(playerList.get(idx).curhp > 0) {
				m.attack(playerList.get(idx));
				break;
			}
		}
		
	}
	
	public void checkAlive() {
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

	@Override
	public boolean update() {
		int idx1 = 0;
		int idx2 = 0;
		boolean isTurn = true;
		
		while(true) {
			if(isTurn) {
				printAll();
				if(idx1 < playerList.size()) {
					attackByPlayer(idx1++);
				} else {
					idx1 = 0;
					isTurn = false;
				}
				
			} else {
				if(idx2 < monsterList.size()) {
					attackByMonster(idx2++);
				} else {
					idx2 = 0;
					isTurn = false;
				}
			}
			// player와 monster 생존자 점검
			checkAlive();
			// player와 monster 중에 하나라도 전멸하면
			if(playerDead == playerList.size() || monsterDead == monsterList.size())
				break;
		}
		return false;
	}

}
