/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.models.boss;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.MathHelper;

public class ModelVexbotBoss extends ModelBase {
	
	private final ModelRenderer vexbotBoss;
	private final ModelRenderer Head;
	private final ModelRenderer BackHeadThingCollection;
	private final ModelRenderer BackHeadThings1;
	private final ModelRenderer BackHeadThing1;
	private final ModelRenderer xCube3_r1;
	private final ModelRenderer xCube2_r1;
	private final ModelRenderer xCube1_r1;
	private final ModelRenderer BackHeadThing2;
	private final ModelRenderer xCube6_r1;
	private final ModelRenderer xCube5_r1;
	private final ModelRenderer xCube4_r1;
	private final ModelRenderer BackHeadThing3;
	private final ModelRenderer xCube9_r1;
	private final ModelRenderer xCube8_r1;
	private final ModelRenderer xCube7_r1;
	private final ModelRenderer BackHeadThings2;
	private final ModelRenderer BackHeadThing4;
	private final ModelRenderer xCube12_r1;
	private final ModelRenderer xCube11_r1;
	private final ModelRenderer xCube10_r1;
	private final ModelRenderer BackHeadThing5;
	private final ModelRenderer xCube15_r1;
	private final ModelRenderer xCube14_r1;
	private final ModelRenderer xCube13_r1;
	private final ModelRenderer BackHeadThing6;
	private final ModelRenderer xCube18_r1;
	private final ModelRenderer xCube17_r1;
	private final ModelRenderer xCube16_r1;
	private final ModelRenderer Antennae;
	private final ModelRenderer RightAntenna2_r1;
	private final ModelRenderer RightAntenna_r1;
	private final ModelRenderer LeftAntenna2_r1;
	private final ModelRenderer LeftAntenna_r1;
	private final ModelRenderer Body;
	private final ModelRenderer hipCube_r1;
	private final ModelRenderer RightArm;
	private final ModelRenderer RightArm3_r1;
	private final ModelRenderer RightArm2_r1;
	private final ModelRenderer RightArm_r1;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftArm3_r1;
	private final ModelRenderer LeftArm2_r1;
	private final ModelRenderer LeftArm_r1;
	private final ModelRenderer RightLeg;
	private final ModelRenderer RightFoot_r1;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer LeftFoot_r1;
	
	public ModelVexbotBoss() {
		textureWidth = 64;
		textureHeight = 64;
		
		vexbotBoss = new ModelRenderer(this);
		vexbotBoss.setRotationPoint(0.0F, 24.0F, 0.0F);
		
		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -42.0F, 0.0F);
		vexbotBoss.addChild(Head);
		Head.cubeList.add(new ModelBox(Head, 0, 0, -4.0F, -44.0F, -13.0F, 8, 20, 8, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 38, 43, -3.0F, -33.0F, -2.0F, 6, 26, 4, 0.0F, false));
		
		BackHeadThingCollection = new ModelRenderer(this);
		BackHeadThingCollection.setRotationPoint(-18.0F, -42.0F, 18.0F);
		Head.addChild(BackHeadThingCollection);
		setRotationAngle(BackHeadThingCollection, 3.1416F, 0.0F, 0.0F);
		
		BackHeadThings1 = new ModelRenderer(this);
		BackHeadThings1.setRotationPoint(18.0F, -25.0F, -4.0F);
		BackHeadThingCollection.addChild(BackHeadThings1);
		setRotationAngle(BackHeadThings1, 0.0873F, 0.0F, 0.0F);
		
		BackHeadThing1 = new ModelRenderer(this);
		BackHeadThing1.setRotationPoint(0.0F, 22.0F, -3.0F);
		BackHeadThings1.addChild(BackHeadThing1);
		
		xCube3_r1 = new ModelRenderer(this);
		xCube3_r1.setRotationPoint(-1.0F, 0.0F, 0.0F);
		BackHeadThing1.addChild(xCube3_r1);
		setRotationAngle(xCube3_r1, -0.2233F, -0.2129F, 0.0479F);
		xCube3_r1.cubeList.add(new ModelBox(xCube3_r1, 32, 47, 3.3668F, -23.9719F, -0.8349F, 9, 25, 14, 0.0F, false));
		
