package com.nikita.springwebexample9.document;

import io.r2dbc.spi.Row;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

public abstract class DoctorReadConverter implements Converter<Row,Doctor> {
    /*
    @Override
    public Doctor convert(Row source) {
        Patient patient = Patient.builder()
                .name(source.get("name", String.class))
                .id(source.get("id", Integer.class))
                .age(source.get("age",Integer.class))
                .build();
        return Doctor.builder()
                .did(source.get("did", Integer.class))
                .dname(source.get("dname",String.class))
                .specs(source.get("specs",String.class))
                .pid(patient)
                .build();
    }*/
}
