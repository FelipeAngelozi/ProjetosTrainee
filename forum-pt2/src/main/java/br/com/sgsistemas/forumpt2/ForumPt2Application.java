package br.com.sgsistemas.forumpt2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport //Habilitará no Spring a opção para conseguir pegar os parametros de paginação da requisição
@EnableCaching
public class ForumPt2Application {

	public static void main(String[] args) {
		SpringApplication.run(ForumPt2Application.class, args);
	}

}
