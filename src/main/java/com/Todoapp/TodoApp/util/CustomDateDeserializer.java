package com.Todoapp.TodoApp.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CustomDateDeserializer extends JsonDeserializer<Date> {

    private static final SimpleDateFormat[] dateFormats = {
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.US), // Example ISO format
            new SimpleDateFormat("yyyy-MM-dd", Locale.US) // Example date format
    };

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
        String dateString = jsonParser.getText();
        for (SimpleDateFormat format : dateFormats) {
            try {
                return format.parse(dateString);
            } catch (ParseException e) {
                // Ignore and try the next format
            }
        }
        throw new IOException("Failed to parse Date value: " + dateString);
    }
}
