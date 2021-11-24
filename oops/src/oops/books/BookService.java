package oops.books;


//https://github.com/AndriiPiatakha/learnit_java_core/blob/master/src/com/itbulls/learnit/javacore/oop/hw/books/BookService.java

public class BookService {

	public Book[] filterBooksByAuthor(Author author, Book[] books) {
		//<write your code here>
		Book[] totalBooks = null;
		int len = 0;
		for(Book book : books) {
			for(Author auth : book.getAuthors())
			  if(author.getId() == auth.getId()) {
				 if(len == 0) {
					 totalBooks = new Book[1];
					 totalBooks[len++] = book;
				 }
				 else {
					 int i=0;
					 Book[] temp = new Book[++len];
					 for(Book b : totalBooks)
						 temp[i++] = b;
					 totalBooks = temp;
				 }
			  }
		}
	    return totalBooks;	
	}

	public Book[] filterBooksByPublisher(Publisher publisher, Book[] books) {
		//<write your code here>
	    return null;	

	}

	// methods keeps books with publishing year inclusively. 
	public Book[] filterBooksAfterSpecifiedYear(int yearFromInclusively, Book[] books) {
		//<write your code here>
	    return null;	

	}



}
