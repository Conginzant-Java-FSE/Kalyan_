import java.util.Scanner;
abstract class Wizard {
    String name;
    int power_level;

    public abstract int castSpell(String spellName);

    public Wizard(String name, int power_level){
        this.name = name;
        this.power_level = power_level;
    }

    public Wizard() {
        // no args
    }
}

class DarkWizard extends Wizard {

    public DarkWizard(String name, int power_level){
        super(name, power_level);
    }

    public DarkWizard() {
        // no args
    }

    public int castSpell(String spellName){
        if (spellName.equals("Crucio")) {
            return power_level * 3;
        } else if (spellName.equals("AvadaKedavra")) {
            return power_level * 5;
        } else {
            return power_level;
        }
    }
}

class HealingWizard extends Wizard {

    public HealingWizard(String name, int power_level){
        super(name, power_level);
    }

    public  HealingWizard() {
        // no args
    }

    public int castSpell(String spellName){
        if (spellName.equals("Heal")) {
            return power_level * 2;
        } else if (spellName.equals("Revive")) {
            return power_level * 4;
        } else {
            return 0;
        }
    }
}

class ElementalWizard extends Wizard {

    public ElementalWizard(String name, int power_level){
        super(name, power_level);
    }

    public  ElementalWizard() {
        // no args
    }

    public int castSpell(String spellName){
        if (spellName.equals("Fireball")) {
            return power_level * 2;
        } else if (spellName.equals("Lightning")) {
            return power_level * 3;
        } else {
            return power_level;
        }
    }
}

public class HogwartsSpell {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String wizard_type;
        String name;
        int power_level;
        String spell;

        System.out.println("Wizard Type: ");
        wizard_type = scan.nextLine();

        System.out.println("Name: ");
        name = scan.nextLine();

        System.out.println("Power Level: ");
        power_level = scan.nextInt();
        scan.nextLine();

        System.out.println("Spell: ");
        spell = scan.nextLine();

        if (wizard_type.equals("DarkWizard")){
            Wizard wiz1 = new DarkWizard(name, power_level);
            int damage = wiz1.castSpell(spell);

            System.out.println("Wizard: " + name);
            System.out.println("Spell Casted: " + spell);
            System.out.println("Damage Dealt: " + damage);
        } else if (wizard_type.equals("HealingWizard")){
            Wizard wiz2 = new HealingWizard(name, power_level);
            int damage = wiz2.castSpell(spell);

            System.out.println("Wizard: " + name);
            System.out.println("Spell Casted: " + spell);
            System.out.println("Damage Dealt: " + damage);
        } else if (wizard_type.equals("ElementalWizard")) {
            Wizard wiz3 = new ElementalWizard(name, power_level);
            int damage = wiz3.castSpell(spell);

            System.out.println("Wizard: " + name);
            System.out.println("Spell Casted: " + spell);
            System.out.println("Damage Dealt: " + damage);
        } else {
            System.out.println("Wizard: " + name);
            System.out.println("Spell Casted: " + spell);
            System.out.println("Damage Dealt: N/A ");
        }

        scan.close();
    }
}
