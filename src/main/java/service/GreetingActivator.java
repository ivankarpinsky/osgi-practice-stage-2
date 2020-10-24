package service;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class GreetingActivator implements BundleActivator {
    private ServiceRegistration<Affable> serviceRegistration;

    public void start(BundleContext context) throws Exception
    {
        serviceRegistration = (ServiceRegistration<Affable>)
                context.registerService (Affable.class.getName(),
                        new HelloWorld(), null);
    }

    public void stop(BundleContext context) throws Exception
    {
        serviceRegistration.unregister();
    }
}
