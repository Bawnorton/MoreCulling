package ca.fxco.moreculling.mixin.models;

import ca.fxco.moreculling.api.model.BakedOpacity;
import net.minecraft.client.resources.model.BakedModel;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BakedModel.class)
public interface BakedModel_extendsMixin extends BakedOpacity {}