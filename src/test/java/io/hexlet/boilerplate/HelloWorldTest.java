package io.hexlet.boilerplate;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThat;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class HelloWorldTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @Test
    @DisplayName("\"main\" method works correctly")
    void testMain() {
        log.debug("Start test");
        HelloWorld.main(null);
        assertThat(output.toString().trim()).isEqualTo("Hello, World!");
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
