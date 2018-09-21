package ca.sait.mystore.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-04-10T19:20:29.688-0600")
@StaticMetamodel(PersonEntity.class)
public class PersonEntity_ extends AbstractEntity_ {
	public static volatile SingularAttribute<PersonEntity, String> firstName;
	public static volatile SingularAttribute<PersonEntity, String> lastName;
	public static volatile SingularAttribute<PersonEntity, String> email;
	public static volatile SingularAttribute<PersonEntity, Date> birthdate;
}
