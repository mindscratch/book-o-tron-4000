package bookotron.resource.rest.provider;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import net.sf.json.JSONSerializer;

import com.sun.jersey.spi.resource.Singleton;

@Provider
@Singleton
public class JSONMessageBodyWriter implements MessageBodyWriter<Object> {
    
	private final JSONSerializer serializer = new JSONSerializer();
	
	public long getSize(final Object t, final Class<?> type, final Type genericType,
               final Annotation[] annotations, final MediaType mediaType) {
          return -1;
     }
     public boolean isWriteable(final Class<?> type, final Type genericType,
               final Annotation[] annotations, final MediaType mediaType) {
          return mediaType.isCompatible(MediaType.APPLICATION_JSON_TYPE);
     }
     public void writeTo(final Object t, final Class<?> type, final Type genericType,
               final Annotation[] annotations, final MediaType mediaType,
               final MultivaluedMap<String, Object> httpHeaders,
               final OutputStream entityStream) throws IOException, WebApplicationException {
    	 
          entityStream.write(serializer.toJSON(t).toString().getBytes());
     }
     
}

