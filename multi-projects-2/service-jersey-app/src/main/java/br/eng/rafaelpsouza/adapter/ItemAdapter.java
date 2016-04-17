package br.eng.rafaelpsouza.adapter;

import java.util.List;
import java.util.stream.Collectors;

import br.eng.rafaelpsouza.contract.v1.Item;
import br.eng.rafaelpsouza.impl.ItemModel;

public class ItemAdapter {

    public Item bindFromModel(ItemModel itemModel) {
        return new Item(itemModel.getId(), itemModel.getBarCode(), itemModel.description, itemModel.getPrice());
    }

    public ItemModel bindToModel(Item item) {
        return new ItemModel(item.getId(), item.getBarCode(), item.description, item.getPrice());
    }

    public List<Item> bindFromModel(List<ItemModel> itemsModel) {
        return itemsModel.stream().map(item -> bindFromModel(item)).collect(Collectors.toList());
    }

    public List<ItemModel> bindToModel(List<Item> items) {
        return items.stream().map(item -> bindToModel(item)).collect(Collectors.toList());
    }
}
