package com.cg.book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.book.entity.Book;
import com.cg.book.entity.Passenger;

@Service
public interface BookService {
	public List<Book> getAllBookings();

	public Book saveBook(Book book);

	public Book getBookingDetailsById(int bookId);
	// public Book saveBook(Book book);

	public Book cancelBooking(int bookId);
}
