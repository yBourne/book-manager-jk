package com.ybourne.bookmanagerjk.controller;

import com.ybourne.bookmanagerjk.dao.UserDAO;
import com.ybourne.bookmanagerjk.model.User;
import com.ybourne.bookmanagerjk.service.BookService;
import com.ybourne.bookmanagerjk.service.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(path = "/index", method={RequestMethod.GET})
    public String bookList(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        Object host = session.getAttribute("host");
        if (host != null){
            model.addAttribute("host", host);
        }
        loadAllBooksView(model);
        return "book/books";
    }

    public void loadAllBooksView(Model model){
        model.addAttribute("books", bookService.getAllBooks());
    }
}
