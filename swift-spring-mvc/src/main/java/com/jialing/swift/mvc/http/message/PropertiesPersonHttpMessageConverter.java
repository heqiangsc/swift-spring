package com.jialing.swift.mvc.http.message;

import com.jialing.swift.mvc.entity.Person;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Properties;

public class PropertiesPersonHttpMessageConverter extends AbstractHttpMessageConverter<Person> {


    public PropertiesPersonHttpMessageConverter() {
        super(MediaType.valueOf("application/properties+person"));
        setDefaultCharset(Charset.forName("UTF-8"));
    }

    @Override
    protected boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(Person.class);
    }

    @Override
    protected Person readInternal(Class<? extends Person> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        InputStream inputStream = httpInputMessage.getBody();
        Properties properties = new Properties();
        properties.load(new InputStreamReader(inputStream,getDefaultCharset()));
        Person p = new Person();
        p.setId(Integer.valueOf(properties.getProperty("person.id")));
        p.setName(properties.getProperty("person.name"));
        return p;
    }

    @Override
    protected void writeInternal(Person person, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        OutputStream outputStream = httpOutputMessage.getBody();
        Properties properties = new Properties();
        properties.setProperty("person.id", person.getId() + "");
        properties.setProperty("person.name", person.getName());
        properties.store(new OutputStreamWriter(outputStream, getDefaultCharset()), "Written by web server");

    }
}
