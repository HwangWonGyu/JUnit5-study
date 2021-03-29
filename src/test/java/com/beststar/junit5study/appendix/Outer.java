package com.beststar.junit5study.appendix;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Outer {

    @BeforeEach
    void outerBefore() {
        System.out.println("outerBefore");
    }

    @Test
    void outer() {
        System.out.println("outer");
    }

    @AfterEach
    void outerAfter() {
        System.out.println("outerAfter");
    }

    @Nested
    class NestedA {
        @BeforeEach
        void nestedBefore() {
            System.out.println("nestedBefore");
        }

        @Test
        void nested1() {
            System.out.println("nested1");
        }

        @AfterEach
        void nestedAfter() {
            System.out.println("nestedAfter");
        }
    }
}
