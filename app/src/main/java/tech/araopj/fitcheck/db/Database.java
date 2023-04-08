package tech.araopj.fitcheck.db;

import org.dizitart.no2.Nitrite;

/**
 * class used by services to gain access to the database.
 */
public class Database {

    private final String url;
    private final String username;
    private final String password;
    private static Nitrite db;

    public Database(Builder builder) {
        this.url = builder.url;
        this.username = builder.username;
        this.password = builder.password;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        protected String url;
        protected String username;
        protected String password;


        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Database build() {
            return new Database(this);
        }
    }

    /**
     * Creates a datasource
     * @see DataService
     * @see Nitrite
     */
    public void setDataSource() {
        db = Nitrite.builder()
                .compressed()
                .filePath(url)
                .openOrCreate(username, password);
    }

    /**
     * Returns a {@code Nitrite} object.
     * Checks first if the {@code Nitrite} object is null. If it is null,
     * throws a {@code RuntimeException}.
     * @return a {@code Nitrite} object.
     */
    public static Nitrite getDb() {
        if (db == null) throw new RuntimeException("Nitrite DB is not initialized");
        return db;
    }

}
