package ca.sait.mystore.entity;

import ca.sait.dto.CartStatus;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-05-01T19:10:47.440-0600")
@StaticMetamodel(ShoppingCartEntity.class)
public class ShoppingCartEntity_ extends AbstractEntity_ {
	public static volatile SingularAttribute<ShoppingCartEntity, PersonEntity> customer;
	public static volatile SingularAttribute<ShoppingCartEntity, Date> shoppingDate;
	public static volatile SingularAttribute<ShoppingCartEntity, Date> shippedDate;
	public static volatile SingularAttribute<ShoppingCartEntity, Date> recievedDate;
	public static volatile SingularAttribute<ShoppingCartEntity, CartStatus> status;
}
