package com.cg.book.controller;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.book.entity.Book;
import com.cg.book.entity.CheckInDTO;
import com.cg.book.entity.FareDTO;
import com.cg.book.entity.FlightDTO;
import com.cg.book.entity.Inventory;
import com.cg.book.entity.Passenger;
import com.cg.book.entity.Status;
import com.cg.book.entity.UiSearchData;
import com.cg.book.repository.BookDao;
import com.cg.book.repository.InventoryDao;
import com.cg.book.service.BookService;
import com.cg.book.service.BookingException;
import com.netflix.discovery.converters.Auto;

@RestController
@RequestMapping(value = "/book")
public class BookController {
	@Autowired
	BookService bookService;
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	BookDao bookDao;
	@Autowired
	InventoryDao inventoryDao;

	// "Display all" bookings
	@GetMapping(value = "/bookings")
	public List<Book> getBookings() {

		return bookService.getAllBookings();
	}

	// To display particular Booking details based on "bookingId"
	@GetMapping(value = "/bookings/{bookId}")
	public Book getBookingDetailsById(@PathVariable int bookId) {
		return bookService.getBookingDetailsById(bookId);
	}

	// To "ADD" new booking
	@PostMapping(value = "/bookings")
	public Book saveBook(@RequestBody Book book) {

		return bookService.saveBook(book);
	}

	// "Integrate" flight with book
	@GetMapping(value = "/bookings/allFlights")
	public String allFlights() {
		String url = "http://localhost:8091/api/allFlights";
		return restTemplate.exchange(url, HttpMethod.GET, null, String.class).getBody();
	}


	@GetMapping(value = "/bookings/cnfCheckIn/{firstName}/{lastName}/{checkInTime}/{flightNumber}/{flightdate}/{bookingId}")
	public String confirmCheckIn(@PathVariable String firstName, @PathVariable String lastName,
			@PathVariable Date checkInTime, @PathVariable int flightNumber, @PathVariable Date flightdate,
			@PathVariable int bookingId) {
		CheckInDTO checkInDto = new CheckInDTO(firstName, lastName, checkInTime, flightNumber, flightdate, bookingId);
		String url = "http://localhost:8070/check/addCheckin";
		RestTemplate restTemplate = new RestTemplate();

		CheckInDTO chk = restTemplate.postForObject(url, checkInDto, CheckInDTO.class);

		return "CheckIn confirmed for booking Id:" + chk.getBookingId();

	}
	
	@DeleteMapping(value="/bookings/cancelBooking/{bookId}")
	public Book cancelBooking(@PathVariable int bookId) {
		
		return bookService.cancelBooking(bookId);
	}
}
