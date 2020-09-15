package model;

import java.io.Serializable;

//�G���[�r���[�̕\�����e��`�B���邽�߂�JavaBeans
public class ErrorViewData implements Serializable{
	private String message;  //�\�����b�Z�[�W 
	private String linkStr;  //�����N�\��������
	private String link;     //�����N��A�h���X
	
	//�R���X�g���N�^
	public ErrorViewData(String message, String linkSre, String link) {
		this.message = message;
		this.linkStr = linkStr;
		this.link = link;
	}
	
	//setter��getter
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getLinkStr() {
		return linkStr;
	}
	public void setLinkStr(String linkStr) {
		this.linkStr = linkStr;
	}
}
