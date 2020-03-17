package com.napier.spartans;

import com.napier.spartans.App;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AppTest {

    static App app;

    @BeforeAll
    static void init(){
        app = new App();
    }

}
