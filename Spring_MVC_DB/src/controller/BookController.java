package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import repository.BookDao;
import vo.BookVO;

@Controller
public class BookController {
	@Autowired
	private BookDao dao;
	
	@RequestMapping(value="/bookList.do", method=RequestMethod.GET)
	public String booklist(Model model){
		List<BookVO> bookList = dao.selectBookListAll();
		model.addAttribute("bookList", bookList);
		return "book_list";
	}
	
	@RequestMapping(value="/addForm.do", method=RequestMethod.GET)
	public String addBookForm(Model model){
		
		return "add_book_form";
	}
	
	@RequestMapping(value="/addBook.do", method=RequestMethod.POST)
	public String addBook(Model model, BookVO book){
		int result = dao.insertBook(book);
		model.addAttribute("addResult", result);
		return "add_result";
	}
	
	@RequestMapping(value="/updateForm.do", method=RequestMethod.GET)
	public String updateBookForm(Model model){
		List<BookVO> bookList = dao.selectBookListAll();
		model.addAttribute("bookList", bookList);
		return "update_book_form";
	}
	
	@RequestMapping(value="/updateBook.do", method=RequestMethod.GET)
	public String updateBook(Model model, BookVO book){
		int result = dao.updateBook(book);
		model.addAttribute("updateResult", result);
		return "update_result";
	}
	
	@RequestMapping(value="/deleteForm.do", method=RequestMethod.GET)
	public String deleteBookForm(Model model){
		List<BookVO> bookList = dao.selectBookListAll();
		model.addAttribute("bookList", bookList);
		return "delete_book_form";
	}
	
	@RequestMapping(value="/deleteBook.do", method=RequestMethod.GET)
	public String deleteBook(Model model, BookVO book){
		int result = dao.deleteBook(book);
		model.addAttribute("deleteResult", result);
		return "delete_result";
	}
}
