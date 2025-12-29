package kureikama.kaytew.lilfurrycreatures;

import java.util.function.Function;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModBlocks {
    private static Block register(
            String name,
            Function<AbstractBlock.Settings, Block> blockFactory,
            AbstractBlock.Settings settings,
            boolean shouldRegisterItem
    ) {
        // Create a registry key for the block using mod ID and block name
        RegistryKey<Block> blockKey = keyOfBlock(name);

        // Build the block with the provided settings and assign the registry key
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        // Optionally create and register a BlockItem for the block
        if (shouldRegisterItem) {
            // Generate a registry key for the item using the same name
            RegistryKey<Item> itemKey = keyOfItem(name);

            // Create a new BlockItem linked to the block with its own registry key
            BlockItem blockItem = new BlockItem(
                    block,
                    new Item.Settings().registryKey(itemKey)
                            .useBlockPrefixedTranslationKey()
            );

            // Register the item with the item registry
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        // Register the item with Minecraft's block registry.
        Registry.register(Registries.BLOCK, blockKey, block);

        return block;
    }

    // Build a block registry key using the mod ID and name
    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(
                RegistryKeys.BLOCK,
                Identifier.of(FurryLilCreatures.MOD_ID, name)
        );
    }

    // Build an item registry key using the mod ID and name
    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(
                RegistryKeys.ITEM,
                Identifier.of(FurryLilCreatures.MOD_ID, name)
        );
    }

    public static void initialize() {
// called for block registration during mod initialization
    }

    // define and register block
    public static final Block NESTING_FLOOR = register(
            "nesting_floor",
            Block::new,
            AbstractBlock.Settings.create(),
            true // register an item version of it
    );
}
