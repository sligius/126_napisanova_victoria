package task;

public class BattleUnit {
    private int Strength;
    private int Armor;
    private int X;
    private int Y;
    private int Health;
    public BattleUnit(int Strength, int Armor, int Health, int X, int Y){
        this.Strength = Strength;
        this.Armor = Armor;
        this.Health = Health;
        this.X = X;
        this.Y = Y;
    }
    public int getStrength(){
        return Strength;
    }
    public int getArmor(){
        return Armor;
    }
    public int getX(){
        return X;
    }
    public int getY(){
        return Y;
    }
    public int getHealth(){
        return Health;
    }
    public void attacked(BattleUnit enemy){
        if (Armor > 0 && Armor < enemy.getStrength()) {
            Health = Health - (enemy.getStrength() - Armor);
        }
        else if (Armor < 0) {
            Health = Health - enemy.getStrength();
        }
    }
    public void moveUp() {
        --Y;
    }
    public void moveDown() {
        ++Y;
    }
    public void moveLeft() {
        --X;
    }
    public void moveRight() {
        ++X;
    }
    public boolean isAlive() {
        return Health > 0;
    }
}
