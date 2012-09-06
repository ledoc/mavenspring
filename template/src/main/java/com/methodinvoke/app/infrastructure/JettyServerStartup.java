package com.methodinvoke.app.infrastructure;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/*
 * Configures the Jetty embedded server and starts it to host this application.
 * Used as starting point of this application.
 * @Author Prakash Sapkota 
 */
public class JettyServerStartup {
	
	/*
	 * Takes two command line argument port and mode
	 * port must an integer number. Default port is 8080.
	 * Mode can be either dev or prod. Default mode is prod.
	 */
	public static void main(String[] args) {
		int port = 8080;
		String mode = "dev";
		
		//Try to parse port given
		if(args.length>0)
		try{
			port = Integer.parseInt(args[0]);
		}catch(NumberFormatException e){
			throw new RuntimeException(e.getMessage());
		}
		
		//Check if user provides mode information
		if(args.length>1){
			mode = args[1];
			if(!(mode.equals("dev") || mode.equals("prod")))
				throw new RuntimeException("Mode must be either dev or prod");
		}
		
		//Start server and configure
		MyLogger.debug("Starting Jetty Server...");
		long initialTime = System.currentTimeMillis();
		startJettyServer(port, mode);
		long finalTime = System.currentTimeMillis();
		MyLogger.debug("Jetty server started in "+(finalTime - initialTime) /1000 +" second");
		
		
	}
	private static void startJettyServer(int port,String mode){
		String appFolder = MyProperties.getProperty("app.folder");
		Server server =new Server(port);
		WebAppContext context =new WebAppContext();
		if(mode.equals("dev")){
			context.setDescriptor("src/main/webapp/WEB-INF/web.xml");
			context.setResourceBase("src/main/webapp");
			context.setExtraClasspath("src/main/resources");
		}else if(mode.equals("prod")){
			context.setDescriptor("target/"+appFolder+"/WEB-INF/web.xml");
        	context.setResourceBase("target/"+appFolder);
		}
    	context.setContextPath("/");
        context.setParentLoaderPriority(true);
        server.setHandler(context);
        
        try{
	       server.start();
        }catch(Exception e){
    	   throw new RuntimeException("Could not start Jetty server. ");
        }
	}

}
