public class Test {
    public static void main(String args[]) {
        Frog frog1= new Frog("a");
        Frog frog2 = new Frog("b");
        Frog frog3 = new Frog("c");
        System.out.println(Frog.getSpecies());
        Frog.setSpecies("dfaf");
        System.out.println(Frog.getSpecies());


    }
}
