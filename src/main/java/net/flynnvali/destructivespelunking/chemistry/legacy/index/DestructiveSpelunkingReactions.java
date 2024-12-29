package net.flynnvali.destructivespelunking.chemistry.legacy.index;
import net.flynnvali.destructivespelunking.DestructiveSpelunking;

import com.petrolpark.destroy.Destroy;
import com.petrolpark.destroy.advancement.DestroyAdvancementTrigger;
import com.petrolpark.destroy.block.DestroyBlocks;
import com.petrolpark.destroy.chemistry.legacy.LegacyReaction;
import com.petrolpark.destroy.chemistry.legacy.LegacyReaction.ReactionBuilder;
import com.petrolpark.destroy.chemistry.legacy.index.DestroyMolecules;
import com.petrolpark.destroy.chemistry.legacy.index.DestroyReactions;
import com.petrolpark.destroy.chemistry.legacy.reactionresult.CombinedReactionResult;
import com.petrolpark.destroy.chemistry.legacy.reactionresult.ExplosionReactionResult;
import com.petrolpark.destroy.chemistry.legacy.reactionresult.PrecipitateReactionResult;
import com.petrolpark.destroy.item.DestroyItems;
import com.petrolpark.destroy.config.DestroySubstancesConfigs;
import com.simibubi.create.AllItems;
import com.simibubi.create.AllTags;

// import com.petrolpark.destroy.chemistry.legacy.index.DestroyReactions;

import net.minecraft.world.item.Items;

public class DestructiveSpelunkingReactions extends DestroyReactions {
    public static final LegacyReaction

            SALTPETER_DISSOLUTION = builder()
            .id("saltpeter_dissolution")
            .addSimpleItemTagReactant(AllTags.forgeItemTag("dusts/saltpeter"), 3f)
            .addCatalyst(DestroyMolecules.WATER, 0)
            .addProduct(DestroyMolecules.POTASSIUM_ION, 5)
            .addProduct(DestroyMolecules.NITRATE, 5)
            .build();



    private static LegacyReaction.ReactionBuilder builder() {
        return new LegacyReaction.ReactionBuilder(DestructiveSpelunking.MOD_ID);
    };

    public static void register() {};
}
