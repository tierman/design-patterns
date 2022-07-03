package pl.dp.cleaners;

import java.lang.ref.Cleaner;

class Room implements AutoCloseable {

    private static final Cleaner cleaner = Cleaner.create();

    // Zasoby wymagające oczyszczenia. Nie można odnosić się do Room!
    private static class State implements Runnable {
        int numJunkPiles; // liczba stert śmieci
        State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }
        // wywoływane przez metodę close lub oczyszczacz
        @Override public void run() {
            System.out.println("Czyszczenie pokoju");
            numJunkPiles = 0;
        }
    }
    // stan pokoju współdzielony z cleanable
    private final State state;

    // Nasz cleanable. Czyści pokój, gdy ten ma zostać usunięty przez
    // odzyskiwanie nieużytków
    private final Cleaner.Cleanable cleanable;
    public Room(int numJunkPiles) {
        state = new State(numJunkPiles);
        cleanable = cleaner.register(this, state);
    }

    @Override
    public void close() throws Exception {
        cleanable.clean();
    }
}
