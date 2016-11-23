package com.personal;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.personal.config.SpringConfigTest;
import com.personal.controller.BookController;
import com.personal.hateoas.assembler.BookResourceAssembler;
import com.personal.model.Book;
import com.personal.service.BookService;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringConfigTest.class)
@ActiveProfiles("test")
@WebAppConfiguration
public class BookControllerTest {

	@Mock
	private BookService bookService;

	@Mock
	private BookResourceAssembler bookResourceAssembler;

	@InjectMocks
	private BookController bookController;

	@Autowired
	private WebApplicationContext webApplicationContext;

	private HttpMessageConverter mappingJackson2HttpMessageConverter;

	private MockMvc mvc;

	@Autowired
	void setConverters(HttpMessageConverter<?>[] converters) {
		System.out.println(converters);
		List<HttpMessageConverter<?>> httpMessageConverterslist = Arrays.asList(converters);
		for (HttpMessageConverter<?> httpMessageConverter : httpMessageConverterslist) {
			if (httpMessageConverter instanceof MappingJackson2HttpMessageConverter) {
				this.mappingJackson2HttpMessageConverter = httpMessageConverter;
			}
		}
		Assert.assertNotNull("the Json message converter should not be null", this.mappingJackson2HttpMessageConverter);
	}

	@org.junit.Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testBookPost() throws Exception {
		Book book = new Book();
		book.setIsbn("1");
		book.setBookName("The ar");
		book.setStartDate(new Date());
		book.setCompleteDate(new Date());
		book.setCreatedBy("Gagan");
		book.setCreatedOn(new Date());
		book.setLastModifiedBy("Gagan");
		book.setLastModifiedOn(new Date());
		book.setType("Paper");

		this.mvc.perform(
				MockMvcRequestBuilders.post("/book").contentType(MediaType.APPLICATION_JSON_VALUE).content(json(book)))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	protected String json(Object o) throws Exception {
		MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
		this.mappingJackson2HttpMessageConverter.write(o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
		return mockHttpOutputMessage.getBodyAsString();
	}
}
