package pl.dp.finalizators;

import java.util.UUID;

class YellowApple {
    private final String name = "yellow apple";
    private UUID someText;

    public YellowApple() {
        someText = UUID.randomUUID();
    }

    @Override
    protected void finalize() throws Throwable {
        //System.out.println(this.getClass().getName() + " : " + name + " : " + someText);
        super.finalize();
 //       throw new IllegalArgumentException("Some custom exception");
    }

}
