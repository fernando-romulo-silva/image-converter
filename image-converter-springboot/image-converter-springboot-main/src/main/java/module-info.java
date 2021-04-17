module org.imageconverter.application {
	requires org.imageconverter.domain;

	// requires java.instrument;
	requires spring.boot;
	requires spring.boot.autoconfigure;
	requires spring.beans;
	requires spring.context;

	exports org.imageconverter;
	exports org.imageconverter.application;

	opens org.imageconverter to spring.core;
	opens org.imageconverter.application to spring.core;
}