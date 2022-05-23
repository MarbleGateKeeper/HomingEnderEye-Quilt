package love.marblegate.homingendereye;

import love.marblegate.homingendereye.misc.*;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class HomingEnderEye implements ModInitializer {

    public static EyeCache EYE_THROW_CACHE;


    @Override
    public void onInitialize(ModContainer mod) {
        ServerLifecycleEvents.SERVER_STARTING.register((server -> {
            if(HomingEnderEye.EYE_THROW_CACHE == null){
                HomingEnderEye.EYE_THROW_CACHE = new EyeCache();
            }
        }));

        AutoConfig.register(ModConfiguration.class, JanksonConfigSerializer::new);
    }
}
