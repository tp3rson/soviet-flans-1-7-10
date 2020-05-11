package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.MathHelper;

public class EntityAIArrowAttack extends EntityAIBase {

   private final EntityLiving entityHost;
   private final IRangedAttackMob rangedAttackEntityHost;
   private EntityLivingBase attackTarget;
   private int rangedAttackTime;
   private double entityMoveSpeed;
   private int field_75318_f;
   private int field_96561_g;
   private int maxRangedAttackTime;
   private float field_96562_i;
   private float field_82642_h;


   public EntityAIArrowAttack(IRangedAttackMob var1, double var2, int var4, float var5) {
      this(var1, var2, var4, var4, var5);
   }

   public EntityAIArrowAttack(IRangedAttackMob var1, double var2, int var4, int var5, float var6) {
      this.rangedAttackTime = -1;
      if(!(var1 instanceof EntityLivingBase)) {
         throw new IllegalArgumentException("ArrowAttackGoal requires Mob implements RangedAttackMob");
      } else {
         this.rangedAttackEntityHost = var1;
         this.entityHost = (EntityLiving)var1;
         this.entityMoveSpeed = var2;
         this.field_96561_g = var4;
         this.maxRangedAttackTime = var5;
         this.field_96562_i = var6;
         this.field_82642_h = var6 * var6;
         this.setMutexBits(3);
      }
   }

   public boolean shouldExecute() {
      EntityLivingBase var1 = this.entityHost.getAttackTarget();
      if(var1 == null) {
         return false;
      } else {
         this.attackTarget = var1;
         return true;
      }
   }

   public boolean continueExecuting() {
      return this.shouldExecute() || !this.entityHost.getNavigator().noPath();
   }

   public void resetTask() {
      this.attackTarget = null;
      this.field_75318_f = 0;
      this.rangedAttackTime = -1;
   }

   public void updateTask() {
      double var1 = this.entityHost.getDistanceSq(this.attackTarget.posX, this.attackTarget.boundingBox.minY, this.attackTarget.posZ);
      boolean var3 = this.entityHost.getEntitySenses().canSee(this.attackTarget);
      if(var3) {
         ++this.field_75318_f;
      } else {
         this.field_75318_f = 0;
      }

      if(var1 <= (double)this.field_82642_h && this.field_75318_f >= 20) {
         this.entityHost.getNavigator().clearPathEntity();
      } else {
         this.entityHost.getNavigator().tryMoveToEntityLiving(this.attackTarget, this.entityMoveSpeed);
      }

      this.entityHost.getLookHelper().setLookPositionWithEntity(this.attackTarget, 30.0F, 30.0F);
      float var4;
      if(--this.rangedAttackTime == 0) {
         if(var1 > (double)this.field_82642_h || !var3) {
            return;
         }

         var4 = MathHelper.sqrt_double(var1) / this.field_96562_i;
         float var5 = var4;
         if(var4 < 0.1F) {
            var5 = 0.1F;
         }

         if(var5 > 1.0F) {
            var5 = 1.0F;
         }

         this.rangedAttackEntityHost.attackEntityWithRangedAttack(this.attackTarget, var5);
         this.rangedAttackTime = MathHelper.floor_float(var4 * (float)(this.maxRangedAttackTime - this.field_96561_g) + (float)this.field_96561_g);
      } else if(this.rangedAttackTime < 0) {
         var4 = MathHelper.sqrt_double(var1) / this.field_96562_i;
         this.rangedAttackTime = MathHelper.floor_float(var4 * (float)(this.maxRangedAttackTime - this.field_96561_g) + (float)this.field_96561_g);
      }

   }
}
