package task;

public class Alchemist extends BattleUnitBase{
    public Alchemist(String name, int maxHealth, int baseStrength, int maxArmor){
        super(name, maxHealth, baseStrength, maxArmor);
    }
    public void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam) {
        int Hmax = 0;
        int Hmin = 1000000;
        BattleUnit ownMin = ownTeam[0];
        BattleUnit ownMax = ownTeam[0];

        for (int i = 0; i < ownTeam.length; ++i){
            if (ownTeam[i].health() <Hmin && ownTeam[i].health() > 0){
                Hmin = ownTeam[i].health();
                ownMin = ownTeam[i];
            }
            else if (ownTeam[i].health() > Hmax && ownTeam[i].health() > 0){
                Hmax = ownTeam[i].health();
                ownMax = ownTeam[i];
            }
        }
        ownMin.heal(10);
        ownMax.setStrength(ownMax.strength() + 1);
    }
    public void attack(BattleUnit other) {
        other.setStrength(other.strength() - 2);
        other.setMaxHealth(other.maxHealth() - 4);
    }
}
