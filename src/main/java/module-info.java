module BookstoreApp {
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
    requires spring.jdbc;


    opens br.com.alura.app.bookstore to org.hibernate.orm.core, spring.core, spring.beans, spring.context, spring.boot, javafx.fxml, javafx.controls, java.sql, jakarta.persistence;
    exports br.com.alura.app.bookstore;
    opens br.com.alura.app.bookstore.controller to javafx.fxml, spring.core;
    exports br.com.alura.app.bookstore.controller;
    opens br.com.alura.app.bookstore.service to spring.core, spring.beans, spring.context, spring.boot, jakarta.persistence;
    exports br.com.alura.app.bookstore.service;
    opens br.com.alura.app.bookstore.model to org.hibernate.orm.core, spring.core, spring.beans, spring.context, spring.boot, jakarta.persistence;
    exports br.com.alura.app.bookstore.model;
    opens br.com.alura.app.bookstore.repository to spring.core, spring.beans, spring.context, spring.boot, jakarta.persistence;
    exports br.com.alura.app.bookstore.repository;
    exports br.com.alura.app.bookstore.Table;
    opens br.com.alura.app.bookstore.Table to jakarta.persistence, org.hibernate.orm.core, spring.beans, spring.boot, spring.context, spring.core;


}


