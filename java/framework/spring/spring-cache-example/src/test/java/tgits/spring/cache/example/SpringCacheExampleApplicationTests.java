package tgits.spring.cache.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SpringCacheExampleApplicationTests {

	@Autowired
	private CacheManager cacheManager;

	@Test
	void contextLoads() {
	}

	@Test
	void smokeTest() {
		assertThat(cacheManager).isNotNull();
		assertThat(cacheManager.getCacheNames()).isNotNull().hasSize(1).contains("pokemons");
		assertThat(cacheManager.getCache("pokemons")).isNotNull().isInstanceOf(Cache.class);
	}

}
