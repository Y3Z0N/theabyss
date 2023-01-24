
  
package net.yezon.theabyss.init;

import net.yezon.theabyss.client.model.Modelzombie1;
import net.yezon.theabyss.client.model.Modelwhale;
import net.yezon.theabyss.client.model.Modelsoul_lizard;
import net.yezon.theabyss.client.model.Modelslime_spider;
import net.yezon.theabyss.client.model.Modelskeleton_abyss;
import net.yezon.theabyss.client.model.Modelscorpion;
import net.yezon.theabyss.client.model.Modelmagician;
import net.yezon.theabyss.client.model.Modelhylia_fox;
import net.yezon.theabyss.client.model.Modelglow_pug;
import net.yezon.theabyss.client.model.Modelfrost_spider;
import net.yezon.theabyss.client.model.Modelfish3;
import net.yezon.theabyss.client.model.Modelfish2;
import net.yezon.theabyss.client.model.Modelfish1;
import net.yezon.theabyss.client.model.Modelelder_entity;
import net.yezon.theabyss.client.model.Modeldeer;
import net.yezon.theabyss.client.model.Modelcrystal_golem_big;
import net.yezon.theabyss.client.model.Modelbrain;
import net.yezon.theabyss.client.model.Modelancient_seeker;
import net.yezon.theabyss.client.model.Modelabyssal_lion;
import net.yezon.theabyss.client.model.Modelabyss_wolf;
import net.yezon.theabyss.client.model.Modelabyss_raptor;
import net.yezon.theabyss.client.model.Modelabyss_lurker;
import net.yezon.theabyss.client.model.Modelabysaurus_rex;
import net.yezon.theabyss.client.model.ModelRokaEntityModel;
import net.yezon.theabyss.client.model.ModelPhantom;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class TheabyssModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelfish3.LAYER_LOCATION, Modelfish3::createBodyLayer);
		event.registerLayerDefinition(ModelRokaEntityModel.LAYER_LOCATION, ModelRokaEntityModel::createBodyLayer);
		event.registerLayerDefinition(Modelcrystal_golem_big.LAYER_LOCATION, Modelcrystal_golem_big::createBodyLayer);
		event.registerLayerDefinition(Modelsoul_lizard.LAYER_LOCATION, Modelsoul_lizard::createBodyLayer);
		event.registerLayerDefinition(Modelelder_entity.LAYER_LOCATION, Modelelder_entity::createBodyLayer);
		event.registerLayerDefinition(Modelbrain.LAYER_LOCATION, Modelbrain::createBodyLayer);
		event.registerLayerDefinition(Modeldeer.LAYER_LOCATION, Modeldeer::createBodyLayer);
		event.registerLayerDefinition(Modelabyss_lurker.LAYER_LOCATION, Modelabyss_lurker::createBodyLayer);
		event.registerLayerDefinition(Modelwhale.LAYER_LOCATION, Modelwhale::createBodyLayer);
		event.registerLayerDefinition(Modelmagician.LAYER_LOCATION, Modelmagician::createBodyLayer);
		event.registerLayerDefinition(Modelskeleton_abyss.LAYER_LOCATION, Modelskeleton_abyss::createBodyLayer);
		event.registerLayerDefinition(Modelhylia_fox.LAYER_LOCATION, Modelhylia_fox::createBodyLayer);
		event.registerLayerDefinition(Modelabyss_raptor.LAYER_LOCATION, Modelabyss_raptor::createBodyLayer);
		event.registerLayerDefinition(Modelancient_seeker.LAYER_LOCATION, Modelancient_seeker::createBodyLayer);
		event.registerLayerDefinition(Modelscorpion.LAYER_LOCATION, Modelscorpion::createBodyLayer);
		event.registerLayerDefinition(Modelabyss_wolf.LAYER_LOCATION, Modelabyss_wolf::createBodyLayer);
		event.registerLayerDefinition(Modelfish2.LAYER_LOCATION, Modelfish2::createBodyLayer);
		event.registerLayerDefinition(ModelPhantom.LAYER_LOCATION, ModelPhantom::createBodyLayer);
		event.registerLayerDefinition(Modelabyssal_lion.LAYER_LOCATION, Modelabyssal_lion::createBodyLayer);
		event.registerLayerDefinition(Modelfrost_spider.LAYER_LOCATION, Modelfrost_spider::createBodyLayer);
		event.registerLayerDefinition(Modelglow_pug.LAYER_LOCATION, Modelglow_pug::createBodyLayer);
		event.registerLayerDefinition(Modelzombie1.LAYER_LOCATION, Modelzombie1::createBodyLayer);
		event.registerLayerDefinition(Modelabysaurus_rex.LAYER_LOCATION, Modelabysaurus_rex::createBodyLayer);
		event.registerLayerDefinition(Modelslime_spider.LAYER_LOCATION, Modelslime_spider::createBodyLayer);
		event.registerLayerDefinition(Modelfish1.LAYER_LOCATION, Modelfish1::createBodyLayer);
	}
}
