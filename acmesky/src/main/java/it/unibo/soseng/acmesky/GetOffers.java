package it.unibo.soseng.acmesky;

import javax.inject.Inject;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.openapitools.client.ApiClient;
import org.openapitools.client.Configuration;
import org.openapitools.client.api.RisorseApi;
import org.openapitools.client.model.InlineResponse2001;
import org.openapitools.client.model.MapsV1Credentials;

public class GetOffers implements JavaDelegate {
	

	
	@Override
    public void execute(DelegateExecution execution) throws Exception {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        
        String airline = (String) execution.getVariable("airline");
        defaultClient.setBasePath(airline);
        
        // Configure API key authorization: apikey
        // ApiKeyAuth apikey = (ApiKeyAuth) defaultClient.getAuthentication("apikey");
        // apikey.setApiKey("YOUR API KEY");
        // // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        // apikey.setApiKeyPrefix("Token");
        
        RisorseApi apiInstance = new RisorseApi(defaultClient);
        // InlineObject1 inlineObject1 = new InlineObject1(); // InlineObject1 | 

        MapsV1Credentials mapsV1Credentials = new MapsV1Credentials();
        mapsV1Credentials.setUsername("Mario");
        mapsV1Credentials.setPassword("12345abcd");


        InlineResponse2001 res = apiInstance.postRegistration(mapsV1Credentials);
        
        execution.setVariable("offers", res);
        

        // apiInstance.registration(); //TODO

        // try {
        //     InlineResponse200 result = apiInstance.getLink(inlineObject1);
        //     System.out.println(result);
        // } catch (ApiException e) {
        //     System.err.println("Exception when calling RisorseApi#getLink");
        //     System.err.println("Status code: " + e.getCode());
        //     System.err.println("Reason: " + e.getResponseBody());
        //     System.err.println("Response headers: " + e.getResponseHeaders());
        //     e.printStackTrace();
        // }
    }
}
