package core;

/*
 * Copyright (C) 2015 fotiou
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */



import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapHandler;

/**
 * This is a basic CoAP client
 * @author fotiou
 */
public class BasicClient {
    private String endpoint;
    
    /**
     * The default constructor
     */
    public BasicClient(){}
    
    /**
     * It initializes a client and species the URI of the remote source. 
     * @param endpoint The URI of the resource
     */
    public BasicClient(String endpoint){
        this.endpoint = endpoint;
    }
    
    /**
     * It performs a CoAP GET method. This is a non-blocking call. The response
     * of this call are handled by the handler.
     * @param handler The handler of the call
     * @throws Exception If a resource has not been specified it throws an exception
     */
    public void get(CoapHandler handler) throws Exception{
        if (endpoint == null){
             throw new Exception("Endpoint has not been set");
        }
        new CoapClient(endpoint).get(handler);
    }
    
    /**
     * It performs a CoAP POST method. This is a non-blocking call. The response
     * of this call are handled by the handler.
     * @param handler The handler of the call
     * @param The payload of the post
     * @param The format of the post. For possible values see https://tools.ietf.org/html/rfc7252#section-12.3
     * @throws Exception If a resource has not been specified it throws an exception
     */
    public void post(CoapHandler handler, String payload, int format) throws Exception{
        if (endpoint == null){
             throw new Exception("Endpoint has not been set");
        }
        new CoapClient(endpoint).post(handler,payload,format);
        
    }
}