		xCube2_r1 = new ModelRenderer(this);
		xCube2_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		BackHeadThing1.addChild(xCube2_r1);
		setRotationAngle(xCube2_r1, -0.2317F, 0.3405F, -0.0786F);
		xCube2_r1.cubeList.add(new ModelBox(xCube2_r1, 32, 47, -11.1598F, -23.9719F, -1.066F, 9, 25, 14, 0.0F, false));
		
		xCube1_r1 = new ModelRenderer(this);
		xCube1_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		BackHeadThing1.addChild(xCube1_r1);
		setRotationAngle(xCube1_r1, -0.2182F, 0.0F, 0.0F);
		xCube1_r1.cubeList.add(new ModelBox(xCube1_r1, 32, 47, -5.0F, -23.9719F, 0.3148F, 11, 25, 14, 0.0F, false));
		
		BackHeadThing2 = new ModelRenderer(this);
		BackHeadThing2.setRotationPoint(14.0F, 22.0F, 1.0F);
		BackHeadThings1.addChild(BackHeadThing2);
		setRotationAngle(BackHeadThing2, 0.0F, -0.6545F, 0.0F);
		
		xCube6_r1 = new ModelRenderer(this);
		xCube6_r1.setRotationPoint(-1.0F, 0.0F, 0.0F);
		BackHeadThing2.addChild(xCube6_r1);
		setRotationAngle(xCube6_r1, -0.2233F, -0.2129F, 0.0479F);
		xCube6_r1.cubeList.add(new ModelBox(xCube6_r1, 32, 47, 4.3746F, -23.8901F, -1.4365F, 9, 25, 14, 0.0F, false));
		
		xCube5_r1 = new ModelRenderer(this);
		xCube5_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		BackHeadThing2.addChild(xCube5_r1);
		setRotationAngle(xCube5_r1, -0.2317F, 0.3405F, -0.0786F);
		xCube5_r1.cubeList.add(new ModelBox(xCube5_r1, 32, 47, -9.9865F, -23.8901F, -1.0319F, 9, 25, 14, 0.0F, false));
		
		xCube4_r1 = new ModelRenderer(this);
		xCube4_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		BackHeadThing2.addChild(xCube4_r1);
		setRotationAngle(xCube4_r1, -0.2182F, 0.0F, 0.0F);
		xCube4_r1.cubeList.add(new ModelBox(xCube4_r1, 32, 47, -3.8858F, -23.8901F, -0.0544F, 11, 25, 14, 0.0F, false));
		
		BackHeadThing3 = new ModelRenderer(this);
		BackHeadThing3.setRotationPoint(-17.0F, 22.0F, 3.0F);
		BackHeadThings1.addChild(BackHeadThing3);
		setRotationAngle(BackHeadThing3, 0.0F, 0.6545F, 0.0F);
		
		xCube9_r1 = new ModelRenderer(this);
		xCube9_r1.setRotationPoint(-1.0F, 0.0F, 0.0F);
		BackHeadThing3.addChild(xCube9_r1);
		setRotationAngle(xCube9_r1, -0.2233F, -0.2129F, 0.0479F);
		xCube9_r1.cubeList.add(new ModelBox(xCube9_r1, 32, 47, 2.1991F, -23.8901F, -0.9542F, 9, 25, 14, 0.0F, false));
		
		xCube8_r1 = new ModelRenderer(this);
		xCube8_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		BackHeadThing3.addChild(xCube8_r1);
		setRotationAngle(xCube8_r1, -0.2317F, 0.3405F, -0.0786F);
		xCube8_r1.cubeList.add(new ModelBox(xCube8_r1, 32, 47, -12.0805F, -23.8901F, -1.7941F, 9, 25, 14, 0.0F, false));
		
		xCube7_r1 = new ModelRenderer(this);
		xCube7_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		BackHeadThing3.addChild(xCube7_r1);
		setRotationAngle(xCube7_r1, -0.2182F, 0.0F, 0.0F);
		xCube7_r1.cubeList.add(new ModelBox(xCube7_r1, 32, 47, -6.1142F, -23.8901F, -0.0544F, 11, 25, 14, 0.0F, false));
		
