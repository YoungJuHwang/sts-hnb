package com.hnb.theme;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class ThemeVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int themeNo;
	private String themeName;
	
	public int getThemeNo() {
		return themeNo;
	}
	public String getThemeName() {
		return themeName;
	}
	public void setThemeNo(int themeNo) {
		this.themeNo = themeNo;
	}
	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}
}
