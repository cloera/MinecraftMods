package de.pitman87.TLPrinterBlock.common;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ServerCustomPacketEvent;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import io.netty.buffer.ByteBufInputStream;
import java.io.IOException;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class PacketHandler
{
  @SubscribeEvent
  public void onServerPacket(FMLNetworkEvent.ServerCustomPacketEvent event)
  {
    ByteBufInputStream dat = new ByteBufInputStream(event.packet.payload());
    try
    {
      print(MinecraftServer.func_71276_C().func_71218_a(dat.readInt()), dat.readInt(), dat.readInt(), dat.readInt(), dat.readInt(), dat.readInt(), 44, 44, dat);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
  
  public static void print(World worldObj, int posX, int posY, int posZ, int mData, int direction, int yLength, int xLength, ByteBufInputStream dat)
  {
    try
    {
      int[][] blocks = new int[yLength][xLength];
      
      int layer = dat.readInt();
      for (int l1 = 0; l1 < yLength; l1++) {
        for (int l2 = 0; l2 < xLength; l2++) {
          blocks[l1][l2] = dat.readInt();
        }
      }
      if (direction > 0) {
        for (int l1 = 0; l1 < yLength; l1++) {
          for (int l2 = 0; l2 < xLength; l2++) {
            if ((mData == 2) || (mData == 7))
            {
              if ((blocks[l1][l2] != 16) && ((worldObj.func_147439_a(posX - l2 * direction, posY + (yLength - 1) - l1, posZ + layer) == Blocks.field_150350_a) || (worldObj.func_147439_a(posX - l2 * direction, posY + (yLength - 1) - l1, posZ + layer) == Blocks.field_150325_L))) {
                worldObj.func_147465_d(posX - l2 * direction, posY + (yLength - 1) - l1, posZ + layer, Blocks.field_150325_L, blocks[l1][l2], 3);
              } else if ((blocks[l1][l2] == 16) && (worldObj.func_147439_a(posX - l2 * direction, posY + (yLength - 1) - l1, posZ + layer) == Blocks.field_150325_L)) {
                worldObj.func_147465_d(posX - l2 * direction, posY + (yLength - 1) - l1, posZ + layer, Blocks.field_150325_L, 0, 3);
              }
            }
            else if ((mData == 3) || (mData == 8))
            {
              if ((blocks[l1][l2] != 16) && ((worldObj.func_147439_a(posX + l2 * direction, posY + (yLength - 1) - l1, posZ - layer) == Blocks.field_150350_a) || (worldObj.func_147439_a(posX + l2 * direction, posY + (yLength - 1) - l1, posZ - layer) == Blocks.field_150325_L))) {
                worldObj.func_147465_d(posX + l2 * direction, posY + (yLength - 1) - l1, posZ - layer, Blocks.field_150325_L, blocks[l1][l2], 3);
              } else if ((blocks[l1][l2] == 16) && (worldObj.func_147439_a(posX + l2 * direction, posY + (yLength - 1) - l1, posZ - layer) == Blocks.field_150325_L)) {
                worldObj.func_147465_d(posX + l2 * direction, posY + (yLength - 1) - l1, posZ - layer, Blocks.field_150325_L, 0, 3);
              }
            }
            else if ((mData == 4) || (mData == 9))
            {
              if ((blocks[l1][l2] != 16) && ((worldObj.func_147439_a(posX + layer, posY + (yLength - 1) - l1, posZ + l2 * direction) == Blocks.field_150350_a) || (worldObj.func_147439_a(posX + layer, posY + (yLength - 1) - l1, posZ + l2 * direction) == Blocks.field_150325_L))) {
                worldObj.func_147465_d(posX + layer, posY + (yLength - 1) - l1, posZ + l2 * direction, Blocks.field_150325_L, blocks[l1][l2], 3);
              } else if ((blocks[l1][l2] == 16) && (worldObj.func_147439_a(posX + layer, posY + (yLength - 1) - l1, posZ + l2 * direction) == Blocks.field_150325_L)) {
                worldObj.func_147465_d(posX + layer, posY + (yLength - 1) - l1, posZ + l2 * direction, Blocks.field_150325_L, 0, 3);
              }
            }
            else if ((mData == 5) || (mData == 10)) {
              if ((blocks[l1][l2] != 16) && ((worldObj.func_147439_a(posX - layer, posY + (yLength - 1) - l1, posZ - l2 * direction) == Blocks.field_150350_a) || (worldObj.func_147439_a(posX - layer, posY + (yLength - 1) - l1, posZ - l2 * direction) == Blocks.field_150325_L))) {
                worldObj.func_147465_d(posX - layer, posY + (yLength - 1) - l1, posZ - l2 * direction, Blocks.field_150325_L, blocks[l1][l2], 3);
              } else if ((blocks[l1][l2] == 16) && (worldObj.func_147439_a(posX - layer, posY + (yLength - 1) - l1, posZ - l2 * direction) == Blocks.field_150325_L)) {
                worldObj.func_147465_d(posX - layer, posY + (yLength - 1) - l1, posZ - l2 * direction, Blocks.field_150325_L, 0, 3);
              }
            }
          }
        }
      } else {
        for (int l1 = 0; l1 < yLength; l1++) {
          for (int l2 = 0; l2 < xLength; l2++) {
            if ((mData == 2) || (mData == 7))
            {
              if ((blocks[l1][(xLength - l2 - 1)] != 16) && ((worldObj.func_147439_a(posX - l2 * direction, posY + (yLength - 1) - l1, posZ + layer) == Blocks.field_150350_a) || (worldObj.func_147439_a(posX - l2 * direction, posY + (yLength - 1) - l1, posZ + layer) == Blocks.field_150325_L))) {
                worldObj.func_147465_d(posX - l2 * direction, posY + (yLength - 1) - l1, posZ + layer, Blocks.field_150325_L, blocks[l1][(xLength - l2 - 1)], 3);
              } else if ((blocks[l1][(xLength - l2 - 1)] == 16) && (worldObj.func_147439_a(posX - l2 * direction, posY + (yLength - 1) - l1, posZ + layer) == Blocks.field_150325_L)) {
                worldObj.func_147465_d(posX - l2 * direction, posY + (yLength - 1) - l1, posZ + layer, Blocks.field_150325_L, 0, 3);
              }
            }
            else if ((mData == 3) || (mData == 8))
            {
              if ((blocks[l1][(xLength - l2 - 1)] != 16) && ((worldObj.func_147439_a(posX + l2 * direction, posY + (yLength - 1) - l1, posZ - layer) == Blocks.field_150350_a) || (worldObj.func_147439_a(posX + l2 * direction, posY + (yLength - 1) - l1, posZ - layer) == Blocks.field_150325_L))) {
                worldObj.func_147465_d(posX + l2 * direction, posY + (yLength - 1) - l1, posZ - layer, Blocks.field_150325_L, blocks[l1][(xLength - l2 - 1)], 3);
              } else if ((blocks[l1][(xLength - l2 - 1)] == 16) && (worldObj.func_147439_a(posX + l2 * direction, posY + (yLength - 1) - l1, posZ - layer) == Blocks.field_150325_L)) {
                worldObj.func_147465_d(posX + l2 * direction, posY + (yLength - 1) - l1, posZ - layer, Blocks.field_150325_L, 0, 3);
              }
            }
            else if ((mData == 4) || (mData == 9))
            {
              if ((blocks[l1][(xLength - l2 - 1)] != 16) && ((worldObj.func_147439_a(posX + layer, posY + (yLength - 1) - l1, posZ + l2 * direction) == Blocks.field_150350_a) || (worldObj.func_147439_a(posX + layer, posY + (yLength - 1) - l1, posZ + l2 * direction) == Blocks.field_150325_L))) {
                worldObj.func_147465_d(posX + layer, posY + (yLength - 1) - l1, posZ + l2 * direction, Blocks.field_150325_L, blocks[l1][(xLength - l2 - 1)], 3);
              } else if ((blocks[l1][(xLength - l2 - 1)] == 16) && (worldObj.func_147439_a(posX + layer, posY + (yLength - 1) - l1, posZ + l2 * direction) == Blocks.field_150325_L)) {
                worldObj.func_147465_d(posX + layer, posY + (yLength - 1) - l1, posZ + l2 * direction, Blocks.field_150325_L, 0, 3);
              }
            }
            else if ((mData == 5) || (mData == 10)) {
              if ((blocks[l1][(xLength - l2 - 1)] != 16) && ((worldObj.func_147439_a(posX - layer, posY + (yLength - 1) - l1, posZ - l2 * direction) == Blocks.field_150350_a) || (worldObj.func_147439_a(posX - layer, posY + (yLength - 1) - l1, posZ - l2 * direction) == Blocks.field_150325_L))) {
                worldObj.func_147465_d(posX - layer, posY + (yLength - 1) - l1, posZ - l2 * direction, Blocks.field_150325_L, blocks[l1][(xLength - l2 - 1)], 3);
              } else if ((blocks[l1][(xLength - l2 - 1)] == 16) && (worldObj.func_147439_a(posX - layer, posY + (yLength - 1) - l1, posZ - l2 * direction) == Blocks.field_150325_L)) {
                worldObj.func_147465_d(posX - layer, posY + (yLength - 1) - l1, posZ - l2 * direction, Blocks.field_150325_L, 0, 3);
              }
            }
          }
        }
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
