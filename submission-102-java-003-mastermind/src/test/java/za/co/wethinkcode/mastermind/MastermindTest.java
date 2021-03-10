package za.co.wethinkcode.mastermind;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MastermindTest {

    @Test
    public void testingCodeLength(){
        //Arrange
        CodeGenerator code = new CodeGenerator();
        String lengthFinder = code.generateCode();

        // Act
        int stringLength = lengthFinder.length();

        //Assert
        assertEquals(stringLength,4);
        assertNotEquals(stringLength,6);
        assertNotEquals(stringLength,0);
    }

    @Test
    public void testTypeofCode(){

        //Arrange
        CodeGenerator code = new CodeGenerator();
        String type = code.generateCode();

        //Assert
        assertEquals(type.getClass(), "".getClass());
    }

    @Test
    public void testUserInput(){

        //Arrange
        InputStream byteArrayInputStream = new ByteArrayInputStream("1234\n".getBytes(StandardCharsets.UTF_8));
        Player playerInput = new Player(byteArrayInputStream);
        String playerGuess = playerInput.getGuess();

        //Assert
        assertEquals("1234", playerGuess);

    }

    @Test
    public void testUserInput2() {

        //Arrange
        InputStream byteArrayInputStream = new ByteArrayInputStream("1111\n".getBytes(StandardCharsets.UTF_8));
        Player playerInput = new Player(byteArrayInputStream);
        String playerGuess = playerInput.getGuess();

        //Assert
        assertEquals("1111", playerGuess);
    }
}
