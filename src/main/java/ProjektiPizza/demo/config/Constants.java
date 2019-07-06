package ProjektiPizza.demo.config;

public final class Constants {
    public static final String SECRET = "youtube";
    private long validityInMs = 3600000;

    public static String getSecret() {
        return SECRET;
    }

    public long getValidityInMs() {
        return validityInMs;
    }
}
