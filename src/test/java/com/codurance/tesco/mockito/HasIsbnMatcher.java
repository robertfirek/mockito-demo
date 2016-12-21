package com.codurance.tesco.mockito;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;

public class HasIsbnMatcher extends TypeSafeMatcher<Book> {

    private final String expectedIsbn;

    public HasIsbnMatcher(String expectedIsbn) {
        this.expectedIsbn = expectedIsbn;
    }

    @Factory
    public static HasIsbnMatcher hasIsbn(String expectedIsbn) {
        return new HasIsbnMatcher(expectedIsbn);
    }

    @Override
    protected boolean matchesSafely(Book item) {
        return item.getIsbn().equals(expectedIsbn);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Expected ISBN is ").appendValue(expectedIsbn);
    }

    @Override
    protected void describeMismatchSafely(Book book, Description mismatchDescription) {
        mismatchDescription.appendText("was ").appendValue(book.getIsbn());
    }
}
