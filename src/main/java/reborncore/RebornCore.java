package reborncore;

import me.modmuss50.jsonDestoryer.JsonDestroyer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import reborncore.common.IModInfo;
import reborncore.common.packets.PacketHandler;
import reborncore.common.util.LogHelper;
import reborncore.common.util.OreUtil;
import reborncore.test.ItemBlockTest;
import reborncore.test.TestBlock;

@Mod(modid = RebornCore.MOD_ID, name = RebornCore.MOD_NAME, version = RebornCore.MOD_VERSION, acceptedMinecraftVersions = "[1.8.8,1.8.9]")
public class RebornCore implements IModInfo {

    public static final String MOD_NAME = "RebornCore";
    public static final String MOD_ID = "reborncore";
    public static final String MOD_VERSION = "@MODVERSION@";

    public static LogHelper logHelper;

    public static TestBlock test;

    public RebornCore() {
        logHelper = new LogHelper(this);
    }

    public static JsonDestroyer jsonDestroyer = new JsonDestroyer();

    @SidedProxy(clientSide = "reborncore.ClientProxy", serverSide = "reborncore.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        jsonDestroyer.load();
        // packets
        PacketHandler.setChannels(NetworkRegistry.INSTANCE.newChannel(
                MOD_ID + "_packets", new PacketHandler()));
        OreUtil.scanForOres();

        test = new TestBlock();
        GameRegistry.registerBlock(test, ItemBlockTest.class, "TestBlockRC");
        jsonDestroyer.registerObject(test);
        proxy.init(event);
    }

    public String MOD_NAME() {
        return MOD_NAME;
    }

    @Override
    public String MOD_ID() {
        return MOD_ID;
    }

    @Override
    public String MOD_VERSION() {
        return MOD_VERSION;
    }

    @Override
    public String MOD_DEPENDENCUIES() {
        return "";
    }
}
