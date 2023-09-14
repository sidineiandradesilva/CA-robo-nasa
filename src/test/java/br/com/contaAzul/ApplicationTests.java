package br.com.contaAzul;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ApplicationTests {

	@Value(value = "${local.server.port}")
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() throws Exception {

	}

	@ParameterizedTest
	@CsvSource(quoteCharacter = '"', textBlock = """
			# entrada,  saida
			"MMRMMRMM",  "(2, 0, S)"
			"MML",       "(0, 2, W)"
			"MML",       "(0, 2, W)"
			"AAA",       "400 Bad Request"
			"MMMMMMMMMMMMMMMMMMMMMMMM","400 Bad Request"
			""")
	void funcMarsTest(String entrada, String saida) {
		assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/rest/mars/" + entrada, null,
				String.class)).contains(saida);
	}
}
