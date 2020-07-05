package com.alexander8;

import java.util.Arrays;

public class Solution {
    public static String[] solution(String[] l) {
        Version[] versions = new Version[l.length];

        for (int i = 0; i < l.length; ++i)
            versions[i] = new Version(l[i]);

        Arrays.sort(versions);

        String[] result = new String[versions.length];
        for (int i = 0; i < versions.length; ++i)
            result[i] = versions[i].toString();

        return result;
    }
}

class Version implements Comparable<Version> {
    int major;
    int minor;
    boolean hasMinor;
    int rev;
    boolean hasRev;

    public Version(String v) {
        String[] parts = v.split("\\.");
        this.major = Integer.parseInt(parts[0]);

        if (parts.length > 1) {
            minor = Integer.parseInt(parts[1]);
            hasMinor = true;
        }
        else {
            minor = 0;
            hasMinor = false;
        }

        if (parts.length > 2) {
            rev = Integer.parseInt(parts[2]);
            hasRev = true;
        }
        else {
            rev = 0;
            hasRev = false;
        }
    }

    public int getMajor() {
        return major;
    }

    public int getMinor() {
        return minor;
    }

    public int getRev() {
        return rev;
    }

    public boolean getHasMinor() {
        return hasMinor;
    }

    public boolean getHasRev() {
        return hasRev;
    }

    public String toString() {
        return major +
                (getHasMinor() ? "." + getMinor() : "") +
                (getHasRev() ? "." + getRev() : "");
    }

    @Override
    public int compareTo(Version v) {
        if (getMajor() != v.getMajor())
            return getMajor() - v.getMajor();

        if (getMinor() != v.getMinor())
            return getMinor() - v.getMinor();

        if (getRev() != v.getRev())
            return getRev() - v.getRev();

        int sum1 = (getHasMinor() ? 1 : 0) + (getHasRev() ? 1 : 0);
        int sum2 = (v.getHasMinor() ? 1 : 0) + (v.getHasRev() ? 1 : 0);

        return sum1 - sum2;
    }
}
