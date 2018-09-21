/**
 * 
 */
package ca.sait.produce;

import java.text.SimpleDateFormat;

/**
 * 
 * @author Chris Elias
 */
public class RawMaterial extends Product {

	private final static long baseItemId = 11100000;

	private final Produce produce;	

	/**
	 * @param name
	 */
	public RawMaterial(final Produce produce) {
		super(produce.getName());
		this.produce = produce;
	}

	public Produce getProduce() {
		return produce;
	}

	@Override
	public String getSKU() {
		final StringBuilder sku = new StringBuilder();

		sku.append(produce.getPLU());
		sku.append("-");
		sku.append(getItemId());

		return sku.toString();
	}

	@Override
	protected long getBaseItemId() {
		return baseItemId;
	}
}