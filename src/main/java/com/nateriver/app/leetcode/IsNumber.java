package com.nateriver.app.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Validate if a given string is numeric.
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 */
public class IsNumber {
    private Map<Status, Map<Type, Status>> STATUS_MACHINE = new HashMap<Status, Map<Type, Status>>() {
        {
            put(Status.S0, new HashMap<Type, Status>() {{
                put(Type.BLANK, Status.S0);
                put(Type.SIGN, Status.S1);
                put(Type.NUMBER, Status.S2);
                put(Type.POINT, Status.S3A);
            }});

            put(Status.S1, new HashMap<Type, Status>() {{
                put(Type.NUMBER, Status.S2);
                put(Type.POINT, Status.S3A);
            }});

            put(Status.S2, new HashMap<Type, Status>() {{
                put(Type.NUMBER, Status.S2);
                put(Type.POINT, Status.S3);
                put(Type.EXPSGN, Status.S4);
                put(Type.BLANK, Status.S7);
                put(Type.TERM, Status.S8);
            }});

            put(Status.S3A, new HashMap<Type, Status>(){{
                put(Type.NUMBER,Status.S3);
            }});

            put(Status.S3, new HashMap<Type, Status>(){{
                put(Type.NUMBER,Status.S3);
                put(Type.EXPSGN, Status.S4);
                put(Type.BLANK, Status.S7);
                put(Type.TERM, Status.S8);
            }});

            put(Status.S4, new HashMap<Type, Status>(){{
                put(Type.SIGN,Status.S5);
                put(Type.NUMBER,Status.S6);
            }});

            put(Status.S5, new HashMap<Type, Status>(){{
                put(Type.NUMBER,Status.S6);
            }});

            put(Status.S6, new HashMap<Type, Status>(){{
                put(Type.NUMBER,Status.S6);
                put(Type.BLANK,Status.S7);
                put(Type.TERM,Status.S8);
            }});

            put(Status.S7, new HashMap<Type, Status>(){{
                put(Type.BLANK,Status.S7);
                put(Type.TERM,Status.S8);
            }});

            put(Status.S8, new HashMap<Type, Status>(){{
                put(Type.TERM, Status.S8);
            }});

        }
    };


    public boolean isNumber(String s) {
        if(s == null) return false;
        Status status = Status.S0;
        for(char a : s.toCharArray()){
            Type t = Type.getType(a);
            if(t == Type.INVALID || !STATUS_MACHINE.get(status).containsKey(t)) return false;
            status = STATUS_MACHINE.get(status).get(t);
        }
        status = STATUS_MACHINE.get(status).get(Type.TERM);
        return status == Status.S8;
    }

    public static void main(String[] args) throws Exception {
        IsNumber judge = new IsNumber();
        System.out.println(judge.isNumber("0"));
        System.out.println(judge.isNumber(" 0.1 "));
        System.out.println(judge.isNumber("abc"));
        System.out.println(judge.isNumber("1 a"));
        System.out.println(judge.isNumber("2e10"));
        System.out.println(judge.isNumber("e"));
    }
}

/**
 S0 = SIGN | NUMBER | POINT | BLANK,
 S1 = NUMBER | POINT,
 S2 = NUMBER | POINT | EXPSGN | BLANK | TERM,
 S3A = NUMBER,
 S3 = NUMBER | EXPSGN | BLANK | TERM,
 S4 = SIGN | NUMBER,
 S5 = NUMBER,
 S6 = NUMBER | BLANK | TERM,
 S7 = BLANK | TERM,
 S8 = TERM
 */

enum Status {
    S0,
    S1,
    S2,
    S3,
    S3A,
    S4,
    S5,
    S6,
    S7,
    S8
}

enum Type {
    TERM,
    NUMBER,
    SIGN,
    POINT,
    EXPSGN,
    BLANK,
    INVALID,;

    public static Type getType(char a) {
        switch (a) {
            case '+':
            case '-':
                return SIGN;
            case '.':
                return POINT;
            case 'E':
            case 'e':
                return EXPSGN;
            case ' ':
                return BLANK;
            case 0:
                return TERM;
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return NUMBER;
            default:
                return INVALID;
        }
    }
}
