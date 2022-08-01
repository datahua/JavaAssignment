import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor {
    private String skill;
    public static int DEFAULT_SUSLEVEL = 15;
    private static String DEFAULT_SKILL = "experienced";

    public RedAstronaut(String name) {
        this(name, DEFAULT_SUSLEVEL, DEFAULT_SKILL);
    }

    public RedAstronaut(String name, int susLevel, String skill) {
        super(name, susLevel);
        this.skill = skill.toLowerCase();
        System.out.println(this.skill);
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public void freeze(Player p) {
        if (this.isFrozen() || p instanceof Impostor) {
            return;
        }
        if (this.getSusLevel() < p.getSusLevel()) {
            p.setFrozen(true);
        } else {
            this.setSusLevel(2 * this.getSusLevel());
        }
        this.gameOver();

    }

    @Override
    public void emergencyMeeting() {
        if (this.isFrozen()) {
            return;
        }
        frozenHelper(Player.getPlayers());
        this.gameOver();
    }

    public boolean frozenHelper(Player[] temp) {
        Arrays.sort(temp);
        double tempHigh = Double.POSITIVE_INFINITY;
        for (int i = temp.length - 1; i > 0; i--) {

        }
    }

    @Override
    public void sabotage(Player p) {
        if (this.isFrozen() || p instanceof Impostor) {
            return;
        }
        if (this.getSusLevel() < 20) {
            int newSus = (int) Math.floor(1.5 * p.getSusLevel());
            p.setSusLevel(newSus);
        } else {
            int newSus = (int) Math.floor(1.25 * p.getSusLevel());
            p.setSusLevel(newSus);
        }
    }

    @Override
    public boolean equals(Object o) {
        if ((o instanceof RedAstronaut) & (this instanceof RedAstronaut)) {
            RedAstronaut redAstronaut = (RedAstronaut) o;
            return super.equals(o) && (this.getSkill() == redAstronaut.getSkill());
        }
        return false;
    }

    @Override
    public String toString() {
        /*
         * return "My name is " + this.name + ", and I have a susLevel of "
         * + this.susLevel + ". I am currently " + frozenString + ".";
         */
        return super.toString() + " I am a " + this.getSkill() + " player!";
    }
}