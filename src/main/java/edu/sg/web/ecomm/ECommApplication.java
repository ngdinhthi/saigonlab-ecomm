package edu.sg.web.ecomm;

import java.io.File;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

public class ECommApplication {
  private static final int PORT = 8080;

  public static void main(String[] args) throws Exception {
    Tomcat tomcat = new Tomcat();
    tomcat.setPort(PORT);
    StandardContext ctx = (StandardContext) tomcat.addWebapp("/", new File("src/main/webapp/").getAbsolutePath());
    tomcat.start();
    tomcat.getServer().await();
  }

}
