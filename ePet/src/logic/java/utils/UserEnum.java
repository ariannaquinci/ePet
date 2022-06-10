package utils;

import java.util.HashMap;
import java.util.Map;

public enum UserEnum {
    SIMPLE_USER(1),
    PET_SITTER(2);

    private int value;

    private static Map<Object, Object> map = new HashMap<>();

    private UserEnum(int value) {
        this.value = value;
    }

    static {
        for (UserEnum user : UserEnum.values()) {
            map.put(user.value, user);
        }
    }

    public static UserEnum valueOf(Integer user) {
        return (UserEnum) map.get(user);
    }

    public int getValue() {
        return value;
    }

    public static UserEnum stringToUserEnum(String in) {
        UserEnum out;
        switch(in) {
            case "SIMPLE_USER":
                out = UserEnum.SIMPLE_USER;
                break;
            case "PET_SITTER":
                out= UserEnum.PET_SITTER;
                break;
            default:
                out = null;
                break;
        }

        return out;
    }

    public static String UserEnumToString(UserEnum in) {
        String out;
        switch(in) {
            case SIMPLE_USER:
                out = "SIMPLE_USER";
                break;
            case PET_SITTER:
                out = "PET_SITTER";
                break;

            default:
                out = null;
                break;
        }

        return out;
    }
}