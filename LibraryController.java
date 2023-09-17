package com.gl.lib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.lib.entity.Book;
import com.gl.lib.entity.Student;
import com.gl.lib.service.BookService;

@RestController
@RequestMapping("/library")
public class LibraryController {
	
	@Autowired
	BookService bookservice;
	
	@GetMapping("/greet")
	public String greet()
	{
		return "Hello World, This is my first Springboot Project";
	}
	
	@GetMapping("/asia")
	public String asia()
	{
		return "India wins Asia cup 2023";
	}
	
	@GetMapping("/getStudent")
	public Student getStudent()
	{
		return new Student(101,"Alice",78.5);
	}
	
	@PostMapping("/addBookReqParam")
	public String addBook( @RequestParam("bno") int bno,
						   @RequestParam("bname") String bname,
						   @RequestParam("author") String author,
						   @RequestParam("cat") String category)
	{
			Book b1=new Book(bno,bname,author,category);
			bookservice.addBook(b1);
			return "Book Added Successfully";
	}
	
	
	@PostMapping("/addBookReqBody")
	public String addBookReqBody(@RequestBody Book b1)
	{
			System.out.println(b1.getAuthor());
			bookservice.addBook(b1);
			return "Book Added Successfully";
	}
	
	@PostMapping("/addBookPathVariable/{bno}/{bname}/{author}/{cat}")
	public String addBookPathVariable(@PathVariable("bno") int bno,
									  @PathVariable("bname") String bname,
									  @PathVariable("author") String author,
									  @PathVariable("cat") String category)
	{
		Book b1=new Book(bno,bname,author,category);
		bookservice.addBook(b1);
		return "Book Added Successfully";
	}
	
	@DeleteMapping("/deleteBook")
	public String deleteBook( @RequestParam("bno") int bno)
	{
			bookservice.deleteBook(bno);
			return "Book Deleted Successfully";
	}
	
	@GetMapping("/getBook")
	public Book getBook( @RequestParam("bno") int bno)
	{
			return bookservice.getBook(bno);
			
	}
	
	@GetMapping("/getAllBooks")
	public List<Book> getAllBooks()
	{
			return bookservice.getAllBooks();
			
	}
	
	@PutMapping("/updateBook")
	public String updateBook(@RequestParam("bno")  int bno,
			   				 @RequestBody Book newBook)
	{
	bookservice.updateBook(bno,newBook);
	return "Book Updated Successfully";
	}
}
