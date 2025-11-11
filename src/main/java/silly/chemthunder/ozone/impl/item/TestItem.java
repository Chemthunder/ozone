package silly.chemthunder.ozone.impl.item;

import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import silly.chemthunder.ozone.api.item.CustomBipedEntityModelPoseItem;
import silly.chemthunder.ozone.api.item.CustomCritEffectItem;

public class TestItem extends Item implements CustomBipedEntityModelPoseItem, CustomCritEffectItem {
    public TestItem(Settings settings) {
        super(settings);
    }

    @Override
    public BipedEntityModel.ArmPose getArmPose(ItemStack stack, PlayerEntity player) {
        return BipedEntityModel.ArmPose.CROSSBOW_HOLD;
    }

    @Override
    public void critEffect(ItemStack stack, World world, LivingEntity player) {
        player.setVelocity(0, 100, 0);
    }


}
