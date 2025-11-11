package silly.chemthunder.ozone.api.thingies;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface CustomKillEffectItem {
    void getKillEffect(World world, PlayerEntity you, LivingEntity victim, ItemStack stack);
}
