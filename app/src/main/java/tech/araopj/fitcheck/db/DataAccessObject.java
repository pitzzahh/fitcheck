package tech.araopj.fitcheck.db;

import org.dizitart.no2.objects.filters.ObjectFilters;
import java.util.Collection;

public interface DataAccessObject<T> {
    boolean create(T type);
    Collection<T> read();
    boolean update(T type);
    boolean delete(T type);
    default void deleteAll(Class<T> deez) {
        Database.getDb().getRepository(deez).remove(ObjectFilters.ALL);
    }
    default int getNewId(Class<T> type) {
        return Math.addExact(Database.getDb().getRepository(type).find().totalCount(), 1);
    }
    default boolean checkExisting(Class<T> deez) {
        return false;
    }
}