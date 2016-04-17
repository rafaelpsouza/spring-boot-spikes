package br.eng.rafaelpsouza.contract.v1;

import java.math.BigDecimal;
import java.util.List;


public interface ExampleServiceContract<T> {

	public List<Item> list();

	public Item get(Long id);

	public T delete(Long id);

	public T create(Item item);
	
        public T update(Long id, String barCode, String description, BigDecimal price);
        
}
