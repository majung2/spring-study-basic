package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {

	ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

	@Test
	@DisplayName("싱글톤 stateful test")
	public void statefulTest(){
		StatefulService statefulService1 = ac.getBean(StatefulService.class);
		StatefulService statefulService2 = ac.getBean(StatefulService.class);

		int userAprice = statefulService1.order("userA", 10000);
		int userBprice = statefulService2.order("userB", 20000);

//		Assertions.assertThat(statefulService1.getPrice()).isEqualTo(10000);
		Assertions.assertThat(userAprice).isEqualTo(10000);

	}


	static class TestConfig {
		@Bean
		public StatefulService statefulService() {
			return new StatefulService();
		}

	}
}
