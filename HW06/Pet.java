public abstract class Pet {
    private String name;
    private double health;
    private int painLevel;

    public Pet(String name, double health, int painLevel) {
        this.name = name;
        this.setHealth(health);
        this.setPainLevel(painLevel);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param health the health to set
     */
    public void setHealth(double health) {
        if (health > 1) {
            this.health = 1;
        } else if (health < 0) {
            this.health = 0;
        } else {
            this.health = health;
        }
    }

    /**
     * @return the health
     */
    public double getHealth() {
        return health;
    }

    /**
     * @param painLevel the painLevel to set
     */
    public void setPainLevel(int painLevel) {
        if (painLevel > 10) {
            this.painLevel = 10;
        } else if (painLevel < 0) {
            this.painLevel = 0;
        } else {
            this.painLevel = painLevel;
        }
    }

    /**
     * @return the painLevel
     */
    public int getPainLevel() {
        return painLevel;
    }

    public abstract int treat();

    public void speak() {
        String output = String.format("Hello! My name is %s", name);
        output = (painLevel > 5) ? output.toLowerCase() : output;
        System.out.println(output);
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Pet)) {
            return false;
        }
        Pet pet2 = (Pet) o;
        return (pet2.name.equals(name));
    }

    protected void heal() {
        health = 1.0;
        painLevel = 1;
    }

}