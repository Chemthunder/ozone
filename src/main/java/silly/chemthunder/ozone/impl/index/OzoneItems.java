package silly.chemthunder.ozone.impl.index;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import silly.chemthunder.ozone.impl.Ozone;
import silly.chemthunder.ozone.impl.item.CustomKillItem;
import silly.chemthunder.ozone.impl.item.TestItem;

import java.util.LinkedHashMap;
import java.util.Map;

public interface OzoneItems {
    Map<Item, Identifier> ITEMS = new LinkedHashMap<>();

    //  Item WEAPON_RACK = create("weapon_rack", new WeaponRackItem(new Item.Settings()));

    Item TEST_ITEM = create("test_item", new TestItem(new Item.Settings()
            .maxCount(1)
            .fireproof()
    ));

    Item CUSTOM_KILL_ITEM = create("custom_kill_item", new CustomKillItem(new Item.Settings()
            .maxCount(1)
            .fireproof()
    ));

    static <T extends Item> T create(String name, T item) {
        ITEMS.put(item, Ozone.id(name));
        return item;
    }

    static void initialize() {
        ITEMS.forEach((item, id) -> Registry.register(Registries.ITEM, id, item));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(OzoneItems::addCombatEntries);
    }

    private static void addCombatEntries(FabricItemGroupEntries fabricItemGroupEntries) {
        fabricItemGroupEntries.add(TEST_ITEM);
        fabricItemGroupEntries.add(CUSTOM_KILL_ITEM);
    }
}
