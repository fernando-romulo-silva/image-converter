module org.imageconverter.application {
    requires org.imageconverter.domain;

    // requires java.instrument;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.beans;
    requires spring.context;
    requires spring.core;
    requires spring.web;
    requires javax.servlet.api;

    exports org.imageconverter;
    exports org.imageconverter.application;

    opens org.imageconverter to spring.core;
    opens org.imageconverter.application to spring.core;
    
}