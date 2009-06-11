package bookotron.ui.util.mappers {
import bookotron.ui.model.IAuthor;
import bookotron.ui.model.impl.Author;
import mx.logging.ILogger;
import mx.logging.Log;
import org.spicefactory.lib.xml.XmlObjectMapper;
import org.spicefactory.lib.xml.XmlProcessorContext;
import org.spicefactory.lib.xml.mapper.PropertyMapperBuilder;
public class AuthorMapper {

    private static const logger:ILogger = Log.getLogger("AuthorMapper");

    private var _mapper:XmlObjectMapper;

    private var _context:XmlProcessorContext;

    public function AuthorMapper() {
        var authorBuilder:PropertyMapperBuilder = new PropertyMapperBuilder(Author, new QName("Author"));
        authorBuilder.mapToChildTextNode("firstName", new QName("firstName"));
        authorBuilder.mapToChildTextNode("lastName", new QName("lastName"));
        _mapper = authorBuilder.build();
        _context = new XmlProcessorContext();

    }

    public function get mapper():XmlObjectMapper{
        return _mapper;
    }

    public function fromXml(xml:XML):Author{
        return mapper.mapToObject(xml,_context) as Author;
    }

    public function toXml(author:IAuthor):XML{
        return mapper.mapToXml(author as Author,_context);
    }
}
}