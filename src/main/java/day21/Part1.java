package day21;

import java.util.Arrays;
import java.util.List;

public class Part1 {

	private static final List<Item> WEAPONS = Arrays.asList(new Item("Greataxe", 74, 8, 0), new Item("Dagger", 8, 4, 0),
			new Item("Shortsword", 10, 5, 0), new Item("Warhammer", 25, 6, 0), new Item("Longsword", 40, 7, 0));

	private static final List<Item> ARMOR = Arrays.asList(new Item("NoArmor", 0, 0, 0), new Item("Leather", 13, 0, 1),
			new Item("Chainmail", 31, 0, 2), new Item("Splintmail", 53, 0, 3), new Item("Bandedmail", 75, 0, 4),
			new Item("Platemail", 102, 0, 5));

	private static final List<Item> RINGS = Arrays.asList(new Item("NoRing1", 0, 0, 0), new Item("NoRing2", 0, 0, 0),
			new Item("Damage1", 25, 1, 0), new Item("Damage2", 50, 2, 0), new Item("Damage3", 100, 3, 0),
			new Item("Defense1", 20, 0, 1), new Item("Defense2", 40, 0, 2), new Item("Defense3", 80, 0, 3));

	public static void main(String[] args) {

		int result = Integer.MIN_VALUE;

		for (Item weapon : WEAPONS) {
			for (Item armor : ARMOR) {
				for (Item ring1 : RINGS) {
					for (Item ring2 : RINGS) {
						if (ring1.name.equals(ring2.name)) {
							continue;
						}
						int totalCost = weapon.cost + armor.cost + ring1.cost + ring2.cost;
						if (totalCost <= result) {
							continue;
						}
						int def = armor.armor + ring1.armor + ring2.armor;
						int dmg = weapon.damage + ring1.damage + ring2.damage;
						if (!win(dmg, def)) {
							result = totalCost;
						}
					}
				}
			}
		}
		System.out.println(result);

	}

	// Hit Points: 100
	// Damage: 8
	// Armor: 2
	private static final int BOSS_DAMAGE = 8;
	private static final int BOSS_ARMOR = 2;

	private static boolean win(int dmg, int def) {
		int damage = Math.max(1, dmg - BOSS_ARMOR);
		int bossDamage = Math.max(1, BOSS_DAMAGE - def);
		int health = 100;
		int bossHealth = 100;
		while (true) {
			bossHealth -= damage;
			if (bossHealth <= 0) {
				return true;
			}
			health -= bossDamage;
			if (health <= 0) {
				return false;
			}
		}
	}

	private static final class Item {
		public final String name;
		public final int cost;
		public final int damage;
		public final int armor;

		public Item(String name, int cost, int damage, int armor) {
			this.name = name;
			this.cost = cost;
			this.damage = damage;
			this.armor = armor;
		}
	}

}
