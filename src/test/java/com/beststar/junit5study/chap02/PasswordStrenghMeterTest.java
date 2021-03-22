package com.beststar.junit5study.chap02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordStrenghMeterTest {

    private PasswordStrenghMeter meter = new PasswordStrenghMeter();

    private void assertStrengh(String password, PasswordStrengh expStr) {
        PasswordStrengh result = meter.meter(password);
        assertEquals(expStr, result);
    }

    @Test
    void meetsAllCreteria_Then_Strong() {
        assertStrengh("ab12!@AB", PasswordStrengh.STRONG);
        assertStrengh("abc1!Add", PasswordStrengh.STRONG);
    }

    @Test
    void meetsOtherCriteria_except_for_Length_Then_Normal() {
        assertStrengh("ab12!@A", PasswordStrengh.NORMAL);
        assertStrengh("AB12!c", PasswordStrengh.NORMAL);
    }

    @Test
    void meetsOtherCreteria_except_for_number_Then_Normal() {
        assertStrengh("ab!@ABqwer", PasswordStrengh.NORMAL);
    }

    @Test
    void nullInput_Then_Invalid() {
        assertStrengh(null, PasswordStrengh.INVALID);
        assertStrengh("", PasswordStrengh.INVALID);
    }

    @Test
    void meetsOtherCriteria_except_for_Uppercase_Then_Normal() {
        assertStrengh("ab12!@df", PasswordStrengh.NORMAL);
    }

    @Test
    void meetsOnlyLengthCriteria_Then_Week() {
        assertStrengh("abdefghi", PasswordStrengh.WEAK);
    }

    @Test
    void meetsOnlyNumCriteria_Then_Week() {
        assertStrengh("12345", PasswordStrengh.WEAK);
    }

    @Test
    void meetsOnlyUpperCriteria_Then_Week() {
        assertStrengh("ABZEF", PasswordStrengh.WEAK);
    }

    @Test
    void meetsNoCriteria_Then_Weak() {
        assertStrengh("abc", PasswordStrengh.WEAK);
    }
}
