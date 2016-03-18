package cookbook

import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.boot.SpringApplication

import javax.sql.DataSource

@SpringBootApplication
@MapperScan("cookbook.daos")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args)
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource);
		return sqlSessionFactory.getObject();
	}
}
