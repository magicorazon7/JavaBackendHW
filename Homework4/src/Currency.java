public enum Currency {
    USD, EUR, RUB;

    // optional helper if you want exchange pairs or display names
    public static Currency fromString(String name) {
        return Currency.valueOf(name.toUpperCase());
    }
}