package insanusnatura;

import insanusnatura.proxy.CommonProxy;
import insanusnatura.util.Reference;
import insanusnatura.util.handlers.RegistryHandler;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(   modid = Reference.MOD_ID,
        name = Reference.NAME,
        version = Reference.VERSION,
        acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)
public class Main {
    @Mod.Instance
    public static Main instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        RegistryHandler.preInitRegistries();
        RegistryHandler.otherRegistries();
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event) {
        RegistryHandler.initRegistries();
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event) {
        RegistryHandler.postInitRegistries();
    }

    @Mod.EventHandler
    public static void serverInit(FMLServerStartingEvent event){RegistryHandler.serverRegistries(event);}
}