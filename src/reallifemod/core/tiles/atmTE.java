package de.ItsAMysterious.mods.reallifemod.core.tiles;

import de.ItsAMysterious.mods.reallifemod.core.tiles.TileEntityDirectional;

public class atmTE extends TileEntityDirectional {

   private double heightToSubstract;


   public double getHeightToSubstract() {
      return this.heightToSubstract;
   }

   public void setHeightToSubstract(double heightToSubstract) {
      this.heightToSubstract = heightToSubstract;
   }

   public int func_145832_p() {
      if(this.field_145850_b != null) {
         if(this.field_145847_g == -1) {
            this.field_145847_g = this.field_145850_b.getBlockMetadata(this.field_145851_c, this.field_145848_d, this.field_145849_e);
         }

         return this.field_145847_g;
      } else {
         return 1;
      }
   }
}
