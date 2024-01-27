package encapsulation;

public class Main {
	
	public static void main(String args[]) {
		
		EnhancedPlayer ed = new EnhancedPlayer("Ed", 20424, "Sword");
		System.out.println("Initial health is " +ed.healthRemaining());
		

		
		/*
		Player player = new Player();
		player.fullName = "Tim";
		player.health = 20;
		player.weapon = "Sword";
		
		int damage = 10;
		player.loseHealth(damage);
		System.out.println("Remaining health = " +player.healthRemaining());
		player.health = 200;
		player.loseHealth(11);
		System.out.println("Remaining health = "+player.healthRemaining());
		*/
	}

}
