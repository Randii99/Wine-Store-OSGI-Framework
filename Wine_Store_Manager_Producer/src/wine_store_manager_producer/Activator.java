package wine_store_manager_producer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;



public class Activator implements BundleActivator {

	ServiceRegistration serviceRegisterer;
	@Override
	public void start(BundleContext context) throws Exception {//Life cycle method-start
		System.out.println("============Wine Store Manager producer service started.============");
		ManagerActivaterService managerSer = new ManagerServiceImpl();
		serviceRegisterer = context.registerService(ManagerActivaterService.class.getName(), managerSer, null); //registering the managerService
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {//Life cycle method-stop
		System.out.println("==============Wine Store Manager producer service closed.=============");
		serviceRegisterer.unregister();
	}

}
