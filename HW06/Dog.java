public class Dog extends Pet {
    private double droolRate;
    public static double DEFAULT_DROOLRATE = 5.0;

    public Dog(String name, double health, int painLevel) {
        this(name, health, painLevel, DEFAULT_DROOLRATE);
    }

    public Dog(String name, double health, int painLevel, double droolRate) {
        super(name, health, painLevel);
        this.droolRate = droolRate;
    }

    /**
     * @return the droolRate
     */
    public double getDroolRate() {
        return droolRate;
    }

    /**
     * @param droolRate the droolRate to set
     */
    public void setDroolRate(double droolRate) {
        this.droolRate = droolRate;
    }

    public int treat() {
        super.heal();
        if (this.getDroolRate() < 3.5) {
            return (int) (this.getPainLevel() * 2 / this.getHealth());
        } else if ((this.getDroolRate() >= 3.5) && (this.getDroolRate() <= 7.5)) {
            return (int) (this.getPainLevel() / this.getHealth());
        } else {
            return (int) (this.getPainLevel() / (this.getHealth() * 2));
        }
    }

    public void speak() {
        super.speak();
        String sound = (getPainLevel() > 5) ? "BARK" : "bark";
        String output = "";
        for (int i = 1; i <= getPainLevel(); i++) {
            output = output + sound;
        }
        System.out.println(output.trim());
    }

    public boolean equals(Object o) {
        return super.equals(o) && this.getDroolRate() == ((Dog) o).getDroolRate();
    }
}