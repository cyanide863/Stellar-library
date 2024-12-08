package stellar;

import arc.Events;
import stellar.graphics.ExoShaders;
import mindustry.game.EventType;
import mindustry.mod.*;
import stellar.util.util.Utils;
import stellar.content.StellStatusEffects;
import stellar.content.StellWeathers;
import stellar.content.*;
import mindustry.mod.Mod;
import mindustry.mod.Mods;
import stellar.gen.*;

import static arc.Core.app;

public class
ExogenesisMod extends Mod{
    public static Mods.LoadedMod modInfo;
    public ExogenesisMod(){
        super();

        Events.on(EventType.FileTreeInitEvent.class, e ->
                app.post(StellShaders::load)
        );

        Events.on(EventType.DisposeEvent.class, e ->
                StellShaders.dispose()
        );
    }
    @Override
    public void loadContent(){
        EntityRegistry.register();
        Utils.init();
        StellStatusEffects.load();
        StellWeathers.load();
    }
}
