package kureikama.kaytew.lilfurrycreatures.items;

import kureikama.kaytew.lilfurrycreatures.FurryLilCreatures;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class Ball {

    public static Item register(
            String name,
            Function<Item.Settings, Item> itemFactory,
            Item.Settings settings
    ) {
        // Create a unique registry key for this item.
        RegistryKey<Item> itemKey = RegistryKey.of(
                RegistryKeys.ITEM,
                Identifier.of(FurryLilCreatures.MOD_ID, name)
        );

        // Create the item instance using the provided factory and settings.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item with Minecraft's item registry.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }
    public static void initialize() {
        // Called from the main mod class to register items
    }

    public static final Item BALL = register(
            "ball",
            Item::new,
            new Item.Settings()
    );

}