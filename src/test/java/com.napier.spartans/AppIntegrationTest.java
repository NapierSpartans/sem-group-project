package com.napier.spartans;

import org.junit.jupiter.api.BeforeAll;

public class AppIntegrationTest {

    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060");
    }
}
