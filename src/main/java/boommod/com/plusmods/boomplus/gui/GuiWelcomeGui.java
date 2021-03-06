package com.plusmods.boomplus.gui;//based on master condiguration

import cpw.mods.fml.client.*;
import cpw.mods.fml.client.registry.*;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.asm.*;
import cpw.mods.fml.common.asm.transformers.*;
import cpw.mods.fml.common.discovery.*;
import cpw.mods.fml.common.discovery.asm.*;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.functions.*;
import cpw.mods.fml.common.network.*;
import cpw.mods.fml.common.registry.*;
import cpw.mods.fml.common.toposort.*;
import cpw.mods.fml.common.versioning.*;
import cpw.mods.fml.relauncher.*;
import cpw.mods.fml.server.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.client.*;
import net.minecraft.client.audio.*;
import net.minecraft.client.entity.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.gui.achievement.*;
import net.minecraft.client.gui.inventory.*;
import net.minecraft.client.model.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.client.particle.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.culling.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.client.settings.*;
import net.minecraft.command.*;
import net.minecraft.crash.*;
import net.minecraft.creativetab.*;
import net.minecraft.dispenser.*;
import net.minecraft.enchantment.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.boss.*;
import net.minecraft.entity.effect.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.*;
import net.minecraft.nbt.*;
import net.minecraft.network.*;
import net.minecraft.network.rcon.*;
import net.minecraft.pathfinding.*;
import net.minecraft.potion.*;
import net.minecraft.profiler.*;
import net.minecraft.server.*;
import net.minecraft.server.dedicated.*;
import net.minecraft.server.gui.*;
import net.minecraft.server.integrated.*;
import net.minecraft.server.management.*;
import net.minecraft.src.*;
import net.minecraft.stats.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.village.*;
import net.minecraft.world.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.chunk.*;
import net.minecraft.world.chunk.storage.*;
import net.minecraft.world.demo.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.layer.*;
import net.minecraft.world.gen.structure.*;
import net.minecraft.world.storage.*;
import net.minecraftforge.classloading.*;
import net.minecraftforge.client.*;
import net.minecraftforge.client.event.*;
import net.minecraftforge.client.event.sound.*;
import net.minecraftforge.common.*;
import net.minecraftforge.event.*;
import net.minecraftforge.event.entity.*;
import net.minecraftforge.event.entity.item.*;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.entity.minecart.*;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.event.terraingen.*;
import net.minecraftforge.event.world.*;
import net.minecraftforge.oredict.*;
import net.minecraftforge.transformers.*;
import net.minecraft.init.*;

import java.util.Random;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SuppressWarnings("unchecked")
public class GuiWelcomeGui {

	public static Object instance;

	public static int GUIID = 1;

	public GuiWelcomeGui() {
	}

	public void load() {
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
	}

	public void registerRenderers() {
	}

	public void generateNether(World world, Random random, int chunkX,
			int chunkZ) {
	}

	public void generateSurface(World world, Random random, int chunkX,
			int chunkZ) {
	}

	public int addFuel(ItemStack fuel) {
		return 0;
	}

	public void serverLoad(FMLServerStartingEvent event) {
	}

	public void preInit(FMLPreInitializationEvent event) {
	}

	public static class GuiHandler implements IGuiHandler {
		@Override
		public Object getServerGuiElement(int id, EntityPlayer player,
				World world, int x, int y, int z) {
			return new GuiWelcomeGui.GuiContainerMod(player);
		}

		@Override
		public Object getClientGuiElement(int id, EntityPlayer player,
				World world, int x, int y, int z) {
			return new GuiWelcomeGui.GuiWindow(world, x, y, z, player);
		}
	}

	public static class GuiContainerMod extends Container {

		public GuiContainerMod(EntityPlayer player) {
		}

		@Override
		public boolean canInteractWith(EntityPlayer player) {
			return true;
		}

		protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
		}

		@Override
		public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
			return null;
		}
	}

	public static class GuiWindow extends GuiContainer {

		int i = 0;
		int j = 0;
		int k = 0;
		EntityPlayer entity = null;

		public GuiWindow(World world, int i, int j, int k, EntityPlayer entity) {
			super(new GuiContainerMod((EntityPlayer) entity));
			this.i = i;
			this.j = j;
			this.k = k;
			this.entity = entity;
		}

		private static final ResourceLocation texture = new ResourceLocation(
				"WelcomeGUI2.png");

		protected void drawGuiContainerBackgroundLayer(float par1, int par2,
				int par3) {
			int posX = (this.width) / 2;
			int posY = (this.height) / 2;
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

			/*
			 * this.mc.renderEngine.bindTexture(texture); this.xSize = 225;
			 * this.ySize = 127; int k = (this.width - this.xSize) / 2; int l =
			 * (this.height - this.ySize) / 2; this.drawTexturedModalRect(k, l,
			 * 0, 0, this.xSize, this.ySize);
			 */

			zLevel = 100.0F;

			this.mc.renderEngine.bindTexture(new ResourceLocation("booml.png"));
			this.drawTexturedModalRect(posX + (-130), posY + (-199), 0, 0, 256,
					256);

		}

		protected void mouseClicked(int par1, int par2, int par3) {
			super.mouseClicked(par1, par2, par3);

		}

		public void updateScreen() {
			int posX = (this.width) / 2;
			int posY = (this.height) / 2;

		}

		protected void drawGuiContainerForegroundLayer(int par1, int par2) {
			int posX = (this.width) / 2;
			int posY = (this.height) / 2;
			this.fontRendererObj.drawString(
					"BoomPlus Developers: ZakDoesGaming, Member1221", posX
							+ (-124), posY + (-40), 0x00ffff);
			this.fontRendererObj.drawString(
					"------------------------------------------",
					posX + (-128), posY + (-30), 0xffffff);
			this.fontRendererObj.drawString("Hello!", posX + (-18), posY
					+ (-20), 0xffffff);
			this.fontRendererObj.drawString("Thanks for playing with Boom+",
					posX + (-79), posY + (-6), 0xffffff);
			this.fontRendererObj
					.drawString(
							"Please contact us if you think we should add your idea into the mod!",
							posX + (-170), posY + (13), 0xffffff);
			this.fontRendererObj.drawString(
					"Contact Email: zak@thegamingunion.org", posX + (-94),
					posY + (40), 0x666600);
			this.fontRendererObj.drawString("Thanks!", posX + (-23),
					posY + (70), 0xff3333);

		}

		public void onGuiClosed() {
			Keyboard.enableRepeatEvents(false);
		}

		public void initGui() {
			Keyboard.enableRepeatEvents(true);
			this.buttonList.clear();
			int posX = (this.width) / 2;
			int posY = (this.height) / 2;
			this.buttonList.add(new GuiButton(0, posX + (-28), posY + (85), 50,
					20, "Close"));
		}

		protected void actionPerformed(GuiButton button) {

				if (button.id == 0) {
						this.mc.displayGuiScreen((GuiScreen) null);
			}
	}

	public boolean doesGuiPauseGame() {
		return false;
	}
	}
}

