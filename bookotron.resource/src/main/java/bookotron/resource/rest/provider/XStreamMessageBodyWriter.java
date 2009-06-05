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

import com.sun.jersey.spi.resource.Singleton;
import com.thoughtworks.xstream.XStream;

@Provider
@Singleton
public class XStreamMessageBodyWriter implements MessageBodyWriter<Object> {

	private final XStream xstream = new XStream();

	@Override
	public long getSize(final Object t, final Class<?> type,
			final Type genericType, final Annotation[] annotations,
			final MediaType mediaType) {
		return -1;
	}

	@Override
	public boolean isWriteable(final Class<?> type, final Type genericType,
			final Annotation[] annotations, final MediaType mediaType) {
		return mediaType.isCompatible(MediaType.APPLICATION_XML_TYPE)
				|| mediaType.isCompatible(MediaType.TEXT_XML_TYPE);
	}

	@Override
	public void writeTo(final Object t, final Class<?> type,
			final Type genericType, final Annotation[] annotations,
			final MediaType mediaType,
			final MultivaluedMap<String, Object> httpHeaders,
			final OutputStream entityStream) throws IOException,
			WebApplicationException {
		xstream.processAnnotations(type);
		xstream.toXML(t, entityStream);
	}

}
