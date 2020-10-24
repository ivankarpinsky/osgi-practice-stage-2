package client;

import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.ServiceReference;

import service.Affable;

public class ClientActivator implements BundleActivator
{
    private BundleContext               bundleContext    = null;
    private ServiceReference<Affable>  serviceReference = null;
    //---------------------------------------------------------------
    @Override
    public void start(BundleContext context) throws Exception
    {
        this.bundleContext = context;
        serviceReference = (ServiceReference<Affable>)
                context.getServiceReference(Affable.class.getName());
        if (serviceReference != null) {
            Affable hello = (Affable)
                    context.getService(serviceReference);
            if (hello != null) {
                hello.Greeting();
            }
        }
    }
    //---------------------------------------------------------------
    @Override
    public void stop(BundleContext context) throws Exception
    {
        if (serviceReference != null)
            context.ungetService(serviceReference);
    }
    //---------------------------------------------------------------
}