		BackHeadThings2 = new ModelRenderer(this);
		BackHeadThings2.setRotationPoint(18.0F, -22.0F, -4.0F);
		BackHeadThingCollection.addChild(BackHeadThings2);
		setRotationAngle(BackHeadThings2, 0.3927F, 0.0F, 0.0F);
		
		BackHeadThing4 = new ModelRenderer(this);
		BackHeadThing4.setRotationPoint(0.0F, 22.0F, -3.0F);
		BackHeadThings2.addChild(BackHeadThing4);
		
		xCube12_r1 = new ModelRenderer(this);
		xCube12_r1.setRotationPoint(-1.0F, 0.0F, 0.0F);
		BackHeadThing4.addChild(xCube12_r1);
		setRotationAngle(xCube12_r1, -0.2233F, -0.2129F, 0.0479F);
		xCube12_r1.cubeList.add(new ModelBox(xCube12_r1, 32, 47, 3.5021F, -23.9137F, -0.2244F, 9, 25, 26, 0.0F, false));
		
		xCube11_r1 = new ModelRenderer(this);
		xCube11_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		BackHeadThing4.addChild(xCube11_r1);
		setRotationAngle(xCube11_r1, -0.2317F, 0.3405F, -0.0786F);
		xCube11_r1.cubeList.add(new ModelBox(xCube11_r1, 32, 47, -11.3737F, -23.9137F, -0.4784F, 9, 25, 26, 0.0F, false));
		
		xCube10_r1 = new ModelRenderer(this);
		xCube10_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		BackHeadThing4.addChild(xCube10_r1);
		setRotationAngle(xCube10_r1, -0.2182F, 0.0F, 0.0F);
		xCube10_r1.cubeList.add(new ModelBox(xCube10_r1, 32, 47, -5.0F, -23.9137F, 0.9401F, 11, 25, 26, 0.0F, false));
		
		BackHeadThing5 = new ModelRenderer(this);
		BackHeadThing5.setRotationPoint(14.0F, 22.0F, 1.0F);
		BackHeadThings2.addChild(BackHeadThing5);
		setRotationAngle(BackHeadThing5, 0.0F, -0.6545F, 0.0F);
		
		xCube15_r1 = new ModelRenderer(this);
		xCube15_r1.setRotationPoint(-1.0F, 0.0F, 0.0F);
		BackHeadThing5.addChild(xCube15_r1);
		setRotationAngle(xCube15_r1, -0.2233F, -0.2129F, 0.0479F);
		xCube15_r1.cubeList.add(new ModelBox(xCube15_r1, 32, 47, 4.8392F, -23.8051F, -1.0226F, 9, 25, 26, 0.0F, false));
		
		xCube14_r1 = new ModelRenderer(this);
		xCube14_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		BackHeadThing5.addChild(xCube14_r1);
		setRotationAngle(xCube14_r1, -0.2317F, 0.3405F, -0.0786F);
		xCube14_r1.cubeList.add(new ModelBox(xCube14_r1, 32, 47, -9.8171F, -23.8051F, -0.4332F, 9, 25, 26, 0.0F, false));
		
		xCube13_r1 = new ModelRenderer(this);
		xCube13_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		BackHeadThing5.addChild(xCube13_r1);
		setRotationAngle(xCube13_r1, -0.2182F, 0.0F, 0.0F);
		xCube13_r1.cubeList.add(new ModelBox(xCube13_r1, 32, 47, -3.5218F, -23.8051F, 0.4502F, 11, 25, 26, 0.0F, false));
		
		BackHeadThing6 = new ModelRenderer(this);
		BackHeadThing6.setRotationPoint(-17.0F, 22.0F, 3.0F);
		BackHeadThings2.addChild(BackHeadThing6);
		setRotationAngle(BackHeadThing6, 0.0F, 0.6545F, 0.0F);
		
		xCube18_r1 = new ModelRenderer(this);
		xCube18_r1.setRotationPoint(-1.0F, 0.0F, 0.0F);
		BackHeadThing6.addChild(xCube18_r1);
		setRotationAngle(xCube18_r1, -0.2233F, -0.2129F, 0.0479F);
		xCube18_r1.cubeList.add(new ModelBox(xCube18_r1, 32, 47, 1.953F, -23.8051F, -0.3827F, 9, 25, 26, 0.0F, false));
		
