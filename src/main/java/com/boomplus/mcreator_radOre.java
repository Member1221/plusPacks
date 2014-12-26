package com.plusmods.boomplus;//based on master condiguration

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
import java.util.*;

import net.minecraftforge.common.util.*;
import net.minecraft.client.renderer.texture.*;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
public class mcreator_radOre {

public mcreator_radOre(){}

public static BlockRadOre block;

public static Object instance;public int addFuel(ItemStack fuel){return 0;}
public void serverLoad(FMLServerStartingEvent event){}
public void preInit(FMLPreInitializationEvent event){

GameRegistry.registerBlock(block, "RadOre");
}
public void registerRenderers(){}
public void load(){
}


static{

block = (BlockRadOre)(new BlockRadOre().setHardness(6.0F)
.setResistance(10.0F)
.setLightLevel(0.0F)
.setBlockName("RadOre")
.setBlockTextureName("radioactiveOretexture")
.setLightOpacity(0)
.setStepSound(Block.soundTypeStone)
.setCreativeTab(mcreator_boomPlusTab.tab)
);block.setBlockBounds(0.0F,0.0F,0.0F,1.0F,1.0F,1.0F);
Block.blockRegistry.addObject(185, "RadOre", block);
block.setHarvestLevel("pickaxe", 2);
}


public void generateSurface(World world, java.util.Random rand, int chunkX, int chunkZ){
for(int i = 0; i < 5; i++){
int randPosX = chunkX + rand.nextInt(16);
int randPosY = rand.nextInt(14)+20;
int randPosZ = chunkZ + rand.nextInt(16);
(new WorldGenMinable(mcreator_radOre.block, 7)).generate(world, rand, randPosX, randPosY, randPosZ);
}
}

public void generateNether(World world, Random random, int chunkX, int chunkZ){}
static class BlockRadOre extends Block
{

int a1 = 0,a2 = 0,a3 = 0,a4 = 0,a5 = 0,a6 = 0;

IIcon gor = null, dol = null, st1 = null, st2 = null, st3 = null, st4 = null;

boolean red = false;





protected BlockRadOre()
{
        super(Material.iron);

}


public void onBlockAdded(World world, int i, int j, int k){
EntityPlayer entity = Minecraft.getMinecraft().thePlayer;
if(entity!=null&&world!=null){
int le = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
world.setBlockMetadataWithNotify(i, j, k, le, 2);
}

world.scheduleBlockUpdate(i, j, k, this, this.tickRate(world));

}
public int isProvidingStrongPower(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5){
return red?1:0;
}
public void randomDisplayTick(World world, int i, int j, int k, Random random){
EntityPlayer entity = Minecraft.getMinecraft().thePlayer;
		World par1World = world;
				int par2 = i;
				int par3 = j;
				int par4 = k;
		Random par5Random = random;
if(true)
        for (int l = 0; l < 15; ++l)
        {
            double d0 = (double)((float)par2 + par5Random.nextFloat());
            double d1 = (double)((float)par3 + par5Random.nextFloat());
            double d2 = (double)((float)par4 + par5Random.nextFloat());
            double d3 = 0.0D;
            double d4 = 0.0D;
            double d5 = 0.0D;
            int i1 = par5Random.nextInt(2) * 2 - 1;
            d3 = ((double)par5Random.nextFloat() - 0.5D) * 1.499999998509884D;
            d4 = ((double)par5Random.nextFloat() - 0.5D) * 1.499999998509884D;
            d5 = ((double)par5Random.nextFloat() - 0.5D) * 1.499999998509884D;
            par1World.spawnParticle("mobSpellAmbient", d0, d1, d2, d3, d4, d5);
        }

}
@SideOnly(Side.CLIENT)
@Override
public IIcon getIcon(int i, int par2){

if (i == 0)
return gor;

else if (i == 1)
return dol;

else if (i == 2)
return st1;

else if (i == 3)
return st2;

else if (i == 4)
return st4;

else if (i == 5)
return st3;

else
return gor;

}

@SideOnly(Side.CLIENT)
@Override
public void registerBlockIcons(IIconRegister reg){
this.gor = reg.registerIcon("radioactiveOretexture");
this.dol = reg.registerIcon("radioactiveOretexture");
this.st1 = reg.registerIcon("radioactiveOretexture");
this.st2 = reg.registerIcon("radioactiveOretexture");
this.st3 = reg.registerIcon("radioactiveOretexture");
this.st4 = reg.registerIcon("radioactiveOretexture");
}
public int getRenderType(){
return 0;
}
@Override
public int tickRate(World world)
{
    return 10;
}

public int quantityDropped(Random par1Random){
return 2;
}

public Item getItemDropped(int par1, Random par2Random, int par3){
return mcreator_radGunpowder.block;
}
}
}
