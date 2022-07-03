package pl.dp.cleaners;

public class ProperUseCleaner {
    public static void main(String[] args) throws Exception {
        try (Room myRoom = new Room(7)) {
            System.out.println("Czy pokój zostanie wyczyszczony?");
        }
    }
}
