package top.slrjy.edu;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.slrjy.edu.Dao")
public class SlrjyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SlrjyApplication.class, args);
	}
}
