package ca.sait.threading.cp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author celias
 *
 */
public class AdvancedProducer extends Producer<String> {

    private static final Logger logger = LoggerFactory.getLogger(AdvancedConsumerProducer.class);

	public AdvancedProducer(SharedResource<String> shared) {
		super(shared);
	}

    @Override
    protected String produce(int count) {
        final StringBuilder txt = new StringBuilder();
        txt.append("Message ").append(count);
        logger.info("Created: {}", txt.toString());

        return txt.toString();
    }

}
