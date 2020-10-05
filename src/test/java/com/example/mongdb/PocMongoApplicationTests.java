package com.example.mongdb;

import com.example.mongdb.model.Usuario;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PocMongoApplicationTests {

    @Test
    void test(@Autowired MongoTemplate template) {

        DBObject dbObject = BasicDBObjectBuilder.start()
                .add("key", "value")
                .get();

        template.save(dbObject, "collection");

        assertThat(template.findAll(DBObject.class, "collection")).extracting("key")
                .containsOnly("value");
    }

    @Test
    void testUsuario(@Autowired MongoTemplate mongoTemplate){

        Usuario usuario = Usuario.builder().id(123L).nome("Teste").build();

        mongoTemplate.save(usuario, "Usuario");

        assertThat(mongoTemplate.findAll(Usuario.class, "Usuario")).extracting("nome")
                .containsOnly("Teste");

    }
}
