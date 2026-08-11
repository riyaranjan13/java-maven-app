package com.devops;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

@Test
void helloEndpointMessage() {
    App app = new App();

    assertEquals("Hello from Azure!", app.hello());
}

}

