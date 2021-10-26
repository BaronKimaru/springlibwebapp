package com.bizzinali.springbootwebapp.controllers;

import com.bizzinali.springbootwebapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    /*
    * @Contoller tells Spring to treat this as such.
    * We bring in the model as this a Model-View-Controller pattern
    * Create a method with model as the argument & have a route before it via @requestMapping and return a view
     */

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String fetchBooks(Model model){
        model.addAttribute("books", bookRepository.findAll());

        return "books/list";
    }


}
