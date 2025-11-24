package silly.chemthunder.ozone.impl.item;

import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import silly.chemthunder.ozone.api.thingies.CustomBipedEntityModelPoseItem;
import silly.chemthunder.ozone.api.thingies.CustomCritEffectItem;

public class TestItem extends Item implements CustomBipedEntityModelPoseItem, CustomCritEffectItem {
    public TestItem(Settings settings) {
        super(settings);
    }

    @Override
    public BipedEntityModel.ArmPose getArmPose(ItemStack stack, PlayerEntity player) {
        return BipedEntityModel.ArmPose.CROSSBOW_HOLD;
    }

    @Override
    public void critEffect(ItemStack stack, World world, LivingEntity attacker, LivingEntity victim) {
        attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 600));
        victim.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 600));
    }

    @Override
    public Text getName(ItemStack stack) {
        return super.getName(stack).copy().styled(style -> style.withColor(0xeb4034));
    }
}
