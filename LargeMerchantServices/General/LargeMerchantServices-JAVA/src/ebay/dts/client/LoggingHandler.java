/**
 * © 2009-2013 eBay Inc., All Rights Reserved
 * Licensed under CDDL 1.0 -  http://opensource.org/licenses/cddl1.php
 */

package ebay.dts.client;

import java.io.PrintStream;
import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;


/**
*
* @author zhuyang
*/
public class LoggingHandler implements SOAPHandler<SOAPMessageContext> {

    private static PrintStream out = System.out;

    public Set<QName> getHeaders() {
        return null;
    }

    public boolean handleMessage(SOAPMessageContext context) {
        log(context);
        return true;
    }

    public boolean handleFault(SOAPMessageContext context) {
        log(context);
        return true;
    }

    public void close(MessageContext messageContext) {
    }

    private void log(SOAPMessageContext messageContext) {
       boolean request =
                ((Boolean) messageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY)).booleanValue();
        if (request ){
            out.println("SOAP Request message:  ");
        } else {
            out.println("SOAP Response message:  ");
        }

        SOAPMessage meg = messageContext.getMessage();

        try {
            meg.writeTo(out);
            out.println("");
        } catch (Exception e) {
            out.println(e);
        }
    }
}

