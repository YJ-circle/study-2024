package server;

import object.Attacker;

public class AttackService {
	private Attacker attacker;
	
	public AttackService() {
		
	}
	public String getAttackerInfo() {
		Attacker attacker = new Attacker(1, "attacker");
		
		return attacker.getId() + ":" + attacker.getName();
		
	}
	
	//////////2
	public Attacker getAttacker(boolean isActive) {
		Attacker attacker = new Attacker(1, "attacker");
		return attacker;
	}

	////////// 3
	public AttackService(int serviceId, String name, Attacker attacker) {
		this.attacker = attacker;
		attacker.setId(serviceId);
		attacker.setName(name);
	}

	public Attacker getAttacker() {
		return attacker;
	}

}
