package tech.araopj.fitcheck.db;


import androidx.annotation.NonNull;
import java.util.Collection;

public class DataService<T> {

    private final DataAccessObject<T> dataAccessObject;

    public DataService(DataAccessObject<T> dataAccessObject) {
        this.dataAccessObject = dataAccessObject;
    }

    public boolean create(T deezType) {
        return dataAccessObject.create(deezType);
    }

    public Collection<T> read() {
        return dataAccessObject.read();
    }

    public boolean update(T deezType) {
        return dataAccessObject.update(deezType);
    }

    public boolean delete(T deezType) {
        return dataAccessObject.delete(deezType);
    }

    public void deleteAllByType(Class<T> deezType) {
        dataAccessObject.deleteAll(deezType);
    }

    public boolean checkExisting(Class<T> deez) {
        return dataAccessObject.checkExisting(deez);
    }

    public int getNewId(Class<T> type) {
        return dataAccessObject.getNewId(type);
    }

    @NonNull
    @Override
    public String toString() {
        return String.valueOf(dataAccessObject);
    }
}