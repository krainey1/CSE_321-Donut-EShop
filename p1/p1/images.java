package p1;

import java.util.HashMap;
import java.util.Map;

public class images {
    private static final Map<Integer, String> donutImageMap = new HashMap<>();

    static {
        // Map donut IDs to image names
        donutImageMap.put(1, "glazeddonut.webp");
        donutImageMap.put(2, "sugardonut.webp");
        donutImageMap.put(3, "chocolatedonut.webp");
        donutImageMap.put(4, "plaindonut.jpg");
        donutImageMap.put(5, "chocolatecakedonut.jpg");
        donutImageMap.put(6, "sugarcakedonut.jpg");
        donutImageMap.put(7, "lemondonut.webp");
        donutImageMap.put(8, "grapedonut.jpg");
        donutImageMap.put(9, "custarddonut.webp");
    }

    public static String getImagePath(int donutID) {
        // Use the map's getOrDefault method to fetch the image name or "default.jpg"
        return "images/" + donutImageMap.getOrDefault(donutID, "default.jpg");
    }
}
