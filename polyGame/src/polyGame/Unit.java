package polyGame;

public abstract class Unit {
	String name;
	int maxhp;
	int curhp;
	int power;
	
	public Unit() {
		
	}
	
	Unit(String name, int max, int power) {
		this.name = name;
		this.maxhp = max;
		this.curhp = max;
		this.power = power;
	};
	
	public abstract void skill();

}
