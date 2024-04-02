package polyGame;

import java.util.Vector;

public abstract class Unit {
	public String name;
	public int maxhp;
	public int curhp;
	public int power;
	
	public Unit() {
		
	}
	
	Unit(String name, int max, int power) {
		this.name = name;
		this.maxhp = max;
		this.curhp = max;
		this.power = power;
	};
	
	public void attack(Unit unit) {
		unit.curhp -= power;
		System.out.println("[" + name + "]이 " + "[" + unit.name + "]에게 " + power + "의 데미지를 입힙니다.");
		
		if(unit.curhp <= 0) {
			unit.curhp = 0;
			System.out.println("[" + unit.name + "]을 처치했습니다.");
		}
	}
	
	public abstract void skill();
	
	public void printData() {
		System.out.println("[" + name + "] [" + curhp + "/" + maxhp + "] [" + power + "]");
	}

	public void init(int hp, int power) {
		// TODO Auto-generated method stub
		this.maxhp = hp;
		this.curhp = hp;
		this.power = power;
	}

}
