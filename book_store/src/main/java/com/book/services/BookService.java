package com.book.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.book.dao.BookRepository;
import com.book.entities.Book;
@Component
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	/*
	private static List<Book> list=new ArrayList<>();
	
	static 
	{
		
		list.add(new Book(2,"ew ","Piyush"));
		list.add(new Book(3,"e ","sh"));
		list.add(new Book(4,"we ","ds"));
		list.add(new Book(5,"t ","ewe"));
	}
	*/
	//get all books
	public List<Book> getAllBooks()
	{
		List<Book> list=(List<Book>)this.bookRepository.findAll();
		return list;
	}
	
	//get single book by id
	public Book getBookById(int id)
	{
		Book book =null;
		try {
			//book=list.stream().filter(e->e.getId()==id).findFirst().get();
			
			this.bookRepository.findByid(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return book;
	}
	//Adding the book
	public Book addBook(Book b)
	{
		Book result=bookRepository.save(b);
		return result;
	}
	
	//delete book
	public void deleteBook(int bid)
	{
		//list=list.stream().filter(book->book.getId() != bid).collect(Collectors.toList());
		bookRepository.deleteById(bid);
	}
	
	//update book
	public void updateBook(Book book,int bookId)
	{
		/*
		 * list=list.stream().map(b->{ if(b.getId()==bookId) {
		 * b.setTitle(book.getTitle()); b.setAuthor(book.getAuthor()); } return b;
		 * }).collect(Collectors.toList());
		 */
		
		book.setId(bookId);
		bookRepository.save(book);
	}

}
