package com.example.springcache1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.SessionScope;

import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import java.lang.reflect.Array;
import java.util.Arrays;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Controller
//@Scope(value = WebApplicationContext.SCOPE_SESSION)
//@SessionScope
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

	@Autowired
	A a;

	int c = 0;

	@GetMapping()
	@ResponseBody
	//@Cacheable(value = "f", unless="#result.length()>10")
//	@CacheEvict
	public String f(@RequestParam int f) throws InterruptedException {

		String s = a.fff();

//		Thread.sleep(2000);
		return "C=" + s + " " + ++c + "; f=" + f;
	}

//	@Cacheable(value="books", key="#isbn.rawNumber")
//	public Book findStoryBook (ISBN isbn, boolean checkWarehouse, boolean includeUsed)
//
//	@Cacheable(value="books", key="T(classType).hash(#isbn)")
//	public Book findStoryBook (ISBN isbn, boolean checkWarehouse, boolean includeUsed)

	public static void main(String[] args) {
		SpringApplication.run(SpringCache1Application.class, args);
	}
}

@NamedNativeQuery( name = "qqq", query = "SELECT 1")
@Component
class A {

	@Cacheable(value = "f")
	public String fff() throws InterruptedException
	{
		Thread.sleep(2000);
		return "aaaaaaaaaa";
	}

}

//class Q implements CacheCo

//@Component
//class SimpleCacheCustomizer implements CacheManagerCustomizer<ConcurrentMapCacheManager> {
//
//	@Override
//	public void customize(ConcurrentMapCacheManager cacheManager) {
//		cacheManager.setCacheNames(Arrays.asList("f"));
//	}
//}
