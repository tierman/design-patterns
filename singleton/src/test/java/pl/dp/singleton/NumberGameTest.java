package pl.dp.singleton;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class NumberGameTest {

    @Test
    void checkSingletonIsReallyOne_correctly() {
        //given
        NumberGame ng1 = NumberGame.getInstance();
        NumberGame ng2 = NumberGame.getInstance();

        //when
        //then
        assertEquals(ng1, ng2);
    }

    @Test
    void checkScoreInTwoCalls_correctly() {
        //given
        NumberGame ng1 = NumberGame.getInstance();

        //when
        ng1.play();
        int ng1Score = ng1.getScore();
        NumberGame ng2 = NumberGame.getInstance();

        //then
        assertEquals(ng1Score, ng2.getScore());
    }

    @Test
    void checkSerializationCase_correctly() throws IOException, ClassNotFoundException {
        //given
        NumberGame ng = NumberGame.getInstance();

        //when
        ng.play();
        int baseScore = ng.getScore();

        serializeNumberGameObject(ng);
        NumberGame ngDeserializedOne = deserializeNumberGame("ng.txt");
        NumberGame ngDeserializedTwo = deserializeNumberGame("ng.txt");

        //then
        assertEquals(ngDeserializedOne, ngDeserializedTwo);
        assertEquals(baseScore, ngDeserializedOne.getScore());
        assertNotEquals(0, ngDeserializedOne.getSecondScore());
        //transient value is != 0, because the (static instance) object exist in memory during test
        //when object is deserialized, then method readResolve is called and existing instance is returned
        //static object is allocated in Metaspace - https://www.baeldung.com/java-permgen-metaspace
    }

    @Test
    void checkSerializationTransientField_correctly() throws IOException, ClassNotFoundException {
        //this test must be run on its own, then it will work properly.
        //Because none of static instance NumberGame exists in memory.
        //given
        //when
        NumberGame ngDeserializedOne = deserializeNumberGame("src/test/resources/ng.txt");
        NumberGame ngDeserializedTwo = deserializeNumberGame("src/test/resources/ng.txt");

        //then
        assertEquals(ngDeserializedOne, ngDeserializedTwo);
        assertEquals(0, ngDeserializedOne.getSecondScore());
        assertEquals(0, ngDeserializedTwo.getSecondScore());
    }

    private NumberGame deserializeNumberGame(String filePath) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        NumberGame ngDeserialized = (NumberGame) objectInputStream.readObject();
        objectInputStream.close();
        return ngDeserialized;
    }

    private void serializeNumberGameObject(NumberGame ng) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("ng.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(ng);
        objectOutputStream.flush();
        objectOutputStream.close();
    }
}