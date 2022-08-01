import java.util.concurrent.Flow.Subscriber;

public class Pond {
    public static void main(String[] args) {
        Frog peepo = new Frog("Peepo");
        Frog pepe = new Frog("pepe", 10, 15);
        Frog peepaw = new Frog("Peepaw", 4.6);
        Frog frog = new Frog("Any name", 10, 10);

        Fly one = new Fly(1, 3);
        Fly six = new Fly(6);
        Fly any = new Fly(10, 10);

        Frog.setSpecies("1331 Frogs");
        System.out.println(peepo);
        peepo.eat(six);
        System.out.println(six);
        peepo.grow(8);
        peepo.eat(six);
        System.out.println(six);
        System.out.println(peepo);
        System.out.println(frog);
        peepaw.grow(4);
        System.out.println(peepaw);
        System.out.println(pepe);
    }
}