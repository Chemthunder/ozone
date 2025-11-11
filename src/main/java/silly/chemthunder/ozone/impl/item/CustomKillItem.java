package silly.chemthunder.ozone.impl.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import silly.chemthunder.ozone.api.thingies.CustomDeathSourceItem;
import silly.chemthunder.ozone.api.thingies.CustomKillEffectItem;
import silly.chemthunder.ozone.impl.index.OzoneDamageSources;

public class CustomKillItem extends Item implements CustomKillEffectItem, CustomDeathSourceItem {
    public CustomKillItem(Settings settings) {
        super(settings);
    }

    @Override
    public void getKillEffect(World world, PlayerEntity you, LivingEntity victim, ItemStack stack) {
        you.setVelocity(0, 5, 0);
        you.velocityModified = true;
    }

    @Override
    public DamageSource getKillSource(LivingEntity target) {
        return OzoneDamageSources.custom_kill(target);
    }
}
