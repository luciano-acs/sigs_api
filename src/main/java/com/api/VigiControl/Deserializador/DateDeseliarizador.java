package com.api.VigiControl.Deserializador;

import com.fasterxml.jackson.databind.util.StdConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDeseliarizador extends StdConverter<String, Date> {
        @Override
        public Date convert(String value) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            try {
                return formatter.parse(value);
            } catch (ParseException e) {
                throw new IllegalArgumentException("Fecha inválida: " + value, e);
            }
        }
}