		xCube17_r1 = new ModelRenderer(this);
		xCube17_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		BackHeadThing6.addChild(xCube17_r1);
		setRotationAngle(xCube17_r1, -0.2317F, 0.3405F, -0.0786F);
		xCube17_r1.cubeList.add(new ModelBox(xCube17_r1, 12, 36, -12.5951F, -23.8051F, -1.4443F, 9, 25, 26, 0.0F, false));
		
		xCube16_r1 = new ModelRenderer(this);
		xCube16_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		BackHeadThing6.addChild(xCube16_r1);
		setRotationAngle(xCube16_r1, -0.2182F, 0.0F, 0.0F);
		xCube16_r1.cubeList.add(new ModelBox(xCube16_r1, 32, 47, -6.4782F, -23.8051F, 0.4502F, 11, 25, 26, 0.0F, false));
		
		Antennae = new ModelRenderer(this);
		Antennae.setRotationPoint(1.0F, -33.0F, 0.0F);
		Head.addChild(Antennae);
		
		RightAntenna2_r1 = new ModelRenderer(this);
		RightAntenna2_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Antennae.addChild(RightAntenna2_r1);
		setRotationAngle(RightAntenna2_r1, 1.194F, 0.892F, 1.5247F);
		RightAntenna2_r1.cubeList.add(new ModelBox(RightAntenna2_r1, 33, 39, -10.0F, -34.0F, 0.0F, 5, 21, 3, 0.0F, false));
		
		RightAntenna_r1 = new ModelRenderer(this);
		RightAntenna_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Antennae.addChild(RightAntenna_r1);
		setRotationAngle(RightAntenna_r1, 1.248F, -1.4329F, -1.2509F);
		RightAntenna_r1.cubeList.add(new ModelBox(RightAntenna_r1, 33, 39, 0.0F, -24.0F, -8.0F, 5, 21, 5, 0.0F, false));
		
		LeftAntenna2_r1 = new ModelRenderer(this);
		LeftAntenna2_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Antennae.addChild(LeftAntenna2_r1);
		setRotationAngle(LeftAntenna2_r1, 1.3504F, 0.833F, 1.2716F);
		LeftAntenna2_r1.cubeList.add(new ModelBox(LeftAntenna2_r1, 33, 39, -14.0F, -32.0F, -7.0F, 5, 21, 3, 0.0F, false));
		
