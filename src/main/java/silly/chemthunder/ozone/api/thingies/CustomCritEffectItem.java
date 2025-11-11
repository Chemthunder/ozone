package silly.chemthunder.ozone.api.thingies;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface CustomCritEffectItem {
    void critEffect(ItemStack stack, World world, LivingEntity attacker, LivingEntity victim);
}
