package com.ll.simpleDb;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public class SimpleDbTest {

    @Test
    @DisplayName("MYSQL접속")
    void t1(){
        String jdbcURL = "jdbc:mysql://localhost:3306/simpleDb__test";
        String username = "root";
        String password = "lldj123414";


    }

}
