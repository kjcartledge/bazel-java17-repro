public record Repro(int value) {
    public static int example(Object o) {
        return switch(o) {
            case null -> 0;
            case String s -> 1;
            default -> -1;
        };
    }
}