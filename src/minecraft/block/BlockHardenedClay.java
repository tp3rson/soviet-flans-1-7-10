package net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockHardenedClay extends Block {

   public BlockHardenedClay() {
      super(Material.rock);
      this.setCreativeTab(CreativeTabs.tabBlock);
   }

   public MapColor getMapColor(int var1) {
      return MapColor.adobeColor;
   }
}
