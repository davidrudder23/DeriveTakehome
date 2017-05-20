package org.dave.derive.web.controller;

import org.dave.derive.persistence.dao.ExampleDao;
import org.dave.derive.persistence.entity.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/example")
public class ExampleController {

    @Autowired
    private ExampleDao exampleDao;

    @RequestMapping("/find/{id}")
    @ResponseBody
    public Example link(@PathVariable("id") long id) {
        return exampleDao.findById(id);
    }

    @RequestMapping("/create")
    @ResponseBody
    public Example link() {
        Example example = new Example();
        example.setName("Example");
        return exampleDao.save(example);
    }

    @RequestMapping("/clear}")
    @ResponseBody
    public void clearDB() {
        exampleDao.deleteAll();
    }

}
