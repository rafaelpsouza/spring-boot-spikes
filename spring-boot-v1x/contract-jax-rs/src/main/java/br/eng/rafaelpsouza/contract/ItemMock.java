package br.eng.rafaelpsouza.contract;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class ItemMock {
	
	private static List<Item> items = new ArrayList<>();
	private static AtomicLong lastId = new AtomicLong(5L);
	
	static{
		items.add(new Item(1L, "111-111-111-111", "Item nro 1", new BigDecimal(110.0)));
		items.add(new Item(2L, "222-222-222-222", "Item nro 2", new BigDecimal(20.0)));
		items.add(new Item(3L, "333-333-333-333", "Item nro 3", new BigDecimal(2.09)));
		items.add(new Item(4L, "444-444-444-444", "Item nro 4", new BigDecimal(4.70)));		
	}
	
	
	public static Item getById(Long id){
		return items.stream().filter(item -> item.getId() == id).findFirst().get();
	}
	
	public static List<Item> listAll(){
		return items;
	}
	
	public static void delete(Long id){
		items.remove(getById(id));
	}
	
	public static void add(Item item){
		item.setId(lastId.getAndIncrement());
		items.add(item);
	}
	
	public static void update(Long id, String barCode, String description, BigDecimal price){
		Item item = getById(id);
		item.setBarCode(barCode);
		item.setDescription(description);
		item.setPrice(price);
	}

}
