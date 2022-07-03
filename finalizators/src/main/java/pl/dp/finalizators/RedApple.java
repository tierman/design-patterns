package pl.dp.finalizators;

import java.util.UUID;

class RedApple {
    private final String name = "red apple";
    private UUID someText;

    public RedApple() {
        someText = UUID.randomUUID();
        //throw new IllegalArgumentException("Some custom exception");
    }
    @Override
    protected void finalize() throws Throwable {
        //System.out.println(this.getClass().getName() + " : " + name + " : " + someText);
        super.finalize();
        throw new IllegalArgumentException("Some custom exception");
    }
}
