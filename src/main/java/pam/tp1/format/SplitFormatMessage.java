package pam.tp1.format;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service 
public class SplitFormatMessage implements IFormatMessage{
	private static Logger logger = Logger.getLogger(SplitFormatMessage.class);
	private int lineSize;
	
	public SplitFormatMessage()
	{
		lineSize = 30;
		logger.info("initialize bean (nb characters: "+lineSize+")");
	}
	
	public SplitFormatMessage(int nb) {
		this();
		this.lineSize = nb;
		
	}
	public int getLineSize() {
		return lineSize;
	}
	public void setLineSize(int nbUpperCase) {
		this.lineSize = nbUpperCase;
	}
	
	@Override
	public String formatMessage(String msg) {
		
		String res = "";
		int lsize = msg.length();
		int idx = 0;
		for(; idx+lineSize<lsize; idx+=lineSize)
			res +=msg.substring(idx, idx+this.lineSize)+"\n";
		res +=msg.substring(idx);
		return res;
	}

}
