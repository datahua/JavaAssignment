public class Cat extends Pet {
    private int miceCaught;

    public static int DEFAULT_MICECAUGHT = 0;

    public Cat(String name, double health, int painLevel) {
        this(name, health, painLevel, DEFAULT_MICECAUGHT);
    }

    public Cat(String name, double health, int painLevel, int miceCaught) {
        super(name, health, painLevel);
        this.miceCaught = (miceCaught < 0) ? 0 : miceCaught;
    }

    /**
     * @return the miceCaught
     */
    public int getMiceCaught() {
        return miceCaught;
    }

    /**
     * @param miceCaught the miceCaught to set
     */
    public void setMiceCaught(int miceCaught) {
        this.miceCaught = miceCaught;
    }

    public int treat() {
        int treatmentTime;
        if (miceCaught < 4) {
            treatmentTime = (int) Math.ceil((getPainLevel() * 2) / getHealth());
        } else if (miceCaught <= 7) {
            treatmentTime = (int) Math.ceil(getPainLevel() / getHealth());
        } else {
            treatmentTime = (int) Math.ceil(getPainLevel() / (getHealth() * 2));
        }
        heal();
        return treatmentTime;
    }

    public void speak() {
        super.speak();
        String sound = (getPainLevel() > 5) ? "MEOW" : "meow";
        String output = "";
        for (int i = 1; i <= miceCaught; i++) {
            output = output + sound;
        }
        System.out.println(output.trim());
    }

    public boolean equals(Object o) {
        return super.equals(o) && ((Cat) this).getMiceCaught() == ((Cat) o).getMiceCaught();
    }

}