		LeftAntenna_r1 = new ModelRenderer(this);
		LeftAntenna_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Antennae.addChild(LeftAntenna_r1);
		setRotationAngle(LeftAntenna_r1, 0.7681F, 1.2027F, 0.8027F);
		LeftAntenna_r1.cubeList.add(new ModelBox(LeftAntenna_r1, 33, 39, -8.0F, -24.0F, -9.0F, 5, 21, 5, 0.0F, false));
		
		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, -24.0F, 0.0F);
		vexbotBoss.addChild(Body);
		Body.cubeList.add(new ModelBox(Body, 6, 12, -6.0F, -34.75F, -10.0F, 12, 27, 14, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 36, 47, -2.0F, -19.75F, -2.0F, 4, 18, 4, 0.0F, false));
		
		hipCube_r1 = new ModelRenderer(this);
		hipCube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(hipCube_r1);
		setRotationAngle(hipCube_r1, -0.2182F, 0.0F, 0.0F);
		hipCube_r1.cubeList.add(new ModelBox(hipCube_r1, 27, 44, -6.0F, -13.0F, -4.0F, 12, 15, 7, 0.0F, false));
		
		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-7.0F, -22.0F, 0.0F);
		vexbotBoss.addChild(RightArm);
		
		RightArm3_r1 = new ModelRenderer(this);
		RightArm3_r1.setRotationPoint(5.0F, -13.0F, -5.0F);
		RightArm.addChild(RightArm3_r1);
		setRotationAngle(RightArm3_r1, -1.2654F, 0.0F, 0.0F);
		RightArm3_r1.cubeList.add(new ModelBox(RightArm3_r1, 32, 43, -13.0F, -9.0F, -10.0F, 11, 40, 4, 0.0F, false));
		
		RightArm2_r1 = new ModelRenderer(this);
		RightArm2_r1.setRotationPoint(5.0F, -13.0F, -5.0F);
		RightArm.addChild(RightArm2_r1);
		setRotationAngle(RightArm2_r1, -0.6545F, 0.0F, 0.0F);
		RightArm2_r1.cubeList.add(new ModelBox(RightArm2_r1, 32, 43, -13.0F, -22.0F, -8.0F, 11, 40, 4, 0.0F, false));
		
		RightArm_r1 = new ModelRenderer(this);
		RightArm_r1.setRotationPoint(5.0F, -13.0F, -5.0F);
		RightArm.addChild(RightArm_r1);
		setRotationAngle(RightArm_r1, -0.1745F, 0.0F, 0.0F);
		RightArm_r1.cubeList.add(new ModelBox(RightArm_r1, 32, 43, -13.0F, -33.0F, -1.0F, 11, 42, 4, 0.0F, false));
		
		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(7.0F, -22.0F, 0.0F);
		vexbotBoss.addChild(LeftArm);
		
		LeftArm3_r1 = new ModelRenderer(this);
		LeftArm3_r1.setRotationPoint(-5.0F, -13.0F, -5.0F);
		LeftArm.addChild(LeftArm3_r1);
		setRotationAngle(LeftArm3_r1, -1.2654F, 0.0F, 0.0F);
		LeftArm3_r1.cubeList.add(new ModelBox(LeftArm3_r1, 32, 43, 2.0F, -9.0F, -10.0F, 11, 40, 4, 0.0F, false));
		
		LeftArm2_r1 = new ModelRenderer(this);
		LeftArm2_r1.setRotationPoint(7.0F, -13.0F, -5.0F);
		LeftArm.addChild(LeftArm2_r1);
		setRotationAngle(LeftArm2_r1, -0.6545F, 0.0F, 0.0F);
		LeftArm2_r1.cubeList.add(new ModelBox(LeftArm2_r1, 32, 43, -10.0F, -22.0F, -8.0F, 11, 40, 3, 0.0F, false));
		
		LeftArm_r1 = new ModelRenderer(this);
		LeftArm_r1.setRotationPoint(-5.0F, -13.0F, -5.0F);
		LeftArm.addChild(LeftArm_r1);
		setRotationAngle(LeftArm_r1, -0.1745F, 0.0F, 0.0F);
		LeftArm_r1.cubeList.add(new ModelBox(LeftArm_r1, 32, 43, 2.0F, -33.0F, -1.0F, 11, 42, 3, 0.0F, false));
		
		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-1.9F, -12.0F, 0.0F);
		vexbotBoss.addChild(RightLeg);
		RightLeg.cubeList.add(new ModelBox(RightLeg, 32, 38, -7.1F, -23.0F, -4.0F, 7, 33, 6, 0.0F, true));
		
		RightFoot_r1 = new ModelRenderer(this);
		RightFoot_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		RightLeg.addChild(RightFoot_r1);
		setRotationAngle(RightFoot_r1, 0.3054F, 0.0F, 0.0F);
		RightFoot_r1.cubeList.add(new ModelBox(RightFoot_r1, 26, 46, -7.0F, -5.0F, -15.0F, 7, 15, 20, 0.0F, false));
		
		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(1.9F, -12.0F, 0.0F);
		vexbotBoss.addChild(LeftLeg);
		LeftLeg.cubeList.add(new ModelBox(LeftLeg, 32, 38, 0.0F, -23.0F, -4.0F, 7, 33, 6, 0.0F, false));
		
		LeftFoot_r1 = new ModelRenderer(this);
		LeftFoot_r1.setRotationPoint(-3.8F, 0.0F, 0.0F);
		LeftLeg.addChild(LeftFoot_r1);
		setRotationAngle(LeftFoot_r1, 0.3054F, 0.0F, 0.0F);
		LeftFoot_r1.cubeList.add(new ModelBox(LeftFoot_r1, 26, 46, 4.0F, -5.0F, -15.0F, 7, 15, 21, 0.0F, false));
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		vexbotBoss.render(f5);
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
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
}