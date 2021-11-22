/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.models.villagers;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.MathHelper;

public class ModelCaligroVillager extends ModelBase {
	
	private final ModelRenderer villager;
	private final ModelRenderer Head;
	private final ModelRenderer Body;
	private final ModelRenderer RightArm;
	private final ModelRenderer RightArm_r1;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftArm_r1;
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer SpiderArm1;
	private final ModelRenderer SpiderArmLeft1;
	private final ModelRenderer SpiderArmLeft3;
	private final ModelRenderer SpideyLeg128_r1;
	private final ModelRenderer SpiderArmLeft6;
	private final ModelRenderer SpideyLeg135_r1;
	private final ModelRenderer SpiderArmLeft7;
	private final ModelRenderer SpideyLeg873_r1;
	private final ModelRenderer SpiderArmLeft5;
	private final ModelRenderer SpideyLeg928_r1;
	private final ModelRenderer SpiderArmLeft4;
	private final ModelRenderer SpiderArm2;
	private final ModelRenderer SpiderArmLeft2;
	private final ModelRenderer SpiderArmLeft8;
	private final ModelRenderer SpideyLeg788_r1;
	private final ModelRenderer SpiderArmLeft9;
	private final ModelRenderer SpideyLeg123_r1;
	private final ModelRenderer SpiderArmLeft10;
	private final ModelRenderer SpideyLeg456_r1;
	private final ModelRenderer SpiderArmLeft11;
	private final ModelRenderer SpideyLeg789_r1;
	private final ModelRenderer SpiderArmLeft12;
	private final ModelRenderer SpiderArm3;
	private final ModelRenderer SpiderArmLeft13;
	private final ModelRenderer SpiderArmLeft14;
	private final ModelRenderer SpideyLeg998_r1;
	private final ModelRenderer SpiderArmLeft15;
	private final ModelRenderer SpideyLeg997_r1;
	private final ModelRenderer SpiderArmLeft16;
	private final ModelRenderer SpideyLeg996_r1;
	private final ModelRenderer SpiderArmLeft17;
	private final ModelRenderer SpideyLeg995_r1;
	private final ModelRenderer SpiderArmLeft18;
	private final ModelRenderer SpiderArm4;
	private final ModelRenderer SpiderArmLeft19;
	private final ModelRenderer SpiderArmLeft20;
	private final ModelRenderer SpideyLeg998_r2;
	private final ModelRenderer SpiderArmLeft21;
	private final ModelRenderer SpideyLeg121_r1;
	private final ModelRenderer SpiderArmLeft22;
	private final ModelRenderer SpideyLeg122_r1;
	private final ModelRenderer SpiderArmLeft23;
	private final ModelRenderer SpideyLeg12345_r1;
	private final ModelRenderer SpiderArmLeft24;
	
