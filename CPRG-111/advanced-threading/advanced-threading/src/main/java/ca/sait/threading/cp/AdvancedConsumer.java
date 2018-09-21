package ca.sait.threading.cp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 */
public class AdvancedConsumer extends Consumer<String> {

    private static final Logger logger = LoggerFactory.getLogger(AdvancedConsumerProducer.class);

	public AdvancedConsumer(SharedResource<String> shared) {
		super(shared);
	}

	@Override
	protected void consume(String object) {
		logger.info("Consumer: {}", object);
	}

}
