package com.hikvision.vqd.entity;

/**
 * Copyright: Copyright (c) 2012-2014 Company:
 * Hikvision(http://www.hikvision.com)
 * 
 * @author：sunxiaobo
 * @Date: 2013-2-21 下午04:34:50
 * @describe：检测项是否被勾中
 */
public class CheckType {

	/**
	 * 图像丢失
	 */
	private boolean signal;

	/**
	 * 图像模糊
	 */
	private boolean blur;

	/**
	 * 对比度
	 */
	private boolean contrast;

	/**
	 * 图像过亮
	 */
	private boolean bright;

	/**
	 * 图像过暗
	 */
	private boolean dark;

	/**
	 * 图像偏色
	 */
	private boolean chroma;

	/**
	 * 黑白图像
	 */
	private boolean mono;

	/**
	 * 噪声干扰
	 */
	private boolean noise;

	/**
	 * 条纹干扰
	 */
	private boolean streak;

	/**
	 * 画面冻结
	 */
	private boolean freeze;

	/**
	 * 视频抖动
	 */
	private boolean shake;

	/**
	 * 视频剧变
	 */
	private boolean flash;

	/**
	 * 场景变换
	 */
	private boolean scene;

	/**
	 * 视频遮挡
	 */
	private boolean cover;
	/**
	 * 云台异常
	 */
	private boolean ptz;
	
	public CheckType(){
		
	}
	
	public CheckType(boolean signal, boolean blur, boolean contrast,
			boolean bright, boolean dark, boolean chroma, boolean mono,
			boolean noise, boolean streak, boolean freeze, boolean shake,
			boolean flash, boolean scene, boolean cover, boolean ptz) {
		this.signal = signal;
		this.blur = blur;
		this.contrast = contrast;
		this.bright = bright;
		this.dark = dark;
		this.chroma = chroma;
		this.mono = mono;
		this.noise = noise;
		this.streak = streak;
		this.freeze = freeze;
		this.shake = shake;
		this.flash = flash;
		this.scene = scene;
		this.cover = cover;
		this.ptz = ptz;

	}

	public boolean isSignal() {
		return signal;
	}

	public void setSignal(boolean signal) {
		this.signal = signal;
	}

	public boolean isBlur() {
		return blur;
	}

	public void setBlur(boolean blur) {
		this.blur = blur;
	}

	public boolean isContrast() {
		return contrast;
	}

	public void setContrast(boolean contrast) {
		this.contrast = contrast;
	}

	public boolean isBright() {
		return bright;
	}

	public void setBright(boolean bright) {
		this.bright = bright;
	}

	public boolean isDark() {
		return dark;
	}

	public void setDark(boolean dark) {
		this.dark = dark;
	}

	public boolean isChroma() {
		return chroma;
	}

	public void setChroma(boolean chroma) {
		this.chroma = chroma;
	}

	public boolean isMono() {
		return mono;
	}

	public void setMono(boolean mono) {
		this.mono = mono;
	}

	public boolean isNoise() {
		return noise;
	}

	public void setNoise(boolean noise) {
		this.noise = noise;
	}

	public boolean isStreak() {
		return streak;
	}

	public void setStreak(boolean streak) {
		this.streak = streak;
	}

	public boolean isFreeze() {
		return freeze;
	}

	public void setFreeze(boolean freeze) {
		this.freeze = freeze;
	}

	public boolean isShake() {
		return shake;
	}

	public void setShake(boolean shake) {
		this.shake = shake;
	}

	public boolean isFlash() {
		return flash;
	}

	public void setFlash(boolean flash) {
		this.flash = flash;
	}

	public boolean isScene() {
		return scene;
	}

	public void setScene(boolean scene) {
		this.scene = scene;
	}

	public boolean isCover() {
		return cover;
	}

	public void setCover(boolean cover) {
		this.cover = cover;
	}

	public boolean isPtz() {
		return ptz;
	}

	public void setPtz(boolean ptz) {
		this.ptz = ptz;
	}

}
