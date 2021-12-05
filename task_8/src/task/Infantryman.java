package task;

public class Infantryman extends BattleUnitBase{
    public Infantryman(String name, int maxHealth, int baseStrength, int maxArmor){
        super(name, maxHealth, baseStrength, maxArmor);
    }
    public void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam){
    }
    public void attack(BattleUnit other){
        if (other.armor() > 0){
            if (strength() / 2 > 0)
                other.takeDamage(strength() / 2);
            else
                other.takeDamage(1);
            if (strength() / 4 > 0)
                other.damageArmor(strength() / 4);
            else
                other.damageArmor(1);
        }
        else
            other.takeDamage(strength());
    }
}
