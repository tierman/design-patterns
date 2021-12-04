package pl.dp.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberGameEnumTest {

    @Test
    void checkScoreInTwoCalls_correctly() {
        //given
        NumberGameEnum ng1 = NumberGameEnum.INSTANCE;

        //when
        ng1.play();
        int ng1Score = ng1.getScore();
        NumberGameEnum ng2 = NumberGameEnum.INSTANCE;

        //then
        assertEquals(ng1Score, ng2.getScore());
    }
}