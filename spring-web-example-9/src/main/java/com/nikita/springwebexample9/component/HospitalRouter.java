package com.nikita.springwebexample9.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;

@Configuration
public class HospitalRouter {
    @Bean
    public RouterFunction<ServerResponse> root(HospitalHandler hospitalHandler) {
        return RouterFunctions.route(
                        GET("/p")
                                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), hospitalHandler::getAllPatients)
                .andRoute(GET("/p/{id}")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), hospitalHandler::getPatient)
                .andRoute(POST("/p")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), hospitalHandler::addNewPatient)
                .andRoute(PUT("/p/{id}")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), hospitalHandler::updatePatient)
                .andRoute(DELETE("/p/{id}")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), hospitalHandler::deletePatient)
                .andRoute(GET("/d")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), hospitalHandler::getAllDoctors)
                .andRoute(GET("/d/{id}")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), hospitalHandler::getDoctor)
                .andRoute(POST("/d")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), hospitalHandler::addNewDoctor)
                .andRoute(PUT("/d/{id}")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), hospitalHandler::updateDoctor)
                .andRoute(DELETE("/d/{id}")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), hospitalHandler::deleteDoctor)
                .andRoute(GET("/dname/{dname}")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), hospitalHandler::findByDName)
                .andRoute(GET("/dspecs/{specs}")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), hospitalHandler::findBySpecs)
                .andRoute(GET("/d/{specs}/{dname}")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), hospitalHandler::updateSpecs)
                .andRoute(GET("/page/{age}")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), hospitalHandler::CategoryByAge)
                .andRoute(GET("/p&d/{pid}")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), hospitalHandler::AlldetailsbyId);
    }
}
