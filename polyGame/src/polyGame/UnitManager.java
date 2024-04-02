package polyGame;

import java.util.Random;
import java.util.Vector;

public class UnitManager {
	private Random ran = new Random();
	
	Vector<Player> playerList = new Vector<>();
	Vector<Unit> monsterList = new Vector<>();
	
	String[] monsters = {"UnitWolf", "UnitBat", "UnitOrc"};
	
	public UnitManager() {
		playerList.add(new Player("name1", 900, 50));
		playerList.add(new Player("name2", 800, 70));
		playerList.add(new Player("name3", 600, 90));
	}
	
	public Vector<Player> getPlayerList() {
		return this.playerList;
	}
	
	public Vector<Unit> getMonsterList() {
		return this.monsterList;
	}
	
	public void makeMonster(int size) { // monster 만들기 수정 중
		for(int i = 0; i < size; i++) {
			try {
				Class<?> clazz = Class.forName(monsters[i]);
				Object obj = clazz.getDeclaredConstructor().newInstance();
				
				int hp = ran.nextInt(150) + 100;
				int power = ran.nextInt(20) + 10;
				
				Unit temp = (Unit) obj;
				temp.init(hp, power);
				monsterList.add(temp);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 잘 만들어졌는지 검사
		for(int i = 0; i < size; i++) {
			String name = monsterList.get(i).name;
			int hp = monsterList.get(i).maxhp;
			int power = monsterList.get(i).power;
			System.out.println(i + ") " + name + " " + hp + " " + power);
		}
		System.out.println(size + "moster 생성 완료");
	}

}
