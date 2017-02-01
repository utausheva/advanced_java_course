package Home2;

/**
 * Created by user on 31.12.2016.
 */
class Pokemon implements Train, Fight{

    enum mode {
        SLEEP,
        TRAINING,
        FIGHT,
    }

    private int health;
    private mode mode;
    private String name;
    private int power;
    private int energy;
    private int level;

    public Pokemon(int health, String name, int power, int level) {
        this.health = health;
        this.name = name;
        this.power = power;
        this.level = level;
    }

    String getName(){
        return this.name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPower() {
        return power;
    }

    public void setMode(Pokemon.mode mode) {
        this.mode = mode;
    }
    public Pokemon.mode getMode() {
        return mode;
    }

    @Override
    public int getEnergy() {
        return energy;
    }
    @Override
    public void setEnergy(int energy) {
        this.energy = energy;
    }

    @Override
    public boolean stopFight(){
        if (this.health <=0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void train(){
        setMode(mode.TRAINING);

        setEnergy(this.energy+this.level*3);
        this.health=this.health + this.energy;
        this.power=power+level+1;
        level++;
        System.out.println(getName() + " : Energy " + energy + ", Power " + power + ", Level " + level);
        setMode(mode.SLEEP);
    }

}
