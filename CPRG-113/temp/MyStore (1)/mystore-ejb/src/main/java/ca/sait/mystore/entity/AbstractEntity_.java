package ca.sait.mystore.entity;

import java.util.Date;
import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-04-10T18:57:10.300-0600")
@StaticMetamodel(AbstractEntity.class)
public class AbstractEntity_ {
	public static volatile SingularAttribute<AbstractEntity, UUID> oid;
	public static volatile SingularAttribute<AbstractEntity, Date> createDate;
	public static volatile SingularAttribute<AbstractEntity, Date> lastModified;
	public static volatile SingularAttribute<AbstractEntity, String> createdBy;
	public static volatile SingularAttribute<AbstractEntity, String> lastModifiedBy;
}
