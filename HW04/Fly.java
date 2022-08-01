public class Fly {
    private double mass;
    private double speed;

    private static final int DEFAULT_MASS = 5;
    private static final int DEFAULT_SPEED = 10;

    // constructors
    public Fly() {
        this(DEFAULT_MASS);
    }

    public Fly(double mass) {
        this(mass, DEFAULT_SPEED);
    }

    public Fly(double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }

    // Setter
    public void setMass(double mass) {
        if (mass >= 0) {
            this.mass = mass;
        }
    }

    public void setSpeed(double speed) {
        if (speed > 0) {
            this.speed = speed;
        }
    }

    // getter method
    public double getMass() {
        return mass;
    }

    public double getSpeed() {
        return speed;
    }

    // grow method
    public void grow(int addMass) {
        if (mass >= 20) {
            speed -= 0.5 * addMass;
        } else if (mass + addMass < 20) {
            speed += addMass;
        } else {
            int before20 = (int) (20 - mass);
            int after20 = (int) (mass + addMass - 20);
            speed += before20 - 0.5 * after20;
        }
        mass += addMass;
    }

    // isDead method
    public boolean isDead() {
        return (mass == 0);
    }

    // override toString method
    public String toString() {
        if (this.mass == 0) {
            return String.format("I'm dead, but I used to be a fly with a speed of %.2f.", speed);
        } else {
            return String.format("I'm a speedy fly with %.2f speed and %.2f mass.", speed, mass);
        }
    }
}