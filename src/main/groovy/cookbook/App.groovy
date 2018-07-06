package cookbook

import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.PropertySource
import org.springframework.context.annotation.PropertySources

import javax.sql.DataSource

@SpringBootApplication
@ComponentScan("cookbook")
@EnableAutoConfiguration
@PropertySources([
	@PropertySource("classpath:application.properties"),
	@PropertySource("classpath:auth0.properties")
])
@MapperScan("cookbook.daos")
class App {

	static void main(String[] args) {
		SpringApplication.run(App.class, args)

	}

	@Bean
	SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean()
		sqlSessionFactory.setDataSource(dataSource)
		return sqlSessionFactory.getObject()
	}
}
