package pl.michalsnella.mytaskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyTaskManager {

	public static void main(String[] args) {
		//TimeZone.setDefault(TimeZone.getTimeZone("Europe/Warsaw"));
		SpringApplication.run(MyTaskManager.class, args);
	}

}
