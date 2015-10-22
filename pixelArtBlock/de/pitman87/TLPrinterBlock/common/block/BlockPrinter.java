package de.pitman87.TLPrinterBlock.common.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.pitman87.TLPrinterBlock.common.CommonProxy;
import de.pitman87.TLPrinterBlock.common.PrinterBlockMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPrinter
  extends Block
{
  @SideOnly(Side.CLIENT)
  IIcon[] icons;
  
  public BlockPrinter()
  {
    super(Material.field_151578_c);
    func_149647_a(CreativeTabs.field_78031_c);
  }
  
  public void func_149726_b(World world, int i, int j, int k)
  {
    super.func_149726_b(world, i, j, k);
    setDefaultDirection(world, i, j, k);
  }
  
  private void setDefaultDirection(World world, int i, int j, int k)
  {
    if (world.field_72995_K) {
      return;
    }
    Block l = world.func_147439_a(i, j, k - 1);
    Block i1 = world.func_147439_a(i, j, k + 1);
    Block j1 = world.func_147439_a(i - 1, j, k);
    Block k1 = world.func_147439_a(i + 1, j, k);
    byte byte0 = 3;
    if ((l.func_149662_c()) && (!i1.func_149662_c())) {
      byte0 = 3;
    }
    if ((i1.func_149662_c()) && (!l.func_149662_c())) {
      byte0 = 2;
    }
    if ((j1.func_149662_c()) && (!k1.func_149662_c())) {
      byte0 = 5;
    }
    if ((k1.func_149662_c()) && (!j1.func_149662_c())) {
      byte0 = 4;
    }
    world.func_72921_c(i, j, k, byte0, 3);
  }
  
  public void func_149689_a(World world, int i, int j, int k, EntityLivingBase entityliving, ItemStack itemStack)
  {
    int l = MathHelper.func_76128_c(entityliving.field_70177_z * 4.0F / 360.0F + 0.5D) & 0x3;
    if (l == 0) {
      world.func_72921_c(i, j, k, 2, 3);
    }
    if (l == 1) {
      world.func_72921_c(i, j, k, 5, 3);
    }
    if (l == 2) {
      world.func_72921_c(i, j, k, 3, 3);
    }
    if (l == 3) {
      world.func_72921_c(i, j, k, 4, 3);
    }
  }
  
  @SideOnly(Side.CLIENT)
  public IIcon func_149673_e(IBlockAccess iblockaccess, int i, int j, int k, int l)
  {
    if (l == 1) {
      return this.field_149761_L;
    }
    int i1 = iblockaccess.func_72805_g(i, j, k);
    if (i1 > 6)
    {
      if (l != i1 - 5) {
        return this.icons[0];
      }
      return this.icons[2];
    }
    if (l != i1) {
      return this.icons[0];
    }
    return this.icons[1];
  }
  
  @SideOnly(Side.CLIENT)
  public IIcon func_149691_a(int i, int m)
  {
    if (i == 3) {
      return this.icons[1];
    }
    if (i == 1) {
      return this.field_149761_L;
    }
    return this.icons[0];
  }
  
  @SideOnly(Side.CLIENT)
  public void func_149651_a(IIconRegister par1IconRegister)
  {
    this.field_149761_L = par1IconRegister.func_94245_a("PrinterBlock:printer_up");
    this.icons = new IIcon[3];
    this.icons[0] = par1IconRegister.func_94245_a("PrinterBlock:printer_side");
    this.icons[1] = par1IconRegister.func_94245_a("PrinterBlock:printer_side2");
    this.icons[2] = par1IconRegister.func_94245_a("PrinterBlock:printer_side3");
  }
  
  public void func_149699_a(World world, int i, int j, int k, EntityPlayer entityplayer)
  {
    int l = world.func_72805_g(i, j, k);
    if (l > 6) {
      world.func_72921_c(i, j, k, l - 5, 3);
    } else {
      world.func_72921_c(i, j, k, l + 5, 3);
    }
    world.func_147471_g(i, j, k);
  }
  
  public boolean func_149727_a(World world, int i, int j, int k, EntityPlayer entityplayer, int par6, float par7, float par8, float par9)
  {
    if (world.field_72995_K)
    {
      int l = world.func_72805_g(i, j, k) < 6 ? 1 : -1;
      PrinterBlockMod.proxy.openGUI(entityplayer, world, i, j + 1, k, world.func_72805_g(i, j, k), l);
    }
    return true;
  }
}
