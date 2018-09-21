package ca.sait.mystore.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-02-27T13:50:13.644-0700")
@StaticMetamodel(Product.class)
public class Product_ extends AbstractEntity_ {
	public static volatile SingularAttribute<Product, Double> price;
	public static volatile SingularAttribute<Product, String> productName;
	public static volatile SingularAttribute<Product, String> description;
	public static volatile SingularAttribute<Product, Integer> inventoryQty;
}
