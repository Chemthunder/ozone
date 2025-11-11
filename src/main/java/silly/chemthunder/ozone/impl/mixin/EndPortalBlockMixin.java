package silly.chemthunder.ozone.impl.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.EndPortalBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import silly.chemthunder.ozone.impl.util.OzoneConfig;

@Mixin(EndPortalBlock.class)
public abstract class EndPortalBlockMixin extends BlockWithEntity {
    protected EndPortalBlockMixin(Settings settings) {
        super(settings);
    }

    @Inject(method = "onEntityCollision", at = @At("HEAD"), cancellable = true)
    private void ozone$disableEndPortals(BlockState state, World world, BlockPos pos, Entity entity, CallbackInfo ci) {
        if (OzoneConfig.disableEndPortals) {
            if (entity instanceof LivingEntity livingEntity) {
                livingEntity.setVelocity(0,0.5,0);
            }
            ci.cancel();
        }
    }
}
