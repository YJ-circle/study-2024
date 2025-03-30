package client;

import object.Attacker;
import server.AttackService;

public class RunClient {

	public static void main(String[] args) {
		
		//1
		AttackService attackService = new AttackService();
		System.out.println(attackService.getAttackerInfo());
		
		
		//2
		Attacker attacker = attackService.getAttacker(true);
		System.out.println(
			attacker.getId() + ":" + attacker.getName());
		
		//3
		
		
	}

}
