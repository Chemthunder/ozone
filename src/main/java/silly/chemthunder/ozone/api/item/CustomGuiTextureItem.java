package silly.chemthunder.ozone.api.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public interface CustomGuiTextureItem {
    Identifier getGuiTexture(ItemStack stack, PlayerEntity player);
}
