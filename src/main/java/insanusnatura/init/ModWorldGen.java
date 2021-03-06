package insanusnatura.init;

import insanusnatura.world.WorldProviderInsanusNatura;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

import javax.annotation.Nullable;

public class ModWorldGen {
    public static final String INSANUSNATURA_NAME = "insanusnatura";
    public static final int INSANUSNATURA_DIM_ID = findFreeDimensionID();
    public static final DimensionType INSANUSNATURA_DIM_TYPE = DimensionType.register(INSANUSNATURA_NAME,
            "_" + INSANUSNATURA_NAME,
            INSANUSNATURA_DIM_ID,
            WorldProviderInsanusNatura.class,
            true);

    public static void registerDimensions()
    {
        DimensionManager.registerDimension(INSANUSNATURA_DIM_ID, INSANUSNATURA_DIM_TYPE);
    }

    @Nullable
    private static Integer findFreeDimensionID()
    {
        for (int i=2; i<Integer.MAX_VALUE; i++)
        {
            if (!DimensionManager.isDimensionRegistered(i))
            {
                // DEBUG
                System.out.println("Found free dimension ID = "+i);
                return i;
            }
        }

        // DEBUG
        System.out.println("ERROR: Could not find free dimension ID");
        return null;
    }
}
