package com.fs.tulingsql.dto;

import com.fs.tulingsql.entity.Author;
import com.fs.tulingsql.entity.Book;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
@Data
@EqualsAndHashCode(callSuper = false)
public class AuthorBookDto extends Author {

    private List<Book> books;

}
