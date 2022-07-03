package pl.dp.finalizators;

import java.util.UUID;

class GreenApple {
    private final String name = "green apple";
    private UUID someText;

    public GreenApple() {
        someText = UUID.randomUUID();
    }
}
