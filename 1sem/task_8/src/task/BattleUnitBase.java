package task;

public abstract class BattleUnitBase implements BattleUnit{
    private String name;
    private int maxHealth;
    private int baseStrength;
    private int maxArmor;
    private int health;
    private int strength;
    private int armor;

    public BattleUnitBase (String name, int maxHealth, int baseStrength, int maxArmor){
        this.name = name;
        this.maxHealth = maxHealth;
        this.baseStrength = baseStrength;
        this.maxArmor = maxArmor;
        health = maxHealth;
        strength = baseStrength;
        armor = maxArmor;
    }

    @Override
    public String name(){
        return name;
    }
    @Override
    public int health(){
        return health;
    }
    @Override
    public int maxHealth(){
        return maxHealth;
    }

    @Override
    public void setMaxHealth(int value){
        if (value < 0)
            maxHealth = 0;
        else
            maxHealth = value;
        if (maxHealth < health)
            health = maxHealth;
    }
    @Override
    public void heal(int value){
        if (health + value > maxHealth)
            health = maxHealth;
        else
            health += value;
    }
    @Override
    public void takeDamage(int value){
        if (health - value < 0)
            health = 0;
        else
            health -= value;
    }
    @Override
    public int strength(){
        return strength;
    }
    @Override
    public void setStrength(int value){
        strength = value;
    }
    @Override
    public int baseStrength(){
        return baseStrength;
    }
    @Override
    public int armor(){
        return armor;
    }
    @Override
    public void restoreArmor(int value){
        if (armor + value > maxArmor)
            armor = maxArmor;
        else
            armor += value;
    }
    @Override
    public void damageArmor(int value){
        if (armor - value < 0)
            armor = 0;
        else
            armor -= value;
    }
    @Override
    public int maxArmor(){
        return maxArmor;
    }
    @Override
    public void setMaxArmor(int value){
        maxArmor = value;
        if (maxArmor < armor)
            armor = maxArmor;
    }

    @Override
    public abstract void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam);
    @Override
    public abstract void attack(BattleUnit other);
}