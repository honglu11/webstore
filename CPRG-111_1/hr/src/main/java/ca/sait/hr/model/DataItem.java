package ca.sait.hr.model;

import java.util.UUID;

public class DataItem {

	private UUID oid;
	
	public DataItem() {
		oid = UUID.randomUUID();
	}

	/**
	 * @return the oid
	 */
	public UUID getOid() {
		return oid;
	}

	/**
	 * @param oid the oid to set
	 */
	public void setOid(UUID oid) {
		this.oid = oid;
	}

}