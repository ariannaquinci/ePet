package utils;

public enum Kind {
    BUNNY,
    CAT,
    DOG,
    HAMSTER,
    OTHER;

    public static Kind stringToKind(String in) {
        Kind out;
        switch(in) {
            case "bunny":
                out = Kind.BUNNY;
                break;
            case "cat":
                out= Kind.CAT;
                break;
            case "dog":
                out= Kind.DOG;
                break;
            case "hamster":
                out= Kind.HAMSTER;
                break;
            case "other":
                out=Kind.OTHER;
                break;
            default:
                out = null;
                break;
        }

        return out;
    }
}
