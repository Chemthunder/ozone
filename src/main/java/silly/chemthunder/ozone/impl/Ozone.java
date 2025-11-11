package silly.chemthunder.ozone.impl;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import silly.chemthunder.ozone.impl.index.OzoneItems;

public class Ozone implements ModInitializer {
	public static final String MOD_ID = "ozone";

    public static Identifier id (String path){
        return Identifier.of(MOD_ID, path); }
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
            OzoneItems.initialize();
        }

		LOGGER.info("Hello Fabric world!");
	}
}