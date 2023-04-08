package tech.araopj.fitcheck.mvvm.model;

import java.util.Collection;
import tech.araopj.fitcheck.db.DataAccessObject;
import tech.araopj.fitcheck.db.Database;

public class UserDAO implements DataAccessObject<UserProfile> {

    @Override
    public boolean create(UserProfile type) {
        try {
            return Database.getDb()
                    .getRepository(UserProfile.class)
                    .insert(type)
                    .getAffectedCount() == 1;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Collection<UserProfile> read() {
        return Database.getDb()
                .getRepository(UserProfile.class)
                .find()
                .toList();
    }

    @Override
    public boolean update(UserProfile type) {
        return Database.getDb()
                .getRepository(UserProfile.class)
                .update(type)
                .getAffectedCount() == 1;
    }

    @Override
    public boolean delete(UserProfile type) {
        return Database.getDb()
                .getRepository(UserProfile.class)
                .remove(type)
                .getAffectedCount() == 1;
    }

}
