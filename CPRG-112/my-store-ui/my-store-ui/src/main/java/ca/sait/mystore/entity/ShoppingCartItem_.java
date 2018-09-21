package ca.sait.mystore.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-02-22T18:29:33.223-0700")
@StaticMetamodel(ShoppingCartItem.class)
public class ShoppingCartItem_ extends AbstractEntity_ {
	public static volatile SingularAttribute<ShoppingCartItem, ShoppingCart> shoppingCart;
	public static volatile SingularAttribute<ShoppingCartItem, Product> product;
	public static volatile SingularAttribute<ShoppingCartItem, Integer> quantity;
	public static volatile SingularAttribute<ShoppingCartItem, Double> price;
}
