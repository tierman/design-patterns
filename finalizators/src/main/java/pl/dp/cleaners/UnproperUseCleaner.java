package pl.dp.cleaners;

public class UnproperUseCleaner {
    public static void main(String[] args) {
        new Room(99);
        System.out.println("Czy pokój zostanie wyczyszczony?");
        System.gc(); //może spowodować czyszczenie pokoju, jednak nie musi.
    }
}
