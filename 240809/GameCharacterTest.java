package day04;

import java.util.ArrayList;

/**
 * 상속을 이용하여 다음 요구사항(중복코드 제거)을 해결
 * 게임 캐릭터의 초기 작업을 위한 초심자(Novice) 클래스와
 * 초심자의 다음 작업인 마법사(Wizard)클래스를 다음과 같이 설계했다고 가정
 * Wizard 클래스가 Novice 클래스의 모든 필드와 메소드를 가지고 있고
 * 추가로 마력필드 mp와 불 공격 메소드 fireball()이 더해져 있음
 */

class Novice {
	String name;
	int hp;
	
	void Attack() {
		System.out.printf("%s(HP: %d)의 펀치!\n", name, hp);
	}
	
	void displayInfo() {
        System.out.printf("이름: %s, HP: %d\n", name, hp);
    }
}

class Wizard extends Novice {
	int mp;
	
	@Override
	void Attack() {
		System.out.printf("%s(MP: %d)의 파이어볼!\n",name, mp);
	}
	
	@Override
	void displayInfo() {
        System.out.printf("이름: %s, HP: %d, MP: %d (마법사)\n", name, hp, mp);
    }
}
class Knight extends Novice {
	int stamina = 70;
	
	@Override
	void Attack() {
		System.out.printf("%s(Stamina: %d)의 베기공격!\n",name, stamina);
	}
	
	@Override
	void displayInfo() {
	  	System.out.printf("이름: %s, HP: %d, Stamina: %d (기사)\n", name, hp, stamina);
	}
}

public class GameCharacterTest {

	public static void main(String[] args) {
		
		ArrayList<Novice> list = new ArrayList<>();
		
		Novice user1 = new Novice();
		Wizard user2 = new Wizard();
		Knight user3 = new Knight();
		list.add(user1);
		list.add(user2);
		list.add(user3);
		user1.hp = 100;
		user1.name = "유저1";
		
		user2.hp = 100;
		user2.name = "유저2";
		user2.mp = 30;
		
		user3.hp = 120;
		user3.name = "유저3";
		user3.stamina = 50;
		
		//user1.punch();
		//user2.punch();
		//user2.fireball();
		
		for (Novice l : list) {
			l.displayInfo();
			l.Attack();
		}
		
	}
	
}
