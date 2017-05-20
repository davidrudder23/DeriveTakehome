package org.dave.derive.persistence.entity;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.condition.IfFalse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Example {

    @Id
    private Long id;

    private String name;

    private Date created = new Date();

    @Index(IfFalse.class)
    private boolean done = false;

    private List<Ref<Object>> slots = new ArrayList<Ref<Object>>();

    public Example() {
        //
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public List<Object> getSlots() {
        ArrayList<Object> list = new ArrayList<Object>(slots.size());

        for (Ref<Object> itemRef : slots) {
            list.add(itemRef.get());
        }

        return list;
    }

    public void setSlots(List<Object> slots) {
        ArrayList<Ref<Object>> list = new ArrayList<Ref<Object>>(slots.size());

        for (Object slot : slots) {
            list.add(Ref.create(slot));
        }
        this.slots = list;
    }
}
