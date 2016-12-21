package com.codurance.tesco.mockito;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.codurance.tesco.mockito.HasIsbnMatcher.hasIsbn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HamcrestTest {

    @Test
    public void playWithHamcrest() {
        boolean actual = true;
        boolean expected = true;

        assertEquals(actual, expected);
        assertTrue(actual);
        org.junit.Assert.assertThat(actual, is(equalTo(expected)));

        assertThat(actual, is(expected));
        assertThat(actual, equalTo(expected));
        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void libraryMatchers() {
        String emptyString = "";
        String nullString = null;
        String notEmptyString = "I'm not empty";

        assertThat(emptyString, isEmptyString());
        assertThat(nullString, isEmptyOrNullString());
        assertThat(notEmptyString, not(isEmptyOrNullString()));
    }

    @Test
    public void testingHamcrest() {
        List<Integer> integers = Arrays.asList(1, 2, 3);
        Double[] doubles = new Double[]{1.0, 2.0, 3.0};

        assertThat(integers, contains(1, 2, 3));
        assertThat(integers, containsInAnyOrder(2, 3, 1));
        assertThat(integers, everyItem(greaterThan(0)));

        assertThat(integers, allOf(
                contains(1, 2, 3),
                containsInAnyOrder(2, 3, 1),
                everyItem(greaterThan(0))
        ));

        assertThat(doubles, arrayWithSize(3));
        assertThat(doubles, arrayContaining(1.0, 2.0, 3.0));
        assertThat(doubles, arrayContainingInAnyOrder(2.0, 3.0, 1.0));
        assertThat(Arrays.asList(doubles), everyItem(greaterThanOrEqualTo(1.0)));
    }

    @Test
    public void customMatchers() {
        Book book = new Book(1L, "isbn", "title");

        assertThat(book, hasProperty("isbn", is(equalTo("isbn"))));
        assertThat(book, hasIsbn("isbn2"));
    }

}
