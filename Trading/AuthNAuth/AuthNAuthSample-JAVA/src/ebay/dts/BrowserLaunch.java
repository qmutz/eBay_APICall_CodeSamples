/*
 * © 2010-2013 eBay Inc., All Rights Reserved
 * Licensed under CDDL 1.0 -  http://opensource.org/licenses/cddl1.php
 */
package ebay.dts;
/*
 * BrowserLaunch.java
 */

import javax.swing.JOptionPane;
import java.util.Arrays;

public class BrowserLaunch {

    public static void openURL(String url) {
        try {  
            Class<?> d = Class.forName("java.awt.Desktop");
            d.getDeclaredMethod("browse", new Class[]{java.net.URI.class}).invoke(
                    d.getDeclaredMethod("getDesktop").invoke(null),
                    new Object[]{java.net.URI.create(url)});
        } catch (Exception exec) {
            String osName = System.getProperty("os.name");
            try {
               if (osName.startsWith("Windows")) {
                    Runtime.getRuntime().exec(
                            "rundll32 url.dll,FileProtocolHandler " + url);
                } else { //assume Unix or Linux
                    String browser = null;
                    for (String b : browsers) {
                        if (browser == null && Runtime.getRuntime().exec(new String[]{"which", b}).getInputStream().read() != -1) {
                            Runtime.getRuntime().exec(new String[]{browser = b, url});
                        }
                    }
                    if (browser == null) {
                        throw new Exception(Arrays.toString(browsers));
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error on launching web browser" + "\n" + e.toString());
            }
        }
    }
    static final String[] browsers = {"google-chrome", "firefox", "opera", "mozilla"};

}
