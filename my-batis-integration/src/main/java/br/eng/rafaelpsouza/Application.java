package br.eng.rafaelpsouza;

import java.io.IOException;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import br.eng.rafaelpsouza.persistence.Item;
import br.eng.rafaelpsouza.persistence.ItemMapper;

/**
 *
 * @author Rafael Souza
 */
@EnableAutoConfiguration
@ComponentScan
public class Application implements CommandLineRunner{

	@Autowired
	ItemMapper itemMapper;
	
	@Override
	public void run(String... args) throws Exception {
		Item createdItem = new Item("333-333-333-333", "Item nro 3", new BigDecimal(2.09));
		itemMapper.create(createdItem);
		System.out.println("Created id: "+createdItem.getId());
		itemMapper.create(new Item("444-444-444-444", "Item nro 4", new BigDecimal(4.70)));
		itemMapper.create(new Item("555-555-555-555", "Item nro 5", new BigDecimal(110.0)));
		itemMapper.create(new Item("666-666-666-666", "Item nro 6", new BigDecimal(20.0)));
				
		itemMapper.listAll().forEach(item -> System.out.println(item));
		System.out.println("Get by id(1): "+itemMapper.getById(1L));
		
	}
	
	//http://mybatis.github.io/spring/
    public static void main(String[] args) throws IOException {
        SpringApplication.run(Application.class, args);
    }
	

}