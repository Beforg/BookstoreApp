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
    requires org.hibernate.orm.core;



    opens br.com.alura.musiscas.screensounds to org.hibernate.orm.core, spring.core, spring.beans, spring.context, spring.boot, javafx.fxml, javafx.controls, java.sql, jakarta.persistence;
    exports br.com.alura.musiscas.screensounds;
    opens br.com.alura.musiscas.screensounds.controller to javafx.fxml, spring.core;
    exports br.com.alura.musiscas.screensounds.controller;
    opens br.com.alura.musiscas.screensounds.service to spring.core, spring.beans, spring.context, spring.boot, jakarta.persistence;
    exports br.com.alura.musiscas.screensounds.service;
    opens br.com.alura.musiscas.screensounds.model to org.hibernate.orm.core, spring.core, spring.beans, spring.context, spring.boot, jakarta.persistence;
    exports br.com.alura.musiscas.screensounds.model;
    opens br.com.alura.musiscas.screensounds.repository to spring.core, spring.beans, spring.context, spring.boot, jakarta.persistence;
    exports br.com.alura.musiscas.screensounds.repository;
    exports br.com.alura.musiscas.screensounds.Table;
    opens br.com.alura.musiscas.screensounds.Table to jakarta.persistence, org.hibernate.orm.core, spring.beans, spring.boot, spring.context, spring.core;


}


