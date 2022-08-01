public class GamePlay {
    public static void main(String[] args) {
        BlueAstronaut bob = new BlueAstronaut("bob", 20, 6, 3);
        BlueAstronaut heath = new BlueAstronaut("Heath", 30, 3, 21);
        BlueAstronaut albert = new BlueAstronaut("Albert", 44, 2, 0);
        BlueAstronaut angel = new BlueAstronaut("angel", 0, 1, 0);
        RedAstronaut liam = new RedAstronaut("Liam", 19, "experienced");
        RedAstronaut suspiciousPerson = new RedAstronaut("Suspicious Person", 100, "expert");


        // 1
        liam.sabotage(bob);
        System.out.println("1 " + bob);

        // 2
        liam.freeze(suspiciousPerson);
        System.out.println("2 "+suspiciousPerson);

        // 3
        liam.freeze(albert);
        System.out.println("3 " + liam);
        System.out.print(albert)

        // 4
        albert.emergencyMeeting();

        // 5
        suspiciousPerson.emergencyMeeting();

        // 6
        bob.emergencyMeeting();

        // 7
        heath.completeTask();
        System.out.println("7"+ heath);

        // 8
        heath.completeTask();
        System.out.println("8" + heath);

        // 9 
        heath.completeTask();

        // 10
        liam.freeze(angel);
        System.out.println("10" + angel);

        // 11
        liam.sabotage(bob);
        System.out.println(bob);
        liam.sabotage(bob);
        System.out.println("11" + bob);

        // 12
        liam.freeze(bob);
        System.out.println("12" + bob);

        // 13
        angel.emergencyMeeting();


    }
}
