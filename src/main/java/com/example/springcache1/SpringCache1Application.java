package com.example.springcache1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.SessionScope;

import java.lang.reflect.Array;
import java.util.Arrays;

@SpringBootApplication()
@Controller
//@Scope(value = WebApplicationContext.SCOPE_SESSION)
@SessionScope
//@RequestMapping("/")
@EnableCaching
public class SpringCache1Application {

//	@Bean
//	public CacheManager cacheManager() {
//		return new ConcurrentMapCacheManager("addresses");
//	}

//	@Autowired
//	CachingService cachingService;

//	@Autowired
//	CacheManager cacheManager;

	int c = 0;

	@GetMapping()
	@ResponseBody
	@Cacheable(value = "f")
	public String f(int f) throws InterruptedException {
		Thread.sleep(3000);
		return "C = " + ++c + f;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCache1Application.class, args);
	}

}


@Component
class SimpleCacheCustomizer implements CacheManagerCustomizer<ConcurrentMapCacheManager> {

	@Override
	public void customize(ConcurrentMapCacheManager cacheManager) {
		cacheManager.setCacheNames(Arrays.asList("f"));
	}
}
