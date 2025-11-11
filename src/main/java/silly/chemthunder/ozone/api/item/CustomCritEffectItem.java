package silly.chemthunder.ozone.api.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface CustomCritEffectItem {
    void critEffect(ItemStack stack, World world, LivingEntity player);
}
