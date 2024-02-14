package lk.cba.bookstore;

import lk.cba.bookstore.entity.Author;
import lk.cba.bookstore.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
class BookstoreApplicationTests {


	@Test
	void contextLoads() {
		Author author1 = new Author(1, "Supun", "San", "supun@mail.com", "89458345", Collections.emptyList());
		Author author2 = new Author(2, "John", "King", "John@mail.com", "893348345", Collections.emptyList());

		List<Book> bookList = Arrays.asList(
				new Book(1, "123", "harry potter", "category1", 1, author1),
				new Book(2, "234", "Madolduwa", "category2", 1, author2),
				new Book(3, "345", "Madduma", "category3", 1, author1)
		);

		Map<String, Integer> result = bookList.stream().collect(Collectors
				.groupingBy(  book -> String.format("%s %s", book.getAuthor().getFirstName(), book.getAuthor().getLastName()),
						Collectors.summingInt(Book::getLikeCount)));
		System.out.println(result);
	}

}
