package galaxymod.proxies;

import galaxymod.mobs.entities.EntityGrayAlien;
import galaxymod.mobs.entities.EntityMoolus;
import galaxymod.mobs.models.ModelGrayAlien;
import galaxymod.mobs.models.ModelMoolus;
import galaxymod.mobs.renderers.RenderGrayAlien;
import galaxymod.mobs.renderers.RenderMoolus;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void initRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityMoolus.class,
				new RenderMoolus(new ModelMoolus(), 0.5F));

		RenderingRegistry.registerEntityRenderingHandler(EntityGrayAlien.class,
				new RenderGrayAlien(new ModelGrayAlien(), 0.5F));
	}
}