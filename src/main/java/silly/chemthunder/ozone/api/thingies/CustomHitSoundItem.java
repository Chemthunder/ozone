package silly.chemthunder.ozone.api.thingies;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public interface CustomHitSoundItem {
    void getHitSound(ItemStack stack, PlayerEntity playerEntity);
}
