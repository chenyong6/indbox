package 代码库.utils.xStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.xstream.XStream;

import 代码库.utils.xStream.csdn.Family;
import 代码库.utils.xStream.csdn.Item;
import 代码库.utils.xStream.csdn.Students;

public class XStreamTest {

	private XStream xstream = null;
	private ObjectOutputStream out = null;
	private ObjectInputStream in = null;

	private Student bean = null;

	/**
	 * <b>function:</b>初始化资源准备
	 * 
	 * @author hoojo
	 * @createDate Nov 27, 2010 12:16:28 PM
	 */
	@Before
	public void init() {
		try {
			xstream = new XStream();
			// xstream = new XStream(new DomDriver()); // 需要xpp3 jar
		} catch (Exception e) {
			e.printStackTrace();
		}
		bean = new Student();
		bean.setAddress("china");
		bean.setEmail("jack@email.com");
		bean.setId(1);
		bean.setName("jack");
		Birthday day = new Birthday();
		day.setBirthday("2010-11-22");
		bean.setBirthday(day);
	}

	@Test
	public void writeBean2XML() {
		try {
			fail("------------Bean->XML------------");
			fail(xstream.toXML(bean));
			fail("重命名后的XML");
			// 类重命名
			// xstream.alias("account", Student.class);
			// xstream.alias("生日", Birthday.class);
			// xstream.aliasField("生日", Student.class, "birthday");
			// xstream.aliasField("生日", Birthday.class, "birthday");
			// fail(xstream.toXML(bean));
			// 属性重命名
			xstream.aliasField("邮件", Student.class, "email");

			// 包重命名 替换包？
			xstream.aliasPackage("utils", "代码库.utils.xStream");
			fail(xstream.toXML(bean));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void writeList2XML() {
		try {
			// 修改元素名称
			fail("----------List-->XML----------");

			List<Object> list = new ArrayList<Object>();
			list.add(bean);
			list.add(bean);// 引用bean
			// list.add(listBean);//引用listBean，父元素

			bean = new Student();
			bean.setAddress("china");
			bean.setEmail("tom@125.com");
			bean.setId(2);
			bean.setName("tom");
			Birthday day = new Birthday("2010-11-22");
			bean.setBirthday(day);

			list.add(bean);

			// 将ListBean中的集合设置空元素，即不显示集合元素标签
			// xstream.addImplicitCollection(ListBean.class, "list");

			// 设置reference模型
			// xstream.setMode(XStream.NO_REFERENCES);//不引用
			xstream.setMode(XStream.ID_REFERENCES);// id引用
			// xstream.setMode(XStream.XPATH_ABSOLUTE_REFERENCES);//绝对路径引用

			// 将name设置为父类（Student）的元素的属性
			xstream.useAttributeFor(Student.class, "name");
			xstream.useAttributeFor(Birthday.class, "birthday");
			// 修改属性的name
			xstream.aliasAttribute("姓名", "name");
			xstream.aliasField("生日", Birthday.class, "birthday");

			fail(xstream.toXML(list));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void writeList2XML4Annotation() {
		try {
			failRed("---------annotation Bean --> XML---------");
			Student stu = new Student();
			stu.setName("jack");
			Classes c = new Classes(bean, stu);
			c.setNumber(111111111);
			// 对指定的类使用Annotation
			xstream.processAnnotations(Classes.class);
			// 启用Annotation
			xstream.autodetectAnnotations(true);
			//xstream.alias("DataServer", Student.class);
			xstream.aliasAttribute("DataServer", "name sszz");
			//xstream.alias("student", Student.class);
			fail(xstream.toXML(c));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void writeMap2XML() {
		try {
			failRed("---------Map --> XML---------");
			Map<String, Student> map = new HashMap<String, Student>();
			map.put("No.1", bean);// put

			bean = new Student();
			bean.setAddress("china");
			bean.setEmail("tom@125.com");
			bean.setId(2);
			bean.setName("tom");
			Birthday day = new Birthday("2010-11-22");
			bean.setBirthday(day);
			map.put("No.2", bean);// put

			bean = new Student();
			bean.setName("jack");
			map.put("No.3", bean);// put

			xstream.alias("student", Student.class);
			xstream.alias("key", String.class);
			xstream.useAttributeFor(Student.class, "id");
			xstream.useAttributeFor("birthday", String.class);
			fail(xstream.toXML(map));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * <b>function:</b>用OutStream输出流写XML
	 * 
	 * @author hoojo
	 * @createDate Nov 27, 2010 1:13:48 PM
	 */
	@Test
	public void writeXML4OutStream() {
		try {
			out = xstream.createObjectOutputStream(System.out);
			Student stu = new Student();
			stu.setName("jack");
			Classes c = new Classes( bean, stu);
			c.setNumber(2);
			failRed("---------ObjectOutputStream # JavaObject--> XML---------");
			out.writeObject(stu);
			out.writeObject(new Birthday("2010-05-33"));
			out.write(22);// byte
			out.writeBoolean(true);
			out.writeFloat(22.f);
			out.writeUTF("hello");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * <b>function:</b>用InputStream将XML文档转换成java对象 需要额外的jar xpp3-main.jar
	 * 
	 * @author hoojo
	 * @createDate Nov 27, 2010 1:14:52 PM
	 */
	@Test
	public void readXML4InputStream() {
		try {
			String s = "<object-stream><代码库.utils.xStream.Student><id>0</id><name>jack</name>"
					+ "</代码库.utils.xStream.Student><代码库.utils.xStream.Birthday><birthday>2010-05-33</birthday>"
					+ "</代码库.utils.xStream.Birthday><byte>22</byte><boolean>true</boolean><float>22.0</float>"
					+ "<string>hello</string></object-stream>";
			failRed("---------ObjectInputStream## XML --> javaObject---------");
			StringReader reader = new StringReader(s);
			in = xstream.createObjectInputStream(reader);
			Student stu = (Student) in.readObject();
			Birthday b = (Birthday) in.readObject();
			byte i = in.readByte();
			boolean bo = in.readBoolean();
			float f = in.readFloat();
			String str = in.readUTF();
			System.out.println(stu);
			System.out.println(b);
			System.out.println(i);
			System.out.println(bo);
			System.out.println(f);
			System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * <b>function:</b>将XML字符串转换成Java对象
	 * 
	 * @author hoojo
	 * @createDate Nov 27, 2010 2:39:06 PM
	 */
	@Test
	public void readXml2Object() {
		try {
			failRed("-----------Xml >>> Bean--------------");
			Student stu = (Student) xstream.fromXML(xstream.toXML(bean));
			fail(stu.toString());

			List<Student> list = new ArrayList<Student>();
			list.add(bean);// add

			Map<String, Student> map = new HashMap<String, Student>();
			map.put("No.1", bean);// put

			bean = new Student();
			bean.setAddress("china");
			bean.setEmail("tom@125.com");
			bean.setId(2);
			bean.setName("tom");
			Birthday day = new Birthday("2010-11-22");
			bean.setBirthday(day);
			list.add(bean);// add
			map.put("No.2", bean);// put

			bean = new Student();
			bean.setName("jack");
			list.add(bean);// add
			map.put("No.3", bean);// put

			failRed("==========XML >>> List===========");
			List<Student> studetns = (List<Student>) xstream.fromXML(xstream.toXML(list));
			fail("size:" + studetns.size());// 3
			for (Student s : studetns) {
				fail(s.toString());
			}

			failRed("==========XML >>> Map===========");
			Map<String, Student> maps = (Map<String, Student>) xstream.fromXML(xstream.toXML(map));
			fail("size:" + maps.size());// 3
			Set<String> key = maps.keySet();
			Iterator<String> iter = key.iterator();
			while (iter.hasNext()) {
				String k = iter.next();
				fail(k + ":" + map.get(k));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void csdnStudent(){
		
		Students stu = new Students();
		stu.setAddress("address");
		stu.setId(1);
		stu.setTel("sss");
		List<Item> items = new ArrayList<>();
		items.add(new Item(2,"11",3));
		items.add(new Item(3,"113",33));
		Family family = new Family();
		family
		.setItem(items);
		//xstream.processAnnotations(Students.class);
		// 启用Annotation
		xstream.autodetectAnnotations(true);
		fail(xstream.toXML(stu));
	}

	/**
	 * <b>function:</b>释放对象资源
	 * 
	 * @author hoojo
	 * @createDate Nov 27, 2010 12:16:38 PM
	 */
	@After
	public void destory() {
		xstream = null;
		bean = null;
		try {
			if (out != null) {
				out.flush();
				out.close();
			}
			if (in != null) {
				in.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.gc();
	}

	public final void fail(String string) {
		System.out.println(string);
	}

	public final void failRed(String string) {
		System.err.println(string);
	}
}
