package ca.sait.mystore.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-04-10T19:20:29.704-0600")
@StaticMetamodel(ProductEntity.class)
public class ProductEntity_ extends AbstractEntity_ {
	public static volatile SingularAttribute<ProductEntity, String> name;
	public static volatile SingularAttribute<ProductEntity, String> description;
	public static volatile SingularAttribute<ProductEntity, Double> price;
}
