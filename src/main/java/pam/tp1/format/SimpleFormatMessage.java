package pam.tp1.format;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class SimpleFormatMessage implements IFormatMessage {
    private static Logger logger = Logger.getLogger(SimpleFormatMessage.class);

    public SimpleFormatMessage() {
        super();
        logger.info("initialize bean");
    }

    /**
     * Remplacer tous les caractères blancs (tab, espace) en un espace.
     */
    @Override
    public String formatMessage(final String msg) {
        return msg.replaceAll("\\s+", " ");
    }

    public String[] parseResponse(String msg) {
        String[] response = msg.split("&");

        response[0] = removeNonWantedChars(response[0].replaceAll("mail=", ""));
        response[1] = removeNonWantedChars(response[1].replaceAll("obj=", ""));
        response[2] = removeNonWantedChars(response[2].replaceAll("msg=", ""));


        return response;
    }

    public String removeWhiteSpace(String msg) {
        return msg.replaceAll("\\s+", "");
    }

    public String removeNonWantedChars(String msg) {
        return msg.replaceAll("\\+", " ").replaceAll("%40", "@");
    }

    public String removeReturns(String msg) {
        return msg.replaceAll("\\n", "");
    }


}
