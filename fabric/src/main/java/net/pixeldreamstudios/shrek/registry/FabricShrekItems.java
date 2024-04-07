package net.pixeldreamstudios.shrek.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.pixeldreamstudios.shrek.Shrek;

import java.util.LinkedList;
import java.util.List;

public record FabricShrekItems() {
    public static List<Item> ITEMS = new LinkedList<>();

    public static Item ONION;

    static <T extends Item> T item(String id, T c) {
        Registry.register(BuiltInRegistries.ITEM, Shrek.modResource(id), c);
        return c;
    }

    public static void init() {
        ONION = item("onion", new Item(new FabricItemSettings().food(new FoodProperties.Builder().nutrition(6).saturationMod(0.8f).build())));
    }
}