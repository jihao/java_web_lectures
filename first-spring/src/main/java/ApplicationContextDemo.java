import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class ApplicationContextDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("demo1_applicationContext.xml");
		StringBuilder sb1 = context.getBean("stringBuilder1_name", StringBuilder.class);
		sb1.append("hello applicationContext");

		System.out.println(sb1.toString());

		// old fashion way and @deprecated
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("demo1_applicationContext.xml"));
		sb1 = bf.getBean("stringBuilder1_name", StringBuilder.class);
		sb1.append("hello beanFactory");

		System.out.println(sb1.toString());
	}

}
