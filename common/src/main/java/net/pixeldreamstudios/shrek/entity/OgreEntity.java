package net.pixeldreamstudios.shrek.entity;

import mod.azure.azurelib.ai.pathing.AzureNavigation;
import mod.azure.azurelib.animatable.GeoEntity;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animatable.instance.SingletonAnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.object.PlayState;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.pixeldreamstudios.shrek.entity.constant.ShrekDefaultAnimations;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class OgreEntity extends PathfinderMob implements GeoEntity {
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private long ticksUntilAttackFinish = 0;

    public OgreEntity(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
        navigation = new AzureNavigation(this, level);
    }

    public static AttributeSupplier.@NotNull Builder createMobAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 100)
                .add(Attributes.ATTACK_DAMAGE, 10)
                .add(Attributes.ATTACK_KNOCKBACK, 1)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.8)
                .add(Attributes.MOVEMENT_SPEED, 0.2);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.25f, true));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0f));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 6.0f));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 3, state -> {
            if (state.isMoving() && !swinging) {
                if (isAggressive() && !swinging) {
                    state.getController().setAnimation(ShrekDefaultAnimations.RUN);
                    return PlayState.CONTINUE;
                }
                state.getController().setAnimation(ShrekDefaultAnimations.WALK);
                return PlayState.CONTINUE;
            } else if (swinging) {
                state.getController().setAnimation(new Random().nextBoolean() ? ShrekDefaultAnimations.ATTACK : ShrekDefaultAnimations.ATTACK_2);
                ticksUntilAttackFinish++;
                if (ticksUntilAttackFinish > 20 * 4) {
                    swinging = false;
                    ticksUntilAttackFinish = 0;
                }
                return PlayState.CONTINUE;
            }
            state.getController().setAnimation(ShrekDefaultAnimations.IDLE);
            return PlayState.CONTINUE;
        }));
    }

    protected SoundEvent getAmbientSound() {
        this.playSound(SoundEvents.VILLAGER_AMBIENT, 1.0f, 0.2f);
        return null;
    }

    protected SoundEvent getHurtSound(DamageSource damageSource) {
        this.playSound(SoundEvents.VILLAGER_HURT, 1.0f, 0.2f);
        return null;
    }

    protected SoundEvent getDeathSound() {
        this.playSound(SoundEvents.VILLAGER_DEATH, 1.0f, 0.2f);
        return null;
    }

    protected void playStepSound(BlockPos blockPos, BlockState blockState) {
        this.playSound(SoundEvents.COW_STEP, 1.0f, 0.2f);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}