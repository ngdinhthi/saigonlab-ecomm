package edu.sg.web.ecomm.config;

import java.io.File;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.springframework.beans.factory.InitializingBean;

public class TomcatApplicationStartupBuilder implements InitializingBean {

  @Override
  public void afterPropertiesSet() throws Exception {
    Tomcat tomcat = new Tomcat();
    tomcat.setPort(8080);
    StandardContext ctx = (StandardContext) tomcat.addWebapp("/", new File("src/main/webapp/").getAbsolutePath());
    tomcat.start();
    tomcat.getServer().await();
  }

  public static void build() throws Exception {
    new TomcatApplicationStartupBuilder().afterPropertiesSet();
  }

}
