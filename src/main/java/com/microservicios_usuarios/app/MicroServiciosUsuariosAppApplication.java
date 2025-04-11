package com.microservicios_usuarios.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.commons.models.entity"})
public class MicroServiciosUsuariosAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiciosUsuariosAppApplication.class, args);
	}

}
