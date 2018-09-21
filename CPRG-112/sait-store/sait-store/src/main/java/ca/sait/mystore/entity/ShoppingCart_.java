package ca.sait.mystore.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-02-27T13:50:13.657-0700")
@StaticMetamodel(ShoppingCart.class)
public class ShoppingCart_ extends AbstractEntity_ {
	public static volatile SingularAttribute<ShoppingCart, Date> startDate;
	public static volatile SingularAttribute<ShoppingCart, Date> submitDate;
	public static volatile SingularAttribute<ShoppingCart, Date> shipDate;
	public static volatile SingularAttribute<ShoppingCart, Person> customer;
	public static volatile ListAttribute<ShoppingCart, ShoppingCartItem> items;
}
