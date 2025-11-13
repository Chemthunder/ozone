package silly.chemthunder.ozone.impl.util;

import eu.midnightdust.lib.config.MidnightConfig;

public class OzoneConfig extends MidnightConfig {
    private static final String config = "config";

    @Entry(category = config)
    public static boolean disableEndPortals = false;
}
