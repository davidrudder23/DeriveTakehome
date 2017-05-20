package org.dave.derive.persistence.dao;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public abstract class AbstractDao {

    protected Objectify ofy = ObjectifyService.ofy();

}
