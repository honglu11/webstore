package ca.sait.mystore.entity;

import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-02-08T21:07:13.792-0700")
@StaticMetamodel(Product.class)
public class Product_ {
	public static volatile SingularAttribute<Product, UUID> oid;
	public static volatile SingularAttribute<Product, Double> price;
	public static volatile SingularAttribute<Product, String> productName;
	public static volatile SingularAttribute<Product, String> description;
	public static volatile SingularAttribute<Product, Integer> inventoryQty;
}
