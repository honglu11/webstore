package ca.sait.mystore.entity;

import java.util.Date;
import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-02-27T13:50:13.586-0700")
@StaticMetamodel(AbstractEntity.class)
public class AbstractEntity_ {
	public static volatile SingularAttribute<AbstractEntity, UUID> oid;
	public static volatile SingularAttribute<AbstractEntity, Date> createDate;
	public static volatile SingularAttribute<AbstractEntity, Date> lastModified;
	public static volatile SingularAttribute<AbstractEntity, String> createdBy;
	public static volatile SingularAttribute<AbstractEntity, String> lastModifiedBy;
}