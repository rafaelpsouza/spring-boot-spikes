create table IF NOT EXISTS ITEM_TABLE (
  ITEM_ID serial primary key,
  ITEM_BARCODE varchar(70),
  ITEM_DESCRIPTION varchar(255),
  ITEM_PRICE decimal
);

insert into ITEM_TABLE(ITEM_BARCODE, ITEM_DESCRIPTION, ITEM_PRICE) values ('1111-1111-1111', 'item 1', 10.0);
insert into ITEM_TABLE(ITEM_BARCODE, ITEM_DESCRIPTION, ITEM_PRICE) values ('2222-2222-2222', 'item 2', 12.9);