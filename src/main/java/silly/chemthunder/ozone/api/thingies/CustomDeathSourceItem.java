package silly.chemthunder.ozone.api.thingies;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;

public interface CustomDeathSourceItem {
    DamageSource getKillSource(LivingEntity target);
}