	public ModelCaligroVillager() {
		textureWidth = 64;
		textureHeight = 64;
		
		villager = new ModelRenderer(this);
		villager.setRotationPoint(0.0F, 24.0F, 0.0F);
		
		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -24.0F, 0.0F);
		villager.addChild(Head);
		Head.cubeList.add(new ModelBox(Head, 0, 0, -4.0F, -13.0F, -4.0F, 8, 13, 8, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 25, 0, -1.0F, -3.0F, -6.0F, 2, 4, 2, 0.0F, false));
		
		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, -24.0F, 0.0F);
		villager.addChild(Body);
		Body.cubeList.add(new ModelBox(Body, 18, 19, -4.0F, 0.25F, -2.0F, 8, 12, 4, 0.0F, false));
		
		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-5.0F, -22.0F, 0.0F);
		villager.addChild(RightArm);
		
		RightArm_r1 = new ModelRenderer(this);
		RightArm_r1.setRotationPoint(5.0F, 22.0F, -5.0F);
		RightArm.addChild(RightArm_r1);
		setRotationAngle(RightArm_r1, -0.2618F, 0.0F, 0.0F);
		RightArm_r1.cubeList.add(new ModelBox(RightArm_r1, 0, 22, -8.0F, -26.0F, -2.0F, 4, 16, 4, 0.0F, false));
		
		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.0F, -22.0F, 0.0F);
		villager.addChild(LeftArm);
		
		LeftArm_r1 = new ModelRenderer(this);
		LeftArm_r1.setRotationPoint(-5.0F, 22.0F, -5.0F);
		LeftArm.addChild(LeftArm_r1);
		setRotationAngle(LeftArm_r1, -0.2618F, 0.0F, 0.0F);
		LeftArm_r1.cubeList.add(new ModelBox(LeftArm_r1, 0, 22, 4.0F, -26.0F, -2.0F, 4, 16, 4, 0.0F, false));
		
		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-1.9F, -12.0F, 0.0F);
		villager.addChild(RightLeg);
		RightLeg.cubeList.add(new ModelBox(RightLeg, 15, 50, -3.1F, 0.0F, -2.0F, 4, 12, 3, 0.0F, true));
		
		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(1.9F, -12.0F, 0.0F);
		villager.addChild(LeftLeg);
		LeftLeg.cubeList.add(new ModelBox(LeftLeg, 15, 49, -1.0F, 0.0F, -2.0F, 4, 12, 3, 0.0F, false));
		
		SpiderArm1 = new ModelRenderer(this);
		SpiderArm1.setRotationPoint(2.0F, -2.0F, 6.0F);
		villager.addChild(SpiderArm1);
		setRotationAngle(SpiderArm1, 0.0F, 0.5672F, 0.0F);
		
		SpiderArmLeft1 = new ModelRenderer(this);
		SpiderArmLeft1.setRotationPoint(4.0F, -15.0F, 0.0F);
		SpiderArm1.addChild(SpiderArmLeft1);
		setRotationAngle(SpiderArmLeft1, 1.4399F, 0.0F, 0.0F);
		SpiderArmLeft1.cubeList.add(new ModelBox(SpiderArmLeft1, 1, 22, -3.0F, -2.0F, 4.0F, 3, 8, 4, 0.0F, false));
		
		SpiderArmLeft3 = new ModelRenderer(this);
		SpiderArmLeft3.setRotationPoint(0.0F, 4.0F, 0.0F);
		SpiderArmLeft1.addChild(SpiderArmLeft3);
		setRotationAngle(SpiderArmLeft3, 2.0071F, 0.0F, 0.0F);
		
		SpideyLeg128_r1 = new ModelRenderer(this);
		SpideyLeg128_r1.setRotationPoint(-5.0F, 22.0F, 0.0F);
		SpiderArmLeft3.addChild(SpideyLeg128_r1);
		setRotationAngle(SpideyLeg128_r1, 0.2618F, 0.0F, 0.0F);
		SpideyLeg128_r1.cubeList.add(new ModelBox(SpideyLeg128_r1, 1, 22, 2.0F, -17.0F, 4.0F, 3, 5, 7, 0.0F, false));
		
		SpiderArmLeft6 = new ModelRenderer(this);
		SpiderArmLeft6.setRotationPoint(4.0F, -15.0F, 18.0F);
		SpiderArm1.addChild(SpiderArmLeft6);
		setRotationAngle(SpiderArmLeft6, 2.8802F, 0.0378F, 0.0218F);
		
		SpideyLeg135_r1 = new ModelRenderer(this);
		SpideyLeg135_r1.setRotationPoint(-5.0F, 22.0F, 0.0F);
		SpiderArmLeft6.addChild(SpideyLeg135_r1);
		setRotationAngle(SpideyLeg135_r1, 0.0F, 0.0436F, 0.0F);
		SpideyLeg135_r1.cubeList.add(new ModelBox(SpideyLeg135_r1, 1, 22, 2.0F, -14.0F, 4.0F, 3, 8, 4, 0.0F, false));
		
		SpiderArmLeft7 = new ModelRenderer(this);
		SpiderArmLeft7.setRotationPoint(4.0F, -15.0F, 18.0F);
		SpiderArm1.addChild(SpiderArmLeft7);
		setRotationAngle(SpiderArmLeft7, 2.8802F, 0.0378F, 0.0218F);
		
		SpideyLeg873_r1 = new ModelRenderer(this);
		SpideyLeg873_r1.setRotationPoint(-5.0F, 22.0F, 0.0F);
		SpiderArmLeft7.addChild(SpideyLeg873_r1);
		setRotationAngle(SpideyLeg873_r1, 0.7418F, 0.0436F, 0.0F);
		SpideyLeg873_r1.cubeList.add(new ModelBox(SpideyLeg873_r1, 1, 22, 3.0F, -2.0F, 7.0F, 1, 8, 4, 0.0F, false));
		
		SpiderArmLeft5 = new ModelRenderer(this);
		SpiderArmLeft5.setRotationPoint(4.0F, -13.0F, 5.0F);
		SpiderArm1.addChild(SpiderArmLeft5);
		setRotationAngle(SpiderArmLeft5, 2.0948F, 0.0378F, 0.0218F);
		
		SpideyLeg928_r1 = new ModelRenderer(this);
		SpideyLeg928_r1.setRotationPoint(-5.0F, 22.0F, 0.0F);
		SpiderArmLeft5.addChild(SpideyLeg928_r1);
		setRotationAngle(SpideyLeg928_r1, 0.0F, 0.0436F, 0.0F);
		SpideyLeg928_r1.cubeList.add(new ModelBox(SpideyLeg928_r1, 1, 22, 2.0F, -14.0F, 4.0F, 3, 7, 4, 0.0F, false));
		
		SpiderArmLeft4 = new ModelRenderer(this);
		SpiderArmLeft4.setRotationPoint(4.0F, -13.0F, 5.0F);
		SpiderArm1.addChild(SpiderArmLeft4);
		setRotationAngle(SpiderArmLeft4, 2.0948F, 0.0378F, 0.0218F);
		SpiderArmLeft4.cubeList.add(new ModelBox(SpiderArmLeft4, 1, 22, -3.0F, 5.0F, 4.0F, 3, 4, 4, 0.0F, false));
		
		SpiderArm2 = new ModelRenderer(this);
		SpiderArm2.setRotationPoint(-7.0F, -2.0F, 4.0F);
		villager.addChild(SpiderArm2);
		setRotationAngle(SpiderArm2, 0.0F, -0.48F, 0.0F);
		
		SpiderArmLeft2 = new ModelRenderer(this);
		SpiderArmLeft2.setRotationPoint(4.0F, -15.0F, 0.0F);
		SpiderArm2.addChild(SpiderArmLeft2);
		setRotationAngle(SpiderArmLeft2, 1.4399F, 0.0F, 0.0F);
		SpiderArmLeft2.cubeList.add(new ModelBox(SpiderArmLeft2, 1, 22, -3.0F, -2.0F, 4.0F, 3, 8, 4, 0.0F, false));
		
		SpiderArmLeft8 = new ModelRenderer(this);
		SpiderArmLeft8.setRotationPoint(0.0F, 4.0F, 0.0F);
		SpiderArmLeft2.addChild(SpiderArmLeft8);
		setRotationAngle(SpiderArmLeft8, 2.0071F, 0.0F, 0.0F);
		
		SpideyLeg788_r1 = new ModelRenderer(this);
		SpideyLeg788_r1.setRotationPoint(-5.0F, 22.0F, 0.0F);
		SpiderArmLeft8.addChild(SpideyLeg788_r1);
		setRotationAngle(SpideyLeg788_r1, 0.2618F, 0.0F, 0.0F);
		SpideyLeg788_r1.cubeList.add(new ModelBox(SpideyLeg788_r1, 1, 22, 2.0F, -17.0F, 4.0F, 3, 5, 7, 0.0F, false));
		
		SpiderArmLeft9 = new ModelRenderer(this);
		SpiderArmLeft9.setRotationPoint(4.0F, -15.0F, 18.0F);
		SpiderArm2.addChild(SpiderArmLeft9);
		setRotationAngle(SpiderArmLeft9, 2.8802F, 0.0378F, 0.0218F);
		
		SpideyLeg123_r1 = new ModelRenderer(this);
		SpideyLeg123_r1.setRotationPoint(-5.0F, 22.0F, 0.0F);
		SpiderArmLeft9.addChild(SpideyLeg123_r1);
		setRotationAngle(SpideyLeg123_r1, 0.0F, 0.0436F, 0.0F);
		SpideyLeg123_r1.cubeList.add(new ModelBox(SpideyLeg123_r1, 1, 22, 2.0F, -14.0F, 4.0F, 3, 8, 4, 0.0F, false));
		
		SpiderArmLeft10 = new ModelRenderer(this);
		SpiderArmLeft10.setRotationPoint(4.0F, -15.0F, 18.0F);
		SpiderArm2.addChild(SpiderArmLeft10);
		setRotationAngle(SpiderArmLeft10, 2.8802F, 0.0378F, 0.0218F);
		
		SpideyLeg456_r1 = new ModelRenderer(this);
		SpideyLeg456_r1.setRotationPoint(-5.0F, 22.0F, 0.0F);
		SpiderArmLeft10.addChild(SpideyLeg456_r1);
		setRotationAngle(SpideyLeg456_r1, 0.7418F, 0.0436F, 0.0F);
		SpideyLeg456_r1.cubeList.add(new ModelBox(SpideyLeg456_r1, 1, 22, 3.0F, -2.0F, 7.0F, 1, 8, 4, 0.0F, false));
		
		SpiderArmLeft11 = new ModelRenderer(this);
		SpiderArmLeft11.setRotationPoint(4.0F, -13.0F, 5.0F);
		SpiderArm2.addChild(SpiderArmLeft11);
		setRotationAngle(SpiderArmLeft11, 2.0948F, 0.0378F, 0.0218F);
		
		SpideyLeg789_r1 = new ModelRenderer(this);
		SpideyLeg789_r1.setRotationPoint(-5.0F, 22.0F, 0.0F);
		SpiderArmLeft11.addChild(SpideyLeg789_r1);
		setRotationAngle(SpideyLeg789_r1, 0.0F, 0.0436F, 0.0F);
		SpideyLeg789_r1.cubeList.add(new ModelBox(SpideyLeg789_r1, 1, 22, 2.0F, -14.0F, 4.0F, 3, 7, 4, 0.0F, false));
		
		SpiderArmLeft12 = new ModelRenderer(this);
		SpiderArmLeft12.setRotationPoint(4.0F, -13.0F, 5.0F);
		SpiderArm2.addChild(SpiderArmLeft12);
		setRotationAngle(SpiderArmLeft12, 2.0948F, 0.0378F, 0.0218F);
		SpiderArmLeft12.cubeList.add(new ModelBox(SpiderArmLeft12, 1, 22, -3.0F, 5.0F, 4.0F, 3, 4, 4, 0.0F, false));
		
		SpiderArm3 = new ModelRenderer(this);
		SpiderArm3.setRotationPoint(7.0F, -27.0F, -12.0F);
		villager.addChild(SpiderArm3);
		setRotationAngle(SpiderArm3, -1.5638F, -0.9064F, -1.4345F);
		
		SpiderArmLeft13 = new ModelRenderer(this);
		SpiderArmLeft13.setRotationPoint(4.0F, -15.0F, 0.0F);
		SpiderArm3.addChild(SpiderArmLeft13);
		setRotationAngle(SpiderArmLeft13, 1.4399F, 0.0F, 0.0F);
		SpiderArmLeft13.cubeList.add(new ModelBox(SpiderArmLeft13, 1, 22, -1.1674F, -2.1153F, 1.6276F, 3, 8, 4, 0.0F, false));
		
		SpiderArmLeft14 = new ModelRenderer(this);
		SpiderArmLeft14.setRotationPoint(0.0F, 4.0F, 0.0F);
		SpiderArmLeft13.addChild(SpiderArmLeft14);
		setRotationAngle(SpiderArmLeft14, 2.0071F, 0.0F, 0.0F);
		
		SpideyLeg998_r1 = new ModelRenderer(this);
		SpideyLeg998_r1.setRotationPoint(-5.0F, 22.0F, 0.0F);
		SpiderArmLeft14.addChild(SpideyLeg998_r1);
		setRotationAngle(SpideyLeg998_r1, 0.2618F, 0.0F, 0.0F);
		SpideyLeg998_r1.cubeList.add(new ModelBox(SpideyLeg998_r1, 1, 22, 3.8326F, -18.7432F, 5.6133F, 3, 5, 7, 0.0F, false));
		
		SpiderArmLeft15 = new ModelRenderer(this);
		SpiderArmLeft15.setRotationPoint(4.0F, -15.0F, 18.0F);
		SpiderArm3.addChild(SpiderArmLeft15);
		setRotationAngle(SpiderArmLeft15, 2.8802F, 0.0378F, 0.0218F);
		
		SpideyLeg997_r1 = new ModelRenderer(this);
		SpideyLeg997_r1.setRotationPoint(-5.0F, 22.0F, 0.0F);
		SpiderArmLeft15.addChild(SpideyLeg997_r1);
		setRotationAngle(SpideyLeg997_r1, 0.0F, 0.0F, 0.0F);
		SpideyLeg997_r1.cubeList.add(new ModelBox(SpideyLeg997_r1, 1, 22, 3.8979F, -16.3096F, 3.7471F, 3, 8, 4, 0.0F, false));
		
		SpiderArmLeft16 = new ModelRenderer(this);
		SpiderArmLeft16.setRotationPoint(4.0F, -15.0F, 18.0F);
		SpiderArm3.addChild(SpiderArmLeft16);
		setRotationAngle(SpiderArmLeft16, 2.8802F, 0.0378F, 0.0218F);
		
		SpideyLeg996_r1 = new ModelRenderer(this);
		SpideyLeg996_r1.setRotationPoint(-5.0F, 22.0F, 0.0F);
		SpiderArmLeft16.addChild(SpideyLeg996_r1);
		setRotationAngle(SpideyLeg996_r1, 0.7418F, 0.0436F, 0.0F);
		SpideyLeg996_r1.cubeList.add(new ModelBox(SpideyLeg996_r1, 1, 22, 4.9071F, -3.8175F, 8.4351F, 1, 8, 4, 0.0F, false));
		
		SpiderArmLeft17 = new ModelRenderer(this);
		SpiderArmLeft17.setRotationPoint(4.0F, -13.0F, 5.0F);
		SpiderArm3.addChild(SpiderArmLeft17);
		setRotationAngle(SpiderArmLeft17, 2.0948F, 0.0378F, 0.0218F);
		
		SpideyLeg995_r1 = new ModelRenderer(this);
		SpideyLeg995_r1.setRotationPoint(-5.0F, 22.0F, 0.0F);
		SpiderArmLeft17.addChild(SpideyLeg995_r1);
		setRotationAngle(SpideyLeg995_r1, 0.0F, 0.0436F, 0.0F);
		SpideyLeg995_r1.cubeList.add(new ModelBox(SpideyLeg995_r1, 1, 22, 3.9751F, -15.4543F, 2.2726F, 3, 7, 4, 0.0F, false));
		
		SpiderArmLeft18 = new ModelRenderer(this);
		SpiderArmLeft18.setRotationPoint(4.0F, -13.0F, 5.0F);
		SpiderArm3.addChild(SpiderArmLeft18);
		setRotationAngle(SpiderArmLeft18, 2.0948F, 0.0378F, 0.0218F);
		SpiderArmLeft18.cubeList.add(new ModelBox(SpiderArmLeft18, 1, 22, -1.1021F, 3.5457F, 2.1881F, 3, 4, 4, 0.0F, false));
		
		SpiderArm4 = new ModelRenderer(this);
		SpiderArm4.setRotationPoint(-6.0F, -28.0F, -11.0F);
		villager.addChild(SpiderArm4);
		setRotationAngle(SpiderArm4, -1.7691F, 0.6964F, 1.2365F);
		
		SpiderArmLeft19 = new ModelRenderer(this);
		SpiderArmLeft19.setRotationPoint(4.0F, -15.0F, 0.0F);
		SpiderArm4.addChild(SpiderArmLeft19);
		setRotationAngle(SpiderArmLeft19, 1.4399F, 0.0F, 0.0F);
		SpiderArmLeft19.cubeList.add(new ModelBox(SpiderArmLeft19, 1, 22, -5.1741F, -2.3437F, 1.9616F, 3, 8, 4, 0.0F, false));
		
		SpiderArmLeft20 = new ModelRenderer(this);
		SpiderArmLeft20.setRotationPoint(0.0F, 4.0F, 0.0F);
		SpiderArmLeft19.addChild(SpiderArmLeft20);
		setRotationAngle(SpiderArmLeft20, 2.0071F, 0.0F, 0.0F);
		
		SpideyLeg998_r2 = new ModelRenderer(this);
		SpideyLeg998_r2.setRotationPoint(-5.0F, 22.0F, 0.0F);
		SpiderArmLeft20.addChild(SpideyLeg998_r2);
		setRotationAngle(SpideyLeg998_r2, 0.2618F, 0.0F, 0.0F);
		SpideyLeg998_r2.cubeList.add(new ModelBox(SpideyLeg998_r2, 1, 22, -0.1741F, -18.3405F, 5.5736F, 3, 5, 7, 0.0F, false));
		
		SpiderArmLeft21 = new ModelRenderer(this);
		SpiderArmLeft21.setRotationPoint(4.0F, -15.0F, 18.0F);
		SpiderArm4.addChild(SpiderArmLeft21);
		setRotationAngle(SpiderArmLeft21, 2.8802F, 0.0378F, 0.0218F);
		
		SpideyLeg121_r1 = new ModelRenderer(this);
		SpideyLeg121_r1.setRotationPoint(-5.0F, 22.0F, 0.0F);
		SpiderArmLeft21.addChild(SpideyLeg121_r1);
		setRotationAngle(SpideyLeg121_r1, 0.0F, 0.0F, 0.0F);
		SpideyLeg121_r1.cubeList.add(new ModelBox(SpideyLeg121_r1, 1, 22, -0.106F, -16.1318F, 4.1408F, 3, 8, 4, 0.0F, false));
		
		SpiderArmLeft22 = new ModelRenderer(this);
		SpiderArmLeft22.setRotationPoint(4.0F, -15.0F, 18.0F);
		SpiderArm4.addChild(SpiderArmLeft22);
		setRotationAngle(SpiderArmLeft22, 2.8802F, 0.0378F, 0.0218F);
		
		SpideyLeg122_r1 = new ModelRenderer(this);
		SpideyLeg122_r1.setRotationPoint(-5.0F, 22.0F, 0.0F);
		SpiderArmLeft22.addChild(SpideyLeg122_r1);
		setRotationAngle(SpideyLeg122_r1, 0.7418F, 0.0436F, 0.0F);
		SpideyLeg122_r1.cubeList.add(new ModelBox(SpideyLeg122_r1, 1, 22, 0.8898F, -3.5388F, 8.4762F, 1, 8, 4, 0.0F, false));
		
		SpiderArmLeft23 = new ModelRenderer(this);
		SpiderArmLeft23.setRotationPoint(4.0F, -13.0F, 5.0F);
		SpiderArm4.addChild(SpiderArmLeft23);
		setRotationAngle(SpiderArmLeft23, 2.0948F, 0.0378F, 0.0218F);
		
		SpideyLeg12345_r1 = new ModelRenderer(this);
		SpideyLeg12345_r1.setRotationPoint(-5.0F, 22.0F, 0.0F);
		SpiderArmLeft23.addChild(SpideyLeg12345_r1);
		setRotationAngle(SpideyLeg12345_r1, 0.0F, 0.0436F, 0.0F);
		SpideyLeg12345_r1.cubeList.add(new ModelBox(SpideyLeg12345_r1, 1, 22, -0.0426F, -15.607F, 2.5016F, 3, 7, 4, 0.0F, false));
		
		SpiderArmLeft24 = new ModelRenderer(this);
		SpiderArmLeft24.setRotationPoint(4.0F, -13.0F, 5.0F);
		SpiderArm4.addChild(SpiderArmLeft24);
		setRotationAngle(SpiderArmLeft24, 2.0948F, 0.0378F, 0.0218F);
		SpiderArmLeft24.cubeList.add(new ModelBox(SpiderArmLeft24, 1, 22, -5.106F, 3.393F, 2.5921F, 3, 4, 4, 0.0F, false));
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		villager.render(f5);
	}
	
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		boolean flag = (entityIn instanceof EntityLivingBase) && (((EntityLivingBase) entityIn).getTicksElytraFlying() > 4);
		float f = 1.0F;
		
		if (flag) {
			f = (float) (entityIn.motionX * entityIn.motionX + entityIn.motionY * entityIn.motionY + entityIn.motionZ * entityIn.motionZ);
			f = f / 0.2F;
			f = f * f * f;
		}
		
		if (f < 1.0F) {
			f = 1.0F;
		}
		
		this.Head.rotateAngleY = netHeadYaw * 0.017453292F;
		this.Head.rotateAngleX = headPitch * 0.017453292F;
		
		this.LeftArm.rotationPointZ = 0.0F;
		this.LeftArm.rotationPointX = 5.0F;
		this.LeftArm.rotateAngleX = -0.75F;
		this.RightArm.rotationPointZ = 0.0F;
		this.RightArm.rotationPointX = -5.0F;
		this.RightArm.rotateAngleX = -0.75F;
		
		this.RightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.0F * limbSwingAmount * 0.5F / f;
		this.LeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f;
		this.LeftArm.rotateAngleZ = 0.0F;
		this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
		this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount / f;
		this.RightLeg.rotateAngleY = 0.0F;
		this.LeftLeg.rotateAngleY = 0.0F;
		this.RightLeg.rotateAngleZ = 0.0F;
		this.LeftLeg.rotateAngleZ = 0.0F;
		
		this.RightArm.rotateAngleY = 0.0F;
		this.RightArm.rotateAngleZ = 0.0F;
		
		if (this.swingProgress > 0.0F) {
			EnumHandSide enumhandside = EnumHandSide.LEFT;
			ModelRenderer modelrenderer = this.LeftArm;
			float f1 = this.swingProgress;
			this.Body.rotateAngleY = MathHelper.sin(MathHelper.sqrt(f1) * ((float) Math.PI * 2F)) * 0.2F;
			
			if (enumhandside == EnumHandSide.LEFT) {
				this.Body.rotateAngleY *= -1.0F;
			}
			
			this.RightArm.rotationPointZ = MathHelper.sin(this.Body.rotateAngleY) * 5.0F;
			this.RightArm.rotationPointX = -MathHelper.cos(this.Body.rotateAngleY) * 5.0F;
			this.LeftArm.rotationPointZ = -MathHelper.sin(this.Body.rotateAngleY) * 5.0F;
			this.LeftArm.rotationPointX = MathHelper.cos(this.Body.rotateAngleY) * 5.0F;
			this.RightArm.rotateAngleY += this.Body.rotateAngleY;
			this.LeftArm.rotateAngleY += this.Body.rotateAngleY;
			this.LeftArm.rotateAngleX += this.Body.rotateAngleY;
			f1 = 1.0F - this.swingProgress;
			f1 = f1 * f1;
			f1 = f1 * f1;
			f1 = 1.0F - f1;
			float f2 = MathHelper.sin(f1 * (float) Math.PI);
			float f3 = MathHelper.sin(this.swingProgress * (float) Math.PI) * -(this.Head.rotateAngleX - 0.7F) * 0.75F;
			modelrenderer.rotateAngleX = (float) (modelrenderer.rotateAngleX - (f2 * 1.2D + f3));
			modelrenderer.rotateAngleY += this.Body.rotateAngleY * 2.0F;
			modelrenderer.rotateAngleZ += MathHelper.sin(this.swingProgress * (float) Math.PI) * -0.4F;
		}
		
		this.RightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.LeftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.RightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		this.LeftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}