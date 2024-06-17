package wine_store_supplier_producer;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;



public class Activator implements BundleActivator {
	ServiceRegistration serviceRegisterer;
	@Override
	public void start(BundleContext context) throws Exception {//Life cycle method-start
		System.out.println("============Welcome to Wine Store. Service Started.============");
		LiquorSuppierService managerSer = new LiquorSuppierServiceImpl();
		serviceRegisterer = context.registerService(LiquorSuppierService.class.getName(), managerSer, null); //registering the managerService
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {//Life cycle method-stop
		System.out.println("==============Thank you! Come Again. Service Closed.=============");
		serviceRegisterer.unregister();
	}

}