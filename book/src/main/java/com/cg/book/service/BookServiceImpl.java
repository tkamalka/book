package com.cg.book.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.book.entity.Book;
import com.cg.book.entity.FareDTO;
import com.cg.book.entity.FlightDTO;
import com.cg.book.entity.Inventory;
import com.cg.book.entity.Status;
import com.cg.book.repository.BookDao;
import com.cg.book.repository.InventoryDao;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	BookDao bookDao;
	
	@Autowired
	InventoryDao inventoryDao;
	
	RestTemplate restTemplate = new RestTemplate();
	 String url = "http://localhost:8083/fares/fare";

	@Override
	public List<Book> getAllBookings() {

		return bookDao.findAll();
	}

//	@Override
//	public Book saveBook(Book book) {
//		return bookDao.save(book);
//	}

	@Override
	public Book saveBook(Book book) {


		// Comparing amount of book fare and fare microService fare
		System.out.println("Getting Fare Details from fare microService");
		FareDTO fares = restTemplate.exchange(url + "/get/" + book.getFlightNumber() + "/" + book.getFlightDate(),
				HttpMethod.GET, null, FareDTO.class).getBody();
		book.setFare(fares.getFare());
		if (book.getFare() != fares.getFare()) {
			throw new BookingException("Fare is Tampered");
		}
		// Comparing available seats and passenger size
		Inventory inv = inventoryDao.findByFlightNumberAndFlightDate(book.getFlightNumber(), book.getFlightDate());
		if (inv.getAvailable() >= book.getPassenger().size()) {
			System.out.println("Seats are availale");
			inv.setAvailable(inv.getAvailable() - book.getPassenger().size());
		} else {
			throw new BookingException("Seats are not available");
		}
		long no_of_passenger=book.getPassenger().size();
		long payable_fare=book.getFare()*no_of_passenger;
		book.setTotalFare(payable_fare);
		
		book.setBookingDate(new Date());
		book.setStatus(Status.booking_confirmed);

		
		return bookDao.save(book);
	}

	@Override
	public Book getBookingDetailsById(int bookId) {
		return bookDao.findById(bookId).get();
	}

	@Override
	public Book cancelBooking(int bookId) {
		Book book=bookDao.findById(bookId).get();
		int no_of_passengers=book.getPassenger().size();
		int flightNo=book.getFlightNumber();
		Inventory inv=inventoryDao.findByFlightNumber(flightNo);
		int update_available_seats=inv.getAvailable()+no_of_passengers;
		inv.setAvailable(update_available_seats);
		bookDao.deleteById(bookId);
		
		return book;
	}

}
