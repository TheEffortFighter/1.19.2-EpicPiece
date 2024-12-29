package net.theeffortfighter.epicpiece.world.capabilities.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.theeffortfighter.epicpiece.EpicPiece;
import net.theeffortfighter.epicpiece.gameasset.OSSAnimations;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.forgeevent.WeaponCapabilityPresetRegistryEvent;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.ColliderPreset;
import yesman.epicfight.gameasset.EpicFightSkills;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.particle.EpicFightParticles;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCapability;

import java.util.function.Function;

@Mod.EventBusSubscriber(modid = EpicPiece.MOD_ID , bus = Mod.EventBusSubscriber.Bus.MOD)
public class EPWeaponCapabilityPresets {
    public static final Function<Item, CapabilityItem.Builder> OSS = (item) -> {
        CapabilityItem.Builder builder = WeaponCapability.builder()
                .category(EPWeaponCategories.OSS)
                .styleProvider((playerpatch) -> CapabilityItem.Styles.TWO_HAND)
                .collider(ColliderPreset.TACHI)
                .hitSound(EpicFightSounds.WHOOSH_SHARP.get())
                .hitParticle(EpicFightParticles.HIT_BLADE.get())
                .canBePlacedOffhand(false)
                .newStyleCombo(CapabilityItem.Styles.TWO_HAND, Animations.TACHI_AUTO1, Animations.TACHI_AUTO2, Animations.TACHI_AUTO3, Animations.TACHI_DASH, Animations.HEARTPIERCER)
                .newStyleCombo(CapabilityItem.Styles.MOUNT, Animations.SPEAR_MOUNT_ATTACK)
                .innateSkill(CapabilityItem.Styles.TWO_HAND,(itemstack) -> EpicFightSkills.BLADE_RUSH)
                .comboCancel((style) -> {
                    return false;
                })
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.IDLE, OSSAnimations.OSS_IDLE)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.WALK, OSSAnimations.OSS_WALK)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.CHASE, Animations.BIPED_RUN_LONGSWORD)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.RUN, Animations.BIPED_RUN_LONGSWORD)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.SWIM, Animations.BIPED_HOLD_LONGSWORD)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.BLOCK, Animations.LONGSWORD_GUARD);
        return builder;
    };

    @SubscribeEvent
    public static void registerMovesets(WeaponCapabilityPresetRegistryEvent event) {
        event.getTypeEntry().put("oss", OSS);
    }
}
