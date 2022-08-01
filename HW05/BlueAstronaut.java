import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate {

    private int numTasks;
    private int taskSpeed;

    public static int DEFAULT_NUMTASKS = 6;
    public static int DEFAULT_TASKSPEED = 10;

    public BlueAstronaut(String name) {
        // question mark
        this(name, RedAstronaut.DEFAULT_SUSLEVEL, DEFAULT_NUMTASKS, DEFAULT_TASKSPEED);
    }

    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
        super(name, susLevel);
        this.numTasks = DEFAULT_NUMTASKS;
        this.taskSpeed = DEFAULT_TASKSPEED;
    }

    public void setNumTasks(int numTasks) {
        if (numTasks <= 0) {
            this.numTasks = 0;
        } else {
            this.numTasks = numTasks;
        }
    }

    public void setTaskSpeed(int taskSpeed) {
        this.taskSpeed = taskSpeed;
    }

    public int getNumTasks() {
        return numTasks;
    }

    public int getTaskSpeed() {
        return taskSpeed;
    }

    public void emergencyMeeting() {
        if (this.isFrozen()) {
            return;
        } else {
            frozenHelper2(Player.getPlayers());
        }
        gameOver();
    }

    public void frozenHelper2(Player[] temp) {
        Arrays.sort(temp);
        for (int i = temp.length - 1; i > 0; i--) {
            if (temp[i].isFrozen()) {
                continue;
            } else {
                if (((!temp[i].isFrozen()) && (!temp[i - 1].isFrozen()))
                        && (temp[i].getSusLevel() == temp[i - 1].getSusLevel())) {
                    System.out.println("No one is voted out.");
                    return;
                } else {
                    temp[i].setFrozen(true);
                    System.out.println(temp[i] + "is frozen.");
                    return;
                }
            }
        }
    }

    public void completeTask() {
        if (this.isFrozen()) {
            return;
        }
        boolean firstTime = true;
        if (this.getNumTasks() == 0) {
            firstTime = false;
        }

        if (this.getTaskSpeed() > 20) {
            this.setNumTasks(this.getNumTasks() - 2);
        } else {
            this.setNumTasks(this.getNumTasks() - 1);
        }

        if ((firstTime) && (this.getNumTasks() == 0)) {
            int temp = (int) Math.floor(this.getSusLevel() * 0.5);
            this.setSusLevel(temp);
            System.out.println("I have Completed all my tasks");
        }
    }

    public boolean equals(Object o) {
        if ((o instanceof BlueAstronaut) & (this instanceof BlueAstronaut)) {
            BlueAstronaut blueAstronaut = (BlueAstronaut) o;
            return super.equals(o) && (this.getNumTasks() == blueAstronaut.getNumTasks())
                    && (this.getTaskSpeed() == blueAstronaut.getTaskSpeed());
        }
        return false;
    }

    @Override
    public String toString() {

        /*
         * return "My name is " + this.name + ", and I have a susLevel of "
         * + this.susLevel + ". I am currently " + frozenString + ".";
         */
        return super.toString() + " I have " + this.getNumTasks() + " left over.";
    }
}