package silly.chemthunder.ozone.impl.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.entity.Attackable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import silly.chemthunder.ozone.api.thingies.CustomDeathSourceItem;
import silly.chemthunder.ozone.api.thingies.CustomKillEffectItem;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity implements Attackable {
    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "tryUseTotem", at = @At("HEAD"))
    private void ozone$killEffectItem(DamageSource source, CallbackInfoReturnable<Boolean> cir) {
        Entity player = source.getAttacker();
        LivingEntity living = (LivingEntity)(Object)this;
        if (player instanceof PlayerEntity player1) {
            Hand hand = player1.getActiveHand();
            ItemStack stack = player1.getStackInHand(hand);

            if (stack.getItem() instanceof CustomKillEffectItem customKillEffectItem) {
                customKillEffectItem.getKillEffect(this.getWorld(), player1, living, stack);
            }
        }
    }

    @WrapOperation(method = "damage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;applyDamage(Lnet/minecraft/entity/damage/DamageSource;F)V"))
    private void ozone$customKillSource(LivingEntity instance, DamageSource source, float amount, Operation<Void> original) {
        if (source.getAttacker() instanceof LivingEntity living && living.getMainHandStack().getItem() instanceof CustomDeathSourceItem deathSource) {
            original.call(instance, deathSource.getKillSource(instance), amount);
        } else {
            original.call(instance, source, amount);
        }
    }
}
