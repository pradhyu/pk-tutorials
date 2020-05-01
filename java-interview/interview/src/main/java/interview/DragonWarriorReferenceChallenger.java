
package interview;

public class DragonWarriorReferenceChallenger {

  public static void main(String... doYourBest) {
    StringBuilder warriorProfession = new StringBuilder("Dragon ");
    String warriorWeapon = "Sword ";
    changeWarriorClass(warriorProfession, warriorWeapon);

    System.out.println("Outside: Warrior=" + warriorProfession + ", Weapon=" + warriorWeapon);
  }

  static void changeWarriorClass(StringBuilder warriorProfession, String weapon) {
    warriorProfession.append("Knight");
    weapon = "Dragon " + weapon;

    System.out.println("inside: Warrior=" + warriorProfession + ", Weapon=" + weapon);
    weapon = null;
    warriorProfession = null;
  }
}

