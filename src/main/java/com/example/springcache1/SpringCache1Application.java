package com.example.springcache1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.SessionScope;

@SpringBootApplication()
@Controller
//@Scope(value = WebApplicationContext.SCOPE_SESSION)
@SessionScope
//@RequestMapping("/")
@EnableCaching
public class SpringCache1Application {

	int c = 0;

	@GetMapping()
	@ResponseBody
	@Cacheable(value = "f")
	public String f() throws InterruptedException {
		Thread.sleep(3000);
		return "C = " + ++c;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCache1Application.class, args);
	}

}
