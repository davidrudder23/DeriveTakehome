package org.dave.derive.persistence.dao;

import com.googlecode.objectify.Key;

import java.util.List;
import java.util.logging.Logger;

import org.dave.derive.persistence.entity.Example;

import static java.util.logging.Level.FINER;

public class ExampleDao extends AbstractDao {

    private static final Logger log = Logger.getLogger(ExampleDao.class.getName());

    public Example findById(long id) {
        log.log(FINER, "Loading example with ID {0}", id);
        return ofy.load().key(Key.create(Example.class, id)).now();
    }

    public Example findByName(String name) {
        return ofy.load().type(Example.class).filter("name =", name).first().now();
    }

    public List<Example> findAllUsers() {
        log.log(FINER, "Loading all examples.");
        return ofy.load().type(Example.class).list();
    }

    public Example save(Example user) {
        log.log(FINER, "Saving example '{0}'", user.getName());
        ofy.save().entities(user).now();
        return user;
    }

    public void deleteAll() {
        List<Key<Example>> keys = ofy.load().type(Example.class).keys().list();
        ofy.delete().entities(keys).now();
    }
}
