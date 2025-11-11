package silly.chemthunder.ozone.impl.util;

import net.minecraft.text.Style;
import net.minecraft.text.Text;

import java.util.List;

public class TextUtils {
     /**
     * Takes a text and returns the same text but with the given int color.
     */
    public static Text withColor(Text text, int color) {
        Style style = text.getStyle().withColor(color);
        List<Text> styled = text.getWithStyle(style);
        if (!styled.isEmpty()) {
            return styled.get(0);
        }
        return text;
    }
}
