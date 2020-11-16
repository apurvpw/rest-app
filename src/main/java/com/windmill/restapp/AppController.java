package com.windmill.restapp;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Validated
@RestController
@RequestMapping("/api/v1")
public class AppController {

    @PostMapping("/find-longest-string")
    public String findLongestString( @RequestBody @Valid List<String> inputStrings) {
        Optional<String> longestStringOptional = inputStrings.stream().max(Comparator.comparingInt(String::length));
        return longestStringOptional.isPresent()?longestStringOptional.get():"";
    }

    @DeleteMapping("/filter-strings")
    public List<String> filterStrings( @RequestBody List<String> inputStrings) {
        List<String> filteredStringList = inputStrings.stream().filter(str->str.length()<=10).collect(Collectors.toList());
        return filteredStringList;
    }
}
