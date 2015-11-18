package galaxymod.proxies;

import galaxymod.mobs.entities.EntityGrayAlien;
import galaxymod.mobs.entities.EntityMoolus;
import galaxymod.mobs.entities.EntityOinkus;
import galaxymod.mobs.models.ModelGrayAlien;
import galaxymod.mobs.models.ModelMoolus;
import galaxymod.mobs.models.ModelOinkus;
import galaxymod.mobs.renders.RenderGrayAlien;
import galaxymod.mobs.renders.RenderMoolus;
import galaxymod.mobs.renders.RenderOinkus;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void initRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityGrayAlien.class,
				new RenderGrayAlien(new ModelGrayAlien(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityMoolus.class,
				new RenderMoolus(new ModelMoolus(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityOinkus.class,
				new RenderOinkus(new ModelOinkus(), 0.5F));
	}
}