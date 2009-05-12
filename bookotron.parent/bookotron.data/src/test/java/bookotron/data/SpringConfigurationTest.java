package bookotron.data;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:bookotron-data.xml"})
public class SpringConfigurationTest extends AbstractDependencyInjectionSpringContextTests {

	@Test
	public void testSpringConfiguration() {
		Assert.assertTrue(true);
	}
}
