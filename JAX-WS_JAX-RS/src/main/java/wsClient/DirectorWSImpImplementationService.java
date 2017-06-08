
package wsClient;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "DirectorWSImpImplementationService", targetNamespace = "http://wsServices/", wsdlLocation = "http://localhost:8080/lab7_war_exploded/DirectorWSImpImplementation?wsdl")
public class DirectorWSImpImplementationService
    extends Service
{

    private final static URL DIRECTORWSIMPIMPLEMENTATIONSERVICE_WSDL_LOCATION;
    private final static WebServiceException DIRECTORWSIMPIMPLEMENTATIONSERVICE_EXCEPTION;
    private final static QName DIRECTORWSIMPIMPLEMENTATIONSERVICE_QNAME = new QName("http://wsServices/", "DirectorWSImpImplementationService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/lab7_war_exploded/DirectorWSImpImplementation?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        DIRECTORWSIMPIMPLEMENTATIONSERVICE_WSDL_LOCATION = url;
        DIRECTORWSIMPIMPLEMENTATIONSERVICE_EXCEPTION = e;
    }

    public DirectorWSImpImplementationService() {
        super(__getWsdlLocation(), DIRECTORWSIMPIMPLEMENTATIONSERVICE_QNAME);
    }

    public DirectorWSImpImplementationService(WebServiceFeature... features) {
        super(__getWsdlLocation(), DIRECTORWSIMPIMPLEMENTATIONSERVICE_QNAME, features);
    }

    public DirectorWSImpImplementationService(URL wsdlLocation) {
        super(wsdlLocation, DIRECTORWSIMPIMPLEMENTATIONSERVICE_QNAME);
    }

    public DirectorWSImpImplementationService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, DIRECTORWSIMPIMPLEMENTATIONSERVICE_QNAME, features);
    }

    public DirectorWSImpImplementationService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DirectorWSImpImplementationService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns DirectorWS
     */
    @WebEndpoint(name = "DirectorWSImpImplementationPort")
    public DirectorWS getDirectorWSImpImplementationPort() {
        return super.getPort(new QName("http://wsServices/", "DirectorWSImpImplementationPort"), DirectorWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns DirectorWS
     */
    @WebEndpoint(name = "DirectorWSImpImplementationPort")
    public DirectorWS getDirectorWSImpImplementationPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://wsServices/", "DirectorWSImpImplementationPort"), DirectorWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (DIRECTORWSIMPIMPLEMENTATIONSERVICE_EXCEPTION!= null) {
            throw DIRECTORWSIMPIMPLEMENTATIONSERVICE_EXCEPTION;
        }
        return DIRECTORWSIMPIMPLEMENTATIONSERVICE_WSDL_LOCATION;
    }

}
