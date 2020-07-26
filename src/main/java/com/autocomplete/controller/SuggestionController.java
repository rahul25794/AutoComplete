package com.autocomplete.controller;

import java.util.List;

import com.autocomplete.generated.jooq.tables.pojos.Country;
import com.autocomplete.repository.CountriesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Validated
public class SuggestionController {
    @Autowired
    public CountriesRepository repo;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/suggest")
    @ResponseBody
    public List<Country> suggest(@RequestParam(required = true) String term) {
        return repo.getSuggestions(term, 10);
    }
}