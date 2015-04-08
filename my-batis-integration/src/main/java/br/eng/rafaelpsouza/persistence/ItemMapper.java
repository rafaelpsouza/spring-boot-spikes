package br.eng.rafaelpsouza.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

public interface ItemMapper {
	
	@Select(value = "select * from item_table")
	@Results(value = {
			@Result(property = "id", column="ITEM_ID"),
			@Result(property = "barCode", column="ITEM_BARCODE"),
			@Result(property = "description", column="ITEM_DESCRIPTION"),
			@Result(property = "price", column="ITEM_PRICE"),
	})
	public List<Item> listAll();
	
	@Select(value = "select * from item_table where ITEM_ID = #{id}")
	@Results(value = {
			@Result(property = "id", column="ITEM_ID"),
			@Result(property = "barCode", column="ITEM_BARCODE"),
			@Result(property = "description", column="ITEM_DESCRIPTION"),
			@Result(property = "price", column="ITEM_PRICE"),
	})
	public Item getById(Long id);
	
	@Insert(value = "insert into ITEM_TABLE(ITEM_BARCODE, ITEM_DESCRIPTION, ITEM_PRICE) values (#{barCode}, #{description}, #{price});")
	@SelectKey(statement="select nextval('item_table_item_id_seq')", keyProperty="id", before=false, resultType=Long.class)
	public int create(Item item);

}
