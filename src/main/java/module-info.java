module ScreenSounds {
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.context;
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.beans;
    requires spring.core;
    requires java.net.http;
    requires java.sql;
    requires spring.data.jpa;
    requires spring.tx;
    requires jakarta.persistence;


    opens br.com.alura.musiscas.screensounds to spring.core, spring.beans, spring.context, spring.boot, javafx.fxml, javafx.controls;
    exports br.com.alura.musiscas.screensounds;
    opens br.com.alura.musiscas.screensounds.controller to javafx.fxml, spring.core;
    exports br.com.alura.musiscas.screensounds.controller;
    opens br.com.alura.musiscas.screensounds.model to spring.core;
    exports br.com.alura.musiscas.screensounds.model;
    opens br.com.alura.musiscas.screensounds.service to spring.core;
    exports br.com.alura.musiscas.screensounds.service;


}