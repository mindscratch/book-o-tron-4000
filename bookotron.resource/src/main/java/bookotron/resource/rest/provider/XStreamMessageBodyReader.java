package bookotron.resource.rest.provider;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

@Provider
public class XStreamMessageBodyReader implements MessageBodyReader<Object> {

	private final XStream xstream = new XStream(new DomDriver());
	
	@Override
	public boolean isReadable(Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		
		return mediaType.isCompatible(MediaType.APPLICATION_XML_TYPE)
				|| mediaType.isCompatible(MediaType.TEXT_XML_TYPE);
	}

	@Override
	public Object readFrom(Class<Object> type, Type genericType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws IOException, WebApplicationException {
		
		xstream.processAnnotations(type);
		return xstream.fromXML(entityStream);
	}

}
