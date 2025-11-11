package silly.chemthunder.ozone.impl.index;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import silly.chemthunder.ozone.impl.Ozone;

public interface OzoneDamageSources {
    RegistryKey<DamageType> CUSTOM_KILL = of("custom_kill");

    static DamageSource custom_kill(LivingEntity entity) {
        return entity.getDamageSources().create(CUSTOM_KILL); }

    private static RegistryKey<DamageType> of(String name) {
        return RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Ozone.id(name));
    }
}
