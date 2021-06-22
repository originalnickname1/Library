package web.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ContextListener implements ServletContextListener {
    private static final Logger log = LogManager.getLogger(ContextListener.class);

    /*public void contextDestroyed(ServletContextEvent event) {
        log.debug("Servlet context destruction starts");
        // do nothing
        log.debug("Servlet context destruction finished");
    }

    public void contextInitialized(ServletContextEvent event) {
        log.debug("Servlet context initialization starts");

        ServletContext servletContext = event.getServletContext();
        initI18N(servletContext);

        log.debug("Servlet context initialization finished");
    }

    private void initI18N(ServletContext servletContext) {
        log.debug("I18N subsystem initialization started");

        String localesValue = servletContext.getInitParameter("locales");
        if (localesValue == null || localesValue.isEmpty()) {
            log.warn("'locales' init parameter is empty, the default encoding will be used");
        } else {
            List<String> locales = new ArrayList<String>();
            StringTokenizer st = new StringTokenizer(localesValue);
            while (st.hasMoreTokens()) {
                String localeName = st.nextToken();
                locales.add(localeName);
            }

            log.debug("Application attribute set: locales --> " + locales);
            servletContext.setAttribute("locales", locales);
        }

        log.debug("I18N subsystem initialization finished");
    }

     */

    public void contextInitialized(ServletContextEvent event) {

        ServletContext context = event.getServletContext();
        String localesFileName = context.getInitParameter("locales");
        String localesFileRealPath = context.getRealPath(localesFileName);
        Properties locales = new Properties();
        try {
            locales.load(new FileInputStream(localesFileRealPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        context.setAttribute("locales", locales);
        locales.list(System.out);
    }
}
