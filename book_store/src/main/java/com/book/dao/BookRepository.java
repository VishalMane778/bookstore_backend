package com.book.dao;

import org.springframework.data.repository.CrudRepository;

import com.book.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer >{
	public Book findByid(int id);

}
