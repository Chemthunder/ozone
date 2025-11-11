package silly.chemthunder.ozone.api.thingies;

import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public interface CustomBipedEntityModelPoseItem {
    BipedEntityModel.ArmPose getArmPose(ItemStack stack, PlayerEntity player);
}
