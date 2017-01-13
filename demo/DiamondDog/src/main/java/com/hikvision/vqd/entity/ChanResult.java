/**
 * 
 */
package com.hikvision.vqd.entity;

/**
 * Copyright: Copyright (c) 2012-2014 Company:
 * Hikvision(http://www.hikvision.com)
 * 
 * @author：sunxiaobo
 * @Date: 2013-3-11 下午03:36:41
 * @describe：VQD检测结果
 */
public class ChanResult {

	/**
	 * 监控点ID
	 */
	public String id;

	/**
	 * 通道IP
	 */
	public String ip;

	/**
	 * 通道号
	 */
	public String chanIndex;

	/**
	 * 图像宽度
	 */
	public String width;

	/**
	 * 图像高度
	 */
	public String height;

	/**
	 * 检查时间
	 */
	public String checkTime;

	/**
	 * 检测结果 0-未检测 1-正常 2-异常 3-登录失败 4-取流异常
	 */
	public String result;

	/**
	 * 视频丢失检测结果 0-未检测 1-正常 2-异常
	 */
	public String resultOfSignal;

	/**
	 * 图像模糊
	 */
	public String resultOfBlur;

	/**
	 * 对比度
	 */
	public String resultOfContrast;

	/**
	 * 图像过亮
	 */
	public String resultOfBright;

	/**
	 * 图像过暗
	 */
	public String resultOfDark;

	/**
	 * 图像偏色
	 */
	public String resultOfChroma;

	/**
	 * 黑白图像
	 */
	public String resultOfMono;

	/**
	 * 噪声干扰
	 */
	public String resultOfNoise;

	/**
	 * 条纹干扰
	 */
	public String resultOfStreak;

	/**
	 * 画面冻结
	 */
	public String resultOfFreeze;

	/**
	 * 视频抖动
	 */
	public String resultOfShake;

	/**
	 * 视频剧变
	 */
	public String resultOfFlash;

	/**
	 * 场景变换
	 */
	public String resultOfScene;

	/**
	 * 视频遮挡
	 */
	public String resultOfCover;

	/**
	 * 云台异常
	 */
	public String resultOfPTZ;

	/**
	 * 检测时的图片
	 */
	public String snapshotURL;

	/**
	 * 国标码流检测结果
	 */
	public String videoType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getChanIndex() {
		return chanIndex;
	}

	public void setChanIndex(String chanIndex) {
		this.chanIndex = chanIndex;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResultOfSignal() {
		return resultOfSignal;
	}

	public void setResultOfSignal(String resultOfSignal) {
		this.resultOfSignal = resultOfSignal;
	}

	public String getResultOfBlur() {
		return resultOfBlur;
	}

	public void setResultOfBlur(String resultOfBlur) {
		this.resultOfBlur = resultOfBlur;
	}

	public String getResultOfContrast() {
		return resultOfContrast;
	}

	public void setResultOfContrast(String resultOfContrast) {
		this.resultOfContrast = resultOfContrast;
	}

	public String getResultOfBright() {
		return resultOfBright;
	}

	public void setResultOfBright(String resultOfBright) {
		this.resultOfBright = resultOfBright;
	}

	public String getResultOfDark() {
		return resultOfDark;
	}

	public void setResultOfDark(String resultOfDark) {
		this.resultOfDark = resultOfDark;
	}

	public String getResultOfChroma() {
		return resultOfChroma;
	}

	public void setResultOfChroma(String resultOfChroma) {
		this.resultOfChroma = resultOfChroma;
	}

	public String getResultOfMono() {
		return resultOfMono;
	}

	public void setResultOfMono(String resultOfMono) {
		this.resultOfMono = resultOfMono;
	}

	public String getResultOfNoise() {
		return resultOfNoise;
	}

	public void setResultOfNoise(String resultOfNoise) {
		this.resultOfNoise = resultOfNoise;
	}

	public String getResultOfStreak() {
		return resultOfStreak;
	}

	public void setResultOfStreak(String resultOfStreak) {
		this.resultOfStreak = resultOfStreak;
	}

	public String getResultOfFreeze() {
		return resultOfFreeze;
	}

	public void setResultOfFreeze(String resultOfFreeze) {
		this.resultOfFreeze = resultOfFreeze;
	}

	public String getResultOfShake() {
		return resultOfShake;
	}

	public void setResultOfShake(String resultOfShake) {
		this.resultOfShake = resultOfShake;
	}

	public String getResultOfFlash() {
		return resultOfFlash;
	}

	public void setResultOfFlash(String resultOfFlash) {
		this.resultOfFlash = resultOfFlash;
	}

	public String getResultOfScene() {
		return resultOfScene;
	}

	public void setResultOfScene(String resultOfScene) {
		this.resultOfScene = resultOfScene;
	}

	public String getResultOfCover() {
		return resultOfCover;
	}

	public void setResultOfCover(String resultOfCover) {
		this.resultOfCover = resultOfCover;
	}

	public String getResultOfPTZ() {
		return resultOfPTZ;
	}

	public void setResultOfPTZ(String resultOfPTZ) {
		this.resultOfPTZ = resultOfPTZ;
	}

	public String getSnapshotURL() {
		return snapshotURL;
	}

	public void setSnapshotURL(String snapshotURL) {
		this.snapshotURL = snapshotURL;
	}

	public String getVideoType() {
		return videoType;
	}

	public void setVideoType(String videoType) {
		this.videoType = videoType;
	}

}
