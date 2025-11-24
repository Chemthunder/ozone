package silly.chemthunder.ozone.impl.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import silly.chemthunder.ozone.api.thingies.CustomCritEffectItem;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {
    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;addCritParticles(Lnet/minecraft/entity/Entity;)V"))
    private void ozone$customCritEffect(Entity target, CallbackInfo ci) {
        Hand hand = this.getActiveHand();
        ItemStack stack = this.getStackInHand(hand);
        World world = this.getWorld();
        if (target instanceof LivingEntity livingEntity) {
            if (stack.getItem() instanceof CustomCritEffectItem critEffectItem) {
                critEffectItem.critEffect(stack, world, this, livingEntity);
            }
        }
    }
}
