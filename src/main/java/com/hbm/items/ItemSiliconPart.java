package com.hbm.items;

import com.hbm.lib.RefStrings;
import com.hbm.main.MainRegistry;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
//TODO It might be a good idea to make it a fancy modular enum, but I am so tired right now. Any change is going to break things.
public class ItemSiliconPart extends ItemEnumMulti {
	
	public static enum EnumSiliconType {
		BOULE_SILICON("boule_silicon"),
		WAFER_SILICON("wafer_silicon"),
		BOULE_DOPED("boule_doped"),
		WAFER_DOPED("wafer_doped");;
		private String texName;
		
		private EnumSiliconType(String texName) {
			this.texName = texName;
		}
	}

	public ItemSiliconPart() {
		super(EnumSiliconType.class, true, true);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg) {
		
		Enum[] enums = theEnum.getEnumConstants();
		this.icons = new IIcon[enums.length];
		
		for(int i = 0; i < icons.length; i++) {
			EnumSiliconType num = (EnumSiliconType)enums[i];
			this.icons[i] = reg.registerIcon(RefStrings.MODID + ":" + num.texName);
		}
	}
}
