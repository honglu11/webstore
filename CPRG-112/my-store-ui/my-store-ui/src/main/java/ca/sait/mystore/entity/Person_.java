package ca.sait.mystore.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-02-22T18:28:35.341-0700")
@StaticMetamodel(Person.class)
public class Person_ extends AbstractEntity_ {
	public static volatile SingularAttribute<Person, String> firstName;
	public static volatile SingularAttribute<Person, String> lastName;
	public static volatile SingularAttribute<Person, String> email;
	public static volatile SingularAttribute<Person, String> password;
	public static volatile SingularAttribute<Person, String> role;
}
