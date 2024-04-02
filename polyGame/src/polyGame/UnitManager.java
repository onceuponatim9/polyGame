package polyGame;

import java.util.Vector;

public class UnitManager {
	Vector<Player> playerList = new Vector<>();
	Vector<Unit> monsterList = new Vector<>();
	
	public UnitManager() {
		playerList.add(new Player("name1", 1000, 50));
		playerList.add(new Player("name2", 800, 60));
		playerList.add(new Player("name3", 600, 70));
	}
	
	public Vector<Player> getPlayerList() {
		return this.playerList;
	}
	
	public Vector<Unit> getMonsterList() {
		return this.monsterList;
	}

}
