package pam.tp1.format;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AdvancedFormatMessage implements IFormatMessage {
	private static Logger logger = Logger.getLogger(AdvancedFormatMessage.class);
	
	@Autowired
	@Qualifier("simple_message_formater")
	public IFormatMessage simpleFormater;
	
	@Autowired
	@Qualifier("split_message_formater")
	public IFormatMessage splitFormater;
	
	public AdvancedFormatMessage() {
		logger.info("initialize bean");
	}
	public AdvancedFormatMessage(IFormatMessage lineFormater,IFormatMessage spFormater) {
		this();
		this.simpleFormater = lineFormater;
		this.splitFormater = spFormater;
		
	}
	
	@Override
	public String formatMessage(final String msg) {
		String message = this.simpleFormater.formatMessage(msg);
		String res = this.splitFormater.formatMessage(message);
		return res;
	}
}
