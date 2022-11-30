package org.dieschnittstelle.ess.mip.webapi;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.apache.logging.log4j.Logger;

/*
 * Note that in order for the webapi to work correctly when running in wildfly, the option
 * -Dresteasy.preferJacksonOverJsonB=true must be set when starting
 * jboss, otherwise JsonTypeInfo will not be considered, see https://docs.jboss.org/resteasy/docs/4.3.1.Final/userguide/html/JAX-RS_2.1_additions.html
 */
@ApplicationPath("/api")
public class RESTWebAPIRoot extends Application {

	protected static Logger logger = org.apache.logging.log4j.LogManager.getLogger(RESTWebAPIRoot.class);
	
	public RESTWebAPIRoot() {
		logger.info("<constructor>");
	}

// explicit declaration of resource implementation does not seem to be necessary
//	@Override
//	public Set<Class<?>> getClasses() {
//		return new HashSet(Arrays.asList(
//				TouchpointAccessImpl.class,
//				CustomerCRUDImpl.class,
//				CustomerTransactionCRUDImpl.class,
//				CustomerTrackingImpl.class,
//				CampaignTrackingImplSingleton.class,
//				ShoppingCartRESTServiceImpl.class));
//	}

}
