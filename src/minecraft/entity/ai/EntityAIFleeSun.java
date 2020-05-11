package net.minecraft.entity.ai;

import java.util.Random;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityAIFleeSun extends EntityAIBase {

   private EntityCreature theCreature;
   private double shelterX;
   private double shelterY;
   private double shelterZ;
   private double movementSpeed;
   private World theWorld;


   public EntityAIFleeSun(EntityCreature var1, double var2) {
      this.theCreature = var1;
      this.movementSpeed = var2;
      this.theWorld = var1.worldObj;
      this.setMutexBits(1);
   }

   public boolean shouldExecute() {
      if(!this.theWorld.isDaytime()) {
         return false;
      } else if(!this.theCreature.isBurning()) {
         return false;
      } else if(!this.theWorld.canBlockSeeTheSky(MathHelper.floor_double(this.theCreature.posX), (int)this.theCreature.boundingBox.minY, MathHelper.floor_double(this.theCreature.posZ))) {
         return false;
      } else {
         Vec3 var1 = this.findPossibleShelter();
         if(var1 == null) {
            return false;
         } else {
            this.shelterX = var1.xCoord;
            this.shelterY = var1.yCoord;
            this.shelterZ = var1.zCoord;
            return true;
         }
      }
   }

   public boolean continueExecuting() {
      return !this.theCreature.getNavigator().noPath();
   }

   public void startExecuting() {
      this.theCreature.getNavigator().tryMoveToXYZ(this.shelterX, this.shelterY, this.shelterZ, this.movementSpeed);
   }

   private Vec3 findPossibleShelter() {
      Random var1 = this.theCreature.getRNG();

      for(int var2 = 0; var2 < 10; ++var2) {
         int var3 = MathHelper.floor_double(this.theCreature.posX + (double)var1.nextInt(20) - 10.0D);
         int var4 = MathHelper.floor_double(this.theCreature.boundingBox.minY + (double)var1.nextInt(6) - 3.0D);
         int var5 = MathHelper.floor_double(this.theCreature.posZ + (double)var1.nextInt(20) - 10.0D);
         if(!this.theWorld.canBlockSeeTheSky(var3, var4, var5) && this.theCreature.getBlockPathWeight(var3, var4, var5) < 0.0F) {
            return Vec3.createVectorHelper((double)var3, (double)var4, (double)var5);
         }
      }

      return null;
   }
}
