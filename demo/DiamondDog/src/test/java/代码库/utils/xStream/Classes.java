package 代码库.utils.xStream;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

@XStreamAlias("?xml version=\"1.0\" encoding=\"UTF-8\"?")
public class Classes {
    
    /*
     * 设置属性显示
     */
//    @XStreamAsAttribute
    @XStreamAlias("DataServer")
    private DataServer DataServer = new DataServer();
    
    /*
     * 忽略
     */
    @XStreamOmitField
    private int number;
    
    @XStreamImplicit(itemFieldName = "Students")
    private List<Student> students;
    
    
    public Classes(){}
    public Classes( Student... stu) {
        this.students = Arrays.asList(stu);
    }
    
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public DataServer getDataServer() {
		return DataServer;
	}
	public void setDataServer(DataServer dataServer) {
		DataServer = dataServer;
	}
	
    
}
@XStreamAlias("version=\"1.0\" xmlns=\"urn:selfextension:psiaext-ver10-xsd")
class DataServer{
	
}
class SingleValueCalendarConverter implements Converter {
    public void marshal(Object source, HierarchicalStreamWriter writer,
               MarshallingContext context) {
           Calendar calendar = (Calendar) source;
           writer.setValue(String.valueOf(calendar.getTime().getTime()));
       }

       public Object unmarshal(HierarchicalStreamReader reader,
               UnmarshallingContext context) {
           GregorianCalendar calendar = new GregorianCalendar();
           calendar.setTime(new Date(Long.parseLong(reader.getValue())));
           return calendar;
       }

       @SuppressWarnings("unchecked")
       public boolean canConvert(Class type) {
           return type.equals(GregorianCalendar.class);
       }
}