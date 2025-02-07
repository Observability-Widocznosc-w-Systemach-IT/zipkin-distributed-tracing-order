package com.gruzewskidev.zipkin_distributed_tracing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ZipkinDistributedTracingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinDistributedTracingApplication.class, args);
	}

}
