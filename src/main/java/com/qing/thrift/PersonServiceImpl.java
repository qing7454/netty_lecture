package com.qing.thrift;

import generated.DataException;
import generated.Person;
import generated.PersonService;
import org.apache.thrift.TException;

/**
 * <p>****************************************************************************</p>
 * <p><b>Copyright © 2010-2017 Sanfangda team All Rights Reserved<b></p>
 * <ul style="margin:15px;">
 * <li>@description : com.qing.thrift</li>
 * <li>@version     : 1.0</li>
 * <li>@creation    : 2018年03月03日</li>
 * <li>@author     : fanrenqing</li>
 * </ul>
 * <p>****************************************************************************</p>
 */
public class PersonServiceImpl implements PersonService.Iface {
    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {
        System.out.println("receive client username:" + username);
        Person person = new Person();
        person.setUsername(username);
        person.setAge(20);
        person.setMarred(false);
        return person;
    }

    @Override
    public void save(Person person) throws DataException, TException {
        System.out.println("Got Client Param:");
        System.out.println(person.getUsername());
        System.out.println(person.getAge());
        System.out.println(person.isMarred());
    }
}
