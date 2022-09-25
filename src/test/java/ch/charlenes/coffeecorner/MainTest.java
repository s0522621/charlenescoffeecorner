package ch.charlenes.coffeecorner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void main_noArgument_expectException() {
        assertThrows(IllegalArgumentException.class, () -> Main.main(new String[]{}));
    }
}