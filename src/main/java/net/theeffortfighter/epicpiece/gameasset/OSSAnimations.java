package net.theeffortfighter.epicpiece.gameasset;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.theeffortfighter.epicpiece.EpicPiece;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.api.forgeevent.AnimationRegistryEvent;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.model.armature.HumanoidArmature;

public class OSSAnimations {

    public static StaticAnimation OSS_IDLE;
    public static StaticAnimation OSS_WALK;

    @SubscribeEvent
    public static void registerAnimations(AnimationRegistryEvent event) {
        event.getRegistryMap().put(EpicPiece.MOD_ID, OSSAnimations::build);
    }

    private static void build() {
        HumanoidArmature biped = Armatures.BIPED;

        OSS_IDLE = new MovementAnimation(true, "biped/living/oss_idle", biped);
        OSS_WALK = new MovementAnimation(true, "biped/living/oss_walk", biped);

    }
}
