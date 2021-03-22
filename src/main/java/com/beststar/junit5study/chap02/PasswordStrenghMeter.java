package com.beststar.junit5study.chap02;

public class PasswordStrenghMeter {
    public PasswordStrengh meter(String s) {
        if(s == null || s.isEmpty()) return PasswordStrengh.INVALID;

        int metCounts = getMetCriteriaCounts(s);
        if(metCounts <= 1) return PasswordStrengh.WEAK;
        if(metCounts == 2) return PasswordStrengh.NORMAL;

        return PasswordStrengh.STRONG;
    }

    private int getMetCriteriaCounts(String s) {
        int metCounts = 0;
        if(s.length() >= 8) metCounts++;
        if(meetsContainingNumberCriteria(s)) metCounts++;
        if(meetsContainingUppercaseCriteria(s)) metCounts++;
        return metCounts;
    }

    private boolean meetsContainingNumberCriteria(String s) {
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                return true;
            }
        }
        return false;
    }

    private boolean meetsContainingUppercaseCriteria(String s) {
        for (char ch : s.toCharArray()) {
            if(Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }
}
