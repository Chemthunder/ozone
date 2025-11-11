package silly.chemthunder.ozone.impl.item;

import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import silly.chemthunder.ozone.api.item.CustomBipedEntityModelPoseItem;

public class TestItem extends Item implements CustomBipedEntityModelPoseItem {
    public TestItem(Settings settings) {
        super(settings);
    }

    @Override
    public BipedEntityModel.ArmPose getArmPose(ItemStack stack, PlayerEntity player) {
        return BipedEntityModel.ArmPose.CROSSBOW_HOLD;
    }
}
