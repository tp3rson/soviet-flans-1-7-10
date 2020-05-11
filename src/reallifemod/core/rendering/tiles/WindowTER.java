package de.ItsAMysterious.mods.reallifemod.core.rendering.tiles;

import de.ItsAMysterious.mods.reallifemod.core.tiles.WindowTE;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class WindowTER extends TileEntitySpecialRenderer {

   private IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation("reallifemod:models/outdoor/Window.obj"));


   public void func_147500_a(TileEntity te, double x, double y, double z, float scale) {
      this.doRender((WindowTE)te, x, y, z, scale);
   }

   public void doRender(WindowTE te, double x, double y, double z, float scale) {
      GL11.glPushMatrix();
      GL11.glDisable(2884);
      GL11.glEnable(3008);
      GL11.glTranslated((double)((float)x + 0.5F), (double)((float)y), (double)((float)z + 0.5F));
      GL11.glRotatef((float)(te.func_145832_p() * 90), 0.0F, 1.0F, 0.0F);
      if(te.func_145832_p() * 90 == 180 || te.func_145832_p() * 90 == 0) {
         GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
      }

      GL11.glPushMatrix();
      GL11.glTranslated(-0.5D, 0.0D, 0.0D);
      GL11.glRotated(te.wingrotZ, 0.0D, 1.0D, 0.0D);
      GL11.glRotated(te.wingrotX, 1.0D, 0.0D, 0.0D);
      if(te.shouldrotatewing) {
         GL11.glRotated(180.0D, 0.0D, 0.0D, 1.0D);
         GL11.glTranslated(-1.0D, -1.0D, 0.0D);
      }

      GL11.glPushMatrix();
      this.func_147499_a(new ResourceLocation("minecraft:textures/blocks/glass.png"));
      this.model.renderPart("Glass_0");
      GL11.glPopMatrix();
      this.func_147499_a(new ResourceLocation("minecraft:textures/blocks/planks_oak.png"));
      this.model.renderPart("WindowW_Wing");
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      this.func_147499_a(new ResourceLocation("minecraft:textures/blocks/planks_oak.png"));
      this.model.renderPart("Window_Frame");
      GL11.glPopMatrix();
      GL11.glPopMatrix();
   }

   private void adjustLightFixture(World world, int i, int j, int k, Block block) {
      Tessellator tess = Tessellator.instance;
      float brightness = (float)block.getMixedBrightnessForBlock(world, i, j, k);
      int skyLight = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
      int modulousModifier = skyLight % 65536;
      int divModifier = skyLight / 65536;
      tess.setColorOpaque_F(brightness, brightness, brightness);
      OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)modulousModifier, (float)divModifier);
   }
